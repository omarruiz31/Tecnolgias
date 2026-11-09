export interface Dispositivo {
    encender(): void;
    apagar(): void;
    cambiarVolumen(volumen: number): void;
}
