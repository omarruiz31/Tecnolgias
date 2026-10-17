using System.Runtime.CompilerServices;
using System;

public class Program
{
    public static void Main()
    {
        Casa personalizada = new CasaBuilder()
        .ConAlberca()
        .ConColor("Azul")
        .ConTecho()
        .ConMaterial()
        .Build();

        Casa personalizada1 = new CasaBuilderModerna()
        .ConAlberca()
        .ConColor("Amarillo")
        .ConTecho()
        .ConMaterial()
        .Build();

        Director director = new Director(new CasaBuilder());
        Director director1 = new Director(new CasaBuilderModerna());

        Casa basica = director.ConstruirCasaBasica();
        Casa deLujo = director1.ConstruirCasaDeLujo();

        Casa menosBasica = director1.ConstruirCasaDeLujo();

        personalizada.Mostrar();
        personalizada1.Mostrar();
        basica.Mostrar();
        deLujo.Mostrar();
    }
}