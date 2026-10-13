public class Nono  implements AccionesPersonaje{
    private final String nombre = "Ñoño";

    @Override
    public void darGolpe() {
        throw new UnsupportedOperationException(nombre + "Es un niño, no pega");
    }

    @Override
    public void pagarRenta() {
        throw new UnsupportedOperationException("");
    }

    @Override
    public void cobrarRenta() {
        throw new UnsupportedOperationException(nombre + "No es dueño de la propiedad");
    }

    @Override
    public void jugar() {
        System.out.println(nombre + "Juega con su pelota de playa");
    }

    @Override
    public void llorar() {
        System.out.println("Ajai ajia, ajua ");
    }
}
