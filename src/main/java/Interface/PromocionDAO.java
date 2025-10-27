package Interface;

import Modelo.Promocion;
import java.util.List;
import java.util.Optional;

public interface PromocionDAO {

    boolean create(Promocion promocion) throws Exception;

    List<Promocion> listAll() throws Exception;

    Optional<Promocion> findByCodigo(String codigo) throws Exception;

    boolean update(Promocion promocion) throws Exception;

    boolean delete(int id) throws Exception;
}


