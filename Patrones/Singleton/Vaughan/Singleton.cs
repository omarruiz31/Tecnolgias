using System;
using System.Collections.Generic;
using System.Security.Cryptography;

public class Producto
{
    public int Codigo;
    public int Cantidad;

    public Producto(int codigo, int cantidad)
    {
        Codigo = codigo;
        Cantidad = cantidad;
    }
}

public class AlmacenCentral
{
    public List <Producto> productos = new List<Producto>();

    public AlmacenCentral(){}

    public static AlmacenCentral Instancia => new AlmacenCentral();

    public void RegistrarProducto(Producto producto)
    {
        productos.Add(producto);
        System.Console.WriteLine("Registrado ");
    }

    public void VenderProducto(int codigo, int cantidad)
    {
        Producto producto = productos.Find(p => p.Codigo == codigo);
        if (producto == null)
        {
            System.Console.WriteLine("Producto no encontrado");
            return;
        }

        producto.Cantidad -= cantidad;
        System.Console.WriteLine($"Venta realizada . Stock {producto.Cantidad}");
    }
}

public class Program
{
    public static void Main()
    {
        AlmacenCentral.Instancia.RegistrarProducto(new Producto(676,10));
        AlmacenCentral.Instancia.VenderProducto(676,3);
        System.Console.WriteLine(ReferenceEquals(AlmacenCentral.Instancia, AlmacenCentral.Instancia));
    }
}

