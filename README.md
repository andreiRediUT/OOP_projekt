# Täringumäng

## Autorid

1. Priit Rooden
2. Andrei Redi

## Kirjeldus 

Tegemist on lihtsa täringumänguga, kus on 2 mängijat. Mängija viskavad viskevoorul täringuid kordamööda ja voorus kogutakse vooruskoori. 
Kui mängija saab vooru ajal anda viskekord teisele mängijale üle. Vooruskoor liidetakse üldskoorile juurde. Kuid kui mängija veereta 1, siis viskevoor katkestub 
ning vooruskoori ei liideta üldskoorile. Viskekord läheb automaatselt teisele mängijale. Mängu võidab, kes saab esimesena üldskoori 91. 

## Klassid 

### KuueNumbriTäring

Klassi eesmärk on luua täringu objekt, mis väljastab täringuveeretuse tulemuse. 
Tegemist on kuuetahulise täringuga, vastavalt sellele väljastatakse ka suvalise numbri ühest kuueni. 

- täringuVeeretus() – genereerib suvalise numbri 1st  6ni
- getVeeretus() – väljastab, mida meetod täringuVeeretus() genereeris

### Skoor

Klassi eesmärk on luua objekt kahemängija skoori pidamiseks. Kahemängija skoori salvestamiseks on kahe  elemendiline järjend. Esimene element esimese mängija jaoks, teine element teise. Klass skoor ka peab ajutist vooruskoori, mida saab ka nullida.

- prindiSkoor() – prindib mängijate üldskoori.
- liidaSkoor() – liidab ajutist vooruskoori üldskoorile. Tuvastab _boolean_ parameetriga, millise mängija kord on. 
- keegiVõitnud() – kontrollib peale igat vooru, kas keegi on saanud 91 punkti täis. 


### Täringumäng

Klass, kus toimub programmi põhitöö. Selle klassi abil käivitatakse mäng. Klassis kasutatakse klasse nagu Skoor ja KuueNumbritäring. Mäng ise ehitatud lõpmatu _while_ tsükli peal. 


## Projekti protsess
Protsessi alustamine võttis aega sest kohe ei osanud välja mõelda teemat mida võiks lahendada projektiga. 
Seetõttu pöördusime etteantud ideede variantide poole ja valisime sealt täringumängu.

Klasside kirjutamine ja nende testimisele kulus 3 nädalat.

## Rühmaliikmete panus
Andrei Redi koostas klassid  Skoor ja Testklass
Priit Rooden koostas klassi KuueNubriTäring.

Mõlemad koos töötasime klassi Täringumängu kallal. 
Saab öelda, et mõlema panus on 50%/50%.


## Tegemise mured

## Hinnang tööle

## Testimine



  Koostada klassid Täring ja Täringumäng jäljendamaks kahe mängija mängu. 
  Mängijate viskevoorud kordamööda. Ühes viskevoorus võib mängija visata täringuid ükskõik mitu korda, 
  aga kui tuleb 1, siis kogusumma nullitakse ja viskeõigus läheb teisele mängijale. 
  Muidu viskel saadud tulemus liidetakse kogusummale. Võidab see, kes saab enne üle 91 punkti. 

- [x] autorite nimed;
- [x] projekti põhjalik kirjeldus, kus on kirjas programmi eesmärk ja selgitus programmi üldisest tööst, vajadusel lühike kasutusjuhis;
- [ ] iga klassi kohta eraldi selle eesmärk ja olulisemad meetodid;
- [ ] projekti tegemise protsessi kirjeldus (erinevad etapid ja rühmaliikmete osalemine neis);
- [ ] iga rühmaliikme panus (sh tehtud klassid/meetodid) ja ajakulu (orienteeruvalt);- 
- [ ] tegemise mured (nt millistest teadmistest/oskustest tundsite projekti tegemisel puudust);
- [ ] hinnang oma töö lõpptulemusele (millega saite hästi hakkama ja mis vajab arendamist);- 
- [ ] selgitus ja/või näited, kuidas programmi osi eraldi ja programmi tervikuna testisite ehk kuidas veendusite, et programm töötab korrektselt.
