public class Contado implements MetodoPago{
    private boolean estadoBillete;

    public Contado(boolean estadoBillete){
        this.estadoBillete = estadoBillete;
    }


    public boolean validar(){
        return estadoBillete;
    }

    @Override
    public void pagar(double monto) {
        System.out.printf("Se cobraron %f pesos", monto);

    }
}
