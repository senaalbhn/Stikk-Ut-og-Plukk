Feature: Logg Inn Test

  Scenario: Bruker skal ikke kunne logge inn med feil telefonnummer
    Given Go til Stikk Ut og Plukk webside mobil
    Then  Klikk Logg Inn mobil
    And   Skriv i feil Telefonnummer mobil
    And   Klikk Neste mobil
    And   Bekreft kode deler kommer ikke mobil
