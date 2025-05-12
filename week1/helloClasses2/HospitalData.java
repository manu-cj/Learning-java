package helloClasses2;

public class HospitalData {
    String date;
    int cardiology;
    int radiology;
    int visitors;

    public HospitalData(String date, int cardiology, int radiology, int visitors) {
        this.date = date;
        this.cardiology = cardiology;
        this.radiology = radiology;
        this.visitors = visitors;
    }
    public String getDate() {
        return date;
    }
    public int getCardiology() {
        return cardiology;
    }
    public int getRadiology() {
        return radiology;
    }
    public int getVisitors() {
        return visitors;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public void setCardiology(int cardiology) {
        this.cardiology = cardiology;
    }
    public void setRadiology(int radiology) {
        this.radiology = radiology;
    }
    public void setVisitors(int visitors) {
        this.visitors = visitors;
    }
    
    
}
