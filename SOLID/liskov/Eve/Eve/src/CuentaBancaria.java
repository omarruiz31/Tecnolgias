public abstract class  CuentaBancaria {
    protected String numeroCuenta;
    protected  double saldo;

    public CuentaBancaria(String CuentaBancaria, double saldoInicial){
        this.saldo = saldoInicial;
    }

    public void depositar(double cantidad){
        validarCantidad(cantidad);
        saldo += cantidad;
    }
    public  void retirar(double cantidad){
        validarCantidad(cantidad);
        saldo -= cantidad;
    }
    public double consultarSaldo(){
        return saldo;
    }
    public  String getNumeroCuenta(){
        return numeroCuenta;
    }
    public abstract double calcularIntereses();
    public abstract void  pagarDeuda(double cantidad);

    public void validarCantidad(double cantidad){
        if (cantidad < 0){
            throw new IllegalArgumentException("La cantidad no puede ser menor a 0");
        }
    }
}
