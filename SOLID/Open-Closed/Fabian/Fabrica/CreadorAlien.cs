namespace OCP.Alien;

public class CreadorAlien : IAlien
{
    public string Nombre { get; }
    public string Descripcion { get; }
    private readonly string _habilidad;
    public CreadorAlien(string nombre, string descripcion, string habilidad)
    {
        Nombre = nombre;
        Descripcion = descripcion;
        _habilidad = habilidad;
    }

    public void UsarHabilidad()
    {
        System.Console.WriteLine($"{Nombre} : {_habilidad}");
    }
}
