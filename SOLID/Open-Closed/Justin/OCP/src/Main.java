public class Main {
    static void main() {
        Caja caja = new Caja();
        VerificadorEdad edad = new VerificadorEdad();
        GeneradorEtiqueta etiqueta = new GeneradorEtiqueta();
        CalculadoraDescuento descuento = new CalculadoraDescuento();

        String[] bebidas = {"agua","refresco","tepache","cerveza",};
        double subtotal = 0;

        for (String bebida: bebidas){
            double precioBebida = caja.calcularPrecio(bebida,25);
            System.out.println(etiqueta.generarEtiqueta(bebida) +  " -> $" + precioBebida  + "|Requiere INE:" +edad.requiereIne(bebida));
            subtotal += precioBebida;
        }
        System.out.println("subtotal" + subtotal);
        System.out.println("Desciento de navidad");
        System.out.println("Total " + descuento.aplicarDescuento("descuentoNavidad",subtotal));
    }
}
