Guerrero guerrero1 = new Guerrero("kratos");
Mago mago1 = new Mago("Gandalf");

System.Console.WriteLine("Duelo");
System.Console.WriteLine($"{mago1.Nombre} vs {guerrero1.Nombre}");

while (mago1.EstadoVida && guerrero1.EstadoVida)
{
    System.Console.WriteLine("1.Guerrero Ataca a Mago");
    System.Console.WriteLine("2.Mago Ataca a Guerrero");
    System.Console.WriteLine("3.Mago usa habilidad");
    System.Console.WriteLine("Elija una opcion");

    string? opcion = Console.ReadLine();

    switch (opcion)
    {
        case "1":
            guerrero1.Ataque(mago1);
            break;
        case "2":
            mago1.Ataque(guerrero1);
            break;
        case "3":
            mago1.UsarHabilidad();
            break;
        default:
            System.Console.WriteLine("Opcion no valida");
            break;
    }

    if (mago1.EstadoVida)
    {
        System.Console.WriteLine("Gana mago");
    }
    else
    {
        System.Console.WriteLine("Gana guerrero");
    }
}