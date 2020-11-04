package BasedeDatos;

import Tablas.Artista;
import Tablas.Tour;

import java.sql.*;
import java.util.ArrayList;

public class ConnectDB {
    /**
     * Completar atributos (se usaran en las conexiones en los metodos)
     */
    private static String user = "root";
    private static String pass = "root";
    private static String url = "jdbc:mysql://localhost:3306/lab6sw1?serverTimezone=America/Lima";

    public static ArrayList<String> listarBandas() {
        ArrayList<String> listaBandas = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "SELECT idbanda, nombre_banda, nombre_artista FROM banda b\n" +
                "INNER JOIN artista a ON b.artista_lider = a.idartista;  ";
        try (
                Connection conn = DriverManager.getConnection(url, user, pass);
                Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql);) {

                while (rs.next()) {
                    String id = rs.getString(1);
                    String nameBand = rs.getString(2);
                    String nameArtist = rs.getString(3);
                    listaBandas.add("ID: "+id+" | Nombre: "+nameBand+" | Lider "+nameArtist);
                }
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }

        return listaBandas;
    }

    public static ArrayList<String> listarCiudades() {
        ArrayList<String> listaCiudades = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "SELECT idciudad, nombre_ciudad, nombre_pais FROM ciudad c\n" +
                "INNER JOIN pais p ON c.pais = p.idpais;";
        try (
                Connection conn = DriverManager.getConnection(url, user, pass);
                Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql);) {

            while (rs.next()) {
                String id = rs.getString(1);
                String nameCity = rs.getString(2);
                String nameCountry = rs.getString(3);
                listaCiudades.add("ID: "+id+" | Nombre: "+nameCity+" | Pais "+nameCountry);
            }
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }



        return listaCiudades;
    }

    public static ArrayList<String> listarInstrumentos() {
        ArrayList<String> listaInstrumentos = new ArrayList<>();


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "SELECT * FROM instrumento;";
        try (
                Connection conn = DriverManager.getConnection(url, user, pass);
                Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql);) {

            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                listaInstrumentos.add("ID: "+id+" | Nombre: "+name);
            }
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }

        return listaInstrumentos;
    }

    public static ArrayList<String> listarTours() {
        ArrayList<String> listaTours = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "SELECT idtour, nombre_tour, nombre_banda FROM tour t INNER JOIN banda b ON t.banda = b.idbanda;";
        try (
                Connection conn = DriverManager.getConnection(url, user, pass);
                Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql);) {

            while (rs.next()) {
                String id = rs.getString(1);
                String nameTour = rs.getString(2);
                String nameBand = rs.getString(3);
                listaTours.add("ID: "+id+" | Nombre: "+nameTour+" | Banda "+nameBand);
            }
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }

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