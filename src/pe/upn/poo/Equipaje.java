/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.upn.poo;

/**
 *
 * @author Alonzo
 */
public class Equipaje {
    private int idEquipaje;
    private double peso;
    private String tipo; // "Mano", "Bodega", etc.

    public Equipaje(){}
    public Equipaje(int idEquipaje, double peso, String tipo) {
        this.idEquipaje = idEquipaje;
        this.peso = peso;
        this.tipo = tipo;
    }

    public int getIdEquipaje() { return idEquipaje; }
    public void setIdEquipaje(int idEquipaje) { this.idEquipaje = idEquipaje; }

    public double getPeso() { return peso; }
    public void setPeso(double peso) { this.peso = peso; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
}
