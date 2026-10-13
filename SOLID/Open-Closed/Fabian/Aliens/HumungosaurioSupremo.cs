namespace OCP.Alien;

public class HumungusaurioSupremo : Humungusaurio
{
    public override string Nombre => "Humungosaurio Supremo";
    public override void UsarHabilidad()
    {
        base.UsarHabilidad();
        System.Console.WriteLine($"{Nombre} lanza misiles de sus brazos");
    }
}