from extras.extra_taco import ExtraTaco

class DescuentoEstudiante(ExtraTaco):
    def descripcion(self) -> str:
        return self._taco.descripcion() + "10% de descuento"

    def precio(self) -> float:
        return self._taco.precio() * 0.90

    def calorias(self) -> int:
        return self._taco.calorias()