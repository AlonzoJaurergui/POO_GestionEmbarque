/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.upn.poo;

import pe.upn.dao.VueloDao;

/**
 * Utilidades administrativas (usadas por el menú).
 */
public class Administrador {

    private int idAdministrador;
    private String usuario;
    private String password;

    public Administrador() {}

    public Administrador(int idAdministrador, String usuario, String password) {
        this.idAdministrador = idAdministrador;
        this.usuario = usuario;
        this.password = password;
    }

    public int getIdAdministrador() { return idAdministrador; }
    public void setIdAdministrador(int idAdministrador) { this.idAdministrador = idAdministrador; }

    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public boolean iniciarSesion(String usuario, String clave) {
        if (this.usuario == null) return false;
        return this.usuario.equals(usuario) && this.password.equals(clave);
    }

    public void registrarVuelo(Vuelo vuelo, VueloDao dao) {
        if (vuelo == null || dao == null) return;
        dao.create(vuelo);
    }

    public void asignarPuerta(Vuelo vuelo, String puerta) {
        if (vuelo == null || puerta == null) return;
        vuelo.setPuerta(puerta);
    }

    public boolean registrarEmbarque(Pasajero pasajero, Vuelo vuelo) {
        if (vuelo == null || pasajero == null) return false;
        Pasajero p = vuelo.buscarPasajeroPorDni(pasajero.getDni());
        if (p == null) return false;
        p.setEstadoEmbarque("Embarcado");
        vuelo.setEstado("En Embarque");
        return true;
    }

    public void registrarDesembarque(Vuelo vuelo) {
        if (vuelo == null) return;
        for (Pasajero p : vuelo.getPasajeros()) {
            p.setEstadoEmbarque("Desembarcado");
        }
        vuelo.setEstado("Finalizado");
    }

    public boolean registrarEquipaje(Equipaje equipaje, Pasajero pasajero) {
        if (equipaje == null || pasajero == null) return false;
        pasajero.agregarEquipaje(equipaje);
        return true;
    }

    public Pasajero consultarPasajero(String dni, Vuelo vuelo) {
        if (dni == null || vuelo == null) return null;
        return vuelo.buscarPasajeroPorDni(dni);
    }

    @Override
    public String toString() {
        return "Administrador{" + "id=" + idAdministrador + ", usuario=" + usuario + '}';
    }
}
