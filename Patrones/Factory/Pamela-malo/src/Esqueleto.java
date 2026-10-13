public class Esqueleto extends Enemigo{

    public Esqueleto(){
        super("Esqueleto",150,75);
    }
    @Override
    public void atacar() {
        System.out.println("El esqueleto te pega con  su espdad y te quita" + ataque + "de vida");
    }
}
