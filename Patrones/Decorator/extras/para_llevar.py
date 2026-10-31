from extras.extra_taco import ExtraTaco

class ParaLlevar(ExtraTaco):

    def descripcion(self) -> str:
        return self._taco.descripcion() + "(para llevar)"

    def precio(self) -> float:
        return self._taco.precio() + 5
    
    