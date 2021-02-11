import java.util.*;

public class Client {
    
    private String nume;
    private int anInregistrare = 2021;
    private Map<String, Produs> cos = new HashMap<>();
    
    Client(String nume, int anInregistrare) {
        this.nume = nume;
        this.anInregistrare = anInregistrare;
    }
    
    Client(String nume) {
        this.nume = nume;
    }
    
    public String getNume() {
        return this.nume;
    }
    
    public int getAnInregistrare() {
        return this.anInregistrare;
    }
    
    public Map<String, Produs> getCos() {
        return this.cos;
    }

    public int getCantitateProdus(String numeProdus) {
        Iterator<Map.Entry<String, Produs>> iterator = cos.entrySet().iterator();
        Map.Entry<String, Produs> mapElement = (Map.Entry<String, Produs>)iterator.next();
        Produs p = (Produs) mapElement.getValue();
        while(iterator.hasNext() && p.getNume() != numeProdus) {
            mapElement = (Map.Entry<String, Produs>)iterator.next();
            p = (Produs) mapElement.getValue();
        }
        return p.getStoc();
    }
    
    public void adaugaProdus(Produs p) {
        // daca produsul exista deja in cos
        if(cos.containsValue(p))
            System.out.println("Produsul exista deja in cos");
        else
            cos.put(p.getNume(), p);
    }
    
    public void stergeProdus(Produs p) {
        // verificam daca elementul nu exita in cos
        if(cos.remove(p.getNume()) == null)
        // daca rezultatul este null inseamna ca produsul nu exista in cos in primul rand
            System.out.println("Produsul nu exista in cos");
        else
            System.out.println("Produsul a fost scos din cos");
    }
    
    public void golesteCos() {
        cos.clear();
    }
    
    public void afisareCos() {
        System.out.println("Cosul clientului " + this.getNume() + " este: ");
        Iterator<Map.Entry<String, Produs>> iterator = cos.entrySet().iterator();
        int sumaTotala = 0;
        while(iterator.hasNext()) {
            Map.Entry<String, Produs> mapElement = (Map.Entry<String, Produs>)iterator.next();
            Produs p = (Produs) mapElement.getValue();
            sumaTotala += p.getPret() * p.getStoc();
            System.out.println(p.toString() + " cantitate: " + p.getStoc());
        }
        if(this.getAnInregistrare() < 2018) {
            // reducerea de 10%
            sumaTotala *= 0.9;
        }
        System.out.println("Suma totala este: " + sumaTotala);
    }
   
    @Override
    public String toString() {
        return String.format(this.nume + ", anul inregistrarii: " + this.anInregistrare);
    }
}