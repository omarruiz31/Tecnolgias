public class Arma {
    private String nombre;
    private int dano;

    public Arma(String nombre, int dano){
        this.nombre = nombre;
        this.dano = dano;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Arma{" +
                "nombre='" + nombre + '\'' +
                ", dano=" + dano +
                '}';
    }
}
