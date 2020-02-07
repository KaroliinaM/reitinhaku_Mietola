# viikkoraportti 4

Aloitin nelosviikon tutkimalla, miten a* pitäisi toteuttaa. Saan datasta kivasti(teoriassa) pysäkkien etäisyydet. Voisin laskea etäisuyyden maalista la muuntaa sen matka-ajaksi. Kokeillaan tällä

Sain kaavan jolla laskea etäisyydet melko suoraan StackOverflow:sta. Päätin käyttää nopeutena 40 km/h, nappasin sen taloussanomien vuoden 2012 artikkelista. Muutin sen 20km/h, koska arviot olivat melko optimistisia, kahdessa minuutissa Pasilasta kumpulaan linnuntietä. Laskin jonkin laisen arvion käyttäen bussien nopeutta Mannerheimintiellä. Voi olla että säädän sen kanssa vielä, mutta aloitetaan tuolla.

Toteutin A*:n mukaillen paljon Djikstran toteutusta. Lisäsin koodiin vain heurstiikat mukaan laskuihin, ja sillä mennään. Vaikuttaisi toimivva, vaikka en ole niin varma kuin djikstraa tehdessä. Tein jonkinlaiset testit, ja vaikuttaisi olevan ok

Palasin sitten taas takaisin hakemaan dataa bussilinjoista. Tiedostoon kirjoitatminen vaikuttaisi olevan melko helppoa. Filusta lukemisesa menee n. 1,5 min mutta parempi kuin aiempi tulos. Pikoin reitin solmujen välisiksi yhteyksiksi. Hmm, lopullisesti tuo testataan sitten kun pyöräytän tuon läpi.

Nyt kun alkaa olla dataa, joudun katsomaan algoritmien toteutusta hieman uusiksi. Tällä hetkellä mun yhteydet on eri aikoihin tapahtuvia lähtöjä pysäkilt pysäkeille. Pkkuisen hankaloittaa kun joutuu pelaamaan aikojen kanssa, mutta katstaan mitä irtoaa. Refaktorioin noita aika urakalla, testit pitää käytännössäkirjoittaa uusiksi paremmalla ajalla. Pitää muistaa varmistaa että buildi toimii

nyt näkyisi pelaavan ohjelmanakin. UI ei ole kovin UI, koska inputtia ei voi laittaa, mutta sieltä tuli ainakin jonkinlainen pysäkkilistaus. Tällä hetkellä tulee vain pysäkkien id.t, pitänee tehdä tuosta käyttäjäystävällisempi. Buildia joutui taas säätämään hetken ennen kuin siitä tuli taas ehjä.


3.2 2h A* suunnittelua

4.2 2h heuristiikan hankkimista

5.2 4h A* koodausta ja testejä

6.2 4h api säätöä

7.2 6h apia, luokkien refaktorointia, buildin korjaamista, javadocceja, etc.


