public class ProfeJirafales implements Educador,Habitantes{
    private String nombre = "Profesor Jirafales";

    @Override
    public void pasarLista() {
        System.out.println(nombre + " pasa la lista de la clase");
    }

    @Override
    public void impartirClase() {
        System.out.println(nombre + "da una clase de matematicas");
    }

    @Override
    public void hacerCoraje() {
        System.out.println("TA TA TATA TÁ");
    }

    @Override
    public void InteractuarConElChavo() {
        System.out.println(nombre + "Chavito avisame con tiempo");
    }
}
