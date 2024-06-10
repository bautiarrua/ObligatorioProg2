import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.Scanner;

import Entities.Top50;
import adt.Exceptions.NoEsta;
import adt.arbolbinario.Arbolbinario;
import adt.arbolbinario.MyArbolbinario;
import adt.hashcerrado.MyHashCerrado;
import adt.hashcerrado.MyHashCerradoI;
import java.time.format.DateTimeFormatter;


public class Sistema {

    Procesador procesador = new Procesador();
    Arbolbinario<ChronoLocalDate,MyHashCerrado<String, Top50>> arbolBusqueda = procesador.arbol();


    public Object Top_10_canciones (){
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("diga el pais del que quiere sber el top");
        String pais = scanner1.nextLine();
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("diga la fecha de la que quiere sber el top");
        String fecha = scanner2.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse("13/05/2024", formatter);
        ChronoLocalDate fechaFormato = localDate;
        try {
            arbolBusqueda.find(fechaFormato).get(pais).getTop().delete().getName();
        }catch (NoEsta e){}
        return null;

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
