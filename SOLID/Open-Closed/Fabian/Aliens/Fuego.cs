namespace OCP.Alien;

public class Fuego : IAlien
{
    public virtual string Nombre => "Fuego";
    public virtual string Descripcion => "Pyronita | Ser compuesto por plasma y rocas volcanicas";
    public virtual void UsarHabilidad()
    {
        System.Console.WriteLine($"{Nombre} lanza bolas de fuego");
    }
}