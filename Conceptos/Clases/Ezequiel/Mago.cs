class Mago : Personaje, IHabilidadEspecial
{
    public Mago(string nombre) : base(nombre)
    {

    }

    public override void Ataque(Personaje objetivo)
    {
        Console.WriteLine($"{Nombre} ataca a {objetivo.Nombre} con su bola de fuego a {objetivo.Nombre}");
        objetivo.RecibirDanio(15);
    }

    public void UsarHabilidad()
    {
        PuntosVida += 30;
        if (PuntosVida > 100) PuntosVida = 100;
        System.Console.WriteLine($"{Nombre} regenero 30 de vida, su vida actual es {PuntosVida}");
    }
}