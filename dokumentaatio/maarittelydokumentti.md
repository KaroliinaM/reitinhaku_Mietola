# Määrittelydokumentti

Toteutan työssäni A*:in ja Dijkstran algoritmin. Tietorakenteista toteutan ArrayListin, Hashmapin, HashSetin sekä PriorityQueuen. Lisäksi pyrin toteuttamaan matemaattiset funktiot, joiden avulla mitataan kahden karttakordinaattipisteen välinen matka. Tätät tietoa tarvitaan A *:n tarvitsemien hauristiikoiden laskemiseen.

Projektin tarkoitus on tehdä reittioppaasta versio, joka etsii lyhyimmän reitin pysäkiltä pysäkille. Lisäksi työssä on tarkoitus vertailla A* ja Dijkstran algoritmien suorituskykyä, ja löydettyä reittiä. Valitsin nämä algoritmit, koska haluan vertailla, miten Dijkstran algoritmi, joka löytää aina lyhyimmän reitin, vertautuu A* :n joka löytää reitin nopeammin. Työssä on käyttöliittymä, jonka kautta voidaan ajaa sekä reitinhaku että suorituskykytestit. 
 
Ohjelma saa syötteeksi digitransit.fi:n rajapinnan tarjoamaa tietoa reiteistä sekä pysäkeistä. Pysäkkejä on noin 12500. Jokaiseen pysäkkiin tallennetaan tieto siitä lähtevistä linjoista kellonajoittain, jotta reittejä voidaan etsiä eri pysäkeiltä eri kellonaikoina. Rajapinnasta saan myös tiedon pysäkkien sijainneista, joten voin käyttää tätä tietoa A* toteutuksessa. Reitinetsintä rajautuu yhden päivän sisällä lähteviin lähtöihin.

Dijkstran aikavaativuus on O(n+m log n), jossa n on solmujen määrä ja m kaarien määrä. Tässä ohjelmassa solmujen välillä on useampia kaaria, koska linjoilla voi olla samat reitit pitkiäkin matkoja. Aikavaativuus on siis O(n + m log m). Algoritmi käy pahimmillaan läpi kaikki verkon solmut ja kaaret, sekä keko tuo algoritmiin m log m. A* aikavaativuus on pahimmillaan sama, mutta todennäköisesti pienenee O(b^d), jossa d on löydetyn polun pituus ja b on keskiarvo siitä, miten monta kaarta kullakin solmulla on. Algoritmi lähtee etsimään polkua kohdesolmun suuntaan, ja ei hae yhteyksiä solmuista jotka ovat liian kaukana kohdesolmusta.

Djikstran tilavaativuus on O(n^2) koska se tallentaa solmuja kekoon pahimmillaan n * n kappaletta, A* tilavaativuus on O(b^d), koska se ei tallenna tietoa solmuista, jotka ovat tietyn matkan päässä reitistä.

Lähteet:

Tirakirja, Antti Laaksonen, 

http://igraph.wikidot.com/algorithm-space-time-complexity

Wikipedia

https://public-transport-hslhrt.opendata.arcgis.com/datasets/hsln-pys%C3%A4kit/data?page=1251
