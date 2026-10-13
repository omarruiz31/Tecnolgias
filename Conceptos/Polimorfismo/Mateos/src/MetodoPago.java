public interface MetodoPago {

    boolean validar();
    void pagar(double monto);

}
