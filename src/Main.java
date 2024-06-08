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
import adt.linkedlist.*;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;


public class Main {
    public static void main(String[] args) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate localDate = LocalDate.parse("13/05/2024", formatter);
        LocalDate localDate2 = LocalDate.parse("12/05/2024", formatter);
        ChronoLocalDate fecha = localDate;
        ChronoLocalDate fecha2 = localDate2;

        MyArbolbinario<ChronoLocalDate, MyHashCerradoI<String, Top50>> arbolFechas = new Arbolbinario<>();
        MyHashCerradoI<String,Top50> paises = new MyHashCerrado<>();
        MyHashCerradoI<String,Top50> paises2 = new MyHashCerrado<>();
        arbolFechas.add(fecha,paises);
        arbolFechas.add(fecha2,paises2);
        MyHeap<Cancion,Integer> top = new MyHeapIMPL<>();
        Top50 toptemp = new Top50(null,fecha);
        Top50 toptemp2 = new Top50(null,fecha2);
        Float a = 0.0F;
        Cancion c = new Cancion("aa","aa",a);
        top.insert(c,10);
        toptemp.setTop(top);
        try {
            arbolFechas.find(fecha).put("uru",toptemp);
            arbolFechas.find(fecha).put("arg",toptemp);
            arbolFechas.find(fecha).put("br",toptemp);
            arbolFechas.find(fecha2).put("uru", toptemp2);
        }catch (YaExiste e){}
        try {
            System.out.println(arbolFechas.find(fecha).get("uru").getFecha());
            System.out.println(arbolFechas.find(fecha2).get("uru").getFecha());
            for(int i = 0;i<arbolFechas.find(fecha).size();i++) {
                System.out.println(arbolFechas.find(fecha).Keys().get(i));
            }
        }catch (NoEsta e){}
        boolean esta = false;



    }
}