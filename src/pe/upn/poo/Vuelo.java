package pe.upn.poo;

/**
 *
 * @author Alonzo
 */
public class Vuelo {
    /*- idVuelo      : int
- codigoVuelo  : String
- destino      : String
- horaSalida   : String
- horaLlegada  : String
- puerta       : String
- estado       : String  // “Programado”, “En Embarque”, “En Vuelo”, “Finalizado”
------------------------------
+ agregarPasajero(p: Pasajero) : void
+ registrarDesembarque() : void
*/
    private int idVuelo;
    private String codigoVuelo;
    private String destino;
    private String horaEmbarque;
    private String horaSalida;
    private String puerta;
    private String estado;

    public Vuelo() {
    }
    
    public void listavuelos() {
        System.out.println("ID \t : " + this.getIdVuelo());
        System.out.println("Codigo \t : " + this.getCodigoVuelo());
        System.out.println("Destino\t : " + this.getDestino());
        System.out.println("Salida \t : " + this.getHoraSalida());
        System.out.println("H. Embarque\t : " + this.getHoraEmbarque());
        System.out.println("Puerta \t : " + this.getPuerta());
        System.out.println("Estado \t : " + this.getEstado());
        System.out.println("");
    }

    
    
    public int getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(int idVuelo) {
        this.idVuelo = idVuelo;
    }

    public String getCodigoVuelo() {
        return codigoVuelo;
    }

    public void setCodigoVuelo(String codigoVuelo) {
        this.codigoVuelo = codigoVuelo;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getHoraEmbarque() {
        return horaEmbarque;
    }

    public void setHoraEmbarque(String horaEmbarque) {
        this.horaEmbarque = horaEmbarque;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getPuerta() {
        return puerta;
    }

    public void setPuerta(String puerta) {
        this.puerta = puerta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    
}
