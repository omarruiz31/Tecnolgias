public class Tarjeta implements MetodoPago {
    String numero;

    public Tarjeta(String numero){
        this.numero = numero;
    }

    @Override
    public  boolean validar(){
        return this.numero.length() == 16;
    }

    @Override
    public void pagar(double monto){
        System.out.printf("Pago de $ %f realizado con tarjeta %s",monto,numero);
    }
}
