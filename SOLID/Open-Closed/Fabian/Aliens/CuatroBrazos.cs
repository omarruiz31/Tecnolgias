namespace OCP.Alien;

public class CuatroBrazos : IAlien
{
    public virtual string Nombre => "Cuatros Brazos";
    public virtual string Descripcion => "Tetramand | Posee super fuerza, piel bliendada y cuatro brazos";
    public virtual void UsarHabilidad()
    {
        System.Console.WriteLine($"{Nombre} ataca con aplauso sonico");
    }
}