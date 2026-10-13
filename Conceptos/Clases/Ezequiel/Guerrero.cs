class Guerrero : Personaje
{
    public Guerrero(string nombre) : base(nombre)
    {

    }

    public override void Ataque(Personaje objetivo)
    {
        System.Console.WriteLine($"{Nombre} ataca a {objetivo.Nombre} con su espada a {objetivo.Nombre}");
        objetivo.RecibirDanio(30);
    }


}