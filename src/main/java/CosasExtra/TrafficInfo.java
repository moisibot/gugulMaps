package CosasExtra;

public class TrafficInfo {
    private int horaInicio;
    private int horaFinaliza;
    private int probabilidadTrafico;

    public TrafficInfo(int horaInicio, int horaFinaliza, int probabilidadTrafico) {
        this.horaInicio = horaInicio;
        this.horaFinaliza = horaFinaliza;
        this.probabilidadTrafico = probabilidadTrafico;
    }

    public int getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(int horaInicio) {
        this.horaInicio = horaInicio;
    }

    public int getHoraFinaliza() {
        return horaFinaliza;
    }

    public void setHoraFinaliza(int horaFinaliza) {
        this.horaFinaliza = horaFinaliza;
    }

    public int getProbabilidadTrafico() {
        return probabilidadTrafico;
    }

    public void setProbabilidadTrafico(int probabilidadTrafico) {
        this.probabilidadTrafico = probabilidadTrafico;
    }
}

