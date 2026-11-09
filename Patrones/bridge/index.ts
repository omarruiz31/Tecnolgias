import { ControlRemoto } from "./ControlRemoto";
import { ControlRemotoAvanzado } from "./ControlRemotoAvanzado";
import { Radio } from "./Radio";
import { Tv } from "./Tv";

const tv = new Tv();
const radio = new Radio();
const controlTV = new ControlRemoto(tv);
const controlRadio = new ControlRemoto(radio);
const controlProTv = new ControlRemotoAvanzado(tv);
const controlProRadio = new ControlRemotoAvanzado(radio)

console.log("--- TV fcon control basico ---");
controlTV.encender();
controlTV.cambiarVolumen(30);
controlTV.apagar();

console.log("--- TV con control avanzado ---");
controlProTv.encender();
controlProTv.cambiarVolumen(40);
controlProTv.mute();
controlProTv.unmute();
controlProTv.apagar();

console.log("--- Radio con control basico ---");
controlRadio.encender();
controlRadio.cambiarVolumen(60);
controlRadio.apagar();

console.log("--- Radio con control avanzado ---");
controlProRadio.encender()
controlProRadio.cambiarVolumen(80)
controlProRadio.apagar()