# Toteutusdokumentti

Ohjelmassa on main -luokan lisksi pääluokka, jossa haetaan karttadata apistal alustetaan hakutoiminnallisuus karttadatalla ja välitetään toiminnallisuus käyttöliittymälle. 

Datamn haku tapahtuu api-pakkauksessa. Se suorittaa useamman graphql-kyselyn digitransitin apiin, ja palauttaa listan pysäkkejä, joihin on tallennettu tiedot kulloiseenkin aikaan pysäkiltä lähtevistä linjoista. 

käyttöliittymässä on luokka jossa alustetaan komponentit sekä tapahtumankuuntelija, joka toteuttaa käyttöliittymän kontrollien toiminnallisuuden.

Analyysit ovat vielä pahasti vaiheessa



