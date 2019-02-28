/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videobox.Sql;

import java.util.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import javax.swing.JOptionPane;



/**
 *
 * @author VALERE
 */
public class SqlDriver {
    
    //==========================================================================
    //                        REQUETES EMISSIONS
    //==========================================================================
    
    public void loadEmissionQuery(String params[], String types[]){
        String sql = "INSERT INTO emissions VALUES (?,?,?,?,?,?,?) ;";
        this.executeUpdateQuery(sql, params, types);
    }
    
    public List<ArrayList<String>> extractEmissionNamesQuery(String params[], String types[]){
        String sql = "SELECT emTitle, emThematic FROM emissions WHERE emDescription LIKE ? ORDER BY emTitle, emThematic ASC ;";
        //System.out.println(sql);
        String [] columns = {"emTitle","emThematic"};
        List<ArrayList<String>> ressearch = this.executeSelectQuery(sql, columns, params, types);
        return ressearch;
    }
    
    public List<ArrayList<String>> extractEmissionNames2Query(String params[], String types[]){
        String sql = "SELECT emTitle, emThematic FROM emissions WHERE emTitle LIKE ? OR emThematic LIKE ? ORDER BY emTitle, emThematic ASC ;";
        //System.out.println(sql);
        String [] columns = {"emTitle","emThematic"};
        List<ArrayList<String>> ressearch = this.executeSelectQuery(sql, columns, params, types);
        return ressearch;
    }
    
    public List<ArrayList<String>> extractEmissionFileNamesQuery(String params[], String types[]){
        String sql = "SELECT emFileName FROM emissions WHERE emTitle LIKE ? OR emThematic LIKE ? ORDER BY emFileName ASC ;";
        System.out.println(sql);
        String [] columns = {"emFileName"};
        List<ArrayList<String>> ressearch = this.executeSelectQuery(sql, columns, params, types);
        return ressearch;
    }
    
    public List<ArrayList<String>> extractOneEmissionInfosQuery(String[] params, String[] types,String[] columns){
        String sql = "SELECT * FROM emissions WHERE emTitle = ? AND emThematic = ? ;";
        List<ArrayList<String>> infos = this.executeSelectQuery(sql, columns, params, types);
        return infos;
    }
    
    public void updateEmissionElementQuery(String[] params, String[] types, String column, String refValue){
        String sql = "UPDATE emissions SET "+ column +" = ? where emFileName = '"+ refValue +"' ;";
        //System.out.println(sql);
        this.executeUpdateQuery(sql, params, types);
    }
    
    public void suppressAllEmissionElementsQuery(String[] params, String[] types){
        String sql = "DELETE FROM emissions WHERE emFileName = ? ;";
        this.executeUpdateQuery(sql, params, types);
    }
        
    //==========================================================================
    //                        REQUETES MOVIES
    //==========================================================================
    
    public void loadMovieQuery(String params[], String types[]){
        String sql = "INSERT INTO movies VALUES (?,?,?,?,?,?) ;";
        this.executeUpdateQuery(sql, params, types);
    }
    
    public List<ArrayList<String>> extractAllMoviesQuery(){
        String sql = "SELECT movieName FROM movies ORDER BY movieName ASC ;";
        String[] params = {};
        String[] types = {};
        String [] columns = {"movieName"};
        List<ArrayList<String>> output = this.executeSelectQuery(sql, columns, params, types);
        return output;
    }
    
    public List<ArrayList<String>> extractOneMovieInfosQuery(String[] params, String[] types,String[] columns){
        String sql = "SELECT * FROM movies WHERE movieName = ? ;";
        List<ArrayList<String>> infos = this.executeSelectQuery(sql, columns, params, types);
        return infos;
    }
    
    public void updateMovieElementQuery(String[] params, String[] types, String column, String refValue){
        String sql = "UPDATE movies SET "+ column +" = ? where fileName = '"+ refValue +"' ;";
        //System.out.println(sql);
        this.executeUpdateQuery(sql, params, types);
    }
    
    public List<ArrayList<String>> extractMovieNamesQuery(String[] params, String[] types){
        String sql = "SELECT movieName FROM movies WHERE movieName LIKE ? ORDER BY movieName ASC ;";
        System.out.println(sql);
        String [] columns = {"movieName"};
        List<ArrayList<String>> ressearch = this.executeSelectQuery(sql, columns, params, types);
        return ressearch;
    }
    
