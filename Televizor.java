public class Televizor extends Produs {
    
    private int diagonala;
    private boolean esteSmart;
    
    Televizor(String nume, double pret, int stoc, String producator, int diagonala, boolean esteSmart) {
        super(nume, pret, stoc, producator);
        this.diagonala = diagonala;
        this.esteSmart = esteSmart;
    }
    
    public int getDiagonala() {
        return this.diagonala;
    }
    
    public boolean esteSmart() {
        return this.esteSmart;
    }
    
    @Override
    public String toString() {
        return String.format("Nume: " + this.getNume() + " Pret: " + this.getPret() + ", producator: " + this.getProducator() + ", diagonala: " + this.getDiagonala() + ", esteSmart: " + this.esteSmart());
    }
}