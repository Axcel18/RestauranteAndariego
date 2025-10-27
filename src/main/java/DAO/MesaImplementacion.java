package DAO;

import Interface.MesaDAO;
import Modelo.Mesa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MesaImplementacion implements MesaDAO {

    @Override
    public boolean create(Mesa mesa) throws Exception {
        String sql = "INSERT INTO mesas(numero, capacidad, estado) VALUES(?,?,?)";
        try (Connection c = ConexionBD.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, mesa.getNumero());
            ps.setInt(2, mesa.getCapacidad());
            ps.setString(3, mesa.getEstado());
            return ps.executeUpdate() == 1;
        }
    }

    @Override
    public List<Mesa> listAll() throws Exception {
        List<Mesa> lista = new ArrayList<>();
        String sql = "SELECT * FROM mesas";
        try (Connection c = ConexionBD.getConnection(); Statement st = c.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Mesa(
                        rs.getInt("id"),
                        rs.getInt("numero"),
                        rs.getInt("capacidad"),
                        rs.getString("estado")
                ));
            }
        }
        return lista;
    }

    @Override
    public Optional<Mesa> findByNumero(int numero) throws Exception {
        String sql = "SELECT * FROM mesas WHERE numero=?";
        try (Connection c = ConexionBD.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, numero);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Mesa m = new Mesa(
                            rs.getInt("id"),
                            rs.getInt("numero"),
                            rs.getInt("capacidad"),
                            rs.getString("estado")
                    );
                    return Optional.of(m);
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean updateEstado(int id, String estado) throws Exception {
        String sql = "UPDATE mesas SET estado=? WHERE id=?";
        try (Connection c = ConexionBD.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, estado);
            ps.setInt(2, id);
            return ps.executeUpdate() == 1;
        }
    }

    @Override
    public boolean delete(int id) throws Exception {
        String sql = "DELETE FROM mesas WHERE id=?";
        try (Connection c = ConexionBD.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() == 1;
        }
    }
}
