import random

class ConexionWiFi:
    def __init__(self):
        self.red_conectada = None
        self.ip = None

    def conectar(self, red):
        self.red_conectada = red
        self.ip = f"192.168.1{random.randint(10, 200)}"

    def desconectar(self):
        self.red_conectada = None
        self.ip = None

class BateriaRecargable:
    def __init__(self, nivel_bateria = 100):
        self.nivel_bateria = nivel_bateria

    def cargar_bateria (self):
        self.nivel_bateria = 100

    def consumir_bateria(self, cantidad = 2):
        if self.nivel_bateria > 0:
            self.nivel_bateria -= cantidad
        if self.nivel_bateria <= 0:
            self.nivel_bateria = 0

class SensorMovimiento:
    def detectar_movimiento(self):
        return random.choice([True, False, False])

        