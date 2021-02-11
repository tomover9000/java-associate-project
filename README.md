# java-associate-project

Acesta este proiectul de la finalul cursului Java Associate.
Este o aplicatie in cmd line ce intretine stocul unui magazin.


# Instructiuni utilizare

Aplicatia se ruleaza din Main, acolo este definita metoda main.

Comenzile disponibile:
- ADAUGA_CLIENT <nume>
- ADAUGA_PRODUS <numeClient> <tipProdus>, urmată de un mesaj care să ceară
utilizatorului introducerea detaliilor despre produs (se va valida faptul că tipul
produsului este unul dintre cele 3: laptop, telefon sau televizor)
- laptop: pret stoc producator nrProcesoare areTouchScreen
- telefon: pret stoc producator dimBaterie nrMexapixeli
- televizor: pret stoc producator diagonala esteSmart
- STERGE_PRODUS numeClient numeProdus
- STERGE_TOATE_PRODUSELE numeClient
- AFISARE_CLIENTI - afișează numele și anul înregistrării fiecărui client
- AFISARE_COS numeClient
- AFISARE_COMPLETA - clienții vor fi sortati alfabetic, după nume, iar pentru
fiecare client, va fi afișat numele, anul înregistrării și coșul său.
- EXIT – ieșire din aplicație
