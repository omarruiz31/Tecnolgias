package main

import "fmt"

type ClienteStripe struct {
	ClaveApi string
}

func (s *ClienteStripe) CobrarTarjeta(monto float64) bool {
	fmt.Printf("[API STRIPE] Enviando $%.2f con la clave %s\n", monto, s.ClaveApi)
	return true
}

type NotificadorSengri struct {
	CorreoRemitente string
}

func (n *NotificadorSengri) EnviarReciboCorreo(monto float64, correo string) {
	fmt.Printf("[API SENGRID] Enviando desde %s a %s la cantidad de %.2f\n", n.CorreoRemitente, correo, monto)
}

type ServicioPago struct {
	clienteStripe *ClienteStripe
	notificador   *NotificadorSengri
}

func NuevoServicioPago() *ServicioPago {
	return &ServicioPago{
		clienteStripe: &ClienteStripe{ClaveApi: "1"},
		notificador:   &NotificadorSengri{CorreoRemitente: "lobita@gmail.com"},
	}
}

func (s *ServicioPago) ProcesarPago(monto float64, correo string) {
	if s.clienteStripe.CobrarTarjeta(monto) {
		s.notificador.EnviarReciboCorreo(monto, correo)
	}
}

func main() {
	servicio := NuevoServicioPago()
	servicio.ProcesarPago(1500.01, "hormonadita@gmail.com")
}
