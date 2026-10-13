using OCP.Alien;

namespace OCP.Extenciones;

public class Fusion<TAlienA, TAlienB> : IAlien
    where TAlienA : IAlien, new()
    where TAlienB : IAlien, new()
{
    private readonly TAlienA _alienA = new();
    private readonly TAlienB _alienB = new();

    public string Nombre => $"Fusion {_alienA.Nombre} + {_alienB.Nombre}";
    public string Descripcion => $" Habilidades combinadas de {_alienA.Nombre} y {_alienB.Nombre}";

    public void UsarHabilidad()
    {
        System.Console.WriteLine($" activas ambas mitades de ADN fusionando:");
        _alienA.UsarHabilidad();
        _alienB.UsarHabilidad();
    }
}