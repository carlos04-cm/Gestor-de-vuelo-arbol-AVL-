# ✈️ Sistema de Gestión de Vuelos (Árbol AVL)

Proyecto desarrollado en **Java** por **Carlos, Yesenia y Andrés**, que implementa un sistema de registro, búsqueda y eliminación de vuelos utilizando un **árbol AVL** (árbol binario de búsqueda balanceado).

📹 **Video demostrativo:** [Sistema de Gestión de Vuelos basado en Árboles AVL](https://youtu.be/mGZ3CjZQi4I?si=orvAG3B65FaZGStx)

---

## 📘 Descripción del Proyecto

El sistema permite gestionar vuelos de manera eficiente manteniendo los datos organizados mediante un **árbol AVL**, el cual asegura que el árbol se mantenga balanceado tras cada inserción o eliminación, optimizando así las búsquedas y operaciones.

Cada vuelo contiene la siguiente información:

- **Número de vuelo**
- **Origen**
- **Destino**
- **Hora**
- **Aerolínea**

---

## ⚙️ Funcionalidades

El menú principal ofrece las siguientes opciones:

1. **Registrar vuelo:**  
   Permite ingresar un nuevo vuelo con todos sus datos.  
   El vuelo se inserta automáticamente en el árbol AVL y el sistema realiza el reequilibrio si es necesario.

2. **Buscar vuelo por número:**  
   Busca y muestra la información de un vuelo específico usando su número.

3. **Buscar vuelos por destino:**  
   Muestra todos los vuelos cuyo destino coincide con el ingresado.

4. **Mostrar recorridos:**  
   Muestra los recorridos del árbol por número de vuelo:  
   - **Inorden** → izquierda, raíz, derecha  
   - **Preorden** → raíz, izquierda, derecha  
   - **Postorden** → izquierda, derecha, raíz  

5. **Eliminar vuelo:**  
   Elimina un vuelo según su número.  
   Si el vuelo existe, se quita del árbol y este se rebalancea automáticamente.

6. **Salir:**  
   Finaliza la ejecución del programa.

---

## 🧩 Estructura del Código

El proyecto está compuesto por las siguientes clases:

### 🛫 `Vuelo.java`  
Representa la información de un vuelo con sus atributos y un método `toString()` para mostrarlo en texto.

### 🌲 `NodoAVL.java`  
Define un nodo del árbol AVL, el cual contiene un objeto `Vuelo`, referencias a sus hijos izquierdo y derecho, y su altura.

### ⚖️ `ArbolAVL.java`  
Contiene toda la lógica del árbol AVL:  
- Inserción de vuelos (`insertar`)  
- Eliminación (`eliminar`)  
- Rotaciones (izquierda y derecha)  
- Cálculo de alturas y balance  
- Búsquedas por número o destino  
- Recorridos (inorden, preorden, postorden)

### 💻 `Main.java`  
Contiene el menú principal e interacción con el usuario mediante consola.

---

## ▶️ Ejecución del Programa

### Requisitos  
- Tener instalado **Java 17** o superior.  
- Tener todos los archivos en el mismo paquete (por ejemplo, `package carlos;`).

### Cómo ejecutar

1. **Compila los archivos:**  
   ```bash
   javac carlos/*.java
