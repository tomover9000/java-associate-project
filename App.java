import java.util.Scanner;

public class App {

    private Magazin magazin;
    private Scanner scan;
    private boolean shouldExit;

    App() {
        magazin = Magazin.getInstance();
        scan = new Scanner(System.in);
        shouldExit = false;
    }

    public void run() {
        String comanda = "";
        while (!shouldExit) {
            // facem totul lowercase pt usurinta si ca sa nu fie case sensitive
            comanda = scan.nextLine().trim().toLowerCase();
            String[] comParts = comanda.split(" ");
            // verificam daca s-a citit comanda de iesire
            // facem un switch dupa primul cuvant din comanda
            // adica codul comenzii in sine
            switch (comParts[0]) {

                // adauga_client <nume>
                case "adauga_client":
                    if (comParts.length != 2) {
                        System.out.println("Numar de argumente invalid");
                    } else {
                        magazin.adaugaClient(new Client(comParts[1]));
                    }
                    break;

                // adauga_produs <numeClient> <tipProdus>
                case "adauga_produs":
                    if (comParts.length != 3) {
                        System.out.println("Numar de argumente invalid");
                    } else {
                        // verificam tipul de produs
                        // am adaugat si numele ca parametru pentru a identifica mai usor produsul in
                        // cos
                        switch (comParts[2]) {
                            // <numeProdus> <pret> <cantitate> <producator> <nrProcesoare> <areTouchScreen>
                            case "laptop":
                                System.out.println("Introduceti urmatoarele date despre produs");
                                System.out.println(
                                        "<numeProdus> <pret> <cantitate> <producator> <nrProcesoare> <areTouchScreen>");
                                String comanda2 = scan.nextLine();
                                String[] com2Parts = comanda2.split(" ");

                                // verificam ca numarul de argumente este ok
                                if (com2Parts.length != 6) {
                                    System.out.println("Numar de argumente invalid");
                                } else {
                                    try {
                                        // adaugam produsul in cos
                                        magazin.adaugaProdus(comParts[1],
                                                new Laptop(com2Parts[0], Double.parseDouble(com2Parts[1]),
                                                        Integer.parseInt(com2Parts[2]), com2Parts[3],
                                                        Integer.parseInt(com2Parts[4]),
                                                        Boolean.parseBoolean(com2Parts[5])));
                                    } catch(ClientInexistentException e) {
                                        System.out.println(e);
                                    }
                                }
                                break;

                            case "telefon":

                                // <numeProdus> <pret> <cantitate> <producator> <dimBaterie> <nrMegapixeli>
                                System.out.println("Introduceti urmatoarele date despre produs");
                                System.out.println(
                                        "<numeProdus> <pret> <cantitate> <producator> <dimBaterie> <nrMegapixeli>");
                                String comanda3 = scan.nextLine();
                                String[] com3Parts = comanda3.split(" ");

                                // verificam ca numarul de argumente este ok
                                if (com3Parts.length != 6) {
                                    System.out.println("Numar de argumente invalid");
                                } else {
                                    try {
                                        // adaugam produsul in cos
                                        magazin.adaugaProdus(comParts[1],
                                                new Telefon(com3Parts[0], Double.parseDouble(com3Parts[1]),
                                                        Integer.parseInt(com3Parts[2]), com3Parts[3],
                                                        Integer.parseInt(com3Parts[4]), Integer.parseInt(com3Parts[5])));
                                    } catch(ClientInexistentException e) {
                                        System.err.println(e);
                                    }
                                }
                                break;

                            case "televizor":

                                // <numeProdus> <pret> <cantitate> <producator> <dimBaterie> <nrMegapixeli>
                                System.out.println("Introduceti urmatoarele date despre produs");
                                System.out.println(
                                        "<numeProdus> <pret> <cantitate> <producator> <diagonala> <esteSmart>");
                                String comanda4 = scan.nextLine();
                                String[] com4Parts = comanda4.split(" ");

                                // verificam ca numarul de argumente este ok
                                if (com4Parts.length != 6) {
                                    System.out.println("Numar de argumente invalid");
                                } else {
                                    // adaugam produsul in cos
                                    try {
                                        magazin.adaugaProdus(comParts[1],
                                                new Televizor(com4Parts[0], Double.parseDouble(com4Parts[1]),
                                                        Integer.parseInt(com4Parts[2]), com4Parts[3],
                                                        Integer.parseInt(com4Parts[4]),
                                                        Boolean.parseBoolean(com4Parts[5])));
                                    }  catch (ClientInexistentException e) {
                                        System.err.println(e);
                                    }
                                }
                                break;

                            default :
                                System.out.println("Acest tip de produs nu exista");
                        }
                    }
                    break;
                
                // sterge_produs <numeClient> <numeProdus>
                case "sterge_produs" :
                    if(comParts.length != 3) {
                        System.out.println("Numarul de argumente este invalid");
                    } else {
                        try {
                            magazin.stergeProdus(comParts[1], comParts[2]);
                        } catch(ClientInexistentException e) {
                            System.err.println(e);
                        }
                    }
                    break;

                // sterge_toate_produsele <numeClient>
                case "sterge_toate_produsele" :
                    if(comParts.length != 2) {
                        System.out.println("Numarul de argumente este invalid");
                    } else {
                        try {
                            magazin.golesteCos(comParts[1]);;
                        } catch(ClientInexistentException e) {
                            System.err.println(e);
                        }
                    }
                    break;

                // afisare_clienti
                case "afisare_clienti" :
                    if(comParts.length != 1) {
                        System.out.println("Numarul de argumente este invalid");
                    } else {
                        magazin.afisareClienti();
                    }
                    break;

                // afisare_cos <numeClient>
                case "afisare_cos" :
                    if(comParts.length != 2) {
                        System.out.println("Numarul de argumente este invalid");
                    } else {
                        try {
                            magazin.afisareCos(comParts[1]);
                        } catch(ClientInexistentException e) {
                            System.err.println(e);
                        }
                    }
                    break;

                // afisare_completa
                case "afisare_completa" :
                    if(comParts.length != 1) {
                        System.out.println("Numarul de argumente este invalid");
                    } else {
                        magazin.afisareCompleta();
                    }
                    break;
                
                case "exit" : 
                    shouldExit = true;
                    magazin.stopThreadAfisareStoc();
                    break;

                default :
                    System.out.println("Comanda invalida");
            }
            System.out.println();
        }
        
    }
}