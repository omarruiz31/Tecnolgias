#include <iostream>
#include <unordered_map>
#include <string>
#include <vector>
#include <cstdlib>

using namespace std;

// Flyweight: contiene el estado intrínseco (compartido)
class TipoArbol {
public:
    string nombre;
    string color;
    string textura;

    TipoArbol(const string& nombre, const string& color, const string& textura)
        : nombre(nombre), color(color), textura(textura) {}

    void dibujar(int x, int y) const {
        cout << nombre << " de color " << color << " con textura " << textura 
             << " posicionado en (" << x << ", " << y << ")\n";
    }
};

// Contexto: contiene el estado extrínseco (único para cada árbol)
class Arbol {
private:
    int x;
    int y;
    const TipoArbol* tipo;

public:
    Arbol(int x, int y, const TipoArbol* tipo)
        : x(x), y(y), tipo(tipo) {}

    void dibujar() const {
        tipo->dibujar(x, y);
    }
};

// Factoría Flyweight: gestiona y reutiliza las instancias de TipoArbol
class TipoArbolFactory {
private:
    static unordered_map<string, TipoArbol*> tipos;

public:
    static TipoArbol* obtener(const string& nombre, const string& color, const string& textura) {
        string clave = nombre + "_" + color + "_" + textura;
        if (tipos.find(clave) == tipos.end()) {
            tipos[clave] = new TipoArbol(nombre, color, textura);
        }
        return tipos[clave];
    }

    static size_t total() {
        return tipos.size();
    }

    static void liberar() {
        for (auto& p : tipos) {
            delete p.second;
        }
        tipos.clear();
    }
};

unordered_map<string, TipoArbol*> TipoArbolFactory::tipos;

class Bosque {
private:
    vector<Arbol> arboles;

public:
    void plantar(int x, int y, const string& nombre, const string& color, const string& textura) {
        TipoArbol* tipo = TipoArbolFactory::obtener(nombre, color, textura);
        arboles.emplace_back(x, y, tipo);
    }

    void dibujar() const {
        for (const auto& arbol : arboles) {
            arbol.dibujar();
        }
    }

    size_t total() const {
        return arboles.size();
    }
};

int main() {
    // Optimización de I/O para imprimir 200,000 líneas a alta velocidad
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    Bosque bosque;

    for (int i = 0; i < 100000; i++) {
        bosque.plantar(rand() % 100, rand() % 100, "Pino", "Verde", "Normal");
        bosque.plantar(rand() % 100, rand() % 100, "Roble", "Verde", "Normal");
    }

    // Dibujar todos los árboles
    bosque.dibujar();

    cout << "\nArboles creados: " << bosque.total() << "\n";
    cout << "Tipos de arbol unicos creados (Flyweights): " << TipoArbolFactory::total() << "\n";
    cout << "Memoria de TipoArbol utilizada con Flyweight: " 
         << (sizeof(TipoArbol) * TipoArbolFactory::total()) << " bytes\n";
    cout << "Memoria que habrian ocupado sin Flyweight: " 
         << (sizeof(TipoArbol) * bosque.total()) << " bytes\n";

    // Liberar memoria dinámica reservada por la factoría
    TipoArbolFactory::liberar();

    return 0;
}
