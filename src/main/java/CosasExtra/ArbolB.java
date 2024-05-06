
package CosasExtra;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArbolB {
    private NodoArbolB raiz; 
    private int orden; 

    public ArbolB(int ordenArbol) {
        raiz = null;
        orden = ordenArbol;
    }

    public List<String> buscar(int clave) {
        return buscarRecursivo(clave, raiz);
    }

    private List<String> buscarRecursivo(int clave, NodoArbolB nodo) {
        List<String> ruta = new ArrayList<>();
        int i = 0;
        if (nodo == null) {
            return ruta;
        }
        while (i < nodo.numClaves && clave > nodo.claves[i]) {
            i++;
        }
        if (i < nodo.numClaves && clave == nodo.claves[i]) {
            ruta = agregarNodosRuta(nodo, ruta);
            return ruta;
        }
        if (nodo.hojaNodo) {
            return ruta;
        }
        return buscarRecursivo(clave, nodo.hijos[i]);
    }
    
    private List<String> agregarNodosRuta(NodoArbolB nodo, List<String> ruta) {
        if (nodo.hojaNodo) {
            for (int i = 0; i < nodo.numClaves; i++) {
                ruta.add(String.valueOf(nodo.claves[i]));
            }
            return ruta;
        }
        for (int i = 0; i <= nodo.numClaves; i++) {
            if (nodo.hijos[i] != null) {
                ruta = agregarNodosRuta(nodo.hijos[i], ruta);
            }
        }

        return ruta;
    }

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

    public String generarCodigoDot() {
        StringBuilder dotBuilder = new StringBuilder();
        dotBuilder.append("digraph ArbolB {\n");
        dotBuilder.append("\tnode [shape=record];\n");
        generarCodigoDotRecursivo(raiz, dotBuilder);
        dotBuilder.append("}\n");
        return dotBuilder.toString();
    }

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
