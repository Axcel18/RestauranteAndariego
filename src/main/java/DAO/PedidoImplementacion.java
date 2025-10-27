
package DAO;

import Interface.PedidoDAO;
import Modelo.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PedidoImplementacion implements PedidoDAO{

    @Override
    public int create(Pedido pedido) throws Exception {
        String sql = "INSERT INTO pedidos(id_usuario, fecha, estado, total) VALUES(?,?,?,?)";
        try (Connection c = ConexionBD.getConnection();
             PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, pedido.getIdUsuario());
            ps.setTimestamp(2, new Timestamp(pedido.getFecha().getTime()));
            ps.setString(3, pedido.getEstado());
            ps.setDouble(4, pedido.getTotal());
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        }
        return -1;
    }

    @Override
    public List<Pedido> listAll() throws Exception {
        List<Pedido> lista = new ArrayList<>();
        String sql = "SELECT * FROM pedidos";
        try (Connection c = ConexionBD.getConnection();
             Statement st = c.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Pedido(
                    rs.getInt("id"),
                    rs.getInt("id_usuario"),
                    rs.getDate("fecha"),
                    rs.getString("estado"),
                    rs.getDouble("total")
                ));
            }
        }
        return lista;
    }

    @Override
    public List<Pedido> listPendientes() throws Exception {
        List<Pedido> lista = new ArrayList<>();
        String sql = "SELECT * FROM pedidos WHERE estado='PENDIENTE'";
        try (Connection c = ConexionBD.getConnection();
             Statement st = c.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Pedido(
                    rs.getInt("id"),
                    rs.getInt("id_usuario"),
                    rs.getDate("fecha"),
                    rs.getString("estado"),
                    rs.getDouble("total")
                ));
            }
        }
        return lista;
    }

    @Override
    public Optional<Pedido> findById(int id) throws Exception {
        String sql = "SELECT * FROM pedidos WHERE id=?";
        try (Connection c = ConexionBD.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Pedido p = new Pedido(
                        rs.getInt("id"),
                        rs.getInt("id_usuario"),
                        rs.getDate("fecha"),
                        rs.getString("estado"),
                        rs.getDouble("total")
                    );
                    return Optional.of(p);
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean actualizarEstado(int id, String nuevoEstado) throws Exception {
        String sql = "UPDATE pedidos SET estado=? WHERE id=?";
        try (Connection c = ConexionBD.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, nuevoEstado);
            ps.setInt(2, id);
            return ps.executeUpdate() == 1;
        }
    }
}

    

