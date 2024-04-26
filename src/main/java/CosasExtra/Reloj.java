package CosasExtra;

import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JTextField;

public class Reloj {
    private LocalTime horaActual;
    private boolean bloqueado;
    private JTextField ControlReloj; 
    private Timer timer;

    public Reloj(JTextField ControlReloj) {
        this.ControlReloj = ControlReloj;
        horaActual = LocalTime.now();
        bloqueado = false;
        timer = new Timer();
        iniciarReloj();
    }

    public void iniciarReloj() {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (!bloqueado) {
                    avanzarTiempo();
                    actualizarEtiqueta();
                }
            }
            //se utiliza el periodo de mil pq eso es un milisegundo 
          }, 0, 1000); 
    }

    public void bloquear() {
        bloqueado = true;
    }

    public void desbloquear() {
        bloqueado = false;
    }

    public boolean estaBloqueado() {
        return bloqueado;
    }

    public void avanzarTiempo() {
        horaActual = horaActual.plusSeconds(1); 
    }

    public String obtenerHoraActual() {
        return horaActual.toString(); 
    }

    private void actualizarEtiqueta() {
        String horaFormateada = horaActual.toString(); 
        ControlReloj.setText(horaFormateada); 
    }
    public void setHora(int hora) {
    if (hora >= 0 && hora < 24) {
        this.horaActual = this.horaActual.withHour(hora);
    }
}

public void setMinuto(int minuto) {
    if (minuto >= 0 && minuto < 60) {
        this.horaActual = this.horaActual.withMinute(minuto);
    }
}
public void aplicarValoresIngresados() {
    String texto = ControlReloj.getText();
//ajuste para poder usarl mili y segundos
    String[] partes = texto.split(":");
    if (partes.length >= 2) {
        try {
            int hora = Integer.parseInt(partes[0]);
            int minuto = Integer.parseInt(partes[1]);
//se crean las variables pero no cambian en su funcion ya que funcionan medio bien xd
            int segundo = 0;
            int milisegundo = 0;
            if (partes.length > 2) {
                String[] segundosMilisegundos = partes[2].split("\\.");
                segundo = Integer.parseInt(segundosMilisegundos[0]);
                if (segundosMilisegundos.length > 1) {
                    milisegundo = Integer.parseInt(segundosMilisegundos[1]);
                }
            }
            setHora(hora);
            setMinuto(minuto);
        } catch (NumberFormatException e) {
            System.err.println("Formato de hora inválido.");
        }
    } else {
        System.err.println("Formato de hora inválido.");
    }
}



}
