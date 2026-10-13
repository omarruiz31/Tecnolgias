public class Venta
{
    private readonly IALmacen _almacen;

    public Venta(IAlmacen almacen)
    {
        _almacen = almacen;
    }

    public bool CobrarProducto(int codigo, int cantidad)
    {
        Producto venta = _almacen.BuscarProducto(codigo);
        if(venta == null) return false;
        double total = venta.Precio * cantidad;
        System.Console.WriteLine($"[CAJA]: Venta realizada con exit por el producto ${venta.Nombre}, total: ${total}");
    }
}