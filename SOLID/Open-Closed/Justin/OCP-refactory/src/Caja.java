public class Caja {
    double subtotal = 0;
    public void cobrar(Bebida[] bebidas, Descuento descuento, double efectivo){
        double subtotal = 0;
        for (Bebida bebida: bebidas){
            System.out.println(bebida.getEtiqueta() + "$ " + bebida.calcularTotal());
            if (bebida.requiereINE()) System.out.println("Requiere INE");
            subtotal += bebida.calcularTotal();
        }

        double total = descuento.aplicar(subtotal);

        if (efectivo < total){
            System.out.println("efectivo insuficiente");
            return;
        }

        System.out.println("Subtotal" + subtotal);
        System.out.println("Descuento: " + descuento.getDescripcion());
        System.out.println("Total: " + total);
        System.out.println("Cambio " + (efectivo - total));
    }
}
