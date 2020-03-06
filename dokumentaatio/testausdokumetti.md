# Testausdokumentti

## junit
Algoritmit, tietorakenteet ja luokat on yksikkötestattu JUnitilla.  Yksikkötestien syötteinä on käytetty kovakoodattua dataa koska ohjelman käyttämä data voi muuttua jos se ladataan uusiksi. Testikattavuusraportit löytyvät tästä kansiosta. Erityisesti A* manuaalitestaus oli haastavaa, suuren etäisyyksittäin painotetun verkon luonti on hankalaa.

## manuaalitestaus
Ohjelmaa on manuaalitetattu sekä käyttöliittymän kautta että suorituskykytestauksen tuloksia tarkastelemalla. Olen vertaillut arvoja aiempiin arvoishin ja katsonut mikäli tulosteissa löytyy jotain outoa. 

## suorituskykytestaus
Suorituskykytestien puohjana toimii sama data mitä ohjelma käyttää. Testit arpovat tietyn määrän lähtö -ja kohdepysäkkejä, joista tarkistetaan ensin että reitti pysäkiltä pysäkille löytyy varmasti. Tulokset on järjestetty pysäkkimäärän ja etäisyyden mukaan. Päädyin ajamaan yksittäisen haun 30 kertaa ja ottamaan keskiarvon, variaatio eri testikertojen välillä ei näin ollut liian suurta. Arvottavina oli 120 joista 94 löytyi reitti.

## testien toistettavuus
Yksikkötestit voidaan toistaa junitin kautta ja ne ajetaan myös buildissa. Suorituskykytestien ajamiseen on käyttöliittymässä oma valintansa, tuloste tulee konsoliin. 

## testauksen tulokset

Algoritmien erot ovat hyvin satunnaisia, joissakin tapauksissa Dijkstra on nopeampi, joissakin A*. Dijkstra vaikutti ylipäätään tehokkaammalta. Ennen etäisyyttä mittavien matemaattisten funktioiden implementointia A* oli useammilla hauilla nopeampi, mutta funktiot hidastivat algoritmin toimintaa selvästi. Ero ei kuitenkaan ole suuri eikä ole huomattavissa reittioppaan käytössä.

Alla on graafinen esitys sekä Dijkstran algoritmista että A*:sta, jossa hakuihin käytetty aika on järjestetty etäisyyksittäin

![dijkstra etäisyyksittäin](https://github.com/KaroliinaM/reitinhaku_Mietola/blob/master/dokumentaatio/kuvat/dijkstra_etaisyys.png)

![A* etäisyyksittäin](https://github.com/KaroliinaM/reitinhaku_Mietola/blob/master/dokumentaatio/kuvat/astar_etaisyys.png)

Molemmissa tulokset ovat hyvin hajallaan. Tätä selittänee se, että satunnaisesti arvotut pysäkit voivat olla kumpaan suuntaan meneviä linjoja, jolloin todellisesta matkasta tulee huomattavasti pidempi. Graafeissa on havaittavissa paljon samankaltaisuuksia, poikkeamat ovat samoissa kodin.

Näissä graafeissa hakuihin kuluneet ajat on järjestetty pysäkeittäin

![dijkstra pysäkeittäin](https://github.com/KaroliinaM/reitinhaku_Mietola/blob/master/dokumentaatio/kuvat/dijkstra_pysakit.png)

![A* pysäkeittäin](https://github.com/KaroliinaM/reitinhaku_Mietola/blob/master/dokumentaatio/kuvat/astar_pysakit.png)

Näissä on näkyvissä se, että pysäkkimääränn kasvaessa myös matka-aika kasvaa, vaikka hajontaa on näissäkin reippaasti.

Matkan kestolla ei ollut huoomattavia eroja, Dijkstran hakema reitti erosi A* hakemasta 11 testatuista 94 reitistä

Lopuksi vielä Dijkstra ja A* samassa graafissa

![Dikstra vs A*](https://github.com/KaroliinaM/reitinhaku_Mietola/blob/master/dokumentaatio/kuvat/dikstra_vs_astar.png)

Pisimmät hakuajat ovat A* mutta nopeimmissa on melko tasaista.





