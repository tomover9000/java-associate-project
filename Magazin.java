import java.util.*;

public class Magazin {
    // instanta magazin (singleton)
    private static Magazin instanta_magazin = null;
    
    // aici vom stoca toti clientii
    private Map<String, Client> clienti = new HashMap<>();
    // aici vom stoca produsele din stoc
    private Map<String, Produs> stocProduse = new HashMap<>();
    private AfisareStoc threadAfisareStoc;
    
    private Magazin() {
        threadAfisareStoc = new AfisareStoc(this);
        // in aceasta metoda vom initializa stocul
        // adica pur si simplu o sa adaugam produse in stoc
        // daca mai vreti sa adaugati produse aici trebuie puse toate stringurile cu litere mici
        // deoarece toate comenzile se dau in lowercase pentru usurinta
        Telefon iPhone11 = new Telefon("iphone11", 4000, 1, "apple", 2000, 12);
        Televizor LG40 = new Televizor("lg40", 2000, 3, "lg", 55, true);
        Laptop DellXPS = new Laptop("xps13", 5000, 40, "dell", 8, true);
        this.stocProduse.put(iPhone11.getNume(), iPhone11);
        this.stocProduse.put(LG40.getNume(), LG40);
        this.stocProduse.put(DellXPS.getNume(), DellXPS);
        // pornim threadul ce ne afisaza stocul
        threadAfisareStoc.start();
    }
    
    public static Magazin getInstance() {
        if(instanta_magazin == null) {
            instanta_magazin = new Magazin();
        }
        return instanta_magazin;
    }
    
    public void adaugaClient(Client c) {
        if(!clienti.containsKey(c.getNume())) {
            clienti.put(c.getNume(), c);
            System.out.println("Clientul a fost adaugat");
        } else {
            System.out.println("Clientul deja exista");
        }
    }
    
    public void adaugaProdus(String numeClient, Produs p) throws ClientInexistentException {
        if(!clienti.containsKey(numeClient)) {
            throw new ClientInexistentException("Clientul nu exista");
        } else {
            // verificam daca stocul este suficient
            if(this.stocProduse.containsKey(p.getNume()) && this.stocProduse.get(p.getNume()).getStoc() >= p.getStoc()) {
                // adaugam produsul in cosul clientului
                clienti.get(numeClient).adaugaProdus(p);
                // scadem stocul
                this.stocProduse.get(p.getNume()).updateStoc(-p.getStoc());
                System.out.println("Produsul a fost adaugat in cos!");
            } else {
                System.out.println("Stoc insuficient");
            }
        }
    }
    
    public void stergeProdus(String numeClient, String numeProdus) throws ClientInexistentException {
        if(!clienti.containsKey(numeClient)) {
            throw new ClientInexistentException("Clientul nu exista");
        } else {
            // restituim stocul
            stocProduse.get(numeProdus).updateStoc(clienti.get(numeClient).getCantitateProdus(numeProdus));
            // stergem produsul din cosul clientului
            clienti.get(numeClient).stergeProdus(stocProduse.get(numeProdus));
        }
    }
    
    public void golesteCos(String numeClient) throws ClientInexistentException {
        if(!clienti.containsKey(numeClient)) {
            throw new ClientInexistentException("Clientul nu exista");
        } else {
            // punem stocul la loc in magazin
            Iterator<Map.Entry<String, Produs>> iterator = clienti.get(numeClient).getCos().entrySet().iterator();
            while(iterator.hasNext()) {
                Map.Entry<String, Produs> mapElement = (Map.Entry<String, Produs>)iterator.next();
                Produs p = (Produs) mapElement.getValue();
                System.out.println("Punem stocul la loc");
                this.stocProduse.get(p.getNume()).updateStoc(p.getStoc());
            }
            // golim cosul
            clienti.get(numeClient).golesteCos();
        }
    }

    // afisam clientii existenti
    public void afisareClienti() {
        Iterator<Map.Entry<String, Client>> iterator = clienti.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry<String, Client> mapElement = (Map.Entry<String, Client>)iterator.next();
            Client c = (Client) mapElement.getValue();
            System.out.println(c.toString());
        }
    }

    // afisam cosul unui client la alegere
    public void afisareCos(String numeClient) throws ClientInexistentException {
        if(!clienti.containsKey(numeClient)) {
            throw new ClientInexistentException("Clientul nu exista");
        } else {
            clienti.get(numeClient).afisareCos();
        }
    }

    public void afisareCompleta() {
        // punem toti clientii in treemap astfel vor fi sortati natural 
        // deoarece treemap sorteaza automat datele puse in el
        TreeMap<String, Client> sorted = new TreeMap<>();
        sorted.putAll(clienti);

        // afisam toti clientii
        for(Map.Entry<String, Client> entry : sorted.entrySet()) {
            System.out.println(entry.getValue().toString());
            entry.getValue().afisareCos();
            System.out.println();
        }
    }

    // metoda pentru a opri threadul ce afisaza stocul
    public void stopThreadAfisareStoc() {
        // interupem sleepul threadului pentru a-l inchide imediat
        this.threadAfisareStoc.interrupt();
    }
    
    // this is just for me to test with
    public void afisazaStoc() {
        for(String name: stocProduse.keySet()) {
            String value = stocProduse.get(name).toString();
            System.out.println(value + " stoc: " + stocProduse.get(name).getStoc());
        }
    }
}