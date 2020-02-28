# viikkoraportti 6

Toteutin HashMapin ja HashSetin sekä otin ne käyttöön ohjelmassa. Lisäksi siivosin checkstylen varoituksia.

huomasin metodeja katsoessani että mun etäisyyskonvertterissa on hyädynnetty huolella noita Math funktioita. Hmm. pitänee tehdä sille reilusti testejä ja kirjoitella sitten niitä auki.

Tein myös vähän suorituskykytestejä. konsepti on vielä kesken niiden suhteen, alan hahmottaa miten ehkä saisi dataa ulos

Yritin myös saada käyttöjärjestelmää parempaan malliin. jatkan siitä vielä. Ohjelma alkaa entistä enemmän olla refaktoroinnin tarpeessa, mutta yritän saada sitä vielä valmiimmaksi ennen.

Suorituskykytestejä kokeillessani huomasin että a* toimii n 7 kertaa hitaammin kuin aiemmin. Palautin javascriptin omat matemaattiset funktiot, ongelma korjautui. Mennään sitten niillä.

Teen suorituskykytestit nyt niin, että arvon lähtö- ja kohdepysäkit ja mittaan matkan niiden välillä. Kokeilen miten se vaikuttaa algoritmien toimivuuteen. LÖysin A* sta bugin, matka-arvio laskettiin mukaan saapumisaikoihin.

lisäsin käyttöliittymään nyt mahdollisuuden vaihtaa algoritmia sekä ajaa suorituskykytestejä. se on vieläkin melko kömpelö. LÖysin myös virheen matka-aikojen käsittelystä, korjasin sen.

Rajasin myös koodikattavuusraporttia ja kirjoitin lisää testejä.

18.2 2h hashmapin koodausta
19.2 6h hashmap ja hashset sekä yksikkötestit ja käyttöönotto
20.2 6h algoritmien käyttöönottoa ja suorituskykytestejä
21.2 6h käyttöjärjestelmän muokkausta
25.2 1h suorituskykytestejä
26.2 4h käyttöliittymää ja suorituskykytestejä
27.2 3h käyttöliittymää ja suorituskykytestejä
28.2 5h vertaisarviointi, kattavuusraportin säätöä ja testejä


