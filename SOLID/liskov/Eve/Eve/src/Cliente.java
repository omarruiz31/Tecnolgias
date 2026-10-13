public class Cliente {
    private String nombre;
    private String id;
    private CuentaBancaria cuenta;

    public Cliente(String nombre, String id, CuentaBancaria cuenta){
        this.nombre = nombre;
        this.id = id;
        this.cuenta = cuenta;
    }
    public String getNombre(){
        return nombre;
    }
    public String getId(){
        return id;
    }

    public CuentaBancaria cuenta() {
        return cuenta;
    }

    public void depositar(double cantidad){
        cuenta.depositar(cantidad);
    }
    public void retirar(double cantidad){
        cuenta.retirar(cantidad);
    }
    public double consultarSaldo(){
        return saldo;
    }
    public double calcularIntereses(){
        return cuenta.calcularIntereses();
    }
    public double pagarDeuda(){
        return cuenta.pagarDeuda();
    }
    public void mostrarInformacion(){
        System.out.println("nombre" + nombre);
        System.out.println("Id: " + id);
        System.out.println("Ceunta: "+ cuenta);
    }
}
