public abstract class Nivel {

    protected String nombre;

    public Nivel(String nombre){
        this.nombre = nombre;
    }

    public abstract Enemigo crearEnemigo();

    public void  jugar() {
        Enemigo enemigo = crearEnemigo();
        int vidaJugador = 250;
        int danoJugador = 60;
        int turno = 1;

        System.out.println(nombre);
        System.out.println("Aparece un" + enemigo + "con" + enemigo.getVida());

    }
}
