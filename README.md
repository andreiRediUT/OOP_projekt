# OOP_projekt
# Täringumäng

## Autorid

1. Priit Rooden
2. Andrei Redi

## Kirjeldus

Tegemist on lihtsa täringumänguga, kus on 2 mängijat. Mängija viskavad viskevoorul täringuid kordamööda ja voorus kogutakse vooruskoori. Kui mängija saab vooru ajal anda viskekord teisele mängijale üle. Vooruskoor liidetakse üldskoorile juurde. Kuid kui mängija veereta 1, siis viskevoor katkestub ning vooruskoori ei liideta üldskoorile. Viskekord läheb automaatselt teisele mängijale. Mängu võidab, kes saab esimesena üldskoori 91.

Rõhmatöö 2 ülesandena lisasime graafika osas ja täiendasime olemasolevat koodi. 



## Klassid

### KuueNumbriTäring

Klassi eesmärk on luua täringu objekt, mis väljastab täringuveeretuse tulemuse. Tegemist on kuuetahulise täringuga, vastavalt sellele väljastatakse ka suvalise numbri ühest kuueni.

- täringuVeeretus() – genereerib suvalise numbri 1st 6ni
- getVeeretus() – väljastab, mida meetod täringuVeeretus() genereeris

### Skoor

Klassi eesmärk on luua objekt kahemängija skoori pidamiseks. Kahemängija skoori salvestamiseks on kahe elemendiline järjend. Esimene element esimese mängija jaoks, teine element teise. Klass skoor ka peab ajutist vooruskoori, mida saab ka nullida.

- prindiSkoor() – prindib mängijate üldskoori.
- liidaSkoor() – liidab ajutist vooruskoori üldskoorile. Tuvastab *boolean* parameetriga, millise mängija kord on.
- keegiVõitnud() – kontrollib peale igat vooru, kas keegi on saanud 91 punkti täis.

### Täringumäng

Klass, kus toimub programmi põhitöö. Klassis kasutatakse klasse nagu Skoor ja KuueNumbritäring. Mäng ise ehitatud lõpmatu *while* tsükli peal.

- alusta() – Paneb käima koguprogrammi. Kutsuma peaks *main* meetodis.
- reeglid() – Saab panna printima mängu kirjelduse ja reegleid.
- poole_vahetus() - mängu siseselt pooltevahetus, et kelle kord täringuid veeretada. Parameetriks võtab booleani, mis näitab, kas pooltevahetus tuli viskes täringuviskest "1" või vabatahtlikult kirjutades "ff".



### MustRuut

Klass, milles toimub Täringumängu graafiline töötlemine ja mängu käivitamine. 
Klassis on meetodid:

- start()  -  luuakse pealava ja paigutatakse sellele nuppud. Kutsutakse välja alustuseks reelglite aken. 
- mängija()  - jälgib kumma mängija kord on ja kuvab seda pealavale.
- võiduTeade() - väljstab võiduteate pärast võidu saabumist. 
- täring_vooruskoor() - kuvab skoori.
- kelle_kord() - kuvab kelle kord on prasjagu.
- reeglid() - kuvab mängureeglid eraldi akanas enne mangu alustamist.
- joonistaTulemus() - selle meetodiga joonistatakse täringu veeretuse tulemusele vastav täring. 
- statistikaGraaf() - pärast mängu lõppu väljastatakse täringu statistika  - kui palju mingit numbrit veeretati.



## Projekti protsess

Protsessi alustamine võttis aega sest kohe ei osanud välja mõelda teemat mida võiks lahendada projektiga. Seetõttu pöördusime etteantud ideede variantide poole ja valisime sealt täringumängu.
Klasside kirjutamine ja nende testimisele kulus 3 nädalat.

Rühmatöö 2 on koostatud rühmatöö 1 baasil. Juurde on kirjutatud klass MustRuut graafika jaoks ja on töiendatud teisi klasse graafikast tulenevalt. 



## Rühmaliikmete panus

Andrei Redi koostas klassid Skoor ja Testklass. Priit Rooden koostas klassi KuueNumbriTäring.

Mõlemad koos töötasime klassi Täringumängu kallal. Saab öelda, et mõlema panus on 50%/50%.

## Tegemise mured

Tegemisega väga suuri muresi ei olnud. Pigem on õige teema leidmine see, mis projekti puhul oli kohaks mis viivitas projekti tegemise alustamist. Ei osanud leida lahendamist vajavat teemat ja mõtet. Tegime etteantud teemadest valitud teemal, kui teema valitud oli siis läks asi lihtsamalt. Projektiks vajaliku oskused olid praktikumide materjaliga kaetud. Suhtlusvahendina kasutasime Slacki ja hoidsime koodi ka Githubis ja see lihtsustas vägagi suhtlemist.

## Hinnang tööle

Töö on tehtud parasjagu oskuste järgi mida omasime või oskasime kasutada selle ülesande lahendamiseks või väljamõelda kuidas seda erinevalt lahendada. Kindlasti saab programmi keerulisemaks ja paremaks teha aga selleks oleks vaja välispidist tagasisidete mille põhjal saaks edasi arendada. Hinanguna võib öelda et ülesanne ei olnud meile üleliia keerukas.

## Testimine

Teste eraldi klassidel ei kirjutanud. Jooksvalt katsetasime iga klassi konstruktori õigsust ning kas iga meetod tagastab või väljastab õiget väärtust. Täringumängu läbisime korduvalt läbi, kuid väiksemas mahus - 10 punkti lõppskooriga.

