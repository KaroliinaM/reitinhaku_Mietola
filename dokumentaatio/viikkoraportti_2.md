# Viikkoraportti 2

Aloitin kakkosviikon tutustumalla GraphQl:n dokumentaatioon. Lueskelin Full Stack openin matskuista, että mistä tuossa on kyse, ja graphQl.orgista löytyi kirjasto, joka tukee api muodostusta. Alan pikkuhiljaa nähdä mahdollisuuden uhan sijasta, vaokuttaisi siltä että GraphQl:llä voi tehdä sekä linjoista että pysäkeistä. 

Enemmällä lukemisella paljastui että kirjasto näkyisi olevan tarkoitettu graphQl-serverin pystyttämiseen. Kyselyiden tekeminen Javalla vaati sitten enemmän etsimistä. LÖysin stackoverflow:sta pohjan jota sain käytettyä melko suoraan. Sain haulla json stringin. Seuraavaksi lähdin kääntämään sitä javan olioksi. Pikaisella googletuksella neuvottiin kääntämään javan json objektiksi ja siitä muuntamaan pojoksi. Pienen säädön jälkeen paljastui että saam käännettyä merkkijonon suoraan gsonilla olioksi. Pienen sovittamisen ja kokeilun jälkeen sain ulos lista, jossa on 8610 pysäkkiä. Tein apista luokan Helloworld, jolla testasin tuon toimintaaa, järkeistän tuota vielä myöhemmin.

Reittitietojen ulos saaminen oli hankalampaa. Pysäkinvälit tulivat ok, mutta aikatauluja joutui hakemaan niin monesta skeemasta että se ei tunnu onnistuvan. Rajapinnassa on erikseen reitit, jotka ovat noita numerotunnisteisia linjoja. Niihin kuuluu patternit, jotka kuvaavat reittivariaatioita kuten esim jos linja menee varikolle tms. Patterneissa ja reiteissä on vielä matkat, joihin ajat sisältyvät. Haluaisin ulos sellaisen kivat listan pysäkkien etäisyyksista minuutteina, mutta sitä ei irtoa. Varmaankin siksi että rajapinnassa on vielä erikseen itienary, joka tekee juuri sen saman mitä tässä yritän tehdä eli laskee optimoidut reitit. Yritän ensi viikolla uudelleen tuota aikojen hakua ja lähden nyt tekemään ohjelman perusrakennetta.

loin ohjelmalle joitain perusluokkia ja testejä niille. Huitaisin Djikstran äkkiä kasaan, en vielä testannut. Testaan tuon ennen kuin lähden muokkaamaan sitä enemmän mun tarkoituksiin sopivaksi. Tällä hetkellä se laskee vain etäisyyden, pitää miettiä mitä dataa siltä pitää saada ulos, ja miten se toteutetaan. 


21.1 1h dokumentaation lukemista

22.1 5h Digitransitin rajapinnan tutkimista

23.1 3h hakua apista

24.1 5h Koodin kirjoitusta ja graphql-hakuja

25.1 3h koodausta
