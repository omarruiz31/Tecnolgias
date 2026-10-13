public abstract class MobHostil {
    String nombre;
    int salud;

    public MobHostil(String nombre, int salud){
        this.nombre = nombre;
        this.salud = salud;
    }

    public void quemarEnLava(){
        this.salud -= 5;
        System.out.println(nombre + "se quema en lava. Salud restante: " + salud + "HP");
    }

    abstract void atacar();
}
