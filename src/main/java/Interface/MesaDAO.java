package Interface;

import Modelo.Mesa;
import java.util.List;
import java.util.Optional;

public interface MesaDAO {

    boolean create(Mesa mesa) throws Exception;

    List<Mesa> listAll() throws Exception;

    Optional<Mesa> findByNumero(int numero) throws Exception;

    boolean updateEstado(int id, String estado) throws Exception;

    boolean delete(int id) throws Exception;
}


