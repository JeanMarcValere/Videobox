/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videobox.Manager;

import java.util.ArrayList;
import java.util.List;
import videobox.Entities.Movie;
import videobox.Sql.SqlDriver;

/**
 *
 * @author VALERE
 */
public class MovieManager {
    
    private Movie movieObj;
    private SqlDriver sqldriver;
    
    /**
     * Constructeur de la classe MovieManager.
     * @param oneMovieObj 
     */
    public MovieManager(Movie oneMovieObj){
        this.movieObj = oneMovieObj;
        this.sqldriver = new SqlDriver();
    }
    
    public void loadMovie(){
        String filename = this.movieObj.getFtitle();
        String title = this.movieObj.getTitle();
        String genre = this.movieObj.getGenre();
        String description = this.movieObj.getDescription();
        int duration = this.movieObj.getDuration();
        String url = this.movieObj.getUrl();
        
        String strduration = String.valueOf(duration);
        
        String params[] = {filename, title, genre, description, strduration, url};
        String types[] = {"String", "String", "String", "String", "int", "String"};
        
        this.sqldriver.loadMovieQuery(params, types);
        
    }
    
    public List<ArrayList<String>> extractAllMovies(){
       List<ArrayList<String>> results = this.sqldriver.extractAllMoviesQuery();
       return results;
    }
    
    public List<ArrayList<String>> extractOneMovieInfos(String nwName){
        
        String[] params = {nwName};
        String[] types = {"String"};
        String[] columns = {"fileName","movieName","movieGenre","movieDescription","movieDuration","movieUrl"};
                
        List<ArrayList<String>> mvinfos = this.sqldriver.extractOneMovieInfosQuery(params, types, columns);
        return mvinfos;
    }/**/
    
    public void updateMovieElement(String element, String newValue, String refValue){
        
        String column = null;
        
        switch(element){
            case "jButton1":
                column = "fileName";
                break;
            case "jButton2":
                column = "movieName";
                break;
            case "jButton3":
                column = "movieGenre";
                break;
            case "jButton4":
                column = "movieDescription";
                break;
            case "jButton5":                
                column = "movieDuration";
                break;
            case "jButton6":
                column = "movieUrl";
                break;
        }
        
        String[] params = {newValue};
        String[] types = {"String"};
        
        this.sqldriver.updateMovieElementQuery(params, types, column, refValue);
    }
    
    public List<ArrayList<String>> extractMovieNames(String nameElement){
        String [] params = {"%" + nameElement + "%"};
        String[] types = {"String"};
        List<ArrayList<String>> searchres = this.sqldriver.extractMovieNamesQuery(params, types);
        return searchres;
    }
    
    
}
