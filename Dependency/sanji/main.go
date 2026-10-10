package main

import "fmt"

func main() {
	fmt.Println(" ===== Entorno Real =====")

	pasarelaReal := &AdaptadorMercadoPago{TokenAccess: "isanfiabsfoi"}
	emisorReal := &AdaptadorTwilio{IdentificadorCuenta: "123"}

	servicioReal := NuevoServicioPago(pasarelaReal, emisorReal)
	_ = servicioReal.ProcesarPago("cahng@gmail.com", 1500)

	fmt.Println(" ===== Entorno Pruebas =====")

	pasarelaMock := &SimuladorPasarela{DebeFallar: false}
	emisorMock := &SimuladorEmisor{}

	servicioMock := NuevoServicioPago(pasarelaMock)

}
