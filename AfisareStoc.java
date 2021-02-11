public class AfisareStoc extends Thread {

    private Magazin magazin;

    AfisareStoc(Magazin magazin) {
        this.magazin = magazin;
    }

    public void run() {
        while(true) {
            System.out.println("Stoc: ");
            magazin.afisazaStoc();
            System.out.println();
            // sleep 15s
            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                // daca s-a intrerupt threadul atunci iesim din bucla de afisare a stocului
                break;
            }
        }
    }
}