import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.ChronoUnit;
import java.util.LinkedList;
import java.util.Scanner;

import Entities.Artista;
import Entities.Cancion;
import Entities.Top50;
import adt.Exceptions.NoEsta;
import adt.Heap.MyHeap;
import adt.Heap.MyHeapIMPL;
import adt.arbolbinario.Arbolbinario;
import adt.arbolbinario.MyArbolbinario;
import adt.hashcerrado.MyHashCerrado;
import adt.hashcerrado.MyHashCerradoI;
import adt.linkedlist.MyLinkedListImpl;
import adt.linkedlist.MyList;

import java.time.format.DateTimeFormatter;


public class Sistema {

    Procesador procesador = new Procesador();
    Arbolbinario<ChronoLocalDate, MyHashCerrado<String, Top50>> arbolBusqueda = procesador.arbol();


    public void Top_10_canciones() {
        System.out.println("------------------------------------------------------");
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("diga el pais del que quiere sber el top");
        String pais = scanner1.nextLine();
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("diga la fecha de la que quiere sber el top");
        String fecha = scanner2.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(fecha, formatter);
        ChronoLocalDate fechaFormato = localDate;
        try {
            System.out.println("------------------------------------------------------");
            MyHeap<Cancion, Integer> heapABorrar = arbolBusqueda.find(fechaFormato).get(pais).getTop().clonar();
            for (int i = 0; i < 10; i++) {
                System.out.println("TOP " +(i+1)+" "+heapABorrar.delete().getName());
            }
        } catch (NoEsta e) {
            System.out.println("No entra");
        }
        System.out.println("------------------------------------------------------");
    }

    public void Top_7_artistas() {
        MyList<Artista> artistaFechas = new MyLinkedListImpl<>();
        MyHeap<Artista, Artista> heapArtistas = new MyHeapIMPL<>();
        int cantcan = 0;
        LocalDate localDate = null;
        LocalDate localDate2 = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (localDate == null) {
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Seleccione la fehca de inicio con el formato dd/mm/yyyy");
            String fecha1 = scanner1.nextLine();
            try {
                localDate = LocalDate.parse(fecha1, formatter);
            } catch (Exception e) {
                System.out.println("La fecha no es compatible con el formato");
            }

        }
        ChronoLocalDate fecha1Formato = localDate;
        while (localDate2 == null) {
            Scanner scanner2 = new Scanner(System.in);
            System.out.println("Seleccione la fehca de fin con el formato dd/mm/yyyy");
            String fecha2 = scanner2.nextLine();
            try {
                localDate2 = LocalDate.parse(fecha2, formatter);
            } catch (Exception e) {
                System.out.println("La fecha no es compatible con el formato");
            }
        }
        ChronoLocalDate fecha2Formato = localDate2;
        ChronoLocalDate tempfecha = fecha1Formato;
        LocalDate localdatepri = LocalDate.parse("18/10/2023", formatter);
        ChronoLocalDate primeraFecha = localdatepri;
        LocalDate localdateult = LocalDate.parse("14/05/2024", formatter);
        ChronoLocalDate ultimaFecha = localdateult;
        if (fecha1Formato.isAfter(fecha2Formato)) {
            System.out.println("No tiene sentido el orden");
        }
        if (fecha1Formato.isBefore(primeraFecha)) {
            System.out.println("No tenemos registro de una fecha tan lejana");
        }
        if (fecha2Formato.isAfter(ultimaFecha)) {
            System.out.println("No tenemos registro de una fecha tan cercana");
        } else {
            while (!tempfecha.equals(fecha2Formato)) {
                if (arbolBusqueda.find(tempfecha) != null) {
                    MyList<Top50> recorrer = arbolBusqueda.find(tempfecha).Values();
                    for (int i = 0; i < recorrer.size(); i++) {
                        Top50 tempTop = recorrer.get(i);
                        MyHeap<Cancion, Integer> clonTop = tempTop.getTop().clonar();
                        int tam = clonTop.size();
                        for (int j = 0; j < tam; j++) {
                            Cancion canciontemp = clonTop.delete();
                            for (int a = 0; a < canciontemp.getArtist().size(); a++) {
                                String nombreA = String.valueOf(canciontemp.getArtist().get(a));
                                try {
                                    Artista tempArtista = procesador.hash().get(nombreA);
                                    if (!artistaFechas.contains(tempArtista)) {
                                        artistaFechas.add(tempArtista);
                                    }
                                } catch (NoEsta e) {
                                }

                                try {
                                    procesador.hash().get(nombreA).setContdor(procesador.hash().get(nombreA).getContdor() + 1);
                                } catch (NoEsta e) {
                                }
                            }
                        }
                    }
                }
                tempfecha = tempfecha.plus(1, ChronoUnit.DAYS);
            }
            for (int i = 0; i < artistaFechas.size(); i++) {
                Artista ArtistaTemp = artistaFechas.get(i);
                heapArtistas.insert(ArtistaTemp, ArtistaTemp);
            }
            System.out.println("------------------------------------------------------");
            for (int j = 0; j < 7; j++) {
                Artista tempArtist = heapArtistas.delete();
                System.out.println("TOP " + (j + 1) + " " + tempArtist.getNombre());
            }
            for (int i = 0; i < artistaFechas.size(); i++) {
                Artista ArtistaTemp = artistaFechas.get(i);
                ArtistaTemp.setContdor(0);
            }
            System.out.println("------------------------------------------------------");
        }
    }

    public Object Top_5_canciones() {
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("diga la fecha de la que quiere sber el top con el formato dd/mm/yyyy");
        String fecha = scanner2.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(fecha, formatter);
        ChronoLocalDate fechaFormato = localDate;
        arbolBusqueda.find(fechaFormato).Keys();
        for (int i = 0; i < arbolBusqueda.find(fechaFormato).Keys().size(); i++) {
            String key = arbolBusqueda.find(fechaFormato).Keys().get(i);
            try {
                for (int j = 0; j < 50; j++) {
                    arbolBusqueda.find(fechaFormato).get(key).getTop().delete().getArtist();


                }
            } catch (NoEsta e) {
            }

        }

        return null;
    }

    public void cant_art() {
        LocalDate localDate = null;
        System.out.println("------------------------------------------------------");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione un artista");
        String nombreA = scanner.nextLine().replaceAll("[\"; ]", "").toLowerCase();
        if (procesador.hash().contains(nombreA.toLowerCase())) {
            try {
                Artista tempA = procesador.hash().get(nombreA.toLowerCase());
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                while (localDate == null) {
                    Scanner scanner1 = new Scanner(System.in);
                    System.out.println("Seleccione la fehca con el formato dd/mm/yyyy");
                    String fecha1 = scanner1.nextLine();
                    try {
                        localDate = LocalDate.parse(fecha1, formatter);
                    } catch (Exception e) {
                        System.out.println("La fecha no es compatible con el formato");
                    }
                }
                ChronoLocalDate fecha1Formato = localDate;
                LocalDate localdatepri = LocalDate.parse("18/10/2023", formatter);
                ChronoLocalDate primeraFecha = localdatepri;
                LocalDate localdateult = LocalDate.parse("14/05/2024", formatter);
                ChronoLocalDate ultimaFecha = localdateult;
                if (fecha1Formato.isBefore(primeraFecha)) {
                    System.out.println("No tenemos registro de una fecha tan lejana");
                }
                if (fecha1Formato.isAfter(ultimaFecha)) {
                    System.out.println("No tenemos registro de una fecha tan cercana");
                }
                if (arbolBusqueda.find(fecha1Formato) != null) {
                    MyList<Top50> recorrer = arbolBusqueda.find(fecha1Formato).Values();
                    for (int i = 0; i < recorrer.size(); i++) {
                        Top50 tempTop = recorrer.get(i);
                        MyHeap<Cancion, Integer> clonTop = tempTop.getTop().clonar();
                        int tam = clonTop.size();
                        for (int j = 0; j <tam; j++) {
                            Cancion canciontemp = clonTop.delete();
                            if (canciontemp.getArtist().contains(nombreA)) {
                                tempA.setContdor(tempA.getContdor() + 1);

                            }
                        }
                    }
                }
                System.out.println("El artista aparece " + tempA.getContdor() + " veces");
                tempA.setContdor(0);
            } catch (NoEsta e) {
            }
        } else {
            System.out.println("Ese artista no esta");
        }

    }


