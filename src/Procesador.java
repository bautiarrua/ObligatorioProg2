import Entities.Cancion;
import adt.arbolbinario.Arbolbinario;
import adt.arbolbinario.MyArbolbinario;
import java.time.LocalDate;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.Key;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;

public class Procesador {
    public static void main(String[] args) {
        Cancion c;
        int size =750000;
        int ca = 2;
        String fileName = "C:\\Users\\jarruabarrena\\OneDrive - Universidad de Montevideo\\Prog2\\Obligatorio\\universal_top_spotify_songs.csv";
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
            String linea = br.readLine();
//            while ((linea = br.readLine()) != null){
            for (int i = 0; i<size; i++){
                System.out.println(ca);
                linea = br.readLine();
                if(linea!=null) {
                    ca++;
                    String[] datos = linea.split(",\"");
                    String ar = datos[2];
                    String[] artistas = ar.split(",");
                        c = new Cancion(datos[0].replaceAll("\"", ""),
                                datos[1].replaceAll("\"", ""),
                                Float.parseFloat(datos[3].replaceAll("\"", "")));
                        for (int a = 0; a < artistas.length; a++) {
                            c.getArtist().add(artistas[a].replaceAll("[\"; ]", ""));
                        }
                    }
                }
        } catch (IOException e) {
            System.out.println("No entro");
        }

//        c = canciones.get(3);
//        System.out.println("id cancion: "+c.getSpotifyId());
//        System.out.println("Nombre cancion: "+c.getName());
//        for(int i = 0; i<canciones.get(3).getArtist().size();i++){
//            System.out.println("Nombre artista "+(i+1)+": "+c.getArtist().get(i));
//        }
//        System.out.println("tempo: "+c.getTempo());
    }
}
