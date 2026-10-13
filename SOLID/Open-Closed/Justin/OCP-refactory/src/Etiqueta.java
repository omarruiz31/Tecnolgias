public enum Etiqueta {

    SIN_IVA("Libre de impuestos"),
    CON_IVA("IVA INCLUIDO"),
    CON_IEPS("IVA + IEPS incluidos");

    private final String descripcion;

    Etiqueta(String descripcion){
        this.descripcion = descripcion;
    }

    public String getDescripcion(){
        return descripcion;
    }
}
