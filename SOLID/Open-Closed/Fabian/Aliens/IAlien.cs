namespace OCP.Alien;

public interface IAlien
{
    public string Nombre { get; }
    public string Descripcion { get; }
    public void UsarHabilidad();
}