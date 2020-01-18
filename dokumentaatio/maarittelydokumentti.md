# Määrittelydokumentti

Vertailen työssäni verkon reitinhakualgoritmeja. Lähtökohtaisesti vertailen Djikstran algoritmia A* :an, ja katson miten saisin parhaiten toteutettua A* tarvitsemat heuristiikat. Lisäksi toteutan algoritmien tarvitsemat tietorakenteet, ainakin keon. Vertailen sekä algoritmien tehokkuutta että kykyä valita optimaalinen reitti. Toteutan projektin Javalla, ja käytän Gradlea buildin hallinnassa. Käyttöliittymän toteutus on vielä auki. Toteutuksesta riippuen saatan tehdöä tekstipohjaisen käyttöliittymän, tai graafisen joko swingilla tai JavaScriptillä.

Haluan etsiä työssäni parannettua reitinhalualgoritmia julkisen liikenteen verkkoon. Painotuksina käytän perilläoloaikaa matka-ajat ja odotusajat yhteenlaskettuina. Valitsin Djikstran algoritmin koska se on ilmeisesti aika klassinen algoritmi reitinetsintään painotetussa verkossa. Vertailualgoritmiksi valitsin A* :n koska haluann kokeilla miten se vertautuu Djikstraan painotetussa verkossa. Saako heuristiikasta hyötyä reitinetsinnässä painotetussa verkossa. Lisäksi heuristiikat voivat olla hyödyllisiä suorituskyvynkin kannalta, reitinetsintä laajemmalla alueella voi käydä raskaaksi pelkällä laskennalla. Varsinkin jos jokaisella pysäkillä lasketaan pysäkiltä lähtevät yhteydet mukaan 

Ohjelma saa syötteeksi digitransit.fi:n tarjoamaa tietoa joukkoliikenteen reiteistä pääkaupunkiseudulla. Rajapinta tarjoaa tietoa julkisen liikenteen reiteistä ja pysäkeistä. Käytän pääasiassa rajapinnan tarjoamaa tietoa reiteistä ja pysäkeistä. Näistä tiedoista etsitään yhteyksiä kulloiseltakin pysäkiltä seuraavalle. Pysäkkejä on noin 12500. Linjoissa yhteydet lasketaan pysäkkien välisinä, joten todellinen määrä on suurempi kuin HSL:llä ajossa olevien linjojen määrä. Tarkoitus olisi tehdä sovellus joka etsii reittejä pysäkiltä pysäkille, eli se saa syötteeksi tiedot lähtöpysäkistä ja kohdepysäkistä käyttäjältä. Aluksi sovellus etsisi reitin niin, että vaihdot tapahtuvat pysäkiltä pysäkille ja sovellusta olisi tarkoitus laajentaa niin että se etsisi myös vaihtoja kävelyetäisyyden päässä olevista pysäkeistä. 

Djikstran aikavaativuus on O(n+m log n), jossa n on kaarien määrä ja m solmujen määrä. Tässä ohjelmassa saattaa olla että solmujen välillä on useampia kaaria, koska linjoilla voi olla samat reiti pitkiäkin matkoja. Aikavaativuus saattaa olla siis O(n + m log m). Oletan että painotetussa verkossa A* aikavaativuus on sama, koska algoritmin aikavaativuus riippuu käytetystä heuristiikasta eikä siitä ole vielä tarkempaa tietoa. Kokeilen voinko A* pienentää tuota oletusta jotenkin.
Djikstran tilavaativuus on O(n^2), A* on varmaankin sama, koska tallentaa samanlaista tietoa.

LÄhteet:

Tirakirja, Antti Laaksonen, 

http://igraph.wikidot.com/algorithm-space-time-complexity

Wikipedia

https://public-transport-hslhrt.opendata.arcgis.com/datasets/hsln-pys%C3%A4kit/data?page=1251
