package Interface;

import Modelo.PedidoItem;
import java.util.List;

public interface PedidoItemDAO {

    boolean create(PedidoItem item) throws Exception;

    List<PedidoItem> listByPedido(int pedidoId) throws Exception;

    boolean updateEstado(int id, String nuevoEstado) throws Exception;
}
