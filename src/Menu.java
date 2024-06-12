import java.util.Scanner;

public class Menu {

    public void eleccion(){
        boolean devuelta = true;
        Sistema sis = new Sistema();
        while (devuelta) {
            System.out.println("Haga su eleccion");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Elija 1 para obtener un top 10 de un pais en una fecha \n" +
                    "Elija el 2 para obtener un top 5 canciones que mas aparecen en un top 50 en una fecha\n" +
                    "El 3 para obtener los 7 artistas que aparecen en mas top 50 en un rango de fechas\n" +
                    "El 4 para saber la cantidad de veces que aparece un artista elegido en los top 50 en una fecha \n" +
                    "El 5 para obtener las canciones con un rango en especifico en un rango de fecha \n" +
                    "El 0 para salir del bucle \n" +
                    "Cualquier si la opcion es otra se volvera a preguntar ");
            int eleccion = scanner.nextInt();
            if (eleccion == 1) {
                sis.Top_10_canciones();
            }
            if (eleccion == 2) {
                sis.Top_5_canciones();
            }
            if (eleccion == 3) {
                sis.Top_7_artistas();
            }
            if (eleccion == 4) {
                sis.cant_art();
            }
            if (eleccion == 5) {
                sis.cant_canc_tempo();
            }
            if (eleccion == 0) {
                devuelta = false;
            }
        }
    }



}
