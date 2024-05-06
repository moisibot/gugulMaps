package CosasExtra;

import java.awt.Color;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JPanel;

public class GrafoVisual extends JPanel {
    private Map<String, NodoVisual> nodos;
    private Map<String, Map<String, Integer>> aristas;
    private List<String> rutaResaltada;
    private String origenResaltado;
    private String destinoResaltado;

    public GrafoVisual() {
        nodos = new HashMap<>();
        aristas = new HashMap<>();
        rutaResaltada = null;
        origenResaltado = null;
        destinoResaltado = null;
    }

    public void agregarNodo(String nombre, int x, int y) {
        NodoVisual nodo = new NodoVisual(nombre, x, y);
        nodos.put(nombre, nodo);
    }

    public void agregarArista(String origen, String destino, int peso) {
        if (!aristas.containsKey(origen)) {
            aristas.put(origen, new HashMap<>());
        }
        aristas.get(origen).put(destino, peso);
    }

    public void resaltarOrigen(String origen) {
        origenResaltado = origen;
        repaint();
    }

    public void resaltarDestino(String destino) {
        destinoResaltado = destino;
        repaint();
    }

    public void resaltarRuta(List<String> ruta) {
        rutaResaltada = ruta;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dibujar aristas
        for (Map.Entry<String, Map<String, Integer>> entryOrigen : aristas.entrySet()) {
            String origen = entryOrigen.getKey();
            NodoVisual nodoOrigen = nodos.get(origen);
            for (Map.Entry<String, Integer> entryDestino : entryOrigen.getValue().entrySet()) {
                String destino = entryDestino.getKey();
                NodoVisual nodoDestino = nodos.get(destino);
                g.drawLine(nodoOrigen.getX(), nodoOrigen.getY(), nodoDestino.getX(), nodoDestino.getY());
            }
        }

        // Dibujar nodos
        for (NodoVisual nodo : nodos.values()) {
            Color color = Color.GRAY;
            if (nodo.getNombre().equals(origenResaltado)) {
                color = Color.RED;
            } else if (nodo.getNombre().equals(destinoResaltado)) {
                color = Color.BLUE;
            } else if (rutaResaltada != null && rutaResaltada.contains(nodo.getNombre())) {
                color = Color.YELLOW;
            }
            nodo.dibujar(g, color);
        }
    }

    private class NodoVisual {
        private String nombre;
        private int x, y;

        public NodoVisual(String nombre, int x, int y) {
            this.nombre = nombre;
            this.x = x;
            this.y = y;
        }

        public String getNombre() {
            return nombre;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void dibujar(Graphics g, Color color) {
            g.setColor(color);
            g.fillOval(x - 20, y - 20, 40, 40);
            g.setColor(Color.BLACK);
            g.drawString(nombre, x - 10, y + 5);
        }
    }
}
