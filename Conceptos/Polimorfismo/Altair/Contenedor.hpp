#pragma once
#include <cstddef>

template <typename T>
class Contenedor {
public:
    virtual ~Contenedor() = default;

    virtual bool vacio() const = 0;
    virtual size_t tamano() const = 0;
    virtual void agregar(const T& x) = 0;
    virtual T& obtener(size_t i) = 0;
    virtual void quitar(size_t i) = 0;
};