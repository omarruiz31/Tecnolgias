public class Zombie extends MobHostil{

    public Zombie(){
        super("Zombie",20);
    }

    @Override
    public void atacar(){
        System.out.println("El zombie va hacia ti y te golpea con las manos");
    }


}
