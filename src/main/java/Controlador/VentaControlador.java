package Controlador;

import DAO.VentaImplementacion;
import Modelo.Venta;
import java.util.List;

public class VentaControlador {

    private final VentaImplementacion ventaDAO;

    public VentaControlador() {
        this.ventaDAO = new VentaImplementacion();
    }

    public boolean registrarVenta(Venta v) {
        try {
            v.setFecha(new java.sql.Date(System.currentTimeMillis()));
            return ventaDAO.create(v);
        } catch (Exception e) {
            System.out.println("Error al registrar venta: " + e.getMessage());
            return false;
        }
    }

    public List<Venta> listarVentas() {
        try {
            return ventaDAO.listAll();
        } catch (Exception e) {
            System.out.println("Error al listar ventas: " + e.getMessage());
            return null;
        }
    }

    public Venta buscarPorPedido(int idPedido) {
        try {
            return ventaDAO.findByPedido(idPedido);
        } catch (Exception e) {
            System.out.println("Error al buscar venta por pedido: " + e.getMessage());
            return null;
        }
    }
}
