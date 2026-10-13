public class Lampara implements ActivavblePorRedstone{

    @Override
    public void activar(){
        System.out.println("Lampara se enciende e ilumina");
    }

    @Override
    public void desactivar(){
        System.out.println("Lampara se apaga");
    }
}
