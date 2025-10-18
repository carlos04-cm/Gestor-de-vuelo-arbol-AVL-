package carlos;

// Clase que representa un nodo del árbol AVL
public class NodoAVL {
    Vuelo vuelo;        // Datos del vuelo
    int altura;         // Altura del nodo
    NodoAVL izquierda;  // Hijo izquierdo
    NodoAVL derecha;    // Hijo derecho

    public NodoAVL(Vuelo vuelo) {
        this.vuelo = vuelo;
        this.altura = 1; // Un nuevo nodo empieza con altura 1
    }
}