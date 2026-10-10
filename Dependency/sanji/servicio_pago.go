package main

import "fmt"

type ServicioPago struct {
	pasarela PasarelaPago
	emisor   EmisorComprobante
}

func NuevoServicioPago(pasarela PasarelaPago, emisor EmisorComprobante) *ServicioPago {
	return &ServicioPago{
		emisor:   emisor,
		pasarela: pasarela,
	}
}

func (sp *ServicioPago) ProcesarPago(correo string, monto float64) error {
	if err := sp.pasarela.Cobrar(monto); err != nil {
		fmt.Errorf("No se pudo realizar el cobro de %w", &err)
		return nil
	}
	if err := sp.emisor.Enviar(correo, monto); err != nil {
		fmt.Errorf("No se puede enviar el comprobante %w", err)
		return nil
	}

	return nil
}
