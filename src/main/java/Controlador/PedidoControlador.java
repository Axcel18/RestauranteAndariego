package Controlador;

import DAO.PedidoImplementacion;
import DAO.PedidoItemImplementacion;
import Modelo.Pedido;
import Modelo.PedidoItem;
import java.util.List;

public class PedidoControlador {

    private final PedidoImplementacion pedidoDAO;
    private final PedidoItemImplementacion pedidoItemDAO;

    public PedidoControlador() {
        this.pedidoDAO = new PedidoImplementacion();
        this.pedidoItemDAO = new PedidoItemImplementacion();
    }

    public int registrarPedido(Pedido pedido, List<PedidoItem> items) {
        try {
            pedido.setFecha(new java.sql.Date(System.currentTimeMillis()));
            int idPedido = pedidoDAO.create(pedido);
            if (idPedido > 0) {
                for (PedidoItem item : items) {
                    item.setIdPedido(idPedido);
                    pedidoItemDAO.create(item);
                }
            }
            return idPedido;
        } catch (Exception e) {
            System.out.println("Error al registrar pedido: " + e.getMessage());
            return -1;
        }
    }

    public List<Pedido> listarPedidos() {
        try {
            return pedidoDAO.listAll();
        } catch (Exception e) {
            System.out.println("Error al listar pedidos: " + e.getMessage());
            return null;
        }
    }

    public boolean cambiarEstadoPedido(int id, String nuevoEstado) {
        try {
            return pedidoDAO.actualizarEstado(id, nuevoEstado);
        } catch (Exception e) {
            System.out.println("Error al cambiar estado del pedido: " + e.getMessage());
            return false;
        }
    }
}
