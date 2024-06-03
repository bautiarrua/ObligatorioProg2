import Entities.Cancion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Procesador {
    public static void main(String[] args) {
        Cancion c;
        int size =10;
        int ca = 0;
        ArrayList<Cancion> canciones = new ArrayList<>();
        ArrayList<String> cancionesnombres = new ArrayList<>();
        String fileName = "C:\\Users\\jarruabarrena\\OneDrive - Universidad de Montevideo\\Prog2\\Obligatorio\\universal_top_spotify_songs.csv";
//        String fileName = "C:\\Users\\jarruabarrena\\OneDrive - Universidad de Montevideo\\Prog2\\Obligatorio\\Valoresdes.csv";
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
            String linea = br.readLine();
//            while ((linea = br.readLine()) != null){
            for (int i = 0; i<size; i++){
                linea = br.readLine();
                if(linea!=null) {
                    String[] datos = linea.split(",\"");

                    String ar = datos[2];
                    String[] artistas = ar.split(",");
                    if (cancionesnombres.contains(datos[1].replaceAll("\"", ""))) {
                    } else {
                        c = new Cancion(datos[0].replaceAll("\"", ""),
                                datos[1].replaceAll("\"", ""),
                                Float.parseFloat(datos[3].replaceAll("\"", "")));
                        for (int a = 0; a < artistas.length; a++) {
                            c.getArtist().add(artistas[a].replaceAll("[\"; ]", ""));
                        }
                        if (canciones.contains(c)) {

                        } else {
                            canciones.add(c);
                            cancionesnombres.add(datos[1].replaceAll("\"", ""));
                        }
                    }
                }else {
                    continue;
                }
            }

        } catch (IOException e) {
            System.out.println("No entro");
        }

        c = canciones.get(3);
        System.out.println("id cancion: "+c.getSpotifyId());
        System.out.println("Nombre cancion: "+c.getName());
        for(int i = 0; i<canciones.get(3).getArtist().size();i++){
            System.out.println("Nombre artista "+(i+1)+": "+c.getArtist().get(i));
        }
        System.out.println("tempo: "+c.getTempo());
    }
}
