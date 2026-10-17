public interface ICasaBuilder
{
    public ICasaBuilder ConPisos(int pisos);
    public ICasaBuilder ConColor(string color);
    public ICasaBuilder ConMaterial();
    public ICasaBuilder ConTecho();
    public ICasaBuilder ConGarage();
    public ICasaBuilder ConJardin();
    public ICasaBuilder ConAlberca();
    public Casa Build();
}