from abc import ABC, abstractmethod

class Personaje(ABC):
    def __init__(self, nombre, vida):
        self.nombre = nombre
        self.vida = vida

    def recibir_danio(self, cantidad):
        self.vida -= cantidad
        print(f"{self.nombre} recibe {cantidad} de daño")
        print(f"vida restante: {self.vida}")

    @abstractmethod
    def atacar(self):
        pass


class ICurable(ABC):
    @abstractmethod
    def curar(self, objetivo):
        pass

class Guerrero(Personaje):
    def atacar(self):
        print(f"{self.nombre} ataca con su espada")

class Mago(Personaje):
    def atacar(self):
        print(f"{self.nombre} ataca con una bola de fuego")

    def curar(self, objetivo):
        objetivo.vida += 20
        print(f"{self.nombre} cura a {objetivo.nombre} + 20 de vida ")

class Soporte(Personaje):
    def atacar(self):
        print(f"{self.nombre} Ataca con baston")

    def curar(self, objetivo):
            objetivo.vida += 20
            print(f"{self.nombre} cura a {objetivo.nombre} + 20 de vida ")


guerrero = Guerrero("Guerrero1", 100)
mago  = Mago("Mago1",60)
soporte = Soporte("Soporte1", 70)

guerrero.atacar()
mago.atacar()    
soporte.atacar()


guerrero.recibir_danio(30)
mago.curar(guerrero)
soporte.curar(guerrero)

print(f"Vida final de {guerrero.nombre}: {guerrero.vida}")
