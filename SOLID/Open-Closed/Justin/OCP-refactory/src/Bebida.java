public abstract class Bebida {
    protected static final double IVA = 0.16;
    private final String nombreBebida;
    private Etiqueta etiqueta;
    private double precioBase;

    protected  Bebida(String nombreBebida,Etiqueta etiqueta, double precioBase){
        if (precioBase <= 0) throw new IllegalArgumentException("Precio invalido");
        this.etiqueta = etiqueta;
        this.nombreBebida = nombreBebida;
        this.precioBase = precioBase;
    }

    public abstract boolean requiereINE();
    public abstract double calcularTotal();

    public double getPrecioBase(){
        return precioBase;
    }
    public String getNombreBebida(){
        return nombreBebida;
    }

    public String getEtiqueta(){
        return nombreBebida + " " + etiqueta;
    }
}
