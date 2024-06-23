import java.util.Scanner;

public class Menu {

    public void eleccion(){
        boolean devuelta = true;
        System.out.println("A continuacion se le mostrara cuanto demora en ejecutarse el procesador");
        Sistema sis = new Sistema();
        System.out.println("------------------------------------------------------");
        while (devuelta) {
            System.out.println("Haga su eleccion");
            Scanner scanner = new Scanner(System.in);
            System.out.println("1) top 10 de un pais en una fecha \n" +
                    "2) top 5 canciones que mas aparecen en un top 50 en una fecha\n"+
                    "3) 7 artistas que aparecen en mas top 50 en un rango de fechas\n" +
                    "4) cantidad de veces que aparece un artista elegido en los top 50 en una fecha \n" +
                    "5) canciones con un rango en especifico en un rango de fecha \n" +
                    "0) salir");
            String eleccion = scanner.nextLine();
            if (eleccion.equals("1")) {
                sis.Top_10_canciones();
            }
            if (eleccion.equals("2")) {
                sis.Top_5_canciones();
            }
            if (eleccion.equals("3")) {
                sis.Top_7_artistas();
            }
            if (eleccion.equals("4")) {
                sis.cant_art();
            }
            if (eleccion.equals("5")) {
                sis.cant_canc_tempo();
            }
            if (eleccion.equals("0")) {
                System.out.println("------------------------------------------------------");
                System.out.println("Se terminaron las consultas");
                devuelta = false;
            }
        }
    }



}
