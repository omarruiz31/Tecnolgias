package main

type EmisorComprobante interface {
	Enviar(correo string, monto float64) error
}
