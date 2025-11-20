/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.upn.service;

import java.util.LinkedList;

/**
 *
 * @author Alonzo
 */
public interface crudVuelo <V> {
    public void create(V obj);
    public void read(int id);
    public void update(V obj);
    public void delete(int id);
    public LinkedList<V> list();
    public LinkedList<V> search();
    public LinkedList<V> order();
    public LinkedList<V> filter();
}
