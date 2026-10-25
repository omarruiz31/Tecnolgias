from taco import Taco
from pedido import Pedido
from tacos.taco_pastor import TacoPastor
from tacos.taco_suadero import TacoSuadero
from tacos.taco_bistec import TacoBistec
from extras.con_queso import ConQueso
from extras.con_guacamole import ConGuacamole
from extras.con_pina import ConPina
from extras.con_salsa_habanera import ConSalsaHabanera
from extras.para_llevar import ParaLlevar


class Taqueria:
    """Atiende al cliente por consola: arma los tacos envolviéndolos con extras."""

    def __init__(self):
        self._menu_tacos = {
            "1": TacoPastor,
            "2": TacoSuadero,
            "3": TacoBistec,
        }
        self._menu_extras = {
            "1": ConQueso,
            "2": ConGuacamole,
            "3": ConPina,
            "4": ConSalsaHabanera,
            "5": ParaLlevar,
        }

    def atender(self) -> None:
        nombre = input("¿A nombre de quién es el pedido? ")
        pedido = Pedido(nombre)

        while True:
            taco = self._armar_taco()
            if taco is not None:
                pedido.agregar(taco)
            otro = input("\n¿Quieres otro taco? (s/n) ")
            if otro.lower() != "s":
                break

        if pedido.esta_vacio():
            print("No se pidió ningún taco. ¡Vuelva pronto!")
            return

        estudiante = input("¿Eres estudiante? (s/n) ")
        if estudiante.lower() == "s":
            pedido.aplicar_descuento_estudiante()

        pedido.imprimir_ticket()

    def _armar_taco(self) -> Taco | None:
        print("\n¿Qué taco quieres?  1. Pastor  2. Suadero  3. Bistec")
        opcion = input("> ")
        if opcion not in self._menu_tacos:
            print("Opción no válida")
            return None

        taco = self._menu_tacos[opcion]()

        while True:
            print(f"\nTu taco: {taco.descripcion()}  (${taco.precio():.2f})")
            print("Agregar: 1. Queso  2. Guacamole  3. Piña  4. Salsa habanera  5. Para llevar  0. Listo")
            opcion = input("> ")
            if opcion == "0":
                return taco
            if opcion in self._menu_extras:
                taco = self._menu_extras[opcion](taco)
            else:
                print("Opción no válida")
                