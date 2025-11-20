/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.upn.poo;

/**
 *
 * @author Alonzo
 */
public class Pasajero {
    /*- idPasajero : int
- nombre     : String
- dni        : String
- estadoEmbarque : String  // “Pendiente”, “Embarcado”, “Desembarcado”
------------------------------
+ consultarVuelo() : Vuelo
*/
private int idpasajero;
private String nombre;
private int dni;
private String estadoEmbarque;

    public Pasajero(){}
    
    public Pasajero(int idpasajero, String nombre, int dni, String estadoEmbarque) {
        this.idpasajero = idpasajero;
        this.nombre = nombre;
        this.dni = dni;
        this.estadoEmbarque = estadoEmbarque;
    }



    public int getIdpasajero() {
        return idpasajero;
    }

    public void setIdpasajero(int idpasajero) {
        this.idpasajero = idpasajero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getEstadoEmbarque() {
        return estadoEmbarque;
    }

    public void setEstadoEmbarque(String estadoEmbarque) {
        this.estadoEmbarque = estadoEmbarque;
    }
    

}
