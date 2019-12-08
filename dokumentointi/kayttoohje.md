
# Käyttöohje

Lataa tiedosto [MassiMatti_v0.1-alpha.jar](https://github.com/InglouriousObjects/ot-harjoitustyo/releases/tag/Viikko5) sekä siihen liittyvä tiedosto _config.properties_.

## Konfigurointi

Ohjelma olettaa, että sen käynnistyshakemistossa on konfiguraatiotiedosto _config.properties_, joka määrittää tietojen tallentamiseen liittyvän tietokannan. Käynnistettäessä sovellus, sovellus luo tietokannan, mikäli sitä ei ole jo aiemmin luotu, sen hetkiseen työkansioon nimellä massimatti.mv.db. Kun tietokantaan on tallennettu tietoa luodaan tietokannanhallintajärjestelmän toimesta työkansioon myös tiedosto nimellä massimatti.trace.db.

## Ohjelman käynnistäminen

Ohjelma käynnistetään komennolla 

```
java -jar MassiMatti_v0.1-alpha.jar
```