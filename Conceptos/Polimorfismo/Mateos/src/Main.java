public class Main {
    static void main(String[] args) {

        Caja caja = new Caja();

        MetodoPago tarjeta = new Tarjeta("4152314116178934");
        MetodoPago payPal = new PayPal("omar.ruiz0531@gmail.com");
        MetodoPago contado = new Contado(true);

        caja.cobrar(tarjeta,100);
        caja.cobrar(payPal,20300);
        caja.cobrar(contado,100);
    }
}
