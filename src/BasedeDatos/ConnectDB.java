package BasedeDatos;

import Tablas.Artista;
import Tablas.Tour;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

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

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "INSERT INTO tour(nombre_tour, banda) "+
                "VALUES ('"+tour.getNombre()+"','"+tour.getIdBanda()+"');";

        int key = -1;
        try (
                Connection conn = DriverManager.getConnection(url, user, pass);
                Statement stmt = conn.createStatement();) {

            stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rsKey = stmt.getGeneratedKeys();
            key = rsKey.getInt(1);
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }

        String sql2 = "SELECT nombre_banda FROM banda WHERE idbanda = '"+tour.getIdBanda()+"';";
        String nameBand = "";
        try (
                Connection conn2 = DriverManager.getConnection(url, user, pass);
                Statement stmt2 = conn2.createStatement(); ResultSet rs2 = stmt2.executeQuery(sql2);) {

            rs2.next();
            nameBand = rs2.getString(1);
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }

        System.out.println("TOUR CREADO:");
        System.out.println("ID: "+key+" | Nombre: "+tour.getNombre()+" | Banda: "+nameBand);

    }

    public static void agregaArtista(Artista artista) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "INSERT INTO artista(nombre_artista, instrumento, banda)\n" +
                "VALUES ('"+artista.getNombre()+"','"+artista.getIdInstrumento()+
                "','"+artista.getIdBanda()+"');";

        int key = -1;
        try (
                Connection conn = DriverManager.getConnection(url, user, pass);
                Statement stmt = conn.createStatement();) {

            stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rsKey = stmt.getGeneratedKeys();
            key = rsKey.getInt(1);
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }

        String sql2 = "SELECT nombre_inst FROM instrumento WHERE idinstrumento = '"+
                artista.getIdInstrumento()+"'; ";
        String nameInstrument= "";
        try (
                Connection conn2 = DriverManager.getConnection(url, user, pass);
                Statement stmt2 = conn2.createStatement(); ResultSet rs2 = stmt2.executeQuery(sql2);) {

            rs2.next();
            nameInstrument = rs2.getString(1);
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }

        String sql3 = "SELECT nombre_banda FROM banda WHERE idbanda = '"+
                artista.getIdBanda()+"';";
        String nameBand = "";
        try (
                Connection conn3 = DriverManager.getConnection(url, user, pass);
                Statement stmt3 = conn3.createStatement(); ResultSet rs3 = stmt3.executeQuery(sql2);) {

            rs3.next();
            nameBand = rs3.getString(1);
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }

        System.out.println("ARTISTA CREADO:");
        System.out.println("ID: "+key+" | Nombre: "+artista.getNombre()
                +" | Instrumento: "+nameInstrument+" | Banda: "+nameBand);
    }


    public static ArrayList<String> buscarCancionesporBanda(String idbanda) {
        ArrayList<String> listaCanciones = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "SELECT idcancion, nombre_cancion FROM cancion WHERE banda = '"+
                idbanda+"';";
        try (
                Connection conn = DriverManager.getConnection(url, user, pass);
                Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql);) {

            while (rs.next()) {
                String id = rs.getString(1);
                String nameSong = rs.getString(2);
                listaCanciones.add("ID: "+id+" | Nombre: "+nameSong);
            }
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }

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