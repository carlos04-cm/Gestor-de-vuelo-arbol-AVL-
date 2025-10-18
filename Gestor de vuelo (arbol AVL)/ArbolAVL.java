package carlos;

public class ArbolAVL {
    NodoAVL raiz;

    // ======================
    // MÉTODOS DE UTILIDAD
    // ======================
    int altura(NodoAVL n) {
        return (n == null) ? 0 : n.altura;
    }

    int balance(NodoAVL n) {
        return (n == null) ? 0 : altura(n.izquierda) - altura(n.derecha);
    }

    // ======================
    // ROTACIONES
    // ======================
    NodoAVL rotarDerecha(NodoAVL y) {
        NodoAVL x = y.izquierda;
        NodoAVL T2 = x.derecha;

        x.derecha = y;
        y.izquierda = T2;

        y.altura = Math.max(altura(y.izquierda), altura(y.derecha)) + 1;
        x.altura = Math.max(altura(x.izquierda), altura(x.derecha)) + 1;

        return x;
    }

    NodoAVL rotarIzquierda(NodoAVL x) {
        NodoAVL y = x.derecha;
        NodoAVL T2 = y.izquierda;

        y.izquierda = x;
        x.derecha = T2;

        x.altura = Math.max(altura(x.izquierda), altura(x.derecha)) + 1;
        y.altura = Math.max(altura(y.izquierda), altura(y.derecha)) + 1;

        return y;
    }

    // ======================
    // INSERCIÓN DE VUELOS
    // ======================
    NodoAVL insertar(NodoAVL nodo, Vuelo vuelo) {
        if (nodo == null)
            return new NodoAVL(vuelo);

        if (vuelo.numeroVuelo < nodo.vuelo.numeroVuelo)
            nodo.izquierda = insertar(nodo.izquierda, vuelo);
        else if (vuelo.numeroVuelo > nodo.vuelo.numeroVuelo)
            nodo.derecha = insertar(nodo.derecha, vuelo);
        else
            return nodo; // no se permiten duplicados

        nodo.altura = 1 + Math.max(altura(nodo.izquierda), altura(nodo.derecha));
        int balance = balance(nodo);

        // Casos de rotación
        if (balance > 1 && vuelo.numeroVuelo < nodo.izquierda.vuelo.numeroVuelo)
            return rotarDerecha(nodo);
        if (balance < -1 && vuelo.numeroVuelo > nodo.derecha.vuelo.numeroVuelo)
            return rotarIzquierda(nodo);
        if (balance > 1 && vuelo.numeroVuelo > nodo.izquierda.vuelo.numeroVuelo) {
            nodo.izquierda = rotarIzquierda(nodo.izquierda);
            return rotarDerecha(nodo);
        }
        if (balance < -1 && vuelo.numeroVuelo < nodo.derecha.vuelo.numeroVuelo) {
            nodo.derecha = rotarDerecha(nodo.derecha);
            return rotarIzquierda(nodo);
        }

        return nodo;
    }

    // ======================
    // ELIMINAR VUELOS
    // ======================
    NodoAVL eliminar(NodoAVL nodo, int numeroVuelo) {
        if (nodo == null)
            return nodo;

        if (numeroVuelo < nodo.vuelo.numeroVuelo)
            nodo.izquierda = eliminar(nodo.izquierda, numeroVuelo);
        else if (numeroVuelo > nodo.vuelo.numeroVuelo)
            nodo.derecha = eliminar(nodo.derecha, numeroVuelo);
        else {
            if ((nodo.izquierda == null) || (nodo.derecha == null)) {
                NodoAVL temp = (nodo.izquierda != null) ? nodo.izquierda : nodo.derecha;

                if (temp == null) {
                    nodo = null;
                } else {
                    nodo = temp;
                }
            } else {
                NodoAVL temp = minValorNodo(nodo.derecha);
                nodo.vuelo = temp.vuelo;
                nodo.derecha = eliminar(nodo.derecha, temp.vuelo.numeroVuelo);
            }
        }

        if (nodo == null)
            return nodo;

        nodo.altura = 1 + Math.max(altura(nodo.izquierda), altura(nodo.derecha));
        int balance = balance(nodo);

        if (balance > 1 && balance(nodo.izquierda) >= 0)
            return rotarDerecha(nodo);
        if (balance > 1 && balance(nodo.izquierda) < 0) {
            nodo.izquierda = rotarIzquierda(nodo.izquierda);
            return rotarDerecha(nodo);
        }
        if (balance < -1 && balance(nodo.derecha) <= 0)
            return rotarIzquierda(nodo);
        if (balance < -1 && balance(nodo.derecha) > 0) {
            nodo.derecha = rotarDerecha(nodo.derecha);
            return rotarIzquierda(nodo);
        }

        return nodo;
    }

    NodoAVL minValorNodo(NodoAVL nodo) {
        NodoAVL actual = nodo;
        while (actual.izquierda != null)
            actual = actual.izquierda;
        return actual;
    }

    // ======================
    // BÚSQUEDAS
    // ======================
    Vuelo buscarPorNumero(NodoAVL nodo, int numeroVuelo) {
        if (nodo == null)
            return null;
        if (numeroVuelo == nodo.vuelo.numeroVuelo)
            return nodo.vuelo;

        return (numeroVuelo < nodo.vuelo.numeroVuelo)
                ? buscarPorNumero(nodo.izquierda, numeroVuelo)
                : buscarPorNumero(nodo.derecha, numeroVuelo);
    }

    void buscarPorDestino(NodoAVL nodo, String destino) {
        if (nodo != null) {
            buscarPorDestino(nodo.izquierda, destino);
            if (nodo.vuelo.destino.equalsIgnoreCase(destino)) {
                System.out.println(nodo.vuelo);
            }
            buscarPorDestino(nodo.derecha, destino);
        }
    }

    // ======================
    // RECORRIDOS SOLO NÚMEROS
    // ======================
    void inOrdenNumeros(NodoAVL nodo) {
        if (nodo != null) {
            inOrdenNumeros(nodo.izquierda);
            System.out.print(nodo.vuelo.numeroVuelo + ", ");
            inOrdenNumeros(nodo.derecha);
        }
    }

    void preOrdenNumeros(NodoAVL nodo) {
        if (nodo != null) {
            System.out.print(nodo.vuelo.numeroVuelo + ", ");
            preOrdenNumeros(nodo.izquierda);
            preOrdenNumeros(nodo.derecha);
        }
    }

    void postOrdenNumeros(NodoAVL nodo) {
        if (nodo != null) {
            postOrdenNumeros(nodo.izquierda);
            postOrdenNumeros(nodo.derecha);
            System.out.print(nodo.vuelo.numeroVuelo + ", ");
        }
    }
}