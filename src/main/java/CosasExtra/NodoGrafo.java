package CosasExtra;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class NodoGrafo extends JPanel {
    private String nombre;
    private boolean esOrigen;
    private boolean esDestino;
    private Color color;

    public NodoGrafo(String nombre) {
        this.nombre = nombre;
        this.color = Color.GRAY; // Color por defecto
        setOpaque(true);
    }

    public void setEsOrigen(boolean esOrigen) {
        this.esOrigen = esOrigen;
        color = esOrigen ? Color.RED : Color.GRAY;
    }

    public void setEsDestino(boolean esDestino) {
        this.esDestino = esDestino;
        color = esDestino ? Color.BLUE : Color.GRAY;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        g.fillOval(10, 10, getWidth() - 20, getHeight() - 20);
        g.setColor(Color.BLACK);
        g.drawString(nombre, getWidth() / 2 - g.getFontMetrics().stringWidth(nombre) / 2, getHeight() / 2 + 5);
    }
}