package Entities;

import java.util.List;

public class Artista implements Comparable<Artista> {

    private String nombre;
    //List<Cancion> canciones;
    private Integer Contdor; //Pa contar las veces q aparece en el top 50

    public Artista(String nombre) {
        this.nombre = nombre;
        this.Contdor = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getContdor() {
        return Contdor;
    }

    public void setContdor(Integer Contdor) {
        this.Contdor = Contdor;
    }

    //public List<Cancion> getCanciones() {
     //   return canciones;
    //}

    //public void setCanciones(List<Cancion> canciones) {
      //  this.canciones = canciones;
    //}

    public int compareTo(Artista a) {
        if (this.Contdor < a.getContdor()) {
            return 1;
        } else if (this.Contdor > a.getContdor()) {
            return -1;
        } else {
            return 0;
        }
    }
}
