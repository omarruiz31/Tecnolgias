public class Box : IComponente
{
    public readonly List<IComponente> _children = new List<IComponente>();
    public string Name { get; }

    public Box(string name)
    {
        this.Name = name;
    }

    public void Add(IComponente componente)
    {
        _children.Add(componente);
    }
    public void Remove(IComponente componente)
    {
        _children.Remove(componente);
    }

    public decimal CalculatePrice() => _children.Sum(child => child.CalculatePrice());

    public void display(int indent = 0)
    {
        Console.WriteLine(new string('-', indent) + $"Caja: {Name}");
        foreach (var child in _children)
        {
            child.display(indent + 2);
        }
    }
}