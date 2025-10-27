package Interface;

import Modelo.MenuItem;
import java.util.List;
import java.util.Optional;

public interface MenuItemDAO {

    boolean create(MenuItem item) throws Exception;

    List<MenuItem> listAll() throws Exception;

    Optional<MenuItem> findById(int id) throws Exception;

    boolean update(MenuItem item) throws Exception;

    boolean delete(int id) throws Exception;
}
