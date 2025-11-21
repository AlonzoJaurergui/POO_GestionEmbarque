/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.upn.poo;

import java.util.LinkedList;

public class Pasajero {
    private int idpasajero;
    private String nombre;
    private String dni;
    private String estadoEmbarque;
    private LinkedList<Equipaje> equipajes = new LinkedList<>();

    public Pasajero(){}

    public Pasajero(int idpasajero, String nombre, String dni, String estadoEmbarque) {
        this.idpasajero = idpasajero;
        this.nombre = nombre;
        this.dni = dni;
        this.estadoEmbarque = estadoEmbarque;
    }

    public int getIdpasajero() { return idpasajero; }
    public void setIdpasajero(int idpasajero) { this.idpasajero = idpasajero; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public String getEstadoEmbarque() { return estadoEmbarque; }
    public void setEstadoEmbarque(String estadoEmbarque) { this.estadoEmbarque = estadoEmbarque; }

    public LinkedList<Equipaje> getEquipajes() { return equipajes; }
    public void agregarEquipaje(Equipaje eq) { this.equipajes.add(eq); }

    public boolean eliminarEquipajePorId(int idEquipaje) {
        return this.equipajes.removeIf(e -> e.getIdEquipaje() == idEquipaje);
    }

    public void listarEquipajes() {
        if (equipajes.isEmpty()) {
            System.out.println("  No tiene equipajes registrados.");
            return;
        }
        for (Equipaje e : equipajes) {
            System.out.println("  ID: " + e.getIdEquipaje() + " - Peso: " + e.getPeso() + " - Tipo: " + e.getTipo());
        }
    }

    @Override
    public String toString() {
        return "Pasajero{" +
                "id=" + idpasajero +
                ", nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", estado='" + estadoEmbarque + '\'' +
                '}';
    }
}
