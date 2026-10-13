from dispositivos import DispositivoElectronico
from mixins import ConexionWiFi, BateriaRecargable, SensorMovimiento

class CamaraSeguridadInalambrica(DispositivoElectronico, ConexionWiFi , BateriaRecargable, SensorMovimiento):
    def __init__(self, marca, modelo ):
        DispositivoElectronico.__init__(self, marca, modelo)
        ConexionWiFi.__init__(self)
        BateriaRecargable.__init__(self, nivel_bateria = 100 )

    def reporte_completo(self):
        texto = f"--- {self.marca} {self.modelo} ---\n"
        texto += f"Estado actual: {'Encendida' if self.estado else 'Apagada'}\n"

        if self.red_conectada:
            texto += f"🟢Red: Conectado a {self.red_conectada}\n IP: {self.ip}\n"
        else:
            texto += "🔴Red: Desconcetado\n"

        texto += f"Bateria: {self.nivel_bateria}%"
        if self.nivel_bateria == 0:
            texto += "[NECESITA CARGA]"
        return texto