import { Dispositivo } from "./Dispositivo";

export class ControlRemoto {
    protected dispositivo: Dispositivo;

    constructor(dispositivo: Dispositivo) {
        this.dispositivo = dispositivo;
    }

    encender(): void {
        this.dispositivo.encender();
    }

    apagar(): void {
        this.dispositivo.apagar();
    }

    cambiarVolumen(volumen: number): void {
        this.dispositivo.cambiarVolumen(volumen);
    }
}
