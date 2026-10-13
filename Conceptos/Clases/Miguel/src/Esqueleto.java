public class Esqueleto extends MobHostil {

    public Esqueleto(){
        super("Esqueleto",20);
    }

    @Override
    void atacar(){
        System.out.println("Ek esqueleto te persigue y te ataca con su arco");
    }
}
