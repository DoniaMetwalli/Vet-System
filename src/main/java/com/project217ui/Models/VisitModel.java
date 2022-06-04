package com.project217ui.Models;

public class VisitModel {
    
    public VisitModel() {
    }
    
    
    public VisitModel(float o_Temp, float o_Pulse, float o_CRT, String o_Complaint, float o_Cost) {
        setTemp(o_Temp);
        setPulse(o_Pulse);
        setCRT(o_CRT);
        setComplaint(o_Complaint);
        setCost(o_Cost);
    }
    
    
    public VisitModel(float o_Temp, float o_Pulse, float o_CRT, String o_Ear, String o_Eye, String o_Mouth, String o_Skin,
            String o_Other, String o_Complaint, float o_Cost) {
        setTemp(o_Temp);
        setPulse(o_Pulse);;
        setCRT(o_CRT);;
        setEar(o_Ear);;
        setEye(o_Eye);;
        setMouth(o_Mouth);;
        setSkin(o_Skin);;
        setOther(o_Other);;
        setComplaint(o_Complaint);;
        setCost(o_Cost);;
    }


    public VisitModel(VisitModel o_Visit)
    {
        this(o_Visit.getTemp(),o_Visit.getPulse(),o_Visit.getCRT(),new String(o_Visit.getEar()), new String (o_Visit.getEye()), new String (o_Visit.getMouth()),new String (o_Visit.getSkin()),new String(o_Visit.getOther()),new String(o_Visit.getOther()),o_Visit.getCost());
    }
    

    public float getTemp() {
        return m_Temp;
    }


    public void setTemp(float o_Temp) {
        this.m_Temp = o_Temp;
    }
    
    
    public float getPulse() {
        return m_Pulse;
    }
    
    
    public void setPulse(float o_Pulse) {
        this.m_Pulse = o_Pulse;
    }
    
    
    public float getCRT() {
        return m_CRT;
    }
    
    
    public void setCRT(float o_CRT) {
        this.m_CRT = o_CRT;
    }
    
    
    public String getEar() {
        return m_Ear;
    }
    
    
    public void setEar(String o_Ear) {
        this.m_Ear = o_Ear;
    }
    
    
    public String getEye() {
        return m_Eye;
    }
    
    
    public void setEye(String o_Eye) {
        this.m_Eye = o_Eye;
    }
    
    
    public String getMouth() {
        return m_Mouth;
    }
    
    
    public void setMouth(String o_Mouth) {
        this.m_Mouth = o_Mouth;
    }
    
    
    public String getSkin() {
        return m_Skin;
    }
    
    
    public void setSkin(String o_Skin) {
        this.m_Skin = o_Skin;
    }
    
    
    public String getOther() {
        return m_Other;
    }
    
    
    public void setOther(String o_Other) {
        this.m_Other = o_Other;
    }
    
    
    public String getComplaint() {
        return m_Complaint;
    }
    
    
    public void setComplaint(String o_Complaint) {
        this.m_Complaint = o_Complaint;
    }
    
    
    public float getCost() {
        return m_Cost;
    }
    
    
    public void setCost(float o_Cost) {
        this.m_Cost = o_Cost;
    }


    private float m_Temp;
    private float m_Pulse;
    private float m_CRT;
    private String m_Ear = "N/A";
    private String m_Eye = "N/A";
    private String m_Mouth = "N/A";
    private String m_Skin = "N/A";
    private String m_Other = "N/A"; 
    private String m_Complaint;
    private float m_Cost;
}
