
package Controlador;

import DAO.InsumoImplementacion;
import Modelo.Insumo;
import java.util.List;

public class InventarioControlador {
    
    private final InsumoImplementacion insumoDAO;

    public InventarioControlador() {
        this.insumoDAO = new InsumoImplementacion();
    }

    public boolean registrarInsumo(Insumo i) {
        try {
            return insumoDAO.create(i);
        } catch (Exception e) {
            System.out.println("Error al registrar insumo: " + e.getMessage());
            return false;
        }
    }

    public List<Insumo> listarInsumos() {
        try {
            return insumoDAO.listAll();
        } catch (Exception e) {
            System.out.println("Error al listar insumos: " + e.getMessage());
            return null;
        }
    }

    public boolean actualizarStock(int id, double nuevoStock) {
        try {
            return insumoDAO.actualizarStock(id, nuevoStock);
        } catch (Exception e) {
            System.out.println("Error al actualizar stock: " + e.getMessage());
            return false;
        }
    }
}

    

