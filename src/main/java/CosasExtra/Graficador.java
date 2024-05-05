package CosasExtra;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Graficador extends JPanel {
    private String dotSource;

    public Graficador(String dotSource) {
        this.dotSource = dotSource;
    }

    public void graficar() {
        try {
            // Crear un archivo temporal para almacenar el código DOT
            File dotFile = Files.createTempFile("graph", ".dot").toFile();
            dotFile.deleteOnExit();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(dotFile))) {
                writer.write(dotSource);
            }

            // Crear un archivo temporal para almacenar la imagen generada por Graphviz
            File imgFile = Files.createTempFile("graph", ".png").toFile();
            imgFile.deleteOnExit();

            // Ejecutar el comando dot de Graphviz para generar la imagen PNG
            ProcessBuilder processBuilder = new ProcessBuilder("dot", "-Tpng", "-o", imgFile.getAbsolutePath(), dotFile.getAbsolutePath());
            Process process = processBuilder.start();
            process.waitFor();

            // Cargar la imagen generada en un ImageIcon
            ImageIcon icon = new ImageIcon(imgFile.getAbsolutePath());

            // Establecer el tamaño del panel según las dimensiones de la imagen
            setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
            setBackground(Color.white);

            // Repintar el panel con la nueva imagen
            repaint();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Cargar la imagen generada por Graphviz y dibujarla en el panel
        ImageIcon icon = new ImageIcon("graph.png");
        int x = (getWidth() - icon.getIconWidth()) / 2;
        int y = (getHeight() - icon.getIconHeight()) / 2;
        g.drawImage(icon.getImage(), x, y, this);
    }
}
