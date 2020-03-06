# Viikkoraportti 7

Vaihdoin alkuviikosta käyttöliittymän pudotusvalikot takaisin tekstikentiksi, valikoista ei tullut lisähyötyä, koska oikean pysäkin etsiminen o joka tapauksessa hankalaa vaikka tieto olisikin esillä. Komponentit olivat lisäksi raskaita. muutin lisäksi aineiston latauksen tapahtumaan automaattisesti silloin kun aineistoa ei ole saatavilla, minkä jälkeen ohjelmasta sai muodostettua jarin.

Huomasin bugin sovelluksessa: suorituskykytestejä tehdessäni dijkstrasta tulee välillä pidempi etäisyys kuin a*:sta. Ongelma ei ratkennut useamman tunnin koodin kkatselun jälkeenkään. Ongelma saattaisi osittain liittyä kekoon, koska Javan omalla toteutuksella saatava tieto on erilaista. Tein useamman testin keolle, ja kaikki menivät läpi. Lisäksi ongelma ei poistu täysin Javan keollakaan, se esiintyy vain eri tapauksissa. Outoa. Tarkisitin että aineistossakaan ei ole negatiivisia kaaria. Ongelma esiintyy vainhyvin harvoissa tapauksissa. Katson tätä vielä lopuksi jos ehdin, muuten vain dokumentoin sen.

Muutin a*:a tehokkaammaksi, nyt näyttää paremmalta. Yritin inplementoida siihen myös funktioita, onnistui arctania lukuun ottamatta. Täydentelin myös dokumentaatiota sekä lisäsin javadoceja. 

tiistai 5h

keskiviikko 8h

torstai 6h

perjantai 11h

