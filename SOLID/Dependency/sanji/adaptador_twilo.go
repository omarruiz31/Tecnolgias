package main

import "fmt"

type AdaptadorTwilio struct {
	IdentificadorCuenta string
}

func (at *AdaptadorTwilio) Enviar(correo string, monto float64) error {
	fmt.Printf("[Twilio] Comprobante enviado al correo %s, por el monto de %.2f (Cuenta: %s)", correo, monto, at.IdentificadorCuenta)
	return nil
}
