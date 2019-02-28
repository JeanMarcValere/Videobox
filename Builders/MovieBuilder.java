/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videobox.Builders;

import videobox.Entities.Movie;

/**
 *
 * @author VALERE
 */
public class MovieBuilder {
    
    private String bldFileName;
    private String bldMovieName;
    private String bldMovieGenre;
    private String bldMovieDescription;
    private int bldMovieDuration;
    private String bldMovieUrl;
    
    /**
     * constructeur de la classe MovieBuilder.
     * 
     * @param ftitle
     * @param title
     * @param genre
     * @param description
     * @param duration
     * @param url 
     */
    public MovieBuilder(String ftitle, String title, String genre, String description, int duration, String url){
        this.bldFileName = ftitle;
        this.bldMovieName = title;
        this.bldMovieGenre = genre;
        this.bldMovieDescription = description;
        this.bldMovieDuration = duration;
        this.bldMovieUrl = url;
    }
    
    /**
     * cette fonction permet de construire l'objet Movie.
     * @return Movie nwMovie
     */
    public Movie buildMovie(){
        
        Movie nwMovie = new Movie();
        
        nwMovie.setFtitle(this.bldFileName);
        nwMovie.setTitle(this.bldMovieName);
        nwMovie.setGenre(this.bldMovieGenre);
        nwMovie.setDescription(this.bldMovieDescription);
        nwMovie.setDuration(this.bldMovieDuration);
        nwMovie.setUrl(this.bldMovieUrl);
        
        return nwMovie;
    }
        
}
