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

        ChronoLocalDate fecha = localDate;
        MyArbolbinario<ChronoLocalDate, MyHashCerradoI<String, Top50>> arbolFechas = new Arbolbinario<>();
        MyHashCerradoI<String,Top50> paises = new MyHashCerrado<>();
        arbolFechas.add(fecha,paises);
        MyHeap<Cancion,Integer> top = new MyHeapIMPL<>();
        Top50 toptemp = new Top50(null,null);
        Float a = 0.0F;
        Cancion c = new Cancion("aa","aa",a);
        top.insert(c,10);
        toptemp.setTop(top);
        try {
            arbolFechas.find(fecha).put("uru",toptemp);
            arbolFechas.find(fecha).put("arg",toptemp);
            arbolFechas.find(fecha).put("br",toptemp);
        }catch (YaExiste e){}
        try {
            System.out.println(arbolFechas.find(fecha).get("uru").getTop().delete().getTempo());
            System.out.println(arbolFechas.find(fecha).contains("uru"));
            for(int i = 0;i<arbolFechas.find(fecha).size();i++) {
                System.out.println(arbolFechas.find(fecha).Keys().get(i));
            }
        }catch (NoEsta e){}
        boolean esta = false;



    }
}