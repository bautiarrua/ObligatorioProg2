import Entities.Cancion;
import Entities.Top50;
import adt.Heap.MyHeap;
import adt.Heap.MyHeapIMPL;
import adt.arbolbinario.Arbolbinario;
import adt.arbolbinario.MyArbolbinario;
import adt.hashcerrado.MyHashCerrado;
import adt.hashcerrado.MyHashCerradoI;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;


public class Procesador {
    public static void main(String[] args) {

//        MyHashCerrado<String, Top50> paises = new MyHashCerrado<>();
        MyArbolbinario<ChronoLocalDate,MyHashCerradoI<String,Top50>> arbolFechas = new Arbolbinario<>();
        Cancion c;
        Top50 toptemp = new Top50(null,null);
        int size =100;
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
                    String pais = datos[6].replaceAll("\"", "");
                    ChronoLocalDate fecha = LocalDate.parse(datos[7].replaceAll("\"", ""));
                    System.out.println(fecha);
                    System.out.println(pais);
                    int dr = Integer.parseInt(datos[3].replaceAll("\"", ""));
                    c = new Cancion(datos[0].replaceAll("\"", ""),
                            datos[1].replaceAll("\"", ""),
                            Float.parseFloat(datos[3].replaceAll("\"", "")));
                    for (int a = 0; a < artistas.length; a++) {
                        c.getArtist().add(artistas[a].replaceAll("[\"; ]", ""));
                    }
                    if(!arbolFechas.contains(fecha)){
                        MyHashCerradoI<String,Top50> paises = new MyHashCerrado<>();
                        arbolFechas.add(fecha,paises);
                    }
                    if(arbolFechas.contains(fecha)){
                        if(!arbolFechas.find(fecha).contains(pais)){
                            toptemp.setPais(pais);
                            toptemp.setFecha(fecha);
                            MyHeap<Cancion,Integer> top = new MyHeapIMPL<>();
                            toptemp.setTop(top);
                            toptemp.getTop().insert(c,dr);
                            try {
                                arbolFechas.find(fecha).put(pais,toptemp);
                            }catch (Exception e){System.out.println("no agrego el pais");}
                            try {
                                arbolFechas.find(fecha).get(pais).setTop(toptemp.getTop());
                            }catch (Exception e){System.out.println("no agrego el top");}
                        }
                        if(arbolFechas.find(fecha).contains(pais)){
                            toptemp.getTop().insert(c,dr);
                            if(toptemp.getTop().size() == 50){
                                try {
                                    arbolFechas.find(fecha).get(pais).setTop(toptemp.getTop());
                                }catch (Exception e){System.out.println("no agrego el top lleno");}
                            }

                        }
                    }
                    }
                }
        } catch (IOException e) {
            System.out.println("No entro");
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Parse the date string to LocalDate
        LocalDate localDate = LocalDate.parse("13/05/2024", formatter);

        // Assign to ChronoLocalDate
        ChronoLocalDate fecha = localDate;

        try {
            int tamaño = arbolFechas.find(fecha).get("ZA").getTop().size();
            System.out.println("tamaño= " + tamaño);
        }catch (Exception e){System.out.println("no entra");}

    }
}
