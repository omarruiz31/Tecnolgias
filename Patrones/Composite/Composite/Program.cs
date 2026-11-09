public class Program
{
    public static void Main(string[] args)
    {
        IComponente ram = new Producto("RAM", 1200);
        IComponente cpu = new Producto("CPU", 300);
        IComponente mouse = new Producto("Mouse", 50);
        IComponente motherBoard = new Producto("MotherBoard", 50);
        IComponente hdd = new Producto("HDD", 500);
        IComponente gpu = new Producto("GPU", 1500);

        Box pcBox = new Box("PC Box");
        Box periphals = new Box("Periphals");
        Box mainBox = new Box("Main Box");

        pcBox.Add(cpu);
        pcBox.Add(ram);
        pcBox.Add(motherBoard);
        pcBox.Add(hdd);
        pcBox.Add(gpu);

        periphals.Add(mouse);

        mainBox.Add(pcBox);
        mainBox.Add(periphals);

        System.Console.WriteLine("Calculo de cajas individuales");
        System.Console.WriteLine($"Total de pc: {pcBox.CalculatePrice()}");
        System.Console.WriteLine($"Total de perifericos: {periphals.CalculatePrice()}");
        System.Console.WriteLine("Calculo de caja general");
        System.Console.WriteLine($"Total de caja general: {mainBox.CalculatePrice()}");

        mainBox.display();

    }
}