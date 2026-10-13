class DispositivoElectronico:
    def __init__(self, marca, modelo):
        self.marca = marca
        self.modelo = modelo
        self.estado = False #Apagado por defecto

    def encender(self):
        self.estado = True

    def apagar(self):
        self.estado = False

    def estado_actual(self):
        return "Encendido" if self.estado else "Apagado"


class FocoInteligente(DispositivoElectronico):
    def __init__(self, marca, modelo, color = "Blanco"):
        super().__init__(marca,modelo)
        self.color = color

    def cambiar_color(self, nuevo_color):
        if self.estado:
            self.color = nuevo_color
            return True
        return False