public class CuentaAhorro extends  CuentaBancaria{
    private double tasaInteres;

    public CuentaAhorro(String numeroCuenta, double saldoInicial){
        super(numeroCuenta, saldoInicial);
        tasaInteres = 0.05;
    }

    @Override
    public double calcularIntereses() {
        return saldo * tasaInteres;
    }

    @Override
    public void pagarDeuda(double cantidad) {
        throw new IllegalArgumentException("No hay deudad");
    }

}
