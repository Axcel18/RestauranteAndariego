package DAO;

import Interface.PromocionDAO;
import Modelo.Promocion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PromocionImplementacion implements PromocionDAO {

    @Override
    public boolean create(Promocion promocion) throws Exception {
        String sql = "INSERT INTO promociones(nombre, codigo, descuento, activo) VALUES(?,?,?,?)";
        try (Connection c = ConexionBD.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, promocion.getNombre());
            ps.setString(2, promocion.getCodigo());
            ps.setDouble(3, promocion.getDescuento());
            ps.setBoolean(4, promocion.isActivo());
            return ps.executeUpdate() == 1;
        }
    }

    @Override
    public List<Promocion> listAll() throws Exception {
        List<Promocion> lista = new ArrayList<>();
        String sql = "SELECT * FROM promociones";
        try (Connection c = ConexionBD.getConnection(); Statement st = c.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Promocion(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("codigo"),
                        rs.getDouble("descuento"),
                        rs.getBoolean("activo")
                ));
            }
        }
        return lista;
    }

    @Override
    public Optional<Promocion> findByCodigo(String codigo) throws Exception {
        String sql = "SELECT * FROM promociones WHERE codigo=?";
        try (Connection c = ConexionBD.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, codigo);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(new Promocion(
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getString("codigo"),
                            rs.getDouble("descuento"),
                            rs.getBoolean("activo")
                    ));
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean update(Promocion promocion) throws Exception {
        String sql = "UPDATE promociones SET nombre=?, codigo=?, descuento=?, activo=? WHERE id=?";
        try (Connection c = ConexionBD.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, promocion.getNombre());
            ps.setString(2, promocion.getCodigo());
            ps.setDouble(3, promocion.getDescuento());
            ps.setBoolean(4, promocion.isActivo());
            ps.setInt(5, promocion.getId());
            return ps.executeUpdate() == 1;
        }
    }

    @Override
    public boolean delete(int id) throws Exception {
        String sql = "DELETE FROM promociones WHERE id=?";
        try (Connection c = ConexionBD.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() == 1;
        }
    }
}
