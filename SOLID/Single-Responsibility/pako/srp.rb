class Jugador 
  attr_accessor :nombre, :puntos, :vidas

  def initialize(nombre)
    @nombre = nombre
    @puntos = 0
    @vidas = 3
  end
end

class MonedaMutante
  def recolectar(jugador)
      jugador.puntos += 100
      puts "Marcador: #{jugador.puntos}"
      
      puts "'ding.mp3'"
  end
end

class GoombaMutante
  def atacar(jugador)
    jugador.vidas -= 1
    puts "daño recibido: 1. Vidas restantes: #{jugador.vidas}"
    puts "'ouch.mp3'"

    if jugador.vidas <= 0
      puts "'game over.mp3"
      puts "game over mario fue aplastado"
    end
  end
end

mario = Jugador.new("Mario")
moneda = MonedaMutante.new
goomba = GoombaMutante.new

puts "---Iniciando nivel 1-1 ---"
puts "Mario tiene #{mario.vidas} vidas"
moneda.recolectar(mario)

print "¿Cuantas goombas emboscan a mario de golpe?"
canitdad_goombas = gets.chomp.to_i

canitdad_goombas.times do 
  goomba.atacar(mario)
end