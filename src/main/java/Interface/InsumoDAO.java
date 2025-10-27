package Interface;

import Modelo.Insumo;
import java.util.List;
import java.util.Optional;

public interface InsumoDAO {

    boolean create(Insumo insumo) throws Exception;

    List<Insumo> listAll() throws Exception;

    Optional<Insumo> findById(int id) throws Exception;

    boolean update(Insumo insumo) throws Exception;

    boolean actualizarStock(int id, double nuevoStock) throws Exception;

    boolean delete(int id) throws Exception;
}

