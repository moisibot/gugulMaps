package CosasExtra;

import java.util.List;

public class Ruta {
    private String origen;
    private String destino;
    private List<String> nodosIntermedio;
    private int distancia;

    public Ruta(String origen, String destino, List<String> nodosIntermedio, int distancia) {
        this.origen = origen;
        this.destino = destino;
        this.nodosIntermedio = nodosIntermedio;
        this.distancia = distancia;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public List<String> getNodosIntermedio() {
        return nodosIntermedio;
    }

    public int getDistancia() {
        return distancia;
    }
}
