
package CosasExtra;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// Clase principal del árbol B
public class ArbolB {
    private NodoArbolB raiz; // Puntero a la raíz del árbol
    private int orden; // Orden del árbol B

    // Constructor para crear un árbol B vacío con un orden dado
    public ArbolB(int ordenArbol) {
        raiz = null;
        orden = ordenArbol;
    }

    // Función para buscar una clave en el árbol B
    public List<String> buscar(int clave) {
        return buscarRecursivo(clave, raiz);
    }

    // Función recursiva para buscar una clave en el árbol B
    private List<String> buscarRecursivo(int clave, NodoArbolB nodo) {
        List<String> ruta = new ArrayList<>();
        int i = 0;

        // Si el nodo es nulo, la clave no se encuentra en el árbol
        if (nodo == null) {
            return ruta;
        }

        // Buscar la posición de la clave en el nodo
        while (i < nodo.numClaves && clave > nodo.claves[i]) {
            i++;
        }

        // Si la clave se encuentra en el nodo
        if (i < nodo.numClaves && clave == nodo.claves[i]) {
            // Agregar los nodos de la ruta a la lista
            ruta = agregarNodosRuta(nodo, ruta);
            return ruta;
        }

        // Si el nodo es una hoja, la clave no se encuentra en el árbol
        if (nodo.hojaNodo) {
            return ruta;
        }

        // Buscar en el hijo apropiado
        return buscarRecursivo(clave, nodo.hijos[i]);
    }

    // Función para agregar los nodos de una ruta a una lista
    private List<String> agregarNodosRuta(NodoArbolB nodo, List<String> ruta) {
        if (nodo.hojaNodo) {
            // Si es una hoja, agregar los nodos de la ruta a la lista
            for (int i = 0; i < nodo.numClaves; i++) {
                ruta.add(String.valueOf(nodo.claves[i]));
            }
            return ruta;
        }

        // Recorrer los hijos del nodo
        for (int i = 0; i <= nodo.numClaves; i++) {
            if (nodo.hijos[i] != null) {
                ruta = agregarNodosRuta(nodo.hijos[i], ruta);
            }
        }

        return ruta;
    }

    // Método para insertar una ruta en el árbol B
    public void insertar(int idRuta, LinkedList<String> ruta) {
        if (raiz == null) {
            raiz = new NodoArbolB(orden, true);
            raiz.claves[0] = idRuta;
            raiz.numClaves = 1;
        } else {
            if (raiz.numClaves == 2 * orden - 1) {
                NodoArbolB nuevaRaiz = new NodoArbolB(orden, false);
                nuevaRaiz.hijos[0] = raiz;
                dividirHijo(nuevaRaiz, 0, raiz);
                int i = 0;
                if (Integer.parseInt(ruta.getFirst()) > nuevaRaiz.claves[0]) {
                    i++;
                }
                insertarNoLleno(nuevaRaiz.hijos[i], idRuta, ruta);
                raiz = nuevaRaiz;
            } else {
                insertarNoLleno(raiz, idRuta, ruta);
            }
        }
    }

    // Método auxiliar para insertar en un nodo no lleno
    private void insertarNoLleno(NodoArbolB nodo, int idRuta, LinkedList<String> ruta) {
        int i = nodo.numClaves - 1;
        if (nodo.hojaNodo) {
            while (i >= 0 && Integer.parseInt(ruta.getFirst()) < nodo.claves[i]) {
                nodo.claves[i + 1] = nodo.claves[i];
                i--;
            }
            nodo.claves[i + 1] = idRuta;
            nodo.numClaves++;
        } else {
            while (i >= 0 && Integer.parseInt(ruta.getFirst()) < nodo.claves[i]) {
                i--;
            }
            i++;
            if (nodo.hijos[i].numClaves == 2 * orden - 1) {
                dividirHijo(nodo, i, nodo.hijos[i]);
                if (Integer.parseInt(ruta.getFirst()) > nodo.claves[i]) {
                    i++;
                }
            }
            insertarNoLleno(nodo.hijos[i], idRuta, ruta);
        }
    }

    // Método para dividir un nodo hijo
    private void dividirHijo(NodoArbolB padre, int indice, NodoArbolB hijo) {
        NodoArbolB nuevoNodo = new NodoArbolB(hijo.orden, hijo.hojaNodo);
        nuevoNodo.numClaves = orden - 1;
        for (int j = 0; j < orden - 1; j++) {
            nuevoNodo.claves[j] = hijo.claves[j + orden];
        }
        if (!hijo.hojaNodo) {
            for (int j = 0; j < orden; j++) {
                nuevoNodo.hijos[j] = hijo.hijos[j + orden];
            }
        }
        hijo.numClaves = orden - 1;
        for (int j = padre.numClaves; j >= indice + 1; j--) {
            padre.hijos[j + 1] = padre.hijos[j];
        }
        padre.hijos[indice + 1] = nuevoNodo;
        for (int j = padre.numClaves - 1; j >= indice; j--) {
            padre.claves[j + 1] = padre.claves[j];
        }
        padre.claves[indice] = hijo.claves[orden - 1];
        padre.numClaves++;
    }

    // Método para generar el código DOT del árbol B
    public String generarCodigoDot() {
        StringBuilder dotBuilder = new StringBuilder();
        dotBuilder.append("digraph ArbolB {\n");
        dotBuilder.append("\tnode [shape=record];\n");
        generarCodigoDotRecursivo(raiz, dotBuilder);
        dotBuilder.append("}\n");
        return dotBuilder.toString();
    }

    // Método auxiliar recursivo para generar el código DOT
    private void generarCodigoDotRecursivo(NodoArbolB nodo, StringBuilder dotBuilder) {
        if (nodo != null) {
            dotBuilder.append("\tnodo").append(nodo.hashCode()).append(" [label=\"");
            for (int i = 0; i < nodo.numClaves; i++) {
                dotBuilder.append("<").append(i).append(">").append(nodo.claves[i]);
                if (i < nodo.numClaves - 1) {
                    dotBuilder.append("|");
                }
            }
            dotBuilder.append("\"];\n");
            for (int i = 0; i <= nodo.numClaves; i++) {
                if (nodo.hijos[i] != null) {
                    dotBuilder.append("\tnodo").append(nodo.hashCode()).append(":").append(i).append(" -> nodo").append(nodo.hijos[i].hashCode()).append(";\n");
                    generarCodigoDotRecursivo(nodo.hijos[i], dotBuilder);
                }
            }
        }
    }
}
