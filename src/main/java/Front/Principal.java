package Front;

import CosasExtra.ArbolB;
import CosasExtra.Reloj;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import CosasExtra.Graficador;
import CosasExtra.TrafficInfo;
import java.awt.BorderLayout;
import java.awt.Dimension; 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import CosasExtra.GrafoDirigidoPonderado;
import CosasExtra.GrafoVisual;
import CosasExtra.NodoGrafo;
import CosasExtra.Ruta;
import java.awt.Color;
import java.awt.Image;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import javax.swing.Timer;
import javax.swing.filechooser.FileNameExtensionFilter;
public class Principal extends javax.swing.JFrame {
    private Map<String, NodoGrafo> nodos = new HashMap<>();
private JPanel panelGrafo;
    private Reloj reloj;
    private Timer timer;
    private List<String[]> datos;
    private GrafoVisual grafoVisual;
    private Map<String, Map<String, Map<String, Integer>>> distancias = new HashMap<>();
        GrafoDirigidoPonderado grafo = new GrafoDirigidoPonderado();
 public Principal() {
        initComponents();
        grafoVisual = new GrafoVisual();
         Graficas.add(grafoVisual);
         grafo = new GrafoDirigidoPonderado();
        Origen.removeAllItems();
        Destino.removeAllItems();
        //se utliza el field para comenzar el reloj
    reloj = new Reloj(ControlReloj); 
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (!reloj.estaBloqueado()) {
                    reloj.avanzarTiempo();
                    actualizarControlReloj();
                }
            }        
        });
        timer.start(); 
        for (String nombreNodo : grafo.obtenerNodos()) {
    NodoGrafo nodoGrafo = new NodoGrafo(nombreNodo);
    nodos.put(nombreNodo, nodoGrafo);
    panelGrafo.add(nodoGrafo);
}

    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        jFrame3 = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        Origen = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Destino = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        Recorrido = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        SiguienteCamino = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        Historial = new javax.swing.JTextField();
        VerDatos = new javax.swing.JButton();
        Arbol = new javax.swing.JButton();
        NuevoViaje = new javax.swing.JButton();
        Archivo = new javax.swing.JButton();
        Pausa = new javax.swing.JButton();
        Reanudar = new javax.swing.JButton();
        ControlReloj = new javax.swing.JTextField();
        Aplicar = new javax.swing.JButton();
        Gas = new javax.swing.JTextField();
        Fisico = new javax.swing.JTextField();
        Distancia = new javax.swing.JTextField();
        Archivo2 = new javax.swing.JButton();
        Graficas = new javax.swing.JPanel();
        Opciones = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame3Layout = new javax.swing.GroupLayout(jFrame3.getContentPane());
        jFrame3.getContentPane().setLayout(jFrame3Layout);
        jFrame3Layout.setHorizontalGroup(
            jFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame3Layout.setVerticalGroup(
            jFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Origen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrigenActionPerformed(evt);
            }
        });

        jLabel1.setText("Estoy en:");

        jLabel2.setText("quiero ir a:");

        Destino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DestinoActionPerformed(evt);
            }
        });

        jLabel3.setText("en:");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "patas", "carrin" }));

        jLabel4.setText("Siguiente:");

        Recorrido.setText("Distancia:");

        jLabel5.setText("gasto fisico:");

        SiguienteCamino.setText("siguiente camino");
        SiguienteCamino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SiguienteCaminoActionPerformed(evt);
            }
        });

        jLabel6.setText("gas-distancia:");

        VerDatos.setText("ver datos");

        Arbol.setText("Arbol");
        Arbol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ArbolActionPerformed(evt);
            }
        });

        NuevoViaje.setText("Nuevo viaje");

        Archivo.setText("Archivo");
        Archivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ArchivoActionPerformed(evt);
            }
        });

        Pausa.setText("Pausa");
        Pausa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PausaActionPerformed(evt);
            }
        });

        Reanudar.setText("Reanudar");
        Reanudar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReanudarActionPerformed(evt);
            }
        });

        ControlReloj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ControlRelojActionPerformed(evt);
            }
        });

        Aplicar.setText("Aplicar");
        Aplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AplicarActionPerformed(evt);
            }
        });

        Gas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GasActionPerformed(evt);
            }
        });

        Fisico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FisicoActionPerformed(evt);
            }
        });

        Distancia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DistanciaActionPerformed(evt);
            }
        });

        Archivo2.setText("Archivo2");
        Archivo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Archivo2ActionPerformed(evt);
            }
        });

        Graficas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Graficas.setForeground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout GraficasLayout = new javax.swing.GroupLayout(Graficas);
        Graficas.setLayout(GraficasLayout);
        GraficasLayout.setHorizontalGroup(
            GraficasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        GraficasLayout.setVerticalGroup(
            GraficasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 662, Short.MAX_VALUE)
        );

        Opciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpcionesActionPerformed(evt);
            }
        });

        jLabel7.setText("Opcioines");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(Archivo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel1))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(Archivo2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
                                        .addComponent(jLabel2)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(Origen, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(69, 69, 69)
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(Destino, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel4))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(SiguienteCamino)))
                                        .addGap(18, 18, 18)
                                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Opciones, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addComponent(Recorrido)))
                                .addGap(12, 12, 12))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(ControlReloj, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(NuevoViaje)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Arbol)
                                .addGap(12, 12, 12)
                                .addComponent(VerDatos))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Gas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Fisico, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Distancia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(Historial, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Pausa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Reanudar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Aplicar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Graficas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Origen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1)
                                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(Archivo))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(Archivo2))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Destino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4))
                                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(SiguienteCamino))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(Opciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)
                                    .addComponent(Gas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(Recorrido)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ControlReloj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Pausa)
                            .addComponent(Reanudar)
                            .addComponent(Aplicar)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Historial, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Fisico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(VerDatos)
                            .addComponent(Arbol)
                            .addComponent(NuevoViaje)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(Distancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(Graficas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AplicarActionPerformed
        // TODO add your handling code here:
        reloj.aplicarValoresIngresados();
        actualizarControlReloj();
    }//GEN-LAST:event_AplicarActionPerformed

    private void ControlRelojActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ControlRelojActionPerformed
        // TODO add your handling code here:
        reloj.aplicarValoresIngresados();
        actualizarControlReloj();
    }//GEN-LAST:event_ControlRelojActionPerformed

    private void ReanudarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReanudarActionPerformed
        // TODO add your handling code here:
        reloj.desbloquear();
        actualizarControlReloj();
    }//GEN-LAST:event_ReanudarActionPerformed

    private void PausaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PausaActionPerformed
        // TODO add your handling code here:
        reloj.bloquear();
        actualizarControlReloj();
    }//GEN-LAST:event_PausaActionPerformed

    private void ArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ArchivoActionPerformed
         JFileChooser fileChooser = new JFileChooser();
    fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos de texto (*.txt)", "txt"));

    int result = fileChooser.showOpenDialog(this);
    if (result == JFileChooser.APPROVE_OPTION) {
        File file = fileChooser.getSelectedFile();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            Set<String> origenesUnicos = new HashSet<>();
            Set<String> destinosUnicos = new HashSet<>();

            Origen.removeAllItems();
            Destino.removeAllItems();
            
            //lectura de las columnas del archivo de los lugares
            Map<String, Map<String, Map<String, Integer>>> distancias = new HashMap<>();

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");

                if (parts.length >= 2) {
                    String origen = parts[0].trim();
                    String destino = parts[1].trim();

                    if (!origenesUnicos.contains(origen)) {
                        Origen.addItem(origen);
                        origenesUnicos.add(origen);
                        // Agregar el nodo de origen al grafo
                        grafo.agregarNodo(origen);
                    }
                    if (!destinosUnicos.contains(destino)) {
                        Destino.addItem(destino);
                        destinosUnicos.add(destino);
                        // Agregar el nodo de destino al grafo
                        grafo.agregarNodo(destino);
                    }
                }
                if (parts.length >= 7) { // Asegurarse de que hay suficientes columnas
                    String origen = parts[0].trim();
                    String destino = parts[1].trim();
                    int tiempoVehiculo = Integer.parseInt(parts[2].trim());
                    int tiempoPie = Integer.parseInt(parts[3].trim());
                    int consumoGas = Integer.parseInt(parts[4].trim());
                    int desgastePersona = Integer.parseInt(parts[5].trim());
                    int distancia = Integer.parseInt(parts[6].trim());

                    // Agregar la arista (ruta) al grafo con el peso (distancia)
                    grafo.agregarArista(origen, destino, distancia);

                    // Modificación: Agregar la lógica para almacenar las columnas adicionales
                    if (!distancias.containsKey(origen)) {
                        distancias.put(origen, new HashMap<>());
                    }
                    if (!distancias.get(origen).containsKey(destino)) {
                        distancias.get(origen).put(destino, new HashMap<>());
                    }
                    distancias.get(origen).get(destino).put("tiempoVehiculo", tiempoVehiculo);
                    distancias.get(origen).get(destino).put("tiempoPie", tiempoPie);
                    distancias.get(origen).get(destino).put("consumoGas", consumoGas);
                    distancias.get(origen).get(destino).put("desgastePersona", desgastePersona);
                    distancias.get(origen).get(destino).put("distancia", distancia);
                }
            }
            reader.close();
