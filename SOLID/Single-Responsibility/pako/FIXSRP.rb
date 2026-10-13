class Jugador
    attr_accessor :nombre, :puntos, :vidas, :estado

    def initialize(nombre)
        @nombre = nombre
        @puntos = 0
        @vidas = 3
        @estado = :pequeno
    end
end

class Moneda
    def valor_puntos; 100; end
end

class Hongo
    def poder; :grande; end
end

class Goomba 
    def dano_ataque; 1; end
end

class Bowser
    def dano_ataque; 1; end
end

class SistemaDeAudio
    def reproducir(evento)
        sonidos = {
            moneda: "'ding.mp3'",
            dano: "'ouch.mp3'",
            game_over: "'game_over.mp3'",
            poder: "'power_up.mp3'",
            pierde_poder: "'pipe_down.mp3'",
            bowser: "'bowser_roar.mp3'"
        }
        puts sonidos[evento]
    end
end

class SistemaDePoderes
    def consumir_hongo(jugador)
        jugador.estado = :grande
        puts "[PODER] ¡WAT QUÉ, MARIO COMIÓ EL HONGO Y AHORA ES GRANDE!"
    end
end

class SistemaDePuntuacion
    def sumar_puntos(jugador, cantidad)
        jugador.puntos += cantidad
        puts "[+#{cantidad} pts, Marcador: #{jugador.puntos}]"
    end
end

class SistemaDeSalud
    def recibido_dano(jugador, cantidad)
        return if cantidad <= 0

        if jugador.estado == :grande
            jugador.estado = :pequeno
            cantidad -= 1
            puts "[ESTADO] EL GOLPE LE QUITÓ EL PODER A MARIO. VUELVE A SER PEQUEÑO."
        end

        if cantidad > 0
            jugador.vidas -= cantidad
            jugador.vidas = 0 if jugador.vidas < 0
        end       
        
        puts "Daño recibido: #{cantidad}. Vidas restantes: #{jugador.vidas}"
    end
end

mario = Jugador.new("Mario")
audio = SistemaDeAudio.new
marcador = SistemaDePuntuacion.new
salud = SistemaDeSalud.new
moneda = Moneda.new
goomba = Goomba.new
poderes = SistemaDePoderes.new
hongo = Hongo.new
bowser = Bowser.new

puts "--- INICIA NIVEL 1-1 ---"
puts "Mario tiene #{mario.vidas} vidas y estado: #{mario.estado}."

puts "--- ESCENARIO 1: EL HONGO Y LA EMBOSCADA ---"
poderes.consumir_hongo(mario)
audio.reproducir(:poder)

print "¿Cuántos Goombas emboscan a Mario de golpe?: "
cantidad_goombas = gets.chomp.to_i
cantidad_goombas = 0 if cantidad_goombas < 0

if cantidad_goombas > 0
    dano_goombas = goomba.dano_ataque * cantidad_goombas
    puts "¡#{cantidad_goombas} goombas atacan! (Daño total: #{dano_goombas})"
    audio.reproducir(:dano)
    salud.recibido_dano(mario, dano_goombas)
end

puts "--- ESCENARIO 2: LA LLEGADA DE BOWSER ---"
if mario.vidas > 0
    puts "Mario encuentra otro hongo antes del jefe final..."
    poderes.consumir_hongo(mario)
    audio.reproducir(:poder)

    print "¿Cuántas veces logra golpear Bowser a Mario?: "
    cantidad_bowser = gets.chomp.to_i
    cantidad_bowser = 0 if cantidad_bowser < 0

    if cantidad_bowser > 0
        dano_bowser = bowser.dano_ataque * cantidad_bowser
        puts "Bowser conecta #{cantidad_bowser} golpes! (Daño total: #{dano_bowser})"
        audio.reproducir(:bowser)
        salud.recibido_dano(mario, dano_bowser)
    end
end

puts "--- RESULTADO FINAL ---"
if mario.vidas <= 0
    audio.reproducir(:game_over)
    puts "GG. Game Over. Mario fue aplastado"
else
    puts "Mario sobrevivió y rescató a la princesa con #{mario.vidas} "
end