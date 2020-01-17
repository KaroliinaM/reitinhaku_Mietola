# Määrittelydokumentti

Vertailen työssäni verkon reitinhakualgoritmeja. Lähtökohtaisesti vertailen Djikstran algoritmia A* algoritmiin, ja katson miten saisin parhaiten toteutettua A* tarvitsemat heuristiikat. Vertailen sekä tehokkuutta että kykyä valita optimaalinen reitti. Toteutan projektin Javalla, ja käytän Gradlea buildin hallinnassa.

Haluan etsiä työssäni parannettua reitinhalualgoritmia julkisen liikenteen verkkoon. Painotuksina käytän perilläoloaikaa matka-ajat ja odotusajat yhteenlaskettuina. Valitsin Djikstran algoritmin ja A* :n koska Djikstran algoritmi on muuten sama kuin A* ilman heuristiikkaa, ja haluan testata voiko joikkoliikenteen reitinetsinnässä optimoida reitinhakua heuristiikoilla ja kuinka paljon.

Syötteinä ohjelma saa joukkoliikenteen reittiaikataulutietoja. //update 
    Mitä algoritmeja ja tietorakenteita toteutat työssäsi
    Mitä ongelmaa ratkaiset ja miksi valitsit kyseiset algoritmit/tietorakenteet
    Mitä syötteitä ohjelma saa ja miten näitä käytetään
Ohjelma saa syötteeksi digitransit.fi:n tarjoamaa tietoa joukkoliikenteen reiteistä. Tarkoitus olisi tehdä sovellus joka etsii reittejä pysäkiltä pysäkille. Aluksi sovellus etsisi reitin niin, että vaihdot tapahtuvat pysäkiltä pysäkille ja sovellusta olisi tarkoitus laajentaa niin että se etsisi myös vaihtoja kävelyetäisyyden päässä olevista pysäkeistä.

Djikstran aikavaativuus on O(n+mlog n), jossa n on kaarien määrä ja n solmujen määrä. Oletan että painotetussa verkossa A* aikavaativuus on sama. Kokeilen voinko A* pienentää tuota jotenkin.
Djikstran tilavaativuus on O(n^2), A* on varmaankin sama, koska tallentaa samanlaista tietoa.

LÄhteet:
Tirakirja, Antti Laaksonen, 

http://igraph.wikidot.com/algorithm-space-time-complexity