    public int cant_canc_tempo () {
        System.out.println("------------------------------------------------------");
        MyList<String> cancionesYaContadas = new MyLinkedListImpl<>();
        int cantcan = 0;
        LocalDate localDate = null;
        LocalDate localDate2 = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (localDate == null) {
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Seleccione la fehca de inicio con el formato dd/mm/yyyy");
            String fecha1 = scanner1.nextLine();
            try {
                localDate = LocalDate.parse(fecha1, formatter);
            } catch (Exception e) {
                System.out.println("La fecha no es compatible con el formato");
            }

        }
        ChronoLocalDate fecha1Formato = localDate;
        while (localDate2 == null) {
            Scanner scanner2 = new Scanner(System.in);
            System.out.println("Seleccione la fehca de fin con el formato dd/mm/yyyy");
            String fecha2 = scanner2.nextLine();
            try {
                localDate2 = LocalDate.parse(fecha2, formatter);
            } catch (Exception e) {
                System.out.println("La fecha no es compatible con el formato");
            }
        }
        ChronoLocalDate fecha2Formato = localDate2;
        ChronoLocalDate tempfecha = fecha1Formato;
        Scanner scanner3 = new Scanner(System.in);
        System.out.println("Seleccione el menor del rengo del tempo");
        String tempS1 = scanner3.nextLine();
        Float temp1 = Float.parseFloat(tempS1);
        Scanner scanner4 = new Scanner(System.in);
        System.out.println("Seleccione el mayor del rengo del tempo");
        String tempS2 = scanner4.nextLine();
        Float temp2 = Float.parseFloat(tempS2);
        LocalDate localdatepri = LocalDate.parse("18/10/2023", formatter);
        ChronoLocalDate primeraFecha = localdatepri;
        LocalDate localdateult = LocalDate.parse("14/05/2024", formatter);
        ChronoLocalDate ultimaFecha = localdateult;
        if (fecha1Formato.isAfter(fecha2Formato)) {
            System.out.println("No tiene sentido el orden");
        }
        if (fecha1Formato.isBefore(primeraFecha)) {
            System.out.println("No tenemos registro de una fecha tan lejana");
        }
        if (fecha2Formato.isAfter(ultimaFecha)) {
            System.out.println("No tenemos registro de una fecha tan cercana");
        } else {
            while (!tempfecha.equals(fecha2Formato)) {
                if (arbolBusqueda.find(tempfecha) != null) {
                    MyList<Top50> recorrer = arbolBusqueda.find(tempfecha).Values();
                    for (int i = 0; i < recorrer.size(); i++) {
                        Top50 tempTop = recorrer.get(i);
                        MyHeap<Cancion, Integer> clonTop = tempTop.getTop().clonar();
                        int tam = clonTop.size();
                        for (int j = 0; j < tam; j++) {
                            Cancion canciontemp = clonTop.delete();
                            Float tempo = canciontemp.getTempo();
                            if (tempo > temp1 && tempo < temp2) {
                                if (!cancionesYaContadas.contains(canciontemp.getName())) {
                                    cantcan++;
                                    cancionesYaContadas.add(canciontemp.getName());
                                }

                            }
                        }
                    }
                }
                tempfecha = tempfecha.plus(1, ChronoUnit.DAYS);
            }
            System.out.println("------------------------------------------------------");
            System.out.println("Hay " + cantcan + " En ese rango de fechas con ese rango de tempo");
            System.out.println("------------------------------------------------------");
            return cantcan;
        }
        return 0;
    }
}
