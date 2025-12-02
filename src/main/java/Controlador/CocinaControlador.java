package Controlador;

import DAO.PedidoItemImplementacion;
import Modelo.PedidoItem;
import java.util.List;

public class CocinaControlador {

    private final PedidoItemImplementacion pedidoItemDAO;

    public CocinaControlador() {
        this.pedidoItemDAO = new PedidoItemImplementacion();
    }

    public List<PedidoItem> listarItemsPorPedido(int idPedido) {
        try {
            return pedidoItemDAO.listByPedido(idPedido);
        } catch (Exception e) {
            System.out.println("Error al listar ítems de pedido: " + e.getMessage());
            return null;
        }
    }

    public boolean marcarComoListo(int idItem) {
        try {
            return pedidoItemDAO.updateEstado(idItem, "LISTO");
        } catch (Exception e) {
            System.out.println("Error al marcar ítem como listo: " + e.getMessage());
            return false;
        }
    }
    //hola 
}


