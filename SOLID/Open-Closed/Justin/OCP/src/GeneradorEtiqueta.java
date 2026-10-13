public class GeneradorEtiqueta {

    public String generarEtiqueta(String tipoBebida){
        if (tipoBebida.equals("agua")) return "Agua (Libre de impuestos)";
        else if (tipoBebida.equals("refresco")){
            return "Refresco con IVA";
        } else if (tipoBebida.equals("cerveza")) {
            return "Cerveza con IVA + IEPS";
        } else if (tipoBebida.equals("tepache")) {
            return "Tepache con IVA";
        }
        else {
            throw new IllegalArgumentException("Tipo no valido");
        }
    }
}
