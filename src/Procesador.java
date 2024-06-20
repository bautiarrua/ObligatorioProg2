import Entities.Artista;
import Entities.Cancion;
import Entities.Top50;
import adt.Exceptions.NoEsta;
import adt.Exceptions.YaExiste;
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
    MyHashCerradoI<String, Artista> hashArtistas = new MyHashCerrado<>();
    MyHashCerrado<String, Cancion> hashCanciones = new MyHashCerrado<>();
   public Arbolbinario<ChronoLocalDate,MyHashCerrado<String, Top50>> arbol() {

       // Obtener la instancia de Runtime
       Runtime runtime = Runtime.getRuntime();

       // Medir la memoria antes de ejecutar el código
       long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();

       // Iniciar la medición del tiempo
       long startTime = System.nanoTime();

       Arbolbinario<ChronoLocalDate, MyHashCerrado<String, Top50>> arbolFechas = new Arbolbinario<>();
       Cancion c = null;
       int size = 750000;
       // int ca = 2;
       int l = 0;
       //String fileName = "C:\\Users\\franc\\OneDrive - Universidad de Montevideo\\Programación 1\\universal_top_spotify_songs (1).csv";
       String fileName = "C:\\Users\\jarruabarrena\\OneDrive - Universidad de Montevideo\\Prog2\\Obligatorio\\universal_top_spotify_songs.csv";
       try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
           String linea = br.readLine();
//            while ((linea = br.readLine()) != null){
           for (int i = 0; i < size; i++) { // Este for es para decirle cuantas lineas leer
               //System.out.println(ca);
               linea = br.readLine();
               if (linea != null) {
                   // ca++;

                   //Obtener los datos
                   String[] datos = linea.split(",\"");

                   String ar = datos[2];
                   String[] artistas = ar.split(",");
                   String pais = datos[6].replaceAll("\"", "");

                   ChronoLocalDate fecha = LocalDate.parse(datos[7].replaceAll("\"", ""));

                   int dailyRank = Integer.parseInt(datos[3].replaceAll("\"", ""));
                   String id = datos[0].replaceAll("\"", "");
                   if(!hashCanciones.contains(id)) {
                       c = new Cancion(id,
                               datos[1].replaceAll("\"", ""),
                               Float.parseFloat(datos[23].replaceAll("\"", "")));

                       for (int a = 0; a < artistas.length; a++) { // Este for es para agregar los artistas a la cancion
                           String nombreV = artistas[a].replaceAll("\"", "");
                           String nombre = artistas[a].replaceAll("[\"; ]", "").toLowerCase();
                           c.getArtist().add(nombre);
                           if (!hashArtistas.contains(nombre)) {
                               Artista tempArtista = new Artista(nombre,nombreV);
                               try {
                                   hashArtistas.put(nombre, tempArtista);
                               } catch (YaExiste e) {
                               }
                           }
                       }
                       try {
                           hashCanciones.put(id, c);
                       }catch (YaExiste e){}
                   }else{
                       try {
                           c = hashCanciones.get(datos[0].replaceAll("\"", ""));
                       }catch (NoEsta e){}
                   }
                   //Agragar los datos a su lugar
                   if (!arbolFechas.contains(fecha)) {
                       MyHashCerrado<String, Top50> paises = new MyHashCerrado<>();
                       arbolFechas.add(fecha, paises);
                   }
                   if (arbolFechas.contains(fecha)) {
                       if (!arbolFechas.find(fecha).Keys().contains(pais)) {
                           Top50 toptemp = new Top50(pais,fecha);
                           try {
                               arbolFechas.find(fecha).put(pais, toptemp);
                           } catch (Exception e) {
                           }
                       }
                       if (arbolFechas.find(fecha).Keys().contains(pais)) {
                           try {
                               arbolFechas.find(fecha).get(pais).getTop().insert(c, dailyRank);
                           }catch (Exception e){}
                       }
                   }
               }
           }
       } catch (IOException e) {
           System.out.println("No entro");
       }


//     MEDIR TIEMPO Y RAM
       long endTime = System.nanoTime();

       // Medir la memoria después de ejecutar el código
       long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();

       // Calcular el uso de memoria
       long memoryUsed = usedMemoryAfter - usedMemoryBefore;

//        Calcular el tiempo transcurrido en nanosegundos
        long duration = (endTime - startTime);

        // Convertir a milisegundos y segundos si es necesario
        long durationInMillis = duration / 1_000_000;
        double durationInSeconds = duration / 1_000_000_000.0;

        System.out.println("El procesador tomó: " + durationInMillis + " milisegundos");
        System.out.println("El procesador tomó: " + durationInSeconds + " segundos");

        System.out.println("Memoria usada: " + (memoryUsed / 1024) + " KB");
        System.out.println("Memoria usada: " + (memoryUsed / (1024 * 1024)) + " MB");
        System.out.println("Hay "+ hashCanciones.size()+ " canciones");
        System.out.println("Hay "+ hashArtistas.size()+ " artistas");
        return arbolFechas;
   }

   public MyHashCerradoI<String,Artista> hash(){
       return hashArtistas;
   }
}
