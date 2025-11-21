/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.upn.dao;

import java.util.LinkedList;
import pe.upn.poo.Equipaje;

public class EquipajeDao {
    private LinkedList<Equipaje> lista = new LinkedList<>();

    public void create(Equipaje e) { lista.add(e); }

    public Equipaje findById(int id) {
        for (Equipaje e : lista) if (e.getIdEquipaje() == id) return e;
        return null;
    }

    public boolean deleteById(int id) {
        return lista.removeIf(e -> e.getIdEquipaje() == id);
    }

    public LinkedList<Equipaje> list() { return lista; }
}
