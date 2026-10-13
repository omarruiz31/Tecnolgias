import tkinter as tk
from tkinter import ttk, messagebox
import sys
import os

# Asegurar importaciones
sys.path.append(os.path.dirname(os.path.abspath(__file__)))

from dispositivos import FocoInteligente
from camara import CamaraSeguridadInalambrica

class SmartHomeProGUI:
    def __init__(self, root):
        self.root = root
        self.root.title("Domótica Pro v2.0")
        self.root.geometry("800x550")
        self.root.configure(bg="#1e272e") # Dark theme
        self.root.resizable(False, False)

        # Configurar Estilos Modernos
        style = ttk.Style()
        style.theme_use('clam')
        style.configure("TFrame", background="#1e272e")
        style.configure("TLabelframe", background="#2f3640", foreground="#f5f6fa", borderwidth=2)
        style.configure("TLabelframe.Label", background="#2f3640", foreground="#f5f6fa", font=("Segoe UI", 12, "bold"))
        style.configure("TButton", font=("Segoe UI", 10, "bold"), padding=5, background="#485460", foreground="white")
        style.map("TButton", background=[("active", "#0fb9b1")])
        
        # Objetos
        self.foco = FocoInteligente("Xiaomi", "Mi Light")
        self.camara = CamaraSeguridadInalambrica("Ring", "Pro 2")

        # Diccionario de colores (Nombre -> Hexadecimal para mostrarlo visualmente)
        self.colores_hex = {
            "Blanco": "#ffffff",
            "Azul": "#0984e3",
            "Rojo": "#d63031",
            "Verde": "#00b894",
            "Morado": "#6c5ce7",
            "Amarillo": "#fdcb6e"
        }

        self.crear_interfaz()
        
        # Iniciar el reloj interno que descarga la batería (cada 3 segundos)
        self.root.after(3000, self.ciclo_bateria)

    def crear_interfaz(self):
        # Título
        titulo = tk.Label(self.root, text="⚡ Smart Home Control Panel v2.0", font=("Segoe UI", 20, "bold"), bg="#1e272e", fg="#00d2d3")
        titulo.pack(pady=15)

        # Contenedor principal
        main_frame = ttk.Frame(self.root)
        main_frame.pack(fill="both", expand=True, padx=20, pady=10)

        # ==========================================
        # PANEL IZQUIERDO: FOCO (HERENCIA SIMPLE)
        # ==========================================
        frame_foco = ttk.LabelFrame(main_frame, text=" 💡 Foco Inteligente ")
        frame_foco.pack(side="left", fill="both", expand=True, padx=(0, 10))

        # Indicador visual del foco
        self.indicador_luz = tk.Canvas(frame_foco, width=100, height=100, bg="#2f3640", highlightthickness=0)
        self.luz_dibujo = self.indicador_luz.create_oval(10, 10, 90, 90, fill="#2d3436", outline="#636e72", width=3)
        self.indicador_luz.pack(pady=15)

        self.lbl_estado_foco = tk.Label(frame_foco, text="Estado: APAGADO", bg="#2f3640", fg="#ff7675", font=("Segoe UI", 11, "bold"))
        self.lbl_estado_foco.pack(pady=5)

        # Botones Foco
        btn_foco_frame = ttk.Frame(frame_foco)
        btn_foco_frame.pack(pady=10)
        
        ttk.Button(btn_foco_frame, text="Encender", command=lambda: [self.foco.encender(), self.actualizar_ui()]).grid(row=0, column=0, padx=5)
        ttk.Button(btn_foco_frame, text="Apagar", command=lambda: [self.foco.apagar(), self.actualizar_ui()]).grid(row=0, column=1, padx=5)

        # Selector de colores
        tk.Label(frame_foco, text="Selecciona un color:", bg="#2f3640", fg="white", font=("Segoe UI", 10)).pack(pady=(10,0))
        
        self.combo_color = ttk.Combobox(frame_foco, values=list(self.colores_hex.keys()), state="readonly")
        self.combo_color.set("Azul")
        self.combo_color.pack(pady=5)
        
        ttk.Button(frame_foco, text="Aplicar Color", command=self.aplicar_color).pack(pady=5)


        # ==========================================
        # PANEL DERECHO: CÁMARA (HERENCIA MÚLTIPLE)
        # ==========================================
        frame_camara = ttk.LabelFrame(main_frame, text=" 📷 Cámara de Seguridad ")
        frame_camara.pack(side="right", fill="both", expand=True, padx=(10, 0))

        self.lbl_reporte_cam = tk.Label(frame_camara, text="", bg="#2f3640", fg="#f1f2f6", font=("Consolas", 11), justify="left")
        self.lbl_reporte_cam.pack(pady=15, padx=10, anchor="w")

        # Barra de progreso para la batería
        self.barra_bat = ttk.Progressbar(frame_camara, orient="horizontal", length=250, mode="determinate")
        self.barra_bat.pack(pady=10)

        # Botones Cámara
        btn_cam_frame1 = ttk.Frame(frame_camara)
        btn_cam_frame1.pack(pady=5)
        ttk.Button(btn_cam_frame1, text="Encender", command=lambda: [self.camara.encender(), self.actualizar_ui()]).grid(row=0, column=0, padx=5)
        ttk.Button(btn_cam_frame1, text="Apagar", command=lambda: [self.camara.apagar(), self.actualizar_ui()]).grid(row=0, column=1, padx=5)
        
        btn_cam_frame2 = ttk.Frame(frame_camara)
        btn_cam_frame2.pack(pady=5)
        ttk.Button(btn_cam_frame2, text="Conectar WiFi", command=lambda: [self.camara.conectar("FibraOptica_5G"), self.actualizar_ui()]).grid(row=0, column=0, padx=5)
        ttk.Button(btn_cam_frame2, text="Desconectar", command=lambda: [self.camara.desconectar(), self.actualizar_ui()]).grid(row=0, column=1, padx=5)

        btn_cam_frame3 = ttk.Frame(frame_camara)
        btn_cam_frame3.pack(pady=5)
        ttk.Button(btn_cam_frame3, text="Forzar Detección", command=self.simular_sensor).grid(row=0, column=0, padx=5)
        ttk.Button(btn_cam_frame3, text="Cargar 🔋", command=lambda: [self.camara.cargar_bateria(), self.actualizar_ui()]).grid(row=0, column=1, padx=5)

        self.actualizar_ui()

    def aplicar_color(self):
        color_elegido = self.combo_color.get()
        # Intentar cambiar de color (solo funcionará si está encendido según la lógica de la clase)
        if not self.foco.cambiar_color(color_elegido):
            messagebox.showwarning("Foco Apagado", "¡Debes encender el foco primero para cambiar de color!")
        self.actualizar_ui()

    def simular_sensor(self):
        if not self.camara.estado:
            messagebox.showerror("Error", "La cámara está apagada. El sensor no funciona.")
            return
            
        if self.camara.nivel_bateria == 0:
            messagebox.showerror("Sin Batería", "La cámara no tiene batería para detectar movimiento.")
            return

        if self.camara.detectar_movimiento():
            messagebox.showinfo("¡ALERTA DE SEGURIDAD!", "🚨 ¡Movimiento detectado en el perímetro! 🚨")
        else:
            messagebox.showinfo("Todo despejado", "No hay nadie en el patio.")
        
        # Al usar el sensor se gasta un poco más de batería
        self.camara.consumir_bateria(5)
        self.actualizar_ui()

    def ciclo_bateria(self):
        # Esta función se ejecuta automáticamente cada 3 segundos
        if self.camara.estado and self.camara.nivel_bateria > 0:
            self.camara.consumir_bateria(2) # Gasta 2%
            
            if self.camara.nivel_bateria == 0:
                self.camara.apagar()
                self.camara.desconectar()
                messagebox.showwarning("Batería Agotada", "La cámara se apagó por falta de batería.")
                
        self.actualizar_ui()
        # Volver a programar el ciclo
        self.root.after(3000, self.ciclo_bateria)

    def actualizar_ui(self):
        # --- FOCO ---
        if self.foco.estado:
            self.lbl_estado_foco.config(text=f"Estado: ENCENDIDO ({self.foco.color})", fg="#00b894") 
            # Cambiar color visual del Canvas
            hex_color = self.colores_hex.get(self.foco.color, "#ffffff")
            self.indicador_luz.itemconfig(self.luz_dibujo, fill=hex_color, outline="#ffeaa7")
        else:
            self.lbl_estado_foco.config(text="Estado: APAGADO", fg="#d63031")
            self.indicador_luz.itemconfig(self.luz_dibujo, fill="#2d3436", outline="#636e72")

        # --- CÁMARA ---
        self.lbl_reporte_cam.config(text=self.camara.reporte_completo())
        self.barra_bat["value"] = self.camara.nivel_bateria
        
        # Cambiar color de la barra según nivel
        style = ttk.Style()
        if self.camara.nivel_bateria > 50:
            style.configure("Horizontal.TProgressbar", background="#00b894") # Verde
        elif self.camara.nivel_bateria > 20:
            style.configure("Horizontal.TProgressbar", background="#fdcb6e") # Amarillo
        else:
            style.configure("Horizontal.TProgressbar", background="#d63031") # Rojo

if __name__ == "__main__":
    root = tk.Tk()
    app = SmartHomeProGUI(root)
    root.mainloop()