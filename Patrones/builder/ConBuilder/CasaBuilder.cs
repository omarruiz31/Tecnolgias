public class CasaBuilder : ICasaBuilder
{
    private Casa _casa = new Casa();

    public ICasaBuilder ConPisos(int pisos)
    {
        _casa.Pisos = pisos;
        return this;
    }

    public ICasaBuilder ConColor(string color)
    {
        _casa.Color = color;
        return this;
    }

    public ICasaBuilder ConMaterial()
    {
        _casa.Material = "Madera";
        return this;
    }

    public ICasaBuilder ConTecho()
    {
        _casa.TieneTecho = true;
        _casa.TipoTecho = "Lamina";
        return this;
    }

    public ICasaBuilder ConGarage()
    {
        _casa.TieneGarage = true;
        return this;
    }

    public ICasaBuilder ConJardin()
    {
        _casa.Jardin = true;
        return this;
    }

    public ICasaBuilder ConAlberca()
    {
        _casa.TieneAlberca = true;
        return this;
    }

    public Casa Build()
    {
        Casa resultado = _casa;
        _casa = new Casa();
        return resultado;
    }
}