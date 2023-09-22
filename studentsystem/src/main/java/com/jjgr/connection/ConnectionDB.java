package com.jjgr.connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static java.lang.Class.forName;

public class ConnectionDB {
    public static Connection getConnectionDB(){
        //objeto para guardar la conexion
        Connection connection = null;

        //variables de conexion
        String db ="sena_db";
        String url ="jdbc:mysql://localhost:3307/" + db;
        String name= "root";
        String pass = "root";

        try {
            //Driver para comprobar el driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //intento conectarme a la base de datos
            connection = DriverManager.getConnection(url, name,pass);

        }catch (ClassNotFoundException | SQLException ex){
            System.out.println("ocurrio un error en la conexion: "+ ex.getMessage());
        }

        return  connection;
    }

    public static void main(String[] args) {
        Connection connection2 = ConnectionDB.getConnectionDB();

        if(connection2 != null){
            System.out.println("conexion exitosa: " + connection2);
        }else {
            System.out.println("conexion no exitosa: " + connection2);
        }
    }
}
