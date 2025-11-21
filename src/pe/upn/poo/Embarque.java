/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.upn.poo;

public class Embarque {

    private int idEmbarque;
    private String fechaHora;

    public Embarque() {}
    public Embarque(int idEmbarque, String fechaHora) {
        this.idEmbarque = idEmbarque;
        this.fechaHora = fechaHora;
    }

    public int getIdEmbarque() { return idEmbarque; }
    public void setIdEmbarque(int idEmbarque) { this.idEmbarque = idEmbarque; }

    public String getFechaHora() { return fechaHora; }
    public void setFechaHora(String fechaHora) { this.fechaHora = fechaHora; }

    public boolean validarTicket(Pasajero pasajero) {
        if (pasajero == null) return false;
        String dni = pasajero.getDni();
        if (dni == null || dni.trim().isEmpty()) return false;
        String estado = pasajero.getEstadoEmbarque();
        if (estado == null) return true;
        return estado.equalsIgnoreCase("Pendiente");
    }

    public boolean confirmarEmbarque(Pasajero pasajero, Vuelo vuelo) {
        if (pasajero == null || vuelo == null) return false;
        Pasajero p = vuelo.buscarPasajeroPorDni(pasajero.getDni());
        if (p == null) return false;
        if (!validarTicket(p)) return false;
        p.setEstadoEmbarque("Embarcado");
        vuelo.setEstado("En Embarque");
        return true;
    }

    @Override
    public String toString() {
        return "Embarque{" + "id=" + idEmbarque + ", fechaHora=" + fechaHora + '}';
    }
}
