# Toteutusdokumentti

## Ohjelman yleisrakenne

Ohjelmassa on main -luokan lisksi pääluokka, jossa haetaan karttadata apista, alustetaan hakutoiminnallisuus karttadatalla ja välitetään toiminnallisuus käyttöliittymälle. 

Datan haku tapahtuu api-pakkauksessa. Se suorittaa useamman graphql-kyselyn digitransitin apiin, ja palauttaa listan pysäkkejä, joihin on tallennettu tiedot kulloiseenkin aikaan pysäkiltä lähtevistä linjoista. 

käyttöliittymässä on luokka jossa alustetaan käyttöliittymäkomponentit sekä tapahtumankuuntelija, joka toteuttaa käyttöliittymän kontrollien toiminnallisuuden.

## Saavutetut aika -ja tilavaativuudet

Dijkstra toimii aikavaativuudella O(n+m log n), jossa n on solmujen määrä ja m kaarien määrä. Algoritmia on tehostettu niin, että mikäli solmuuun päästäessä sen paino on suurempi kuin kohdesolmun, sen kaaria ei käydä läpi. 

A* aikavaativuus on O(b^d), jossa d on löydetyn polun pituus ja b on keskiarvo siitä, miten monta kaarta kullakin solmulla on. Algoritmin pitäisi hakeutua kohdesolmun suuntaan, ja mikäli arvio on suurempi kuin etäisyys kohdesolmusta, solmusta lähteviä kaaria ei käydä läpi.

Keon aikavaativuus on n log n, n on solmujen määrä, se on toteutettu taulukkoon niin, että koko taulukkoa ei käydä läpi,vaan hypätään aina solmun lapsiin.

Hashrakenteet toimivat alle O(n) n on solmujen määrä, uskaltaisin melkein luvata O(1), mikäli hajautus toimii.

Funktioista sin, cos ja toRadian näkyisivät toimivan vakioajassa, koska syötteen koko ei vaikuta kierrosten määrään for-rakenteissa. Pow on O(n), n on eksponentti. Sqrt on O(log n) varmaankin, koska tulos jakautuu aina kahtia.

Djikstran tilavaativuus on O(n^2) koska se tallentaa solmuja kekoon pahimmillaan n * n kappaletta, A* tilavaativuus on O(b^d), koska se ei tallenna tietoa solmuista, jotka ovat tietyn matkan päässä reitistä. Keko on O(n^2). Hashrakenteet ovat O(n)

## Suorituskyky ja O-analyysivertailu

Erot olivat tällä materiaalilla hyvinkin pieniä. Yksi syy voi olla siinä että A* ei aina saanut optimaalisinta pysäkkiä, ja reitti lähti muoudostumaan väärään suuntaan. Myös etäisyyksien laskemisesta koitui A* lle ylimääräisiä kustannuksia. Verkko oli kuitenkin verrattain pieni.

## Puutteet ja parannusehdotukset

Math.atan2 -funktio jäi implementoimatta. Aika loppui kesken, ja se oli hankala. 

Ohjelmassa on jokin virhe, koska aina välillä Dijkstran algoritmi antaa pidemmän polun kuin A*. Epäilen että liittyy ainakin osittain kekoon, koska Javan oma toteutus toimii toisin kuin omani. En saa tilannetta keossa toistettua yksikkötestillä, ja se ilmenee muutenkin n. kolmessa tapauksessa sadasta. Ongelma ilmenee lisäksi myös Javan kekoa käyttäessä, mutta eri tapauksissa.

muut parannusehdotukset liittyisivät toimintaan reittioppaana, datan hakua voisi tehostaa sekä käyttöliittymä voisi olla parempi. 

## Lähteet

Tirakirja
Wikipedia


