namespace OCP.Alien;

public class Humungusaurio : IAlien
{
    public virtual string Nombre => "Humungosaurio";
    public virtual string Descripcion => "Vaxasaurio | Posee super fuerza y puedes crecer hasta 20 metros";
    public virtual void UsarHabilidad()
    {
        System.Console.WriteLine($"{Nombre} golpea el suelo y crea un mini terremoto");
    }
}