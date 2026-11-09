public class Producto : IComponente
{
    private readonly decimal _price;
    public string Name { get; }

    public Producto(string name, decimal price)
    {
        Name = name;
        _price = price;
    }

    public decimal CalculatePrice() => _price;
    public void display(int indent = 0)
    {
        Console.WriteLine(new string('-', indent) + $"{Name}: ${_price}");
    }
}