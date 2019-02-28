/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videobox.Manager;

import java.awt.List;
import java.util.ArrayList;
import videobox.Entities.Emission;
import videobox.Sql.SqlDriver;

/**
 *
 * @author VALERE
 */
public class EmissionManager {
    
    private Emission emissionObj;
    private SqlDriver sqldriver;
    
    public EmissionManager(Emission oneEmissionObj){
        this.emissionObj = oneEmissionObj;
        this.sqldriver = new SqlDriver();
    }
    
    public void loadEmission(){
        String filename = this.emissionObj.getFtitle();
        String title = this.emissionObj.getTitle();
        String thematic = this.emissionObj.getThematic();
        String channel = this.emissionObj.getChannel();
        String duration = this.emissionObj.getDuration();
        String url = this.emissionObj.getUrl();
        String description = this.emissionObj.getDescription();
        
        String[] params = {filename, title, thematic, channel, duration, url, description};
        String[] types = {"String", "String", "String", "String", "String", "String", "String"};
        
        this.sqldriver.loadEmissionQuery(params, types);
    }
    
    public java.util.List<ArrayList<String>> extractEmissionNames(String elemSearched){
        
        String [] params = {"%" + elemSearched + "%"};
        String[] types = {"String"};
        java.util.List<ArrayList<String>> searchres = this.sqldriver.extractEmissionNamesQuery(params, types);
        return searchres;
    }
    
    public java.util.List<ArrayList<String>> extractEmissionNames2(String elemSearched){
        
        String [] params = {"%" + elemSearched + "%", "%" + elemSearched + "%"};
        String[] types = {"String", "String"};
        java.util.List<ArrayList<String>> searchres = this.sqldriver.extractEmissionNames2Query(params, types);
        return searchres;
    }
    
    public java.util.List<ArrayList<String>> extractEmissionFileNames(String elemSearched){
        String [] params = {"%" + elemSearched + "%", "%" + elemSearched + "%"};
        String[] types = {"String", "String"};
        java.util.List<ArrayList<String>> searchres = this.sqldriver.extractEmissionFileNamesQuery(params, types);
        return searchres;
    }
    
    public java.util.List<ArrayList<String>> extractOneEmissionInfos(String nwTitle, String nwThematic){
        String[] params = {nwTitle, nwThematic};
        String[] types = {"String","String"};
        String[] columns = {"emFileName","emTitle","emThematic","emChannel","emDuration","emUrl","emDescription"};
        java.util.List<ArrayList<String>> eminfos = this.sqldriver.extractOneEmissionInfosQuery(params, types, columns);
        return eminfos;
    }
    
    public void updateEmissionElement(String element, String newValue, String refValue){
        String column = null;
        
        switch(element){
            case "jButton3" :
                column = "emFileName";
                break;
            case "jButton4" :
                column = "emTitle";
                break;
            case "jButton5" :
                column = "emThematic";
                break;
            case "jButton6" :
                column = "emDuration";
                break;
            case "jButton7" :
                column = "emChannel";
                break;
            case "jButton8" :
                column = "emUrl";
                break;
            case "jButton9" :
                column = "emDescription";
                break;
        }
        
        String[] params = {newValue};
        String[] types = {"String"};
        
        this.sqldriver.updateEmissionElementQuery(params, types, column, refValue);
    }
    
    public void suppressAllEmissionElement(String newEmFileName){
        String[] params = {newEmFileName};
        String[] types = {"String"};
        
        this.sqldriver.suppressAllEmissionElementsQuery(params, types);
    }
}
