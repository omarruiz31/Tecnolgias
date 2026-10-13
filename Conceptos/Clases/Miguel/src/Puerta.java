public class Puerta implements ActivavblePorRedstone{
    @Override
    public void activar(){
        System.out.println("Puerta se activa y se abre");
    }

    @Override
    public void desactivar(){
        System.out.println("Puerta se cierra ");
    }
}
