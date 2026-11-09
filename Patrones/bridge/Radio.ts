import { Dispositivo } from "./Dispositivo";

export class Radio implements Dispositivo {
    private encendida = false;
    private volumen = 10;

    encender(): void {
        if (this.encendida) {
            console.log("La radio ya esta encendida");
            return;
        }
        this.encendida = true;
        console.log("Encendiendo la radio");
    }

    apagar(): void {
        if (!this.encendida) {
            console.log("La radio ya esta apagada");
            return;
        }
        this.encendida = false;
        console.log("Apagando la radio");
    }

    cambiarVolumen(volumen: number): void {
        if (!this.encendida) {
            console.log("La radio esta apagada, no se puede cambiar el volumen");
            return;
        }
        if (volumen < 0 || volumen > 100) {
            console.log("El volumen debe estar entre 0 y 100");
            return;
        }
        this.volumen = volumen;
        console.log(`Nuevo volumen : ${this.volumen}`);
    }
}
