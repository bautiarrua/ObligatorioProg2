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
        MyArbolbinario<ChronoLocalDate, MyHashCerradoI<String, Top50>> arbolFechas = new Arbolbinario<>();
        Cancion c;
        Top50 toptemp = new Top50(null, null);
        int size =53;
        int ca = 2;
        int l =0;
        String fileName = "C:\\Users\\jarruabarrena\\OneDrive - Universidad de Montevideo\\Prog2\\Obligatorio\\universal_top_spotify_songs.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String linea = br.readLine();
//            while ((linea = br.readLine()) != null){
            for (int i = 0; i < size; i++) {
                System.out.println(ca);
                linea = br.readLine();
                if (linea != null) {
                    ca++;
                    String[] datos = linea.split(",\"");
                    String ar = datos[2];
                    String[] artistas = ar.split(",");
                    String pais = datos[6].replaceAll("\"", "");
                    ChronoLocalDate fecha = LocalDate.parse(datos[7].replaceAll("\"", ""));
                    int dr = Integer.parseInt(datos[3].replaceAll("\"", ""));
                    c = new Cancion(datos[0].replaceAll("\"", ""),
                            datos[1].replaceAll("\"", ""),
                            Float.parseFloat(datos[3].replaceAll("\"", "")));
                    for (int a = 0; a < artistas.length; a++) {
                        c.getArtist().add(artistas[a].replaceAll("[\"; ]", ""));
                    }
                    if (!arbolFechas.contains(fecha)) {
                        MyHashCerradoI<String, Top50> paises = new MyHashCerrado<>();
                        arbolFechas.add(fecha, paises);
                    }
                    if (arbolFechas.contains(fecha)) {
                        if (!arbolFechas.find(fecha).Keys().contains(pais)) {
                            MyHeap<Cancion, Integer> top = new MyHeapIMPL<>();
                            toptemp.setPais(pais);
                            toptemp.setFecha(fecha);
                            toptemp.setTop(top);
                            toptemp.getTop().insert(c, dr);
                            try {
                                arbolFechas.find(fecha).put(pais, toptemp);
                            } catch (Exception e) {

                            }
                            try {
                                arbolFechas.find(fecha).get(pais).setTop(toptemp.getTop());
                            } catch (Exception e) {
                                System.out.println("no agrego el top");
                            }
                        } if (arbolFechas.find(fecha).Keys().contains(pais)) {
                            toptemp.getTop().insert(c, dr);
                            if (toptemp.getTop().size() == 50) {
                                try {
                                    String pa = arbolFechas.find(fecha).Keys().get(l);
                                    arbolFechas.find(fecha).get(pa).setTop(toptemp.getTop());
                                    l++;
                                } catch (Exception e) {
                                    System.out.println("no agrego el top lleno");
                                }
                            }

                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("No entro");
        }


        //Pruebas
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse("13/05/2024", formatter);
        ChronoLocalDate fecha = localDate;
        try {
            if(arbolFechas.find(fecha).Keys().contains("ZA")){
                System.out.println("ZA esta en esta fecha");
            }
            System.out.println("Los paises rgitrados en esta fecha son: ");
            for(int p = 0; p<arbolFechas.find(fecha).Keys().size(); p++){
                System.out.println(arbolFechas.find(fecha).Keys().get(p));
            }
            String pai = arbolFechas.find(fecha).Keys().get(1);
            System.out.println(arbolFechas.find(fecha).get(pai).getTop().delete().getName() );
            }catch (Exception e){System.out.println("no entra");}


    }
}
