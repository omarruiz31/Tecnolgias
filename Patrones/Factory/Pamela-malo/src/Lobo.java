public class Lobo extends Enemigo{

    public Lobo(){
        super("Lobo",100,50);
    }

    @Override
    public void atacar() {
        System.out.println("El lobo te muerde y te quita : " + ataque + "de vida");
    }
}
