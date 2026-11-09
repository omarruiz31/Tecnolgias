import { ControlRemoto } from "./ControlRemoto";

export class ControlRemotoAvanzado extends ControlRemoto {
    private volumenAnterior?: number;

    cambiarVolumen(volumen: number): void {
        this.volumenAnterior = volumen;
        super.cambiarVolumen(volumen);
    }

    mute(): void {
        this.dispositivo.cambiarVolumen(0);
        console.log("El dispositivo esta en mute");
    }

    unmute(): void {
        if (this.volumenAnterior === undefined) {
            console.log("No hay un volumen previo para restaurar");
            return;
        }
        this.dispositivo.cambiarVolumen(this.volumenAnterior);
        console.log(`Volumen restaurado a ${this.volumenAnterior}`);
        this.volumenAnterior = undefined;
    }
}
