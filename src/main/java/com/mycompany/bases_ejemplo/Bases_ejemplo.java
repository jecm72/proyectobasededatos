
package com.mycompany.bases_ejemplo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Bases_ejemplo {

    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion conectar = new Conexion();
    
    public void listar(){
    
        String instruccion = "select * from alumnos";
        
        try {
            con = conectar.Conectar();
            ps = con.prepareStatement(instruccion);
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                System.out.println(rs.getInt(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getString(3));
                System.out.println(rs.getInt(4));
                System.out.println("---------------");
            }
            
        } catch (Exception e) {
        }
    
    }
    
    public void crear(int Codigo, String Nombre, String Direccion, int Telefono){
    String sql = "insert into alumnos(Codigo,Nombre,Direccion,Telefono) values (?,?,?,?)";
    
        try {
            con = conectar.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, Codigo);
            ps.setString(2, Nombre);
            ps.setString(3, Direccion);
            ps.setInt(4, Telefono);
            ps.executeUpdate();
            
            
        } catch (Exception e) {
        }
    
    
    }
    
    public void modificar(int Codigo, String Nombre,  String direccion, int numero){
    
    String sql = "update alumnos set Nombre='" + Nombre + "', Telefono='" + numero + "', Direccion='" + direccion + "' where Codigo ='" + Codigo  + "'";
        try {
            con = conectar.Conectar();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    
    
    }
    
    public void eliminar(int id){
        String sql = "delete from alumnos where Codigo = ?";
        try {
            
            con = conectar.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    
    
    }
    
    
    
    
    public static void main(String[] args) {
        Bases_ejemplo bj = new Bases_ejemplo();
        Scanner sc = new Scanner(System.in);
        int op = 0;
        while (op<=4) {
            System.out.println("Opciones");
            System.out.println("1. Ingreso de datos de los Alumnos");
            System.out.println("2. Modificar datos de los alumnos ");
            System.out.println("3. Mostrar Todos los Datos de los alumnos");
            System.out.println("4. Eliminar Alumnos");
            System.out.println("5. Salir");
            System.out.println("Ingrese su opción");
            op = sc.nextInt();
            switch (op) {
                case 1: {
                System.out.println("Ingresa tu codigo del Alumno");
                int Codigo = sc.nextInt();
                System.out.println("******");
                System.out.println("Ingresa tu nombre del Alumno");
                String Nombre = sc.nextLine();
                System.out.println("******");
                System.out.println("ingresa Direccion del Alumno ");
                System.out.println("******");
                String Direccion = sc.nextLine();
                System.out.println("Ingresa tu telefono del Alumno");
                int Telefono = sc.nextInt();
                
                bj.crear(Codigo, Nombre, Direccion, Telefono);
                 break;
                }
                 case 2: {
                 System.out.println("Ingresa tu codigo del Alumno");
                int Codigo = sc.nextInt();
                System.out.println("******");
                System.out.println("Ingresa tu nombre del Alumno");
                String Nombre = sc.nextLine();
                System.out.println("******");
                System.out.println("ingresa Direccion del Alumno ");
                System.out.println("******");
                String Direccion = sc.nextLine();
                System.out.println("Ingresa tu telefono del Alumno");
                int Telefono = sc.nextInt();
                
                bj.modificar(Codigo, Nombre, Direccion, Telefono);
                 break;
                }
                 case 3: {
                   bj.listar();
                   break;
                }
                 
                  case 4: {
                  System.out.println("Ingresa tu codigo del Alumno");
                  int Codigo = sc.nextInt();
                   bj.eliminar(Codigo);
                  break;
                }
                   case 5: {
                  
                  break;
                }
       
    }
    }
    }
}
