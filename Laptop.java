public class Laptop extends Produs {
    
    private int nrProc;
    private boolean areTouchScreen;
    
    Laptop(String nume, double pret, int stoc, String producator, int nrProc, boolean areTouchScreen) {
        super(nume, pret, stoc, producator);
        this.nrProc = nrProc;
        this.areTouchScreen = areTouchScreen;
    }
    
    public int getNrProc() {
        return this.nrProc;
    }
    
    public boolean areTouchScreen() {
        return this.areTouchScreen;
    }
    
    @Override
    public String toString() {
        return String.format("Nume: " + this.getNume() + " Pret: " + this.getPret() + ", producator: " + this.getProducator() + ", NrProc: " + this.getNrProc() + ", areTouchScreen: " + this.areTouchScreen());
    }
}
