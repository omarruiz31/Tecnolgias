public class PayPal implements MetodoPago{
    private String correo;

    public PayPal(String correo){
        this.correo = correo;
    }

    @Override
    public boolean validar(){
        return this.correo.contains("@");
    }

    @Override
    public void pagar(double monto){
        System.out.printf("Pago de $ %f enviado a la cuenta de PayPal %s",monto,correo);
    }
}
