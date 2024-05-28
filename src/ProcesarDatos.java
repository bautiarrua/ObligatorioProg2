import Entities.Cancion;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;

public class ProcesarDatos {
    public static void main(String[] args) {
        Cancion c;
        int size =1;
        ArrayList<Cancion> canciones = new ArrayList<>();
        String fileName = "C:\\Users\\jarruabarrena\\Downloads\\universal_top_spotify_songs.csv";
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
            String linea = br.readLine();
            for (int i = 0; i<size;i++) {
                linea = br.readLine();
                String[] datos = linea.split(",");
                c = new Cancion(datos[0].replaceAll("\"", ""),
                        datos[1].replaceAll("\"", ""),
                        datos[2].replaceAll("\"", ""),
                        Integer.parseInt(datos[3].replaceAll("\"", "")),
                        Integer.parseInt(datos[4].replaceAll("\"", "")),
                        Integer.parseInt(datos[5].replaceAll("\"", "")),
                        datos[6].replaceAll("\"", ""),
                        datos[7].replaceAll("\"", ""),
                        Integer.parseInt(datos[8].replaceAll("\"", "")),
                        Boolean.parseBoolean(datos[9].replaceAll("\"", "")),
                        Integer.parseInt(datos[10].replaceAll("\"", "")),
                        datos[11].replaceAll("\"", ""),
                        Float.parseFloat(datos[13].replaceAll("\"", "")),
                        Float.parseFloat(datos[14].replaceAll("\"", "")),
                        Float.parseFloat(datos[16].replaceAll("\"", "")),
                        Float.parseFloat(datos[18].replaceAll("\"", "")),
                        Float.parseFloat(datos[19].replaceAll("\"", "")),
                        Float.parseFloat(datos[20].replaceAll("\"", "")),
                        Float.parseFloat(datos[21].replaceAll("\"", "")),
                        Float.parseFloat(datos[22].replaceAll("\"", "")),
                        Float.parseFloat(datos[23].replaceAll("\"", "")),
                        Integer.parseInt(datos[24].replaceAll("[\";]", "")));
                        canciones.add(c);
            }
        } catch (IOException e) {
            System.out.println("No entro");
        }
        Cancion primeraCancion = canciones.get(0);

        System.out.println("Spotify ID: " + primeraCancion.getSpotifyId());
        System.out.println("Nombre: " + primeraCancion.getName());
        System.out.println("Artista: " + primeraCancion.getArtist());
        System.out.println("Daily Rank: " + primeraCancion.getDailyRank());
        System.out.println("Daily Movements: " + primeraCancion.getDailyMovements());
        System.out.println("Weekly Movements: " + primeraCancion.getWeeklyMovements());
        System.out.println("País: " + primeraCancion.getCountry());
        System.out.println("SnapShot: " + primeraCancion.getSnapShot());
        System.out.println("Popularidad: " + primeraCancion.getPopularity());
        System.out.println("Es explícito: " + primeraCancion.isExplicit());
        System.out.println("Duración en milisegundos: " + primeraCancion.getDurationMs());
        System.out.println("Nombre del álbum: " + primeraCancion.getAlbumName());
        System.out.println("Danceability: " + primeraCancion.getDanceability());
        System.out.println("Energía: " + primeraCancion.getEnergy());
        System.out.println("Loudness: " + primeraCancion.getLoudness());
        System.out.println("Speechiness: " + primeraCancion.getSpeechiness());
        System.out.println("Acousticness: " + primeraCancion.getAcousticness());
        System.out.println("Instrumentalness: " + primeraCancion.getInstrumentalness());
        System.out.println("Liveness: " + primeraCancion.getLiveness());
        System.out.println("Valence: " + primeraCancion.getValence());
        System.out.println("Tempo: " + primeraCancion.getTempo());
        System.out.println("Time Signature: " + primeraCancion.getTimeSignature());


    }
}
