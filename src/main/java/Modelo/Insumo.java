package Modelo;

public class Insumo {

    private int id;
    private String nombre;
    private String unidad;
    private double stock;

    public Insumo() {
    }

    public Insumo(int id, String nombre, String unidad, double stock) {
        this.id = id;
        this.nombre = nombre;
        this.unidad = unidad;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public double getStock() {
        return stock;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }
}
