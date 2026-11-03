/**
 * PATRÓN DE DISEÑO BRIDGE (PUENTE) EN JAVASCRIPT
 *
 * Desacopla una Abstracción (ControlRemoto) de su Implementación (Dispositivo),
 * permitiendo que ambas partes evolucionen de manera independiente.
 */

// ===============================================================
// 1. IMPLEMENTADOR (Interfaz / Contrato conceptual)
// ===============================================================
// En JavaScript no hay interfaces nativas, por lo que usamos una clase base
// que define los métodos que deben implementar los dispositivos concretos.
class Dispositivo {
  encender() {
    throw new Error("El método encender() debe ser implementado.");
  }

  apagar() {
    throw new Error("El método apagar() debe ser implementado.");
  }

  estaEncendido() {
    throw new Error("El método estaEncendido() debe ser implementado.");
  }

  getVolumen() {
    throw new Error("El método getVolumen() debe ser implementado.");
  }

  setVolumen(valor) {
    throw new Error("El método setVolumen() debe ser implementado.");
  }
}

// ===============================================================
// 2. IMPLEMENTADORES CONCRETOS
// ===============================================================
class Televisor extends Dispositivo {
  constructor() {
    super();
    this.encendido = false;
    this.volumen = 20;
  }

  encender() {
    this.encendido = true;
    console.log("[TV] Encendida.");
  }

  apagar() {
    this.encendido = false;
    console.log("[TV] Apagada.");
  }

  estaEncendido() {
    return this.encendido;
  }

  getVolumen() {
    return this.volumen;
  }

  setVolumen(valor) {
    this.volumen = Math.max(0, Math.min(100, valor));
    console.log(`[TV] Volumen ajustado a: ${this.volumen}`);
  }
}

class Radio extends Dispositivo {
  constructor() {
    super();
    this.encendido = false;
    this.volumen = 10;
  }

  encender() {
    this.encendido = true;
    console.log("[Radio] Encendida sintonizando emisora.");
  }

  apagar() {
    this.encendido = false;
    console.log("[Radio] Apagada.");
  }

  estaEncendido() {
    return this.encendido;
  }

  getVolumen() {
    return this.volumen;
  }

  setVolumen(valor) {
    this.volumen = Math.max(0, Math.min(50, valor));
    console.log(`[Radio] Volumen ajustado a: ${this.volumen}`);
  }
}

// ===============================================================
// 3. ABSTRACCIÓN (Lógica de alto nivel)
// ===============================================================
class ControlRemoto {
  constructor(dispositivo) {
    // Aquí está el "PUENTE": una referencia al implementador
    this.dispositivo = dispositivo;
  }

  botonEncendido() {
    if (this.dispositivo.estaEncendido()) {
      this.dispositivo.apagar();
    } else {
      this.dispositivo.encender();
    }
  }

  subirVolumen() {
    const actual = this.dispositivo.getVolumen();
    this.dispositivo.setVolumen(actual + 5);
  }

  bajarVolumen() {
    const actual = this.dispositivo.getVolumen();
    this.dispositivo.setVolumen(actual - 5);
  }
}

// ===============================================================
// 4. ABSTRACCIÓN REFINADA (Añade características al control)
// ===============================================================
class ControlAvanzado extends ControlRemoto {
  silenciar() {
    console.log("-> Botón [Mute] presionado.");
    this.dispositivo.setVolumen(0);
  }
}

// ===============================================================
// 5. CÓDIGO CLIENTE (Demostración de uso)
// ===============================================================
const tv = new Televisor();
const radio = new Radio();

console.log("=== Control Básico con TV ===");
const controlTv = new ControlRemoto(tv);
controlTv.botonEncendido();
controlTv.subirVolumen();

console.log("\n=== Control Avanzado con Radio ===");
const controlRadio = new ControlAvanzado(radio);
controlRadio.botonEncendido();
controlRadio.subirVolumen();
controlRadio.silenciar();

console.log("\n=== Cambiando el dispositivo en tiempo de ejecución ===");
// El mismo control remoto puede operar la TV simplemente cambiando el puente
controlRadio.dispositivo = tv;
controlRadio.subirVolumen();
controlRadio.silenciar();

