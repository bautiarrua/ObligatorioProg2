package Entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cancion {

    String spotifyId;//0
    String name;//1
    List<String> artist;//2
    Float tempo;//23

//    int dailyRank;//3
//    int dailyMovements;//4
//    int weeklyMovements;//5
//    String country;//6
//    LocalDate snapShot;//7
//    int popularity;//8
//    boolean isExplicit;//9
//    int durationMs;//10
//    String albumName;//11
//    String albumRelease 12
//    Float danceability;//13
//    Float energy;//1
//    Int key 15
//    Float loudness;//16
//    Int mode 17
//    Float speechiness;//18
//    Float acousticness;//19
//    Float instrumentalness;//20
//    Float liveness;//21
//    Float valence;//22
//    int timeSignature;//24


    public Cancion(String spotifyId, String name,Float tempo) {
        this.spotifyId = spotifyId;
        this.name = name;
        this.tempo = tempo;
        this.artist = new ArrayList<>();
    }


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

    public List getArtist() {
        return artist;
    }

//    public void setArtist(String artist) {
//        this.artist = artist;
//    }
    public Float getTempo() {
        return tempo;
    }

    public void setTempo(Float tempo) {
        this.tempo = tempo;
    }

}