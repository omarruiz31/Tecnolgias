public class DonRamon implements AccionesPersonaje{
    private final String nombre = "Don Ramon";

    @Override
    public void darGolpe() {
        System.out.println(nombre + "Toma , toma");
    }

    @Override
    public void pagarRenta() {
        throw new UnsupportedOperationException(nombre + "Nunca paga renta");
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
        throw new UnsupportedOperationException(nombre + "Los hombres no lloran");
    }
}
