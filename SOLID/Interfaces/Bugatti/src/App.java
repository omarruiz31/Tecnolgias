public class App {
    static void main() {
        DonRamon donRamon = new DonRamon();
        DonaFlorinda donaFlorinda = new DonaFlorinda();
        Nono nono = new Nono();

        System.out.println("== La vecinda del chabo ==");
        donRamon.darGolpe();

        try{
            donRamon.cobrarRenta();
        } catch (UnsupportedOperationException e){
            System.out.println(e.getMessage());
        }
        try{
            donRamon.jugar();
        } catch (UnsupportedOperationException e){
            System.out.println(e.getMessage());
        }
        try{
            donRamon.pagarRenta();
        } catch (UnsupportedOperationException e){
            System.out.println(e.getMessage());
        }
        try{
            donRamon.llorar();
        } catch (UnsupportedOperationException e){
            System.out.println(e.getMessage());
        }

        donaFlorinda.darGolpe();
        donaFlorinda.pagarRenta();

        try {
            donaFlorinda.jugar();
        } catch (UnsupportedOperationException e){
            System.out.println(e.getMessage());
        }
        try {
            donaFlorinda.cobrarRenta();
        } catch (UnsupportedOperationException e){
            System.out.println(e.getMessage());
        }
        try {
            donaFlorinda.llorar();
        } catch (UnsupportedOperationException e){
            System.out.println(e.getMessage());
        }

        nono.jugar();
        nono.llorar();

        try {
            nono.cobrarRenta();
        } catch (UnsupportedOperationException e){
            System.out.println(e.getMessage());
        }
        try {
            nono.pagarRenta();
        } catch (UnsupportedOperationException e){
            System.out.println(e.getMessage());
        }
        try {
            nono.darGolpe();
        } catch (UnsupportedOperationException e){
            System.out.println(e.getMessage());
        }
    }
}
