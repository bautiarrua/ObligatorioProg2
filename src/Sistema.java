import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.Scanner;

import Entities.Top50;
import adt.Exceptions.NoEsta;
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
            for(int i = 0; i<10;i++) {
                System.out.println( arbolBusqueda.find(fechaFormato).get(pais).getTop().delete().getName());
            }
        }catch (NoEsta e){System.out.println("No entra");}

    }

    public Object Top_7_artistas (){
        return null;
    }

    public Object Top_5_canciones (){
        return null;
    }

    public Object cant_art (){
        return null;
    }

    public Object cant_canc_tempo (){
        return null;
    }
}
