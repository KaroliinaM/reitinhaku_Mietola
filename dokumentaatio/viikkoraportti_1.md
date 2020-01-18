# Viikkoraportti 1

Olin miettinyt reitinhakualgoritmeja aiheeksi. Jokin reittiopas-tyyppinen ratkaisu kiinnostaisi, eli reitinhaku painotetussa verkossa. Painoina voisin käyttää eri reittien kestoja. En ollut miettinyt aineistoa etukäteen, ajattelin että tarvittaessa vaikka generoisin sellaisen. Djikstra on tuttu ja turvallinen valinta hakualgoritmiksi, muiden algoritmien valintaa pitikin sitten miettiä. Valitsin A*:n, koska se ei ole perusperiaatetta lukuunottamatta niinkään tuttu. Johdatus tekoälyyn -kurssilla yksi viikkotehtävistä toteutettiin A *:llä painottamattomassa verkossa. iLmeisesti Djikstra voidaan tulkita A *:n kategoriaksi ilman heuristiikkaa. Sinänsä olisi mielenkintoista vertailla Djikstraa ja A *:ä ja katsoa mitä heuristiikalla saataisiin aikaiseksi. En ole varma tuleeko hyöty enemmän esille suorituskyvyssä vai reitissä, varsinkin suuressa tiiviissä verkossa kuormitus voi olla suuri. 

Aloitin projektin. Tein reporsitorion githubiin ja loin java-projektin Netbeansilla. Gradle-liitännäisen käyttöönotto tuotti hieman ongelmia, koska en ole käyttänyt gradlea hetkeen, ja plugari ei suostunut latautumaan suosiolla. Aluksi ongelmaksi tuli se, että Netbeans ilmoitti toimivansa JRE:llä. Asensin sitten (tietenkin) liian uuden version JDK:sta ja ohjelma ei toiminut ollenkaan. Hieman softanpoistojumppaa niin oltiin takaisin alkutilanteessa, ja sain oikean JDK.n viriteltyä käyttöön. Seuraavaksi Pluginin asennus ilmoitti proxysta. Lopulta se, että plugari asentui, vaati latauksen plugarisivulta. Lopulta se kuitenkin lähti toimimaan, ainakin näennäisesti. en ole aivan varma ovatko jacocon raportit määritelty oikein build.gradlessa, mutta se selviää sitten kun niitä raportteja pitäisi tulla.

Aloitin myös dokumentaation kirjoittamisen. Valitsin aineiston hakualgoritmille. Digitransitin rajapintakuvaus näyttää selkeältä, pitää katsoa miltä näyttää sitten kun sitä dataa pitäisi ottaa käyttöön. Lueskelin API-kuvauksen kevyesti läpi. Graphql ei ole tuttu vielä itselleni, mutta ehkäpä kohta on. Rajapinta saattaa vaatia kyllä hieman jumppaa että datan saa sellaiseen muotoon kuin sen haluan. 

Algoritmien aikavaativuuksia piti myös miettiä hieman. Djikstran aikavaativuudessa päädyin Tirakirjassa ilmoitettuun aikavaativuuteen, koska toteutus tulee ainakin alustavasti mukailemaan sitä. A * lle suurimmassa osassa lähteistä aikavaamtivuus oli ilmaistu branching factorin mukaan. Reittikartalle tuota on hankalahkoa lähteä määrittämään, joten se lienee sama kuin Djikstrassa. Ilmeisesti heuristiikka kuitenkin vaikuttaa paljon A *:n aikavativuuteen. Tilavaativuuden ovat molemmilla varmaanin samat, A *:ssä on yksi kenttä lisää mitä pitää tallentaa.


ke 15.1 3 tuntia, aloitusluennon lisäksi lueskelin kursisivuja ja aloittelin projektia

to 16.1 3 tuntia, sain projektin luotua ja kirjoittelin dokumentaatiota

pe 17.1 4 tuntia, tein projektin aloitukseen liittyviä taskeja ja luin dokumentaatiota

la 18.1 1 tunti dokumentaatiota
