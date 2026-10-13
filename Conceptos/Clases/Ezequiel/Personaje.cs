abstract class Personaje
{
    public string Nombre { get; private set; }
    public int PuntosVida { get; set; }

    public bool EstadoVida { get => PuntosVida > 0; }

    public Personaje(string Nombre)
    {
        this.Nombre = Nombre;
        PuntosVida = 100;

    }

    public void RecibirDanio(int cantidad)
    {
        PuntosVida -= cantidad;
        if (PuntosVida < 0) PuntosVida = 0;
        System.Console.WriteLine($"{Nombre} recibe {cantidad} puntos de daño. Puntos de vida actuales: {PuntosVida}");
    }

    public abstract void Ataque(Personaje objetivo);

}

