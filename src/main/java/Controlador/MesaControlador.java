package Controlador;

import DAO.MesaImplementacion;
import Modelo.Mesa;
import java.util.List;

public class MesaControlador {

    private final MesaImplementacion mesaDAO;

    public MesaControlador() {
        this.mesaDAO = new MesaImplementacion();
    }

    public boolean registrarMesa(Mesa m) {
        try {
            return mesaDAO.create(m);
        } catch (Exception e) {
            System.out.println("Error al registrar mesa: " + e.getMessage());
            return false;
        }
    }

    public List<Mesa> listarMesas() {
        try {
            return mesaDAO.listAll();
        } catch (Exception e) {
            System.out.println("Error al listar mesas: " + e.getMessage());
            return null;
        }
    }

    public boolean actualizarEstado(int id, String estado) {
        try {
            return mesaDAO.updateEstado(id, estado);
        } catch (Exception e) {
            System.out.println("Error al actualizar estado: " + e.getMessage());
            return false;
        }
    }
}
