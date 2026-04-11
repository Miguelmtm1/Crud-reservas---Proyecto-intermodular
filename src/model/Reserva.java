package model;

public class Reserva {

    private int idRecurso;
    private int idReservaLocal;
    private int idUsuario;
    private String fecha;
    private String horaInicio;
    private String horaFin;
    private double coste;
    private int numeroPlazas;
    private String motivo;
    private String observaciones;

    public Reserva() {}

    public Reserva(int idRecurso, int idReservaLocal, int idUsuario, String fecha,
                   String horaInicio, String horaFin, double coste,
                   int numeroPlazas, String motivo, String observaciones) {

        this.idRecurso = idRecurso;
        this.idReservaLocal = idReservaLocal;
        this.idUsuario = idUsuario;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.coste = coste;
        this.numeroPlazas = numeroPlazas;
        this.motivo = motivo;
        this.observaciones = observaciones;
    }

    public int getIdRecurso() { return idRecurso; }
    public int getIdReservaLocal() { return idReservaLocal; }
    public int getIdUsuario() { return idUsuario; }
    public String getFecha() { return fecha; }
    public String getHoraInicio() { return horaInicio; }
    public String getHoraFin() { return horaFin; }
    public double getCoste() { return coste; }
    public int getNumeroPlazas() { return numeroPlazas; }
    public String getMotivo() { return motivo; }
    public String getObservaciones() { return observaciones; }

    public void setIdRecurso(int idRecurso) { this.idRecurso = idRecurso; }
    public void setIdReservaLocal(int idReservaLocal) { this.idReservaLocal = idReservaLocal; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }
    public void setFecha(String fecha) { this.fecha = fecha; }
    public void setHoraInicio(String horaInicio) { this.horaInicio = horaInicio; }
    public void setHoraFin(String horaFin) { this.horaFin = horaFin; }
    public void setCoste(double coste) { this.coste = coste; }
    public void setNumeroPlazas(int numeroPlazas) { this.numeroPlazas = numeroPlazas; }
    public void setMotivo(String motivo) { this.motivo = motivo; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }

    @Override
    public String toString() {
        return "Reserva{" +
                "idRecurso=" + idRecurso +
                ", idReservaLocal=" + idReservaLocal +
                ", idUsuario=" + idUsuario +
                ", fecha='" + fecha + '\'' +
                ", horaInicio='" + horaInicio + '\'' +
                ", horaFin='" + horaFin + '\'' +
                ", coste=" + coste +
                ", numeroPlazas=" + numeroPlazas +
                ", motivo='" + motivo + '\'' +
                ", observaciones='" + observaciones + '\'' +
                '}';
    }
}
