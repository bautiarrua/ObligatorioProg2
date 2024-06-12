import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.Scanner;

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
    Arbolbinario<ChronoLocalDate,MyHashCerrado<String, Top50>> arbolBusqueda = procesador.arbol();


    public void Top_10_canciones (){
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
            for(int i = 0; i<10;i++) {
                System.out.println( heapABorrar.delete().getName());
            }
        }catch (NoEsta e){System.out.println("No entra");}
        System.out.println("------------------------------------------------------");
    }

    public Object Top_7_artistas (){
        return null;
    }

    public Object Top_5_canciones (){
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("diga la fecha de la que quiere sber el top");
        String fecha = scanner2.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(fecha, formatter);
        ChronoLocalDate fechaFormato = localDate;
        arbolBusqueda.find(fechaFormato).Keys();
        for(int i = 0; i<arbolBusqueda.find(fechaFormato).Keys().size();i++) {
            String key = arbolBusqueda.find(fechaFormato).Keys().get(i);
            try {
                for(int j = 0; j<50;j++) {
                    arbolBusqueda.find(fechaFormato).get(key).getTop().delete().getArtist();


                }
            }catch (NoEsta e){}

        }

        return null;
    }

    public Object cant_art (){
        return null;
    }

    public int cant_canc_tempo (){
//        Scanner scanner1 = Scanner(System.in);
//        String fecha1 = scanner1.nextLine();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        LocalDate localDate = LocalDate.parse(fecha1, formatter);
//        ChronoLocalDate fecha1Formato = localDate;
//
//
//        Scanner scanner2 = new Scanner(System.in);
//        String fecha2 = scanner2.nextLine();
//        LocalDate localDate2 = LocalDate.parse(fecha2, formatter);
//        ChronoLocalDate fecha2Formato = localDate;
//
//
        return 0;
    }
}
