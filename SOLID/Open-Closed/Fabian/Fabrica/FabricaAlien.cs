using OCP.Alien;

namespace OCP.Fabrica;

public static class FabricaAlien
{
    public static IAlien CrearDesdeMuestra(MuestraADN muestra)
    {
        return new CreadorAlien(muestra.Nombre, muestra.Descripcion, muestra.Habilidad);

    }
}