using OCP.Alien;
using OCP.Extenciones;
using OCP.Fabrica;

namespace OCP.Nucleo;

public class GestorDeAliens
{
    private List<(string Nombre, Func<IAlien> Crear, bool Desbloqueado)> _catalago = new()
    {
        ("Fuego", () => new Fuego(), true),
        ("Humungosaurio", () => new Humungusaurio(),true),
        ("Cuatro Brazos", () => new CuatroBrazos(), true)

    };
    private readonly List<(string Nombre, Func<IAlien> Crear)> _escanearADN = new();

    private readonly Dictionary<Type, Func<IAlien>> _supremos = new()
    {
        {typeof(Humungusaurio), () => new HumungusaurioSupremo()}
    };
    private readonly List<(string Nombre, Func<IAlien> Crear)> _fusiones = new()
    {
        ("Humungosaurio + CuatroBrazos", () => new Fusion<Humungusaurio,CuatroBrazos> ()),
        ("Fuego + Cuatro Brazps", () => new Fusion<Fuego,CuatroBrazos> ()),
        ("Fuego + Humungosaurio", () => new Fusion<Fuego,Humungusaurio>())
    };
    public List<(string Nombre, Func<IAlien> Crear)> ObtenerDesbloqueados()
    {
        var lista = _catalago
            .Where(a => a.Desbloqueado)
            .Select(a => (a.Nombre, a.Crear))
            .ToList();
        lista.AddRange(_escanearADN);
        return lista;
    }
    public void RegistrarADN(MuestraADN muestra)
    {
        var nombre = muestra.Nombre;
        _escanearADN.Add((nombre, () => FabricaAlien.CrearDesdeMuestra(muestra)));
    }
    public bool TieneSupremo(IAlien alien) => _supremos.ContainsKey(alien.GetType());
    public IAlien CrearSupremo(IAlien alien) => _supremos[alien.GetType()]();
    public List<(string Nombre, Func<IAlien> Crear)> ObtenerFusion() => _fusiones;
    public IAlien ElegirAlienAleatorio()
    {
        var disponibles = ObtenerDesbloqueados();
        var indice = Random.Shared.Next(disponibles.Count);
        return disponibles[indice].Crear();
    }
}    
