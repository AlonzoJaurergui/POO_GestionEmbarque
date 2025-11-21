/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.upn.dao;

import java.util.LinkedList;
import pe.upn.poo.Pasajero;

public class PasajeroDao {
    private LinkedList<Pasajero> lista = new LinkedList<>();

    public void create(Pasajero p) { lista.add(p); }

    public Pasajero findByDni(String dni) {
        for (Pasajero p : lista) if (p.getDni().equalsIgnoreCase(dni)) return p;
        return null;
    }

    public boolean deleteByDni(String dni) {
        return lista.removeIf(p -> p.getDni().equalsIgnoreCase(dni));
    }
    

    public LinkedList<Pasajero> list() { return lista; }
}
