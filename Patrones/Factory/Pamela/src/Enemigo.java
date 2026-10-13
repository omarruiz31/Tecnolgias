public abstract class Enemigo {
    protected String nombre;
    protected int vida;
    protected int ataque;

    public Enemigo(String nombre,int vida, int ataque){
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
    }

    public abstract void atacar();

    public void recibirDano(int dano){
        this.vida -= dano;
        if (this.vida < 0){
            this.vida = 0;
        }
    }

    public boolean estaVivo(){
        return vida > 0;
    }

    public int getAtaque() {
        return ataque;
    }
}
