public class DonRamon implements Inquilino,Habitantes,Educador{
    private String nombre = "Don Ramon";

    @Override
    public void InteractuarConElChavo() {
        System.out.println(nombre + "le mete un coscorron al chavo");
    }

    @Override
    public void pagarRenta() {
        System.out.println(nombre + "Le jura que pagara la proxima semana");
    }

    @Override
    public void pasarLista() {
        System.out.println("");
    }

    @Override
    public void impartirClase() {
        System.out.println(nombre + "Da clase de peligro");
    }

    @Override
    public void hacerCoraje() {
        System.out.println(nombre + "Le grita a los alumnos");
    }
}
