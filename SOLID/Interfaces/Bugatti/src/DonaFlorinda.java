public class DonaFlorinda implements AccionesPersonaje{
    private final String nombre = "Doña Florinda";

    @Override
    public void darGolpe() {
        System.out.println(nombre + "Le da un cachetadon a don Ramon");
    }

    @Override
    public void pagarRenta() {
        System.out.println(nombre + ": Paga la renta de 5k");
    }

    @Override
    public void cobrarRenta() {
        throw new UnsupportedOperationException(nombre + "No es dueño de la propiedad");
    }

    @Override
    public void jugar() {
        throw new UnsupportedOperationException(nombre + "No juega a nada");
    }

    @Override
    public void llorar() {
        throw new UnsupportedOperationException(nombre + "Las mujeres ya no lloran ellas facturan");
    }
}
