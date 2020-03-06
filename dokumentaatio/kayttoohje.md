# Käyttöohje

Lataa jar-tiedosto repositorion releaseista. Ohjelma suoritetaan ajamalla 
java -jar <tiedoston nimi>

Käynnistyksen jälkeen ohjelma tarkistaa, onko sillä tallennettuna karttatietoja. mikäli ei, se lataa ja tallentaa ne. tässä menee noin 10 minuuttia. Ohjelma pitää sen jälkeen käynnistää uudelleen

Jos haluat ajaa suorituskykytestit, laita täppä aja suorituskykytestit -ruutuun ja paina hae reitti -painiketta. Testien tulos tulostuu konsoliin.

Kun haet reittiä, valitse käytettävä algoritmi, suötä kenttiin lähtö ja kohdepysäkkien gtfsId:t, ne saat haettua digitransitin rajapinnasta https://digitransit.fi/en/developers/apis/1-routing-api/stops/. Syötä kellonaika ja valitse hae reitti.

