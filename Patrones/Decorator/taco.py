from abc import ABC, abstractmethod


class Taco(ABC):

    @abstractmethod
    def descripcion(self) -> str:
        pass

    @abstractmethod
    def precio(self) -> float:
        pass

    @abstractmethod
    def calorias(self) -> int:
        pass
