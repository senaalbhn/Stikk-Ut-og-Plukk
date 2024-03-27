Feature: Min Side Test

  Scenario: Brukeren kan logge inn
    Given   Go til Stikk Ut og Plukk webside
    Then    Klikk Logg Inn
    Then    Skriv i Telefonnummer
    And     Klikk Neste
    And     Vent 10 sekunder
    And     Klikk Bekreft kode

  Scenario: Brukeren skal kunne lagre sin navn
    Given   Skriv "Olav" fornavn
    Then    Skriv "Nordmen" etternavn
    Then    Skriv "olav.nordmen@exp.com" epost
    And     Klikk Lagre
    And     Bekreft informasjon til bruken ble lagret

  Scenario: Brukeren skal kunne ikke skrive veldig lang informasjon i fornavn,etternavn og epost felt
    Given   Skriv "Olavolavolavolavolavolavolavolavolavolavolavolavolav" fornavn
    Then    Skriv "Nordmennnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn" etternavn
    Then    Skriv "olavolavolavolavolavolavolavolav.nordmennnnnnnnnnnn@exp.com" epost
    And     Klikk Lagre
    And     Bekreft informasjon til bruken ikke ble lagret


  Scenario: Brukeren skal kunne ikke stå tomt i fornavn og etternavn
    Given   Skriv "" fornavn
    Then    Skriv "" etternavn
    Then    Skriv "" epost
    And     Klikk Lagre
    And     Bekreft informasjon til bruken ikke ble lagret

  Scenario: Brukeren skal kunne legg til bankkonto
    Given   Klikk Legg til bankkonto
    Then    Skriv "Konto1" i Kontonavn
    Then    Skriv "12345678" i Bankkonto
    And     Klikk Lagre
    And     Bekreft konto "Konto1" ble lagret

Scenario: Brukeren skal kunne ikke skrive veldig lang informasjon i bankkontofelter
    Given   Klikk Legg til bankkonto
    Then    Skriv "Konto222222222222222222222222222222222222222222222" i Kontonavn
    Then    Skriv "12345678901234567890123456789012345678901234567890" i Bankkonto
    And     Klikk Lagre
    And     Bekreft konto "Konto222222222222222222222222222222222222222222222" ble ikke lagret

Scenario: Brukeren skal kunne ikke stå tomt bankkontofelter
    Given   Klikk Legg til bankkonto
    Then    Skriv "" i Kontonavn
    Then    Skriv "" i Bankkonto
    And     Klikk Lagre
    And     Bekreft konto "" ble ikke lagret

  Scenario: Brukeren skal kunne legg til bankkonto som defeult
    Given   Klikk Legg til bankkonto
    Then    Skriv "Konto2" i Kontonavn
    Then    Skriv "9876543210" i Bankkonto
    And     Klikk Default
    And     Klikk Lagre
    And     Bekreft konto "Konto2" ble lagret som default

  Scenario: Brukeren skal kunne velge et bankkonto som defeult
    Given   Velg "Konto1" bankkonto
    Then    Klikk Default
    And     Klikk Lagre
    And     Bekreft konto "Konto1" ble lagret som default

  Scenario: Brukeren skal kunne ikke velge mer enn et bankkonto som defeult
    Given   Velg "Konto1" bankkonto
    Then    Klikk Default
    And     Klikk Lagre
    And     Bekreft konto "Konto1" ble lagret som default
    Given   Velg "Konto2" bankkonto
    Then    Klikk Default
    And     Klikk Lagre
    And     Bekreft bare et konto som er default

  Scenario: Brukeren skal kunne slette bankkonto
    Given   Velg "Konto2" bankkonto
    Then    Klikk Slett konto
    And     Bekreft konto "Konto2" ble slettet

