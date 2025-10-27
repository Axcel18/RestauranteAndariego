package Interface;

import Modelo.Pedido;
import java.util.List;
import java.util.Optional;

public interface PedidoDAO {

    int create(Pedido pedido) throws Exception;

    List<Pedido> listAll() throws Exception;

    List<Pedido> listPendientes() throws Exception;

    Optional<Pedido> findById(int id) throws Exception;

    boolean actualizarEstado(int id, String nuevoEstado) throws Exception;
}


