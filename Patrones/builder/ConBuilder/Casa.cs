public class Casa
{
    public int Pisos { get; set; }
    public string Color { get; set; } = "Sin definir";
    public string Material { get; set; } = "Sin definir";
    public bool TieneTecho { get; set; }
    public string TipoTecho { get; set; } = "No tiene";
    public bool TieneGarage { get; set; }
    public bool Jardin { get; set; }
    public bool TieneAlberca { get; set; }

    public void Mostrar()
    {
        Console.WriteLine("Mi casa tiene:");
        Console.WriteLine($"Pisos: {Pisos}");
        Console.WriteLine($"Color: {Color}");
        Console.WriteLine($"Material: {Material}");
        Console.WriteLine($"Tiene techo: {(TieneTecho ? "Sí" : "No")}");
        Console.WriteLine($"Tipo de techo: {TipoTecho}");
        Console.WriteLine($"Tiene garage: {(TieneGarage ? "Sí" : "No")}");
        Console.WriteLine($"Tiene jardín: {(Jardin ? "Sí" : "No")}");
        Console.WriteLine($"Tiene alberca: {(TieneAlberca ? "Sí" : "No")}");
    }
}

