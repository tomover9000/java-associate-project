public class Produs {
    
    private double pret;
    // int stoc va fi folosit pentru a tine minte stocul in Magazin
    // si va fi folosit pe post de cantitate pentru cosul Clientului
    private int stoc;
    private String producator;
    private String nume;
    
    Produs(String nume, double pret, int stoc, String producator) {
        this.nume = nume;
        this.pret = pret;
        this.stoc = stoc;
        this.producator = producator;
    }
    
    public String getNume() {
        return this.nume;
    }
    
    public double getPret() {
        return this.pret;
    }
    
    public void setPret(double pret) {
        this.pret = pret;
    }
    
    public int getStoc() {
        return this.stoc;
    }
    
    public void updateStoc(int stoc) {
        this.stoc += stoc;
    }
    
    public String getProducator() {
        return this.producator;
    }
    
    public void setProducator(String producator) {
        this.producator = producator;
    }
}
