import BasedeDatos.ConnectDB;
import Tablas.Artista;
import Tablas.Tour;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String menu = "\n****** Gestión de Bandas y Tours en Latinoamerica *******\n" +
                "\n" +
                "1. Añadir tours.\n" +
                "2. Añadir artistas.\n" +
                "3. Añadir fechas a tours.\n" +
                "4. Buscar canciones por banda.\n" +
                "5. Buscar tours por pais.\n" +
                "6. Buscar paises por número de canciones.\n" +
                "7. Salir\n" +
                "*********************************************************\n" +
                "Opción: ";

        /**
         * Comprobar el driver sql y completar lo demas
         */
        while(true){
            System.out.println(menu);
            String opcion = sc.nextLine();
            switch (opcion){
                case "1":
                    Tour tour = new Tour();
                    Boolean respuesta = tour.escribirTour();
                    if(respuesta){
                        ConnectDB.agregaTour(tour);
                    }
                    break;
                case "2":
                    Artista artista = new Artista();
                    Boolean respuesta2 =  artista.escribirArtista();
                    if(respuesta2){
                        ConnectDB.agregaArtista(artista);
                    }
                    break;
                case "3":
                    break;
                case "4":
                    System.out.println("***BUSCAR CANCIONES POR BANDA***");
                    ArrayList<String> listaBandas =  ConnectDB.listarBandas();
                    for(String infoBanda : listaBandas){
                        System.out.println(infoBanda);
                    }
                    System.out.print("Ingrese id de banda: ");
                    String idBand = sc.nextLine();
                    ConnectDB.buscarCancionesporBanda();
                    break;
                case "5":
                    break;
                case "6":
                    break;
            }
        }
    }
}
