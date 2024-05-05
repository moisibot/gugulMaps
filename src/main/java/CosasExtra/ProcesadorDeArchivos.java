
package CosasExtra;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProcesadorDeArchivos {
    private Map<String, List<String>> nodosConexiones = new HashMap<>();
    public void procesarArchivo(String rutaArchivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = reader.readLine())!= null) {
                String[] partes = linea.split("\\|");
                if (partes.length >= 3) {
                    String origen = partes[0].trim();
                    String destino = partes[1].trim();
                    nodosConexiones.computeIfAbsent(origen, k -> new ArrayList<>()).add(destino);
                    nodosConexiones.computeIfAbsent(destino, k -> new ArrayList<>()).add(origen);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Map<String, List<String>> getNodosConexiones() {
        return nodosConexiones;
    }
}

