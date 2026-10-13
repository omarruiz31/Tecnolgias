public class Agua  extends Bebida{

    public  Agua(String nombreBebida, double precioBase){
        super(nombreBebida, Etiqueta.SIN_IVA, precioBase);
    }

    @Override
    public boolean requiereINE() {
        return false;
    }

    @Override
    public double calcularTotal() {
        return getPrecioBase();
    }
}
