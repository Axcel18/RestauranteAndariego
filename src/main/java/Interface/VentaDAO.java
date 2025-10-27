package Interface;

import Modelo.Venta;
import java.util.List;

public interface VentaDAO {

    boolean create(Venta venta) throws Exception;

    List<Venta> listAll() throws Exception;

    Venta findByPedido(int pedidoId) throws Exception;
}
