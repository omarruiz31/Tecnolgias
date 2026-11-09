import { Dispositivo } from "./Dispositivo";

export class Tv implements Dispositivo {
    private encendida = false;
    private volumen = 10;

    encender(): void {
        if (this.encendida) {
            console.log("La tv ya esta encendida");
            return;
        }
        this.encendida = true;
        console.log("Encendiendo la tv");
    }

    apagar(): void {
        if (!this.encendida) {
            console.log("La tv ya esta apagada");
            return;
        }
        this.encendida = false;
        console.log("Apagando la tv");
    }

    cambiarVolumen(volumen: number): void {
        if (!this.encendida) {
            console.log("La tv esta apagada, no se puede cambiar el volumen");
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
