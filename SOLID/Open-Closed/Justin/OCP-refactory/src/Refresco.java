public class Refresco extends Bebida {
    public Refresco(String nombreBebida, double precioBase){
        super(nombreBebida,Etiqueta.CON_IVA,precioBase);
    }

    @Override
    public boolean requiereINE() {
        return false;
    }

    @Override
    public double calcularTotal() {
        return getPrecioBase() + (1 * IVA);
    }
}
