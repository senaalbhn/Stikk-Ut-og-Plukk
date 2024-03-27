Feature: Lever Sekk Test

  Scenario: Brukeren kan logge inn
    Given   Go til Stikk Ut og Plukk webside
    Then    Klikk Logg Inn
    Then    Skriv i Telefonnummer
    And     Klikk Neste
    And     Vent 10 sekunder
    And     Klikk Bekreft kode

  Scenario: Brukeren skal kunne levere sekk
    Given   Klikk Lever sekk
    Then    Velg "" konto
    And     Velg 2 sekker
    And     Klikk Hent sekkekoder
    And     Bekreft er 2 hente koder
    And     Klikk Neste
    Then    Last opp "" bilde
    And     Klikk Neste
    Then    Velg "Molde" lokasjon
    And     Klikk Neste
    Then    Velg miljostasjon
    And     Klikk Fullfor
    And     Bekreft sekker ble levert

  Scenario: Brukeren skal kunne ikke levere sekk uten velge bankkonto
    Given    Klikk Stikk ut og plukk
    Given   Klikk Lever sekk
    And     Velg 2 sekker
    And     Klikk Neste
    Then    Last opp "" bilde
    And     Klikk Neste
    Then    Velg "Molde" lokasjon
    And     Klikk Neste
    Then    Velg miljostasjon
    And     Klikk Fullfor
    And     Bekreft sekker ble ikke levert

  Scenario: Brukeren skal kunne ikke levere sekk uten laste opp bilder
    Given    Klikk Stikk ut og plukk
    Given   Klikk Lever sekk
    Then    Velg "" konto
    And     Velg 2 sekker
    And     Klikk Hent sekkekoder
    And     Bekreft er 2 hente koder
    And     Klikk Neste
    And     Klikk Neste
    Then    Velg "Molde" lokasjon
    And     Klikk Neste
    Then    Velg miljostasjon
    And     Klikk Fullfor
    And     Bekreft sekker ble ikke levert

  Scenario: Brukeren skal kunne ikke levere sekk uten velg lokasjon
    Given    Klikk Stikk ut og plukk
    Given   Klikk Lever sekk
    Then    Velg "" konto
    And     Velg 2 sekker
    And     Klikk Hent sekkekoder
    And     Bekreft er 2 hente koder
    And     Klikk Neste
    Then    Last opp "" bilde
    And     Klikk Neste
    And     Klikk Neste
    Then    Velg miljostasjon
    And     Klikk Fullfor
    And     Bekreft sekker ble ikke levert

  Scenario: Brukeren skal kunne ikke levere sekk uten velge miljøstasjon
    Given   Klikk Stikk ut og plukk
    Given   Klikk Lever sekk
    Then    Velg "" konto
    And     Velg 2 sekker
    And     Klikk Hent sekkekoder
    And     Bekreft er 2 hente koder
    And     Klikk Neste
    Then    Last opp "" bilde
    And     Klikk Neste
    Then    Velg "Molde" lokasjon
    And     Klikk Neste
    And     Klikk Fullfor
    And     Bekreft sekker ble ikke levert

  Scenario: Brukeren skal kunne slette bilder gjennom levering sekk
    Given   Klikk Stikk ut og plukk
    Given   Klikk Lever sekk
    Then    Velg "" konto
    And     Velg 2 sekker
    And     Klikk Hent sekkekoder
    And     Bekreft er 2 hente koder
    And     Klikk Neste
    Then    Last opp "" bilde
    And     Klikk Neste
    Then    Velg "Molde" lokasjon
    And     Klikk Neste
    Then    Velg miljostasjon
    And     Klikk Tilbake
    And     Klikk Tilbake
    Then    Klikk Slette bilde
    And     Bekreft bilde slettet
    Then    Last opp "" bilde
    And     Klikk Neste
    And     Klikk Neste
    And     Klikk Fullfor
    And     Bekreft sekker ble levert

  Scenario: Brukeren skal kunne slette lokasjon gjennom levering sekk
    Given   Klikk Stikk ut og plukk
    Given   Klikk Lever sekk
    Then    Velg "" konto
    And     Velg 2 sekker
    And     Klikk Hent sekkekoder
    And     Bekreft er 2 hente koder
    And     Klikk Neste
    Then    Last opp "" bilde
    And     Klikk Neste
    Then    Velg "Molde" lokasjon
    And     Klikk Neste
    Then    Velg miljostasjon
    And     Klikk Tilbake
    Then    Klikk Slette lokasjon
    And     Bekreft lokasjon slettet
    Then    Velg "Molde" lokasjon
    And     Klikk Neste
    And     Klikk Fullfor
    And     Bekreft sekker ble levert

 Scenario: Brukeren skal kunne bytte miljøstasjon gjennom levering sekk
    Given   Klikk Stikk ut og plukk
    Given   Klikk Lever sekk
    Then    Velg "" konto
    And     Velg 2 sekker
    And     Klikk Hent sekkekoder
    And     Bekreft er 2 hente koder
    And     Klikk Neste
    Then    Last opp "" bilde
    And     Klikk Neste
    Then    Velg "Molde" lokasjon
    And     Klikk Neste
    Then    Velg miljostasjon
    Then    Velg miljostasjon
    And     Klikk Fullfor
    And     Bekreft sekker ble levert


  Scenario: Brukeren skal kunne ombestemme levere sekk
    Given   Klikk Stikk ut og plukk
    Given   Klikk Lever sekk
    Then    Velg "" konto
    And     Velg 2 sekker
    And     Klikk Hent sekkekoder
    And     Bekreft er 2 hente koder
    And     Klikk Neste
    Then    Last opp "" bilde
    And     Klikk Neste
    Then    Velg "Molde" lokasjon
    And     Klikk Neste
    Then    Velg miljostasjon
    And     Klikk Lukk
    And     Bekreft sekker ble ikke levert



