/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videobox.Builders;

import videobox.Entities.Emission;
/**
 *
 * @author VALERE
 */
public class EmissionBuilder {

    private String emFileName;
    private String emTitle;
    private String emThematic;
    private String emChannel;
    private String emDescription;
    private String emDuration;
    private String emUrl;
    
    /**
     * 
     * @param oneftitle
     * @param onetitle
     * @param onesubtitle
     * @param onechannel
     * @param onedescription
     * @param oneduration
     * @param oneurl 
     * 
     * @return nwemission
     * 
     */
    public EmissionBuilder(String oneftitle,String onetitle,String onethematic,String onechannel,String onedescription,String oneduration,String oneurl){
    
        this.emFileName = oneftitle;
        this.emTitle = onetitle;
        this.emThematic = onethematic;
        this.emChannel = onechannel;
        this.emDescription = onedescription;
        this.emDuration = oneduration;
        this.emUrl = oneurl;
        
    }   
        
    public Emission buildEmission(){    
        
        Emission nwemission = new Emission();
        
        nwemission.setFtitle(this.emFileName);
        nwemission.setTitle(this.emTitle);
        nwemission.setThematic(this.emThematic);
        nwemission.setChannel(this.emChannel);
        nwemission.setDescription(this.emDescription);
        nwemission.setDuration(this.emDuration);
        nwemission.setUrl(this.emUrl);
        
        return nwemission;
        
    }   
    
}
