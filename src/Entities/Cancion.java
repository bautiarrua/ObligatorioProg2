package Entities;

import adt.linkedlist.MyLinkedListImpl;
import adt.linkedlist.MyList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cancion implements Comparable<Cancion> {

    private String spotifyId;//0
    private String name;//1
    private MyList<String> artist;//2
    private Float tempo;//23
    int contador;

    public Cancion(String spotifyId, String name,Float tempo) {
        this.spotifyId = spotifyId;
        this.name = name;
        this.tempo = tempo;
        this.artist = new MyLinkedListImpl<>();
        this.contador = 0;
    }

    //Dos canciones son iguales si su id es el mismo
    public boolean equals(Object obj) {
        Cancion tempP = (Cancion) obj;
        if (this.getSpotifyId() == (tempP.getSpotifyId())) {
            return true;
        } else {
            return false;
        }
    }

    public String getSpotifyId() {
        return spotifyId;
    }

    public void setSpotifyId(String spotifyId) {
        this.spotifyId = spotifyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyList getArtist() {
        return artist;
    }

    public Float getTempo() {
        return tempo;
    }

    public void setTempo(Float tempo) {
        this.tempo = tempo;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    //El compareTo lo hicimos para que el heap se ordene con el que tiene mayor numero de apariciones primero y asi sucesivamente
    public int compareTo(Cancion a) {
        if (this.contador < a.getContador()) {
            return 1;
        } else if (this.contador > a.getContador()) {
            return -1;
        } else {
            return 0;
        }
    }
}