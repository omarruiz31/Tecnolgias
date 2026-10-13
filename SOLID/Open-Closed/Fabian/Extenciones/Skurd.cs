using OCP.Alien;

namespace OCP.Extenciones;

public class Skurd : IAlien
{
    private readonly IAlien _alienBase;
    private readonly IAlien _alienDonador;

    public Skurd(IAlien alienBase, IAlien alienDonador)
    {
        _alienBase = alienBase;
        _alienDonador = alienDonador;
    }

    public string Nombre => $"{_alienBase.Nombre} + Skurd({_alienDonador.Nombre})";
    public string Descripcion => $"{_alienBase.Descripcion} con las habilidades de {_alienDonador.Descripcion}";
    public void UsarHabilidad()
    {
        _alienBase.UsarHabilidad();
        System.Console.WriteLine($"Skurd le prestra las habilidades de");
        _alienDonador.UsarHabilidad();
    }
}
