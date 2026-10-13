public class Caja {

    public double calcularPrecio(String tipoBebida, double precioBebida){
        if (tipoBebida.equals("agua")) return precioBebida;
        else if (tipoBebida.equals("refresco")){
            return precioBebida * 1.16;
        } else if (tipoBebida.equals("cerveza")) {
            return precioBebida * 1.16 * 1.25;
        } else if (tipoBebida.equals("tepache")) {
            return precioBebida * 1.16 ;
        }
        else {
            throw new IllegalArgumentException("Tipo de bebida no existe");
        }
    }
}
