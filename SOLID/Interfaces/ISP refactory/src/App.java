import java.util.List;

public class App {
    static void main(String[] args) {
        Nono nono = new Nono();
        DonRamon donRamon = new DonRamon();
        ProfeJirafales profeJirafales = new ProfeJirafales();

        List<Educador> educadores = List.of(profeJirafales);


        for (Educador e: educadores){
            e.impartirClase();
            e.pasarLista();
            e.hacerCoraje();
        }

        List<Inquilino> inquilinos = List.of(donRamon);
        for (Inquilino i: inquilinos){
            i.pagarRenta();
        }

        List<Habitantes> habitantes = List.of(donRamon,profeJirafales);
        for (Habitantes h: habitantes){
            h.InteractuarConElChavo();
        }

        List<Nino> ninos = List.of(nono);
        for (Nino n: ninos){
            n.llorar();
            n.cantar();
        }
    }
}
