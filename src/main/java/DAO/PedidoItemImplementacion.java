package DAO;

import Interface.PedidoItemDAO;
import Modelo.PedidoItem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PedidoItemImplementacion implements PedidoItemDAO {

    @Override
    public boolean create(PedidoItem item) throws Exception {
        String sql = "INSERT INTO pedido_items(id_pedido, id_menu_item, cantidad, subtotal, estado) VALUES(?,?,?,?,?)";
        try (Connection c = ConexionBD.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, item.getIdPedido());
            ps.setInt(2, item.getIdMenuItem());
            ps.setInt(3, item.getCantidad());
            ps.setDouble(4, item.getSubtotal());
            ps.setString(5, item.getEstado());
            return ps.executeUpdate() == 1;
        }
    }

    @Override
    public List<PedidoItem> listByPedido(int pedidoId) throws Exception {
        List<PedidoItem> lista = new ArrayList<>();
        String sql = "SELECT * FROM pedido_items WHERE id_pedido=?";
        try (Connection c = ConexionBD.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, pedidoId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(new PedidoItem(
                            rs.getInt("id"),
                            rs.getInt("id_pedido"),
                            rs.getInt("id_menu_item"),
                            rs.getInt("cantidad"),
                            rs.getDouble("subtotal"),
                            rs.getString("estado")
                    ));
                }
            }
        }
        return lista;
    }

    @Override
    public boolean updateEstado(int id, String nuevoEstado) throws Exception {
        String sql = "UPDATE pedido_items SET estado=? WHERE id=?";
        try (Connection c = ConexionBD.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, nuevoEstado);
            ps.setInt(2, id);
            return ps.executeUpdate() == 1;
        }
    }
}
