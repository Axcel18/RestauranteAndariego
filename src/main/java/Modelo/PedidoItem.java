package Modelo;

public class PedidoItem {

    private int id;
    private int idPedido;
    private int idMenuItem;
    private int cantidad;
    private double subtotal;
    private String estado;

    public PedidoItem() {
    }

    public PedidoItem(int id, int idPedido, int idMenuItem, int cantidad, double subtotal, String estado) {
        this.id = id;
        this.idPedido = idPedido;
        this.idMenuItem = idMenuItem;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdMenuItem() {
        return idMenuItem;
    }

    public void setIdMenuItem(int idMenuItem) {
        this.idMenuItem = idMenuItem;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
