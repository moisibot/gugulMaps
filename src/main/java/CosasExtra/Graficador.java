package CosasExtra;
import javax.swing.*;
import java.awt.*;

public class Graficador extends JPanel {
    private String Origen;
    private String Destino;

    public Graficador() {
        // Configurar el panel de graficador
        // ...
    }

    public void actualizarNodos(String Origen, String Destino) {
        this.Origen = Origen;
        this.Destino = Destino;
        revalidate();
        repaint(); // Vuelve a dibujar el panel
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Lógica de dibujado de los nodos y las conexiones aquí
        // Utiliza los valores de "origen" y "destino" para determinar qué nodos y conexiones dibujar
     g.setColor(Color.BLACK);
        g.fillOval(50, 50, 50, 50);
        
        // Ejemplo de dibujo de una conexión
        g.setColor(Color.BLACK);
        g.drawLine(75, 75, 200, 200);
    }
}