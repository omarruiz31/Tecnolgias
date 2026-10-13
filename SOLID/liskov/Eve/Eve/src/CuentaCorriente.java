public class CuentaCorriente extends CuentaBancaria{
    private double limiteSobregiro;
    private double tasaInteres;

    public CuentaCorriente(String numeroCuenta, double saldoInicial, double limiteSobreGiro){
        super(numeroCuenta, saldoInicial);
        if (limiteSobreGiro < 0){
            throw new IllegalArgumentException("El limite no debe ser menos a 0");
        }
        this.limiteSobregiro = limiteSobreGiro;
        this.tasaInteres = 0.02;
    }

    public void retirar(double cantidad){
        validarCantidad(cantidad);
        if (cantidad > saldo + limiteSobregiro){
            throw new IllegalArgumentException("La operacion excede el limite ");
        }
        saldo -= cantidad;
    }

    @Override
    public double calcularIntereses() {
        if (saldo < 0){
            limiteSobregiro = Math.abs(saldo);
            return limiteSobregiro * tasaInteres;
        }
        return 0;
    }

    public double consultarSobreGiroUtilizado(){
        if (saldo < 0){
            return Math.abs(saldo);
        }
        return 0;
    }

    public double getLimiteSobregiro(){
        return limiteSobregiro;
    }

    @Override
    public void pagarDeuda(double cantidad) {

    }
}
