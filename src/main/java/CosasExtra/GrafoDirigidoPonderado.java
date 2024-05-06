package CosasExtra;
import java.util.HashMap;
import java.util.HashSet;
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
public Map<String, Integer> dijkstra(String origen) {
    Map<String, Integer> distancias = new HashMap<>();
    Map<String, String> previos = new HashMap<>();
    Set<String> nodosVisitados = new HashSet<>();
    for (String nodo : obtenerNodos()) {
        distancias.put(nodo, Integer.MAX_VALUE);
    }
    distancias.put(origen, 0);

    // Algoritmo de Dijkstra
    while (nodosVisitados.size() < obtenerNodos().size()) {
        String nodoActual = obtenerNodoMasCercano(distancias, nodosVisitados);
        nodosVisitados.add(nodoActual);

        for (String vecino : obtenerNodosAdyacentes(nodoActual)) {
            int pesoArista = obtenerPeso(nodoActual, vecino);
            int distanciaActual = distancias.get(nodoActual) + pesoArista;

            if (distanciaActual < distancias.get(vecino)) {
                distancias.put(vecino, distanciaActual);
                previos.put(vecino, nodoActual);
            }
        }
    }

    return distancias;
}

private String obtenerNodoMasCercano(Map<String, Integer> distancias, Set<String> nodosVisitados) {
    int distanciaMasCercana = Integer.MAX_VALUE;
    String nodoMasCercano = null;
    for (Map.Entry<String, Integer> entry : distancias.entrySet()) {
        String nodo = entry.getKey();
        int distancia = entry.getValue();

        if (!nodosVisitados.contains(nodo) && distancia < distanciaMasCercana) {
            distanciaMasCercana = distancia;
            nodoMasCercano = nodo;
        }
    }
    return nodoMasCercano;
}

}