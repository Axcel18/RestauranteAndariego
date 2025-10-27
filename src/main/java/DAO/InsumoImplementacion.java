package DAO;

import Interface.InsumoDAO;
import Modelo.Insumo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InsumoImplementacion implements InsumoDAO {

    @Override
    public boolean create(Insumo insumo) throws Exception {
        String sql = "INSERT INTO insumos(nombre, unidad, stock) VALUES(?,?,?)";
        try (Connection c = ConexionBD.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, insumo.getNombre());
            ps.setString(2, insumo.getUnidad());
            ps.setDouble(3, insumo.getStock());
            return ps.executeUpdate() == 1;
        }
    }

    @Override
    public List<Insumo> listAll() throws Exception {
        List<Insumo> lista = new ArrayList<>();
        String sql = "SELECT * FROM insumos";
        try (Connection c = ConexionBD.getConnection(); Statement st = c.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Insumo(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("unidad"),
                        rs.getDouble("stock")
                ));
            }
        }
        return lista;
    }

    @Override
    public Optional<Insumo> findById(int id) throws Exception {
        String sql = "SELECT * FROM insumos WHERE id=?";
        try (Connection c = ConexionBD.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(new Insumo(
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getString("unidad"),
                            rs.getDouble("stock")
                    ));
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean update(Insumo insumo) throws Exception {
        String sql = "UPDATE insumos SET nombre=?, unidad=?, stock=? WHERE id=?";
        try (Connection c = ConexionBD.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, insumo.getNombre());
            ps.setString(2, insumo.getUnidad());
            ps.setDouble(3, insumo.getStock());
            ps.setInt(4, insumo.getId());
            return ps.executeUpdate() == 1;
        }
    }

    @Override
    public boolean actualizarStock(int id, double nuevoStock) throws Exception {
        String sql = "UPDATE insumos SET stock=? WHERE id=?";
        try (Connection c = ConexionBD.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setDouble(1, nuevoStock);
            ps.setInt(2, id);
            return ps.executeUpdate() == 1;
        }
    }

    @Override
    public boolean delete(int id) throws Exception {
        String sql = "DELETE FROM insumos WHERE id=?";
        try (Connection c = ConexionBD.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() == 1;
        }
    }
}


