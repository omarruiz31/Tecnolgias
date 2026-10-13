public class SistemaBancario {
    static void main() {
        System.out.println("Sistema Bancario LSP Malo");
        CuentaBancaria ahorro = new CuentaAhorro("CA-001",10000);
        CuentaBancaria corriente = new CuentaCorriente("CA-001",10000,2000);
        CuentaBancaria credito = new CuentaCredito("CA-001",10000);

        Cliente cliente1 = new Cliente("Alexa", "001",ahorro);
        Cliente cliente2 = new Cliente("Pamela", "002",corriente);
        Cliente cliente3 = new Cliente("Vane", "003",credito);

        cliente1.depositar(900);
        cliente2.retirar(2000);


    }
}