    //==========================================================================
    //                        EXECUTION DES REQUETES
    //==========================================================================
    
    /**
     * cette fonction permet d'insérer en base des données.
     * 
     * @return String st
     */
    public void executeUpdateQuery(String sql, String tab[], String types[]){
        
        Connection cn = null;
        java.sql.PreparedStatement st = null;
        
        try{
            //etape 1 : chargement du driver
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost/videoboxdb";
                String login = "root";
                String passwd = "";                
                
            //Etape 2 : ouverture de la connexion
		cn = (Connection) DriverManager.getConnection(url,login,passwd);
			
            //Etape 3 : création d'un statement
		//st = cn.createStatement();
                st = cn.prepareStatement(sql);
                
                int l = types.length;
                
                for(int i=0;i<l;i++){
                    switch(types[i]){
                        case "String":
                            st.setString(i+1,tab[i]);
                            break;
                        case "int":
                            st.setInt(i+1, Integer.parseInt(tab[i]));
                            break;
                    }
                }
                
                st.executeUpdate();
                cn.close();
		st.close();
                
                //JOptionPane.showMessageDialog(null, "L'enregistrement en base est réussi.");
        }
        catch(SQLException e){
            System.out.println("******************************************************");
            System.out.println("executeUpdateQuery - SQLException : ");
            e.printStackTrace();//erreur sql
            JOptionPane.showMessageDialog(null, e, "Message d'avertissement", JOptionPane.ERROR_MESSAGE);
        }
        catch(ClassNotFoundException E){
            System.out.println("******************************************************");
            System.out.println("executeUpdateQuery - ClassNotFoundException : ");
            E.printStackTrace();//pb avec la class
            JOptionPane.showMessageDialog(null, E, "Message d'avertissement", JOptionPane.ERROR_MESSAGE);
	}
    
    }
    
    public List<ArrayList<String>> executeSelectQuery(String sql, String columns[], String tab[], String types[]){
        
        Connection cn = null;
        java.sql.PreparedStatement st = null;
        ResultSet res = null;
        List<ArrayList<String>> finalres = null;
        
        try{
            //etape 1 : chargement du driver
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost/videoboxdb";
                String login = "root";
                String passwd = "";                
                
            //Etape 2 : ouverture de la connexion
		cn = (Connection) DriverManager.getConnection(url,login,passwd);
			
            //Etape 3 : création d'un statement
		//st = cn.createStatement();
                st = cn.prepareStatement(sql);
                
                int l = types.length;
                
                for(int i=0;i<l;i++){
                    switch(types[i]){
                        case "String":
                            st.setString(i+1,tab[i]);
                            break;
                        case "int":
                            st.setInt(i+1, Integer.parseInt(tab[i]));
                            break;
                    }
                }
                
                res = st.executeQuery();
                finalres = this.getExecutionResults(res, columns);
                
                cn.close();
		st.close();
                
                //JOptionPane.showMessageDialog(null, "L'exécution est réussie.");
        }
        catch(SQLException e){
            System.out.println("******************************************************");
            System.out.println("executeSelectQuery - SQLException : ");
            e.printStackTrace();//erreur sql
            JOptionPane.showMessageDialog(null, e, "Message d'avertissement", JOptionPane.ERROR_MESSAGE);
        }
        catch(ClassNotFoundException E){
            System.out.println("******************************************************");
            System.out.println("executeSelectQuery - ClassNotFoundException : ");
            E.printStackTrace();//pb avec la class
            JOptionPane.showMessageDialog(null, E, "Message d'avertissement", JOptionPane.ERROR_MESSAGE);
	}
        
        return finalres;
    }
    
    private List<ArrayList<String>> getExecutionResults(ResultSet res, String[] columns){
        
        List<ArrayList<String>> multi = new ArrayList<ArrayList<String>>();
        ArrayList<String> list = new ArrayList<String>();
        try{
            while(res.next()){
                for(int i=0; i<columns.length; i++){
                    //System.out.println("i : " + i);
                    //System.out.println("valeur à insérer : " + res.getString(columns[i]));
                    list.add(res.getString(columns[i]));
                    //System.out.println("list : " + list);
                }
                multi.add(list);
            }
            //System.out.println("multi : " + multi);         
        }
        catch(Exception e){
            System.out.println("******************************************************");
            System.out.println("getExecutionResults - Exception : ");
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e, "Message d'avertissement", JOptionPane.ERROR_MESSAGE);
        }
        
        return multi;
    }
    
}
