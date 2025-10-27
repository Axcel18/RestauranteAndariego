package DAO;

import Interface.VentaDAO;
import Modelo.Venta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class VentaImplementacion implements VentaDAO {

    @Override
    public boolean create(Venta venta) throws Exception {
        String sql = "INSERT INTO ventas(id_pedido, fecha, monto_total, metodo_pago) VALUES(?,?,?,?)";
        try (Connection c = ConexionBD.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, venta.getIdPedido());
            ps.setTimestamp(2, new Timestamp(venta.getFecha().getTime()));
            ps.setDouble(3, venta.getMontoTotal());
            ps.setString(4, venta.getMetodoPago());
            return ps.executeUpdate() == 1;
        }
    }

    @Override
    public List<Venta> listAll() throws Exception {
        List<Venta> lista = new ArrayList<>();
        String sql = "SELECT * FROM ventas";
        try (Connection c = ConexionBD.getConnection(); Statement st = c.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Venta(
                        rs.getInt("id"),
                        rs.getInt("id_pedido"),
                        rs.getDate("fecha"),
                        rs.getDouble("monto_total"),
                        rs.getString("metodo_pago")
                ));
            }
        }
        return lista;
    }

    @Override
    public Venta findByPedido(int pedidoId) throws Exception {
        String sql = "SELECT * FROM ventas WHERE id_pedido=?";
        try (Connection c = ConexionBD.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, pedidoId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Venta(
                            rs.getInt("id"),
                            rs.getInt("id_pedido"),
                            rs.getDate("fecha"),
                            rs.getDouble("monto_total"),
                            rs.getString("metodo_pago")
                    );
                }
            }
        }
        return null;
    }
}
