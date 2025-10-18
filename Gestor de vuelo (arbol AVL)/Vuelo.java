package carlos;

// Clase que representa la información de un vuelo
public class Vuelo {
    int numeroVuelo;
    String origen;
    String destino;
    String hora;
    String aerolinea;

    // Constructor
    public Vuelo(int numeroVuelo, String origen, String destino, String hora, String aerolinea) {
        this.numeroVuelo = numeroVuelo;
        this.origen = origen;
        this.destino = destino;
        this.hora = hora;
        this.aerolinea = aerolinea;
    }

    // Representación en texto del vuelo
    @Override
    public String toString() {
        return "Número: " + numeroVuelo +
               " | Origen: " + origen +
               " | Destino: " + destino +
               " | Hora: " + hora +
               " | Aerolínea: " + aerolinea;
    }
}