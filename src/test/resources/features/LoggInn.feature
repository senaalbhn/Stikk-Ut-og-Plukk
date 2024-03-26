Feature: Logg Inn Test

  Scenario: Bruker skal ikke kunne logge inn med feil telefonnummer
    Given Go til Stikk Ut og Plukk webside
    Then  Klikk Logg Inn
    And   Skriv i feil Telefonnummer
    And   Klikk Neste
    And   Bekreft kode deler kommer ikke


  Scenario: Bruker skal ikke kunne logge inn med skrive bokstaver i telefonnumer
    Given Go til Stikk Ut og Plukk webside
    Then  Klikk Logg Inn
    And   Skriv bokstaver i Telefonnummer
    And   Klikk Neste
    And   Bekreft kode deler kommer ikke

  Scenario: Bruker skal ikke kunne skrive telefonnummer mindre enn 8
    Given Go til Stikk Ut og Plukk webside
    Then  Klikk Logg Inn
    And   Skriv i Telefonnummer mindre enn 8
    And   Klikk Neste
    And   Bekreft neste blir ikke aktuelt

  Scenario: Bruker skal ikke kunne skrive telefonnummer mer enn 8
    Given Go til Stikk Ut og Plukk webside
    Then  Klikk Logg Inn
    And   Skriv i Telefonnummer mer enn 8
    And   Klikk Neste
    And   Bekreft nummeret skrives ikke

  Scenario: Bruker skal ikke kunne logge inn med feil kode
    Given Go til Stikk Ut og Plukk webside
    Then  Klikk Logg Inn
    And   Skriv i Telefonnummer
    And   Klikk Neste
    And   Bekreft kode deler kommer
    Then  Skriv i feil kode
    And   Klikk Bekreft kode
    And   Bekreft logge ikke inn

  Scenario: Bruker skal kunne logge inn med riktig telefonnummer og kode
    Given Go til Stikk Ut og Plukk webside
    Then  Klikk Logg Inn
    And   Skriv i Telefonnummer
    And   Klikk Neste
    And   Vent 10 sekunder
    And   Klikk Bekreft kode
    And   Bekreft logge inn


