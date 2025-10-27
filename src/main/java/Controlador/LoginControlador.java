package Controlador;

import DAO.UsuarioImplementacion;
import Modelo.Usuario;

public class LoginControlador {

    private final UsuarioImplementacion usuarioDAO;

    public LoginControlador() {
        this.usuarioDAO = new UsuarioImplementacion();
    }

    // Verifica usuario y contraseña
    public boolean autenticar(String username, String password) {
        try {
            var opt = usuarioDAO.findByUsername(username);
            if (opt.isPresent()) {
                Usuario u = opt.get();
                return u.getPasswordHash().equals(password);
            }
        } catch (Exception e) {
            System.out.println("Error al autenticar: " + e.getMessage());
        }
        return false;
    }
}


