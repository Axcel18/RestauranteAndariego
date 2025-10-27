package Interface;

import Modelo.Usuario;
import java.util.List;
import java.util.Optional;

public interface UsuarioDAO {

    boolean create(Usuario usuario) throws Exception;

    Optional<Usuario> findByUsername(String username) throws Exception;

    List<Usuario> listAll() throws Exception;

    boolean update(Usuario usuario) throws Exception;

    boolean delete(int id) throws Exception;
}


