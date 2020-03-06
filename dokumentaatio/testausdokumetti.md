# Testausdokumentti

## junit
Algoritmit, tietorakeneet ja luokat on yksikkötestattu JUnitilla.  Yksikkötestien syötteinä on käytetty kovakoodattua dataa, koska ohjelman käyttämä data voi muuttua jos se ladataan uusiksi. 

## manuaalitestaus
Ohjelmaa on manuaalitetattu sekä käyttöliittymän kautta että suorituskykytestauksen tuloksia tarkastelemalla. Olen vertaillut arvoja aiempiin arvoishin ja katsonut mikäli tulosteissa löytyy jotain outoa. 

## suorituskykytestaus
Suorituskykytestien puohjana toimii sama data mitä ohjelma käyttää. Testit arpovat tietyn määrän lähtö -ja kohdepysäkkejä, joista taekistetaan ensin että reitti pysäkiltä pysäkille löytyy varmasti. Tulokset on järjestetty pysäkkimäärän ja etäisyyden mukaan. Pääduyin ajamaan yksittäisen haun 30 kertaa ja ottamaan keskiarvon, variaatio eri testikertojen välillä ei näin ollu liian suurta

## testien toistettavuus
Yksikkötestit voidaan toistaa junitin kautta ja ne ajetaan myös buildissa. Suorituskykytestien ajamiseen on käyttöliittymässä oma valintansa, tuloste tulee konsoliin. 

## testauksen tulokset







