/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.upn.dao;
import java.util.LinkedList;
import pe.upn.poo.Pasajero;
import pe.upn.poo.Vuelo;
import pe.upn.service.crudVuelo;

public class VueloDao implements crudVuelo<Vuelo> {

    private LinkedList<Vuelo> listaVuelos = new LinkedList<>();

    @Override
    public void create(Vuelo obj) { listaVuelos.add(obj); }

    @Override
    public void read(int id) {
        Vuelo v = findById(id);
        if (v != null) v.listavuelos();
        else System.out.println("Vuelo no encontrado (id=" + id + ")");
    }

    @Override
    public void update(Vuelo obj) {
        for (int i = 0; i < listaVuelos.size(); i++) {
            if (listaVuelos.get(i).getIdVuelo() == obj.getIdVuelo()) {
                listaVuelos.set(i, obj);
                return;
            }
        }
    }

    @Override
    public void delete(int id) { listaVuelos.removeIf(v -> v.getIdVuelo() == id); }

    @Override
    public LinkedList<Vuelo> list() { return listaVuelos; }

    @Override
    public LinkedList<Vuelo> search() { return listaVuelos; }

    @Override
    public LinkedList<Vuelo> order() {
        listaVuelos.sort((a, b) -> a.getCodigoVuelo().compareToIgnoreCase(b.getCodigoVuelo()));
        return listaVuelos;
    }

    @Override
    public LinkedList<Vuelo> filter() { return listaVuelos; }

    public Vuelo findById(int id) {
        for (Vuelo v : listaVuelos) if (v.getIdVuelo() == id) return v;
        return null;
    }

    public Vuelo findByCodigo(String codigo) {
        for (Vuelo v : listaVuelos) if (v.getCodigoVuelo().equalsIgnoreCase(codigo)) return v;
        return null;
    }

    public Pasajero findPasajeroByDni(String dni) {
        for (Vuelo v : listaVuelos) {
            Pasajero p = v.buscarPasajeroPorDni(dni);
            if (p != null) return p;
        }
        return null;
    }

    public Vuelo findVueloByPasajeroDni(String dni) {
        for (Vuelo v : listaVuelos) {
            Pasajero p = v.buscarPasajeroPorDni(dni);
            if (p != null) return v;
        }
        return null;
    }

    public boolean eliminarPasajeroGlobalPorDni(String dni) {
        for (Vuelo v : listaVuelos) {
            if (v.eliminarPasajeroPorDni(dni)) return true;
        }
        return false;
    }
}
