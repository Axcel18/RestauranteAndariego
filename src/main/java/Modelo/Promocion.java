package Modelo;

public class Promocion {

    private int id;
    private String nombre;
    private String codigo;
    private double descuento;
    private boolean activo;

    public Promocion() {
    }

    public Promocion(int id, String nombre, String codigo, double descuento, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.codigo = codigo;
        this.descuento = descuento;
        this.activo = activo;
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