String origenSeleccionado = (String) Origen.getSelectedItem();
String destinoSeleccionado = (String) Destino.getSelectedItem();
List<String> nodosRuta = new ArrayList<>(); 
graficar(distancias, grafo, origenSeleccionado, destinoSeleccionado, nodosRuta);
mostrarImagen("/home/moisibot/NetBeansProjects/FinalEdd/graph.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }//GEN-LAST:event_ArchivoActionPerformed

    private void Archivo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Archivo2ActionPerformed
JFileChooser fileChooser = new JFileChooser();
    fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos de texto (*.txt)", "txt"));

    int result = fileChooser.showOpenDialog(this);
    if (result == JFileChooser.APPROVE_OPTION) {
        File file = fileChooser.getSelectedFile();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
//para ver la info del trafico
            Map<String, Map<String, List<TrafficInfo>>> trafico = new HashMap<>();

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                //para verificar las columnas de los archivos de entrada
                if (parts.length >= 5) { 
                    String origen = parts[0].trim();
                    String destino = parts[1].trim();
                    int horaInicio = Integer.parseInt(parts[2].trim());
                    int horaFinaliza = Integer.parseInt(parts[3].trim());
                    int probabilidadTrafico = Integer.parseInt(parts[4].trim());
                    //esto es para ver el trafico
                    TrafficInfo info = new TrafficInfo(horaInicio, horaFinaliza, probabilidadTrafico);
                    if (!trafico.containsKey(origen)) {
                        trafico.put(origen, new HashMap<>());
                    }
                    if (!trafico.get(origen).containsKey(destino)) {
                        trafico.get(origen).put(destino, new ArrayList<>());
                    }
                    trafico.get(origen).get(destino).add(info);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }//GEN-LAST:event_Archivo2ActionPerformed

    private void OrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrigenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_OrigenActionPerformed

    private void DestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DestinoActionPerformed
        // TODO add your handling code here:
 
    }//GEN-LAST:event_DestinoActionPerformed

    private void OpcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpcionesActionPerformed
    String origen = (String) Origen.getSelectedItem();
    String destino = (String) Destino.getSelectedItem();

    if (distancias.containsKey(origen) && distancias.get(origen).containsKey(destino)) {
        Map<String, Integer> info = distancias.get(origen).get(destino);

        // Mostrar los valores en los campos correspondientes
        Gas.setText(String.valueOf(info.get("consumoGas")));
        Fisico.setText(String.valueOf(info.get("desgastePersona")));
        Distancia.setText(String.valueOf(info.get("distancia")));
    } else {
        Gas.setText("");
        Fisico.setText("");
        Distancia.setText("");
    }
  Ruta rutaMasCorta = calcularRutaMasCorta(origen, destino);
    List<String> nodosRuta = rutaMasCorta.getNodosIntermedio();
     graficar(distancias, grafo, origen, destino, nodosRuta);
    }//GEN-LAST:event_OpcionesActionPerformed

    private void GasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GasActionPerformed

    private void FisicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FisicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FisicoActionPerformed

    private void DistanciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DistanciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DistanciaActionPerformed

    private void ArbolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ArbolActionPerformed
        
        ArbolB arbolB = new ArbolB(5);
    String origenSeleccionado = (String) Origen.getSelectedItem();
    List<List<String>> rutasPosibles = calcularRutasPosibles(origenSeleccionado);
    int idRuta = 1;
    for (List<String> ruta : rutasPosibles) {
        LinkedList<String> rutaLinked = new LinkedList<>(ruta);
        arbolB.insertar(idRuta, rutaLinked);
        idRuta++;
    }
    graficarArbolB(arbolB);
}

    private List<List<String>> calcularRutasPosibles(String origen) {
   List<List<String>> rutasPosibles = new ArrayList<>();
    Map<String, Integer> distancias = grafo.dijkstra(origen);
    for (String destino : grafo.obtenerNodos()) {
        if (!destino.equals(origen)) { 
            Ruta ruta = calcularRutaMasCorta(origen, destino);
            if (ruta != null) {
                rutasPosibles.add(ruta.getNodosIntermedio());

            }
        }
    }
     return rutasPosibles;
    }//GEN-LAST:event_ArbolActionPerformed

    private void SiguienteCaminoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SiguienteCaminoActionPerformed
       String origen = (String) Origen.getSelectedItem();
       String destino = (String) Destino.getSelectedItem();
    
    if (origen != null && destino != null) {
        NodoGrafo nodoGrafoOrigen = nodos.get(origen);
        NodoGrafo nodoGrafoDestino = nodos.get(destino);
        
        if (nodoGrafoOrigen != null && nodoGrafoDestino != null) {
            
              Ruta rutaMasCorta = calcularRutaMasCorta(origen, destino);
        List<String> nodosRuta = rutaMasCorta.getNodosIntermedio();
            
            for (NodoGrafo nodoGrafo : nodos.values()) {
                nodoGrafo.setEsOrigen(false);
                nodoGrafo.setEsDestino(false);
            }
            nodoGrafoOrigen.setEsOrigen(true);
            for (int i = 0; i < nodosRuta.size(); i++) {
                String nodoActual = nodosRuta.get(i);
                NodoGrafo nodoGrafo = nodos.get(nodoActual);
                if (nodoGrafo != null) {
                    nodoGrafo.repaint();
                    try {
                        Thread.sleep(1000); 
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
              grafoVisual.resaltarOrigen(origen);
        grafoVisual.resaltarDestino(destino);
        grafoVisual.resaltarRuta(nodosRuta);
            nodoGrafoDestino.setEsDestino(true);
            nodoGrafoDestino.repaint();

            graficar(distancias, grafo, origen, destino, nodosRuta);
        } else {
            System.out.println("Uno o ambos nodos (origen o destino) no se encontraron en el grafo.");
        }
    } else {
        System.out.println("No se ha seleccionado un origen y/o destino válido.");
    }
    }//GEN-LAST:event_SiguienteCaminoActionPerformed

    private void actualizarControlReloj() {
        ControlReloj.setText(reloj.obtenerHoraActual());
    }

   private void graficar(Map<String, Map<String, Map<String, Integer>>> distancias, GrafoDirigidoPonderado grafo, String origenSeleccionado, String destinoSeleccionado, List<String> nodosRuta) {
        StringBuilder dotSource = new StringBuilder();
        dotSource.append("digraph G {\n"); 
        dotSource.append("  rankdir=LR;\n");
      dotSource.append("  node [shape=oval, style=filled, color=lightgray];\n");
      // Resaltar los nodos de la ruta
dotSource.append("  node [style=filled, color=lightgray];\n"); 
dotSource.append("  \"" + origenSeleccionado + "\" [color=red];\n"); 
dotSource.append("  \"" + destinoSeleccionado + "\" [color=blue];\n"); 
for (String nodo : nodosRuta) {
    if (!nodo.equals(origenSeleccionado) && !nodo.equals(destinoSeleccionado)) {
        dotSource.append("  \"" + nodo + "\" [color=orange];\n"); 
    }
}
      Map<Integer, List<String>> nivelesNodos = new HashMap<>();
      for (String nodo : grafo.obtenerNodos()) {
        int nivel = calcularNivel(nodo, origenSeleccionado);
        if (!nivelesNodos.containsKey(nivel)) {
          nivelesNodos.put(nivel, new ArrayList<>());
        }
        nivelesNodos.get(nivel).add(nodo);
      }

      for (String nodo : grafo.obtenerNodos()) {
        dotSource.append("  \"" + nodo + "\";\n");
      }
      for (String origen : distancias.keySet()) {
        for (String destino : distancias.get(origen).keySet()) {
          Map<String, Integer> info = distancias.get(origen).get(destino);
          int tiempoVehiculo = info.get("tiempoVehiculo");
          int tiempoPie = info.get("tiempoPie");
          int consumoGas = info.get("consumoGas");
          int desgastePersona = info.get("desgastePersona");
          int distancia = info.get("distancia");
          String label = "Tiempo (vehículo): " + tiempoVehiculo + "\\nTiempo (pie): " + tiempoPie + "\\nConsumo de gas: " + consumoGas + "\\nDesgaste persona: " + desgastePersona + "\\nDistancia: " + distancia;
          dotSource.append("  \"" + origen + "\" -> \"" + destino + "\" [label=\"" + label + "\"];\n");
        }
      }
      dotSource.append("}\n");
        try {
            File tempFile = File.createTempFile("graph", ".dot");
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            writer.write(dotSource.toString());
            writer.close();

            ProcessBuilder processBuilder = new ProcessBuilder("dot", "-Tpng", "-o", "graph.png", tempFile.getAbsolutePath());
            Process process = processBuilder.start();
            process.waitFor();
            cargarImagenGrafo();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void cargarImagenGrafo() {
        try {
            ImageIcon icon = new ImageIcon("graph.png");
            Graficas.removeAll(); 
            Graficas.setLayout(new BorderLayout());
            JScrollPane scrollPane = new JScrollPane();
            JLabel labelImagen = new JLabel(icon);
            scrollPane.setViewportView(labelImagen);
            Graficas.add(scrollPane, BorderLayout.CENTER);
            Graficas.revalidate();
            Graficas.repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void mostrarImagen(String rutaImagen) {
        ImageIcon imagenIcono = new ImageIcon(rutaImagen);
        Image imagen = imagenIcono.getImage(); 
        //aquii se muestra la imagen de los grafos en el panel
        Image imagenRedimensionada = imagen.getScaledInstance(669, 1456, Image.SCALE_SMOOTH);
        ImageIcon imagenRedimensionadaIcono = new ImageIcon(imagenRedimensionada); 
        JLabel imagenLabel = new JLabel(imagenRedimensionadaIcono); 
        Graficas.removeAll(); 
        Graficas.add(imagenLabel); 
        Graficas.revalidate(); 
        Graficas.repaint(); 
        
    }

    private void generarImagenDesdeDot(String nombreArchivoDot, String nombreImagen) {
        String comandoDot = String.format("dot -Tpng -o %s.png %s", nombreImagen, nombreArchivoDot);

        try {
            Process proceso = Runtime.getRuntime().exec(comandoDot);
            int exitVal = proceso.waitFor();
            if (exitVal == 0) {
                System.out.println("Imagen generada correctamente: " + nombreImagen);
            } else {
                JOptionPane.showMessageDialog(null, "Error al generar la imagen. Código de salida: " + exitVal);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

  public Ruta calcularRutaMasCorta(String origen, String destino) {
    Map<String, Integer> distancias = new HashMap<>();
    Map<String, String> previos = new HashMap<>();
    Set<String> nodosVisitados = new HashSet<>();

    for (String nodo : grafo.obtenerNodos()) {
        distancias.put(nodo, Integer.MAX_VALUE);
    }
    distancias.put(origen, 0);

    // el mero perro algoritmo de Dijkstra
    while (!nodosVisitados.contains(destino)) {
        String nodoActual = obtenerNodoMasCercano(distancias, nodosVisitados);
        if (nodoActual == null) {
            return null;
        }
        nodosVisitados.add(nodoActual);

        for (String vecino : grafo.obtenerNodosAdyacentes(nodoActual)) {
            int pesoArista = grafo.obtenerPeso(nodoActual, vecino);
            int distanciaActual = distancias.get(nodoActual) + pesoArista;

            if (distanciaActual < distancias.get(vecino)) {
                distancias.put(vecino, distanciaActual);
                previos.put(vecino, nodoActual);
            }
        }
    }

    LinkedList<String> rutaNodos = new LinkedList<>();
    String nodoActual = destino;
    while (previos.containsKey(nodoActual)) {
        rutaNodos.addFirst(nodoActual);
        nodoActual = previos.get(nodoActual);
    }
    rutaNodos.addFirst(origen);
    return new Ruta(origen, destino, rutaNodos, distancias.get(destino));
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

    private int calcularNivel(String nodo, String origen) { 
        Map<String, Integer> distancias = new HashMap<>();
        Map<String, String> previos = new HashMap<>();
        Set<String> nodosVisitados = new HashSet<>();
        for (String n : grafo.obtenerNodos()) {
            distancias.put(n, Integer.MAX_VALUE);
        }
        distancias.put(origen, 0);
        while (!nodosVisitados.contains(nodo)) {
            String nodoActual = obtenerNodoMasCercano(distancias, nodosVisitados);
            if (nodoActual == null) {
                return -1;
            }
            nodosVisitados.add(nodoActual);

            for (String vecino : grafo.obtenerNodosAdyacentes(nodoActual)) {
                int pesoArista = grafo.obtenerPeso(nodoActual, vecino);
                int distanciaActual = distancias.get(nodoActual) + pesoArista;

                if (distanciaActual < distancias.get(vecino)) {
                    distancias.put(vecino, distanciaActual);
                    previos.put(vecino, nodoActual);
                }
            }
        }

        return distancias.get(nodo); // Corrección 2
    }
   
  private void graficarArbolB(ArbolB arbolB) {
    String dotSource = arbolB.generarCodigoDot();

    try {
        File tempFile = File.createTempFile("arbolB", ".dot");
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
        writer.write(dotSource);
        writer.close();

        // Especificar la ubicación para guardar la imagen del árbol
        File imageFile = new File("/home/moisibot/NetBeansProjects/FinalEdd/arbolB.png");

        // Utilizar Graphviz para generar la imagen del árbol
        ProcessBuilder processBuilder = new ProcessBuilder("dot", "-Tpng", "-o", imageFile.getAbsolutePath(), tempFile.getAbsolutePath());
        Process process = processBuilder.start();
        process.waitFor();

        // Mostrar la imagen en tu aplicación (opcional)
        mostrarImagen(imageFile.getAbsolutePath());
    } catch (IOException | InterruptedException e) {
        e.printStackTrace();
    }
}





private void procesarTrafico(Map<String, Map<String, List<TrafficInfo>>> trafico, StringBuilder dotSource) {
    // Obtener la hora actual (suponiendo que es 14:00)
    int horaActual = 14;

    for (String origen : distancias.keySet()) {
        for (String destino : distancias.get(origen).keySet()) {
            Map<String, Integer> info = distancias.get(origen).get(destino);
            int tiempoVehiculo = info.get("tiempoVehiculo");
            int tiempoPie = info.get("tiempoPie");
            int consumoGas = info.get("consumoGas");
            int desgastePersona = info.get("desgastePersona");
            int distancia = info.get("distancia");

            // Verificar si hay información de tráfico para esta ruta
            if (trafico.containsKey(origen) && trafico.get(origen).containsKey(destino)) {
                List<TrafficInfo> infoTrafico = trafico.get(origen).get(destino);
                for (TrafficInfo trafficInfo : infoTrafico) {
                    if (horaActual >= trafficInfo.getHoraInicio() && horaActual < trafficInfo.getHoraFinaliza()) {
                        // Ajustar el tiempo de viaje en vehículo según la probabilidad de tráfico
                        tiempoVehiculo *= (1 + trafficInfo.getProbabilidadTrafico() / 100.0);
                    }
                }
            }

            String label = "Tiempo (vehículo): " + tiempoVehiculo + "\n"
                         + "Tiempo (pie): " + tiempoPie + "\n"
                         + "Consumo de gas: " + consumoGas + "\n"
                         + "Desgaste persona: " + desgastePersona + "\n"
                         + "Distancia: " + distancia;
            dotSource.append("  \"" + origen + "\" -> \"" + destino + "\" [label=\"" + label + "\"];\n");
        }
    }
}
private void generarGrafoDOT(Map<String, Map<String, Map<String, Integer>>> distancias, StringBuilder dotSource) {
    for (String origen : distancias.keySet()) {
        for (String destino : distancias.get(origen).keySet()) {
            Map<String, Integer> info = distancias.get(origen).get(destino);
            int tiempoVehiculo = info.get("tiempoVehiculo");
            int tiempoPie = info.get("tiempoPie");
            int consumoGas = info.get("consumoGas");
            int desgastePersona = info.get("desgastePersona");
            int distancia = info.get("distancia");
            String label = "Tiempo (vehículo): " + tiempoVehiculo + "\\n"
                         + "Tiempo (pie): " + tiempoPie + "\\n"
                         + "Consumo de gas: " + consumoGas + "\\n"
                         + "Desgaste persona: " + desgastePersona + "\\n"
                         + "Distancia: " + distancia;
            dotSource.append("  \"" + origen + "\" -> \"" + destino + "\" [label=\"" + label + "\"];\n");
        }
    }
}
private void graficar(String dotSource, String nombreArchivoDot, String nombreImagen) {
    try (PrintWriter writer = new PrintWriter(nombreArchivoDot)) {
        writer.println(dotSource);
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }

    // Generar la imagen a partir del archivo DOT
    generarImagenDesdeDot(nombreArchivoDot, nombreImagen);
}
private int obtenerProbabilidadTrafico(Map<String, Map<String, List<TrafficInfo>>> trafico, String origen, String destino, int horaActual) {
    if (trafico.containsKey(origen) && trafico.get(origen).containsKey(destino)) {
        List<TrafficInfo> infoTrafico = trafico.get(origen).get(destino);
        for (TrafficInfo info : infoTrafico) {
            if (horaActual >= info.getHoraInicio() && horaActual < info.getHoraFinaliza()) {
                return info.getProbabilidadTrafico();
            }
        }
    }
    return 0; // Si no hay tráfico, la probabilidad es 0
}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Aplicar;
    private javax.swing.JButton Arbol;
    private javax.swing.JButton Archivo;
    private javax.swing.JButton Archivo2;
    private javax.swing.JTextField ControlReloj;
    private javax.swing.JComboBox<String> Destino;
    private javax.swing.JTextField Distancia;
    private javax.swing.JTextField Fisico;
    private javax.swing.JTextField Gas;
    private javax.swing.JPanel Graficas;
    private javax.swing.JTextField Historial;
    private javax.swing.JButton NuevoViaje;
    private javax.swing.JComboBox<String> Opciones;
    public javax.swing.JComboBox<String> Origen;
    private javax.swing.JButton Pausa;
    private javax.swing.JButton Reanudar;
    private javax.swing.JLabel Recorrido;
    private javax.swing.JButton SiguienteCamino;
    private javax.swing.JButton VerDatos;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JFrame jFrame3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
