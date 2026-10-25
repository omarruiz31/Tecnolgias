from taco import Taco
from extras.descuento_estudiante import DescuentoEstudiante

class Pedido:
    def __init__(self, cliente: str):
        self._cliente = cliente
        self._tacos: list[Taco] = []
    
    def agregar(self, taco: Taco) -> None:
        self._tacos.append(taco)

    def esta_vacio(self) -> bool:
        return len(self._tacos) == 0

    def aplicar_descuento_estudiante(self) -> None:
        for i in range(len(self._tacos)):
            self._tacos[i] = DescuentoEstudiante(self._tacos[i])

    def total(self) -> float:
        suma = 0.0
        for taco in self._tacos:
            suma += taco.precio()
        return suma
    
    def imprimir_ticket(self) -> None:
        print("\n Taqueria mag")
        print(f"Cliente: {self._cliente}")
        for numero, taco in enumerate(self._tacos, start = 1):
            print(f"{numero}. {taco.descripcion()}")
            print(f"    ${taco.precio():.2f} | {taco.calorias()} kcal")
        
        print("------------------")
        print(f"Total: ${self.total():.2f}")