public class Telefon extends Produs {
    
    private int dimBaterie;
    private int nrMegapixeli;
    
    Telefon(String nume, double pret, int stoc, String producator, int dimBaterie, int nrMegapixeli) {
        super(nume, pret, stoc, producator);
        this.dimBaterie = dimBaterie;
        this.nrMegapixeli = nrMegapixeli;
    }
    
    public int getDimBaterie() {
        return this.dimBaterie;
    }
    
    public int getNrMegapixeli() {
        return this.nrMegapixeli;
    }
    
    @Override
    public String toString() {
        return String.format("Nume: " + this.getNume() + " Pret: " + this.getPret() + ", producator: " + this.getProducator() + ", dimBaterie: " + this.getDimBaterie() + ", nrMegapixeli: " + this.getNrMegapixeli());
    }
    
}