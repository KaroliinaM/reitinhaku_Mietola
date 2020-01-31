# viikkoraportti 3

Jätin datan haun hetkeksi aikaa hyllylle, palaan siihen vielä myöhemmin tällä viikolla. tein testejä Djikstran algoritmille, jonka laitoin nopeasti alulle viime viikolla. Mockaan tarvittavat tietorakenteet mockitolla toistaiseksi, olen käyttänyt mockitoa töissä, joten se on melko tuttu eikä tarvitse uhrata aikaa opetteluun. 

Testejä tehdessäni huomasin ettei algoritmi toimi, ylläri. En ollut tajunnut alustaa solmujen arviotietoja mockissa, senkään jälkeen ei vielä toiminut. Kun löysin kirjoitusvirheen ja korjasin sen, niin alkoi pelittämään. Tein pari testiä, näyttäisi tulevan oikeita tuloksia. Voisi ehkä mietti' monimutkaisempia testejä, koska sit kun alan kirjoittaa noita tietorakenteita auki, on hyvä tietää jos jokin ei toimi. Seuraavaksi lähden muokkaamaan sitä mitä tuo palauttaa, tällä hekellä tulee pelkkä matka-arvio. Voisin tehdä reitille oman olionsa.

Tein oman olion reitille, tällä hetkellä siihen tallennetaan reitti ja reitin läpikäuýntiin kuluva aika. mietin ohjelman olioiden refaktorointia, mutta se voisi odottaa siihen kun saan oikeaa dataa matkojen kestoista.

Selvitin lisää sitä, miten hakea dataa rajapinnasta. Reitit tulivat vaivatta, mutta jos niihin hakee aikatauludataa samalla, rajapintakutsu kaatuu. kokeilin sellaista viritelmää että haen reittidatan ja teehn aikataulukutsun joka reitille erikseen. n. 5 ja puoli sataa reittiä, niiden kutsuminen kesti melkein 10 minuuttia. Voisin tehdä niin että haen aikataulut kerralla, talletan tiedostoon ja käytän tiedostoa, selviää vähemmillä kahvitauoilla. Näin mä sen varmaan teen :)

28.1 2h testien kirjoittamista
29.1 4h testejä ja djikstran hiomista
30.1 4h api kuvioiden selvitelyä


