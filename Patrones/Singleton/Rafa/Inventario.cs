public class Inventario
{
    private readonly IAlmacen _almacen;

    public Inventario(IAlmacen almacen)
    {
        _almacen = almacen;
    }

    public bool RegistrarProducto(string nombre,int codigo, double precio , int cantidad)
    {
        if(_almacen.BuscarProducto(codigo))== null{
            Producto nuevo = new Producto(nombre,codigo,precio,cantidad);
            _almacen.AgregarProducto(nuevo);
            return true;
        }
        return false;
    }
}