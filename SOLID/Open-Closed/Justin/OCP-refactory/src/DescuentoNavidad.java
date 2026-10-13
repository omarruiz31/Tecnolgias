public class DescuentoNavidad implements Descuento{

    @Override
    public double aplicar(double total) {
        return total * 0.90;
    }

    @Override
    public String getDescripcion() {
        return "Descuento de navidad";
    }
}
