from abc import ABC, abstractmethod


class Taco(ABC):

    @abstractmethod
    def descripcion(self) -> str:
        pass

    @abstractmethod
    def costo(self) -> float:
        pass
