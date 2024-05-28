package Entities;

import java.time.LocalDate;

public class Cancion {

    String spotifyId;//0
    String name;//1
    String artist;//2
    int dailyRank;//3
    int dailyMovements;//4
    int weeklyMovements;//5
    String country;//6
    String snapShot;//7
    int popularity;//8
    boolean isExplicit;//9
    int durationMs;//10
    String albumName;//11

    //String albumRelease 12
    Float danceability;//13
    Float energy;//14

    //Int key 15
    Float loudness;//16

    //Int mode 17
    Float speechiness;//18
    Float acousticness;//19
    Float instrumentalness;//20
    Float liveness;//21
    Float valence;//22
    Float tempo;//23
    int timeSignature;//24


    public Cancion(String spotifyId, String name, String artist, int dailyRank, int dailyMovements, int weeklyMovements,String country,
                   String snapShot, int popularity, boolean isExplicit, int durationMs, String albumName,
                   Float danceability, Float energy, Float loudness, Float speechiness, Float acousticness,
                   Float instrumentalness, Float liveness, Float valence, Float tempo, int timeSignature) {
        this.spotifyId = spotifyId;
        this.name = name;
        this.artist = artist;
        this.dailyRank = dailyRank;
        this.dailyMovements = dailyMovements;
        this.country = country;
        this.weeklyMovements = weeklyMovements;
        this.snapShot = snapShot;
        this.popularity = popularity;
        this.isExplicit = isExplicit;
        this.durationMs = durationMs;
        this.albumName = albumName;
        this.danceability = danceability;
        this.energy = energy;
        this.loudness = loudness;
        this.speechiness = speechiness;
        this.acousticness = acousticness;
        this.instrumentalness = instrumentalness;
        this.liveness = liveness;
        this.valence = valence;
        this.tempo = tempo;
        this.timeSignature = timeSignature;
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

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getDailyRank() {
        return dailyRank;
    }

    public void setDailyRank(int dailyRank) {
        this.dailyRank = dailyRank;
    }

    public int getDailyMovements() {
        return dailyMovements;
    }

    public void setDailyMovements(int dailyMovements) {
        this.dailyMovements = dailyMovements;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String weeklyRank) {
        this.country = weeklyRank;
    }

    public int getWeeklyMovements() {
        return weeklyMovements;
    }

    public void setWeeklyMovements(int weeklyMovements) {
        this.weeklyMovements = weeklyMovements;
    }

    public String getSnapShot() {
        return snapShot;
    }

    public void setSnapShot(String snapShot) {
        this.snapShot = snapShot;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public boolean isExplicit() {
        return isExplicit;
    }

    public void setExplicit(boolean explicit) {
        isExplicit = explicit;
    }

    public int getDurationMs() {
        return durationMs;
    }

    public void setDurationMs(int durationMs) {
        this.durationMs = durationMs;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public Float getDanceability() {
        return danceability;
    }

    public void setDanceability(Float danceability) {
        this.danceability = danceability;
    }

    public Float getEnergy() {
        return energy;
    }

    public void setEnergy(Float energy) {
        this.energy = energy;
    }

    public Float getLoudness() {
        return loudness;
    }

    public void setLoudness(Float loudness) {
        this.loudness = loudness;
    }

    public Float getSpeechiness() {
        return speechiness;
    }

    public void setSpeechiness(Float speechiness) {
        this.speechiness = speechiness;
    }

    public Float getAcousticness() {
        return acousticness;
    }

    public void setAcousticness(Float acousticness) {
        this.acousticness = acousticness;
    }

    public Float getInstrumentalness() {
        return instrumentalness;
    }

    public void setInstrumentalness(Float instrumentalness) {
        this.instrumentalness = instrumentalness;
    }

    public Float getLiveness() {
        return liveness;
    }

    public void setLiveness(Float liveness) {
        this.liveness = liveness;
    }

    public Float getValence() {
        return valence;
    }

    public void setValence(Float valence) {
        this.valence = valence;
    }

    public Float getTempo() {
        return tempo;
    }

    public void setTempo(Float tempo) {
        this.tempo = tempo;
    }

    public int getTimeSignature() {
        return timeSignature;
    }

    public void setTimeSignature(int timeSignature) {
        this.timeSignature = timeSignature;
    }
}