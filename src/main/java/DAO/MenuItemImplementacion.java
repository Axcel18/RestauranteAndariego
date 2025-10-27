package DAO;

import Interface.MenuItemDAO;
import Modelo.MenuItem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MenuItemImplementacion implements MenuItemDAO {

    @Override
    public boolean create(MenuItem item) throws Exception {
        String sql = "INSERT INTO menu_items(nombre, categoria, precio, disponible) VALUES(?,?,?,?)";
        try (Connection c = ConexionBD.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, item.getNombre());
            ps.setString(2, item.getCategoria());
            ps.setDouble(3, item.getPrecio());
            ps.setBoolean(4, item.isDisponible());
            return ps.executeUpdate() == 1;
        }
    }

    @Override
    public List<MenuItem> listAll() throws Exception {
        List<MenuItem> lista = new ArrayList<>();
        String sql = "SELECT * FROM menu_items";
        try (Connection c = ConexionBD.getConnection(); Statement st = c.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new MenuItem(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("categoria"),
                        rs.getDouble("precio"),
                        rs.getBoolean("disponible")
                ));
            }
        }
        return lista;
    }

    @Override
    public Optional<MenuItem> findById(int id) throws Exception {
        String sql = "SELECT * FROM menu_items WHERE id=?";
        try (Connection c = ConexionBD.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(new MenuItem(
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getString("categoria"),
                            rs.getDouble("precio"),
                            rs.getBoolean("disponible")
                    ));
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean update(MenuItem item) throws Exception {
        String sql = "UPDATE menu_items SET nombre=?, categoria=?, precio=?, disponible=? WHERE id=?";
        try (Connection c = ConexionBD.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, item.getNombre());
            ps.setString(2, item.getCategoria());
            ps.setDouble(3, item.getPrecio());
            ps.setBoolean(4, item.isDisponible());
            ps.setInt(5, item.getId());
            return ps.executeUpdate() == 1;
        }
    }

    @Override
    public boolean delete(int id) throws Exception {
        String sql = "DELETE FROM menu_items WHERE id=?";
        try (Connection c = ConexionBD.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() == 1;
        }
    }
}
