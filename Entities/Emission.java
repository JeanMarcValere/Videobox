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
public class Emission {
    
    private String ftitle;          // Titre du fichier
    private String title;           // Titre de l'émission
    private String thematic;        // Sous-titre de l'émission
    private String channel;         // Chaîne de diffusion de l'émission
    private String description;     // Description de l'émission
    private String duration;           // Durée de l'émission
    private String url;             // url d'accès au fichier de l'émission
    
    
    // setters : mutateurs.
    
    public void setFtitle(String newftitle){
        this.ftitle = newftitle;
    }
    
    public void setTitle(String newtitle){
        this.title = newtitle;
    }
    
    public void setThematic(String newthematic){
        this.thematic = newthematic;
    }
    
    public void setChannel(String newchannel){
        this.channel = newchannel;
    }
    
    public void setDescription(String newdescription){
        this.description = newdescription;
    }
    
    public void setDuration(String newduration){
        this.duration = newduration;
    }
    
    public void setUrl(String newurl){
        this.url = newurl;
    }
    
    // getter : accesseurs.
    
    public String getFtitle(){
        return this.ftitle;
    }
    
    public String getTitle(){
        return this.title;
    }
    
    public String getThematic(){
        return this.thematic;
    }
    
    public String getChannel(){
        return this.channel;
    }
    
    public String getDescription(){
        return this.description;
    }
    
    public String getDuration(){
        return this.duration;
    }
    
    public String getUrl(){
        return this.url;
    }
}
