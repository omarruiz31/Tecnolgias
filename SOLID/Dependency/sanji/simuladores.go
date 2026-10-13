package main

import (
	"errors"
	"fmt"
)

type SimuladorPasarela struct {
	DebeFallar bool
}

func (sp *SimuladorPasarela) Cobrar(monto float64) error {
	if sp.DebeFallar {
		return errors.New("Fondos insuficientes")
	}

	fmt.Printf("Cobro realizado por el monto de %.2f\n", monto)
	return nil
}

type SimuladorEmisor struct{}

func (se *SimuladorEmisor) Enviar(correo string, monto float64) error {
	fmt.Printf("[Simulador] Comporbante enviado al correo %s, por el monto de %.2f\n", correo, monto)
	return nil
}
