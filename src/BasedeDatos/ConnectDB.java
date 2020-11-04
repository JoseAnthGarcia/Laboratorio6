package BasedeDatos;

import Tablas.Artista;
import Tablas.Tour;
import java.util.ArrayList;

public class ConnectDB {
    /**
     * Completar atributos (se usaran en las conexiones en los metodos)
     */
    private static String user = "";
    private static String pass = "";
    private static String url = "";

    public static ArrayList<String> listarBandas() {
        ArrayList<String> listaBandas = new ArrayList<>();
        /**
         * COMPLETAR
         */
        return listaBandas;
    }

    public static ArrayList<String> listarCiudades() {
        ArrayList<String> listaCiudades = new ArrayList<>();
        /**
         * COMPLETAR
         */
        return listaCiudades;
    }

    public static ArrayList<String> listarInstrumentos() {
        ArrayList<String> listaInstrumentos = new ArrayList<>();
        /**
         * COMPLETAR
         */
        return listaInstrumentos;
    }

    public static ArrayList<String> listarTours() {
        ArrayList<String> listaTours = new ArrayList<>();
        /**
         * COMPLETAR
         */
        return listaTours;
    }

    public static void agregaTour(Tour tour) {
        /**
         * COMPLETAR
         */
    }

    public static void agregaArtista(Artista artista) {
        /**
         * COMPLETAR
         */
    }


    public static ArrayList<String> buscarCancionesporBanda(String idbanda) {
        ArrayList<String> listaCanciones = new ArrayList<>();
        /**
         * COMPLETAR
         */
        return listaCanciones;
    }

    public static ArrayList<String> buscarToursporPais(String letra) {
        ArrayList<String> listaTours = new ArrayList<>();
        /**
         * COMPLETAR
         */
        return listaTours;
    }

    public static ArrayList<String> buscarPaisesporCancion(int min) {
        ArrayList<String> listaPaises = new ArrayList<>();
        /**
         * COMPLETAR
         */
        return listaPaises;
    }

}