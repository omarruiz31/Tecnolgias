public class CalculadoraDescuento {

    public double aplicarDescuento(String tipoDescuento, double subTotal){
        if (tipoDescuento.equals("descuentoNavidad")){
            return subTotal * 0.90;
        } else if (tipoDescuento.equals("sinDescuento")) {
            return subTotal;
        }
        else {
            throw new IllegalArgumentException("Descuento no valido");
        }
    }
}
