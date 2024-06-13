import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
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
        System.out.println("------------------------------------------------------");
        MyList<String> cancionesYaContadas = new MyLinkedListImpl<>();
        int cantcan = 0;
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Seleccione la fehca de inicio");
        String fecha1 = scanner1.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(fecha1, formatter);
        ChronoLocalDate fecha1Formato = localDate;
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Seleccione la fehca de fin");
        String fecha2 = scanner2.nextLine();
        LocalDate localDate2 = LocalDate.parse(fecha2, formatter);
        ChronoLocalDate fecha2Formato = localDate2;
        Scanner scanner3 = new Scanner(System.in);
        System.out.println("Seleccione el menor del rengo del tempo");
        String tempS1 = scanner3.nextLine();
        Float temp1 = Float.parseFloat(tempS1);
        Scanner scanner4 = new Scanner(System.in);
        System.out.println("Seleccione el mayor del rengo del tempo");
        String tempS2 = scanner4.nextLine();
        Float temp2 = Float.parseFloat(tempS2);
        ChronoLocalDate tempfecha = fecha1Formato;
        while (!tempfecha.equals(fecha2Formato)){
            MyList<Top50> recorrer = arbolBusqueda.find(tempfecha).Values();
            for(int i = 0; i<recorrer.size(); i++){
                Top50 tempTop = recorrer.get(i);
                MyHeap<Cancion, Integer> clonTop = tempTop.getTop().clonar();
                for(int j = 0; j<50; j++){
                    Cancion canciontemp = clonTop.delete();
                    Float tempo = canciontemp.getTempo();
                    if(tempo>temp1 && tempo<temp2){
                        if(!cancionesYaContadas.contains(canciontemp.getName())){
                            cantcan++;
                            cancionesYaContadas.add(canciontemp.getName());
                        }

                    }
                }
            }
            tempfecha = tempfecha.plus(1, java.time.temporal.ChronoUnit.DAYS);
        }
        System.out.println("------------------------------------------------------");
        System.out.println("Hay "+ cantcan+" En ese rango de fechas con ese rango de tempo");
        System.out.println("------------------------------------------------------");
        return cantcan;
    }
}
