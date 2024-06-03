package Entities;

import adt.Heap.MyHeap;
import adt.Heap.MyHeapIMPL;

import java.time.LocalDate;

public class Top50 {
    String pais;
    LocalDate fecha;
    MyHeap<Cancion,Integer> top; //No tendria q ser daily rank en vez de cancion?

    public Top50(String pais, LocalDate fecha) {
        this.pais = pais;
        this.fecha = fecha;
        top = new MyHeapIMPL<>();
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public MyHeap<Cancion, Integer> getTop() {
        return top;
    }

    public void setTop(MyHeap<Cancion, Integer> top) {
        this.top = top;
    }//Para que se usa este metodo?

    public Object MakeTop(Integer length_top){ // Q calcule el top aca mismo, del tamaño q le pasen
        return null;
    }
}
