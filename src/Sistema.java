import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;

import Entities.Top50;
import adt.arbolbinario.Arbolbinario;
import adt.arbolbinario.MyArbolbinario;
import adt.hashcerrado.MyHashCerrado;
import adt.hashcerrado.MyHashCerradoI;



public class Sistema {

    private MyArbolbinario<ChronoLocalDate,String> arbolfechas = new Arbolbinario<>();
    private MyHashCerradoI<String, Top50> hashPais = new MyHashCerrado<>();

    public Object Top_10_canciones (String Pais, LocalDate fecha){
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
