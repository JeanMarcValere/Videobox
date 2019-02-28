/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videobox.Entities;

/**
 *
 * @author VALERE
 */
public class Movie {
    
    private String ftitle;          // titre du fichier du film
    private String title;           // titre du film
    private String genre;           // genre du film 
    private String description;     // description du film
    private int duration;           // durée du film
    private String url;             // url d'accès au fichier du film
    
    // Setters : mutateurs.
    
    public void setFtitle(String newftitle){
        this.ftitle = newftitle;
    }
    
    public void setTitle(String newtitle){
        this.title = newtitle;
    }
    
    public void setGenre(String newgenre){
        this.genre = newgenre;
    }
    
    public void setDescription(String newdescription){
        this.description = newdescription;
    }
    
    public void setDuration(int newduration){
        this.duration = newduration;
    }
    
    public void setUrl(String newurl){
        this.url = newurl;
    }
    
    // Getters : accesseurs.
    
    public String getFtitle(){
        return this.ftitle;
    }
    
    public String getTitle(){
        return this.title;
    }
    
    public String getGenre(){
        return this.genre;
    }
    
    public String getDescription(){
        return this.description;
    }
    
    public int getDuration(){
        return this.duration;
    }
    
    public String getUrl(){
        return this.url;
    }
}
