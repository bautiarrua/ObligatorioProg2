import Entities.Cancion;
import Entities.Top50;
import adt.Heap.MyHeap;
import adt.Heap.MyHeapIMPL;
import adt.arbolbinario.Arbolbinario;
import adt.hashcerrado.MyHashCerrado;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;


public class Procesador2 {
    public static void main(String[] args) {

        MyHashCerrado<String, Top50> Template_hash_paises = new MyHashCerrado<>();
        MyHashCerrado<String, Top50> Temp_hash_paises = new MyHashCerrado<>();
        Top50 toptemp = new Top50(null, null);
        Arbolbinario<ChronoLocalDate, MyHashCerrado<String, Top50>> arbolFechas = new Arbolbinario<>();
        Cancion c;

       // int contador = 0;
        int size =120;
        int l =0;
        Boolean Primera_vez = true;
        String Pais_reg = "";
        ChronoLocalDate fecha_reg = LocalDate.parse("13/05/2024", DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        //String fileName = "C:\\Users\\jarruabarrena\\OneDrive - Universidad de Montevideo\\Prog2\\Obligatorio\\universal_top_spotify_songs.csv";
        String fileName = "C:\\Users\\franc\\OneDrive - Universidad de Montevideo\\Programación 1\\universal_top_spotify_songs (1).csv";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String linea = br.readLine();

            for (int i = 0; i < size; i++) { // Este for es para decirle cuantas lineas leer
                //System.out.println(ca);
                linea = br.readLine();
                if (linea != null) {

                    //Obtener los datos
                    String[] datos = linea.split(",\"");

                    String ar = datos[2];
                    String[] artistas = ar.split(",");

                    String pais = datos[6].replaceAll("\"", "");

                    ChronoLocalDate fecha = LocalDate.parse(datos[7].replaceAll("\"", ""));

                    int dailyRank = Integer.parseInt(datos[3].replaceAll("\"", ""));

                    c = new Cancion(datos[0].replaceAll("\"", ""),
                            datos[1].replaceAll("\"", ""),
                            Float.parseFloat(datos[23].replaceAll("\"", "")));

                    for (int a = 0; a < artistas.length; a++) { // Este for es para agregar los artistas a la cancion
                        c.getArtist().add(artistas[a].replaceAll("[\"; ]", ""));
                    }


                    //Agragar los datos a su lugar
                    //if (!arbolFechas.contains(fecha)) { // Si la fecha no esta en el arbol

                        //if (Primera_vez){ // Solo si es la primera vez q se agregan paises a una fecha

//                            if (pais.isEmpty() && !fecha.equals(LocalDate.parse("13/05/2024", DateTimeFormatter.ofPattern("dd/MM/yyyy")))){
//                                Primera_vez = false;
//                                arbolFechas.add(LocalDate.parse("13/05/2024", DateTimeFormatter.ofPattern("dd/MM/yyyy")),Primer_hash_paises);
//                            }
                        if (fecha.equals(fecha_reg)){

                            if (toptemp.getTop().size() == 0) {

                                //Pais_reg = pais;
                                toptemp = new Top50(null, null);
                                // Relleno el top50
                                MyHeap<Cancion, Integer> top = new MyHeapIMPL<>(); // Creo un heap para el top
                                toptemp.setPais(pais);
                                toptemp.setFecha(fecha);
                                toptemp.setTop(top);
                            }

                            if (!pais.equals(Pais_reg)) { // Si el pais es distinto al anterior reset al top50

                                try {
                                    Temp_hash_paises.put(Pais_reg,toptemp);
                                }catch (Exception e){
                                    System.out.println("No se pudo agregar el pais");
                                }

                                Pais_reg = pais;
                                toptemp = new Top50(null, null);
                                // Relleno el top50
                                MyHeap<Cancion, Integer> top = new MyHeapIMPL<>(); // Creo un heap para el top
                                toptemp.setPais(pais);
                                toptemp.setFecha(fecha);
                                toptemp.setTop(top);
                            }

                            toptemp.getTop().insert(c, dailyRank);

//                            try {
//                               // paises_hash_temp.put(pais,null);
//                                Template_hash_paises.put(pais,null);
//                                //Primer_hash_paises.put(pais,toptemp);
//
//                            }catch (Exception e){
//                                System.out.println("No se pudo agregar el pais");
//                            }

                        } else { // Cuando cambia de fecha reset el hash paises y top

                            try {
                                Temp_hash_paises.put(Pais_reg,toptemp);
                            }catch (Exception e){
                                System.out.println("No se pudo agregar el pais");
                            }
                            arbolFechas.add(fecha_reg,Temp_hash_paises); // Agrego la fecha anterior al arbol
                            fecha_reg = fecha;

                            //resets
                            Template_hash_paises = new MyHashCerrado<>();
                            Pais_reg = pais;
                            toptemp = new Top50(null, null);

                            // Relleno el top50
                            MyHeap<Cancion, Integer> top = new MyHeapIMPL<>(); // Creo un heap para el top
                            toptemp.setPais(pais);
                            toptemp.setFecha(fecha);
                            toptemp.setTop(top);

                        }
//                    }else{
//
//                        if (!pais.equals(Pais_reg)) { // Si el pais es distinto al anterior reset al top50
//                            try {
//                                arbolFechas.find(fecha).put(Pais_reg,toptemp);
//                            }catch (Exception e){
//                                System.out.println("No se pudo agregar el pais");
//                            }
//                            Pais_reg = pais;
//                            toptemp = new Top50(null, null);
//
//                            // Inicializo el top50
//                            MyHeap<Cancion, Integer> top = new MyHeapIMPL<>(); // Creo un heap para el top
//                            toptemp.setPais(pais);
//                            toptemp.setFecha(fecha);
//                            toptemp.setTop(top);
//                        }
//                        toptemp.getTop().insert(c, dailyRank);// Agrego la cancion al top50
//
//                    }



//                    if (arbolFechas.contains(fecha)) {
//                        if (!arbolFechas.find(fecha).Keys().contains(pais)) { // Si el pais no esta en la fecha
//                            MyHeap<Cancion, Integer> top = new MyHeapIMPL<>(); // Creo un heap para el top
//                            toptemp.setPais(pais);
//                            toptemp.setFecha(fecha);
//                            toptemp.setTop(top);
//                            toptemp.getTop().insert(c, dailyRank);
//                            try {
//                                arbolFechas.find(fecha).put(pais, toptemp); // Agrego el pais a la fecha
//                            } catch (Exception e) {
//
//                            }
//                            try {
//                                arbolFechas.find(fecha).get(pais).setTop(toptemp.getTop()); // Agrego el top al pais
//                            } catch (Exception e) {
//                                System.out.println("no agrego el top");
//                            }
//                        }
//
//                        if (arbolFechas.find(fecha).Keys().contains(pais)) {
//                            toptemp.getTop().insert(c, dailyRank);
//                            if (toptemp.getTop().size() == 50) {
//                                try {
//                                    arbolFechas.find(fecha).get(pais).setTop(toptemp.getTop());
//                                } catch (Exception e) {
//                                    System.out.println("no agrego el top lleno");
//                                }
//                            }
//
//                        }
//                    }
                }
            }
        } catch (IOException e) {
            System.out.println("No entro");
        }


        //Pruebas
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse("13/05/2024", formatter);
        ChronoLocalDate fecha = localDate;
//        try {
//            if(arbolFechas.find(fecha).Keys().contains("ZA")){
//                System.out.println("ZA esta en esta fecha");
//            }
//            System.out.println("Los paises rgitrados en esta fecha son: ");
//            for(int p = 0; p<arbolFechas.find(fecha).Keys().size(); p++){
//                System.out.println(arbolFechas.find(fecha).Keys().get(p));
//            }
//            String pai = arbolFechas.find(fecha).Keys().get(1);
//            System.out.println(arbolFechas.find(fecha).get(pai).getTop().delete().getName() );
//            }catch (Exception e){System.out.println("no entra");}
//        try {
//            if (arbolFechas.contains(fecha)) {
//                MyHashCerrado<String,Top50> fechaData = arbolFechas.find(fecha);
//                if (fechaData != null && fechaData.contains("")) {
//                    Top50 zaData = fechaData.get("");
//                    if (zaData != null && zaData.getTop() != null) {
//                        int tamaño = zaData.getTop().size();
//                        System.out.println("tamaño = " + tamaño);
//                    } else {
//                        System.out.println("Top50 o su Top es null");
//                    }
//                } else {
//                    System.out.println("Fecha no contiene ZA");
//                }
//            } else {
//                System.out.println("ArbolFechas no contiene la fecha");
//            }
//            //System.out.println("el top 1 de ZA el dia de la fecha es  "+ arbolFechas.find(fecha).get("ZA").getTop().delete().getTempo());
//        } catch (Exception e) {
//            System.out.println("Ocurrió una excepción: " + e.getMessage());
//        }

        try {
            System.out.println("Paises registrados en la fecha: "+ arbolFechas.find(fecha).size());
            System.out.println("Fechas registradas: "+ arbolFechas.inOrder().size());
            System.out.println("Prueba "+ arbolFechas.find(fecha).get("ZA").getPais());
            System.out.println("el top 1 de inter el dia de la fecha es "+ arbolFechas.find(fecha).get("").getTop().delete().getName());
            System.out.println("el top 2 de inter el dia de la fecha es "+ arbolFechas.find(fecha).get("").getTop().delete().getName());
            System.out.println("el top 3 de inter el dia de la fecha es "+ arbolFechas.find(fecha).get("").getTop().delete().getName());
            System.out.println("el top 4 de inter el dia de la fecha es "+ arbolFechas.find(fecha).get("").getTop().delete().getName());
        } catch (Exception e) {
            System.out.println("Ocurrió una excepción: " + e.getMessage());
        }


    }
}
