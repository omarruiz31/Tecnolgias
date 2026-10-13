public class BloqueMusical implements ActivavblePorRedstone{
    @Override
    public void activar(){
        System.out.println("Bloque recibe señal y reproduce musica");
    }

    @Override
    public void desactivar(){
        System.out.println("Bloque recibe señal y deja de reproducit musica");
    }
}
