package CosasExtra;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
public class GrafoDirigidoPonderado {
    private Map<String, Map<String, Integer>> listaAdyacencia;
    public GrafoDirigidoPonderado() {
        listaAdyacencia = new HashMap<>();
    }
    public void agregarNodo(String nodo) {
        listaAdyacencia.putIfAbsent(nodo, new HashMap<>());
    }
    public void agregarArista(String nodoOrigen, String nodoDestino, int peso) {
        listaAdyacencia.get(nodoOrigen).put(nodoDestino, peso);
    }
    public int obtenerPeso(String nodoOrigen, String nodoDestino) {
        return listaAdyacencia.get(nodoOrigen).getOrDefault(nodoDestino, Integer.MAX_VALUE);
    }
   public List<String> obtenerNodosAdyacentes(String nodo) {
    if (listaAdyacencia.containsKey(nodo)) {
        return new LinkedList<>(listaAdyacencia.get(nodo).keySet());
    } else {
        return new LinkedList<>(); 
    }
}
public Set<String> obtenerNodos() {
    return listaAdyacencia.keySet();
}
}