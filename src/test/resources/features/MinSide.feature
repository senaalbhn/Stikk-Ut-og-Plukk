Feature: Min Side Test

  Scenario: Brukeren kan logge inn
    Given   Go til Stikk Ut og Plukk webside
    Then    Skriv i Telefonnummer
    And     Vent 10 sekunder
    And     Klikk Bekreft kode

  Scenario: Brukeren skal kunne lagre sin navn
    Given   Skriv "Olav" fornavn
    Then    Skriv "Nordmen" etternavn
    Then    Skriv "olav.nordmen@exp.com" epost
    And     Klikk Lagre
    And     Bekreft informasjon til bruken ble lagret

  Scenario: Brukeren skal kunne ikke skrive veldig lang informasjon i fornavn,etternavn og epost felt
    Given   Skriv "Olav" fornavn
    Then    Skriv "Nordmen" etternavn
    Then    Skriv "olav.nordmen@exp.com" epost
    And     Klikk Lagre
    And     Bekreft informasjon til bruken ble lagret


  Scenario: Brukeren skal kunne ikke stå tomt i fornavn og etternavn
    Given   Skriv "Olav" fornavn
    Then    Skriv "Nordmen" etternavn
    And     Klikk Lagre
    And     Bekreft informasjon til bruken ble lagret

  Scenario: Brukeren skal kunne legg til bankkonto
    Given   Klikk Legg til bankkonto
    Then    Skriv "Konto1" i Kontonavn
    Then    Skriv "12345678" i Bankkonto
    And     Klikk Lagre
    And     Bekreft konto "Konto1" ble lagret

  Scenario: Brukeren skal kunne legg til bankkonto som defeult
    Given   Klikk Legg til bankkonto
    Then    Skriv "Konto1" i Kontonavn
    Then    Skriv "12345678" i Bankkonto
    And     Klikk Default
    And     Klikk Lagre
    And     Bekreft konto "Konto1" ble lagret som default

  Scenario: Brukeren skal kunne velge et bankkonto som defeult
    Given   Velg "Konto1" bankkonto
    Then    Klikk Default
    And     Klikk Lagre
    And     Bekreft konto "Konto1" ble lagret som default
