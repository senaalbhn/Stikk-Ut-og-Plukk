package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.HovedsidePage;
import pages.MinSidePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class LoggInnStepdefs {
    HovedsidePage hovedsidePage = new HovedsidePage();
    MinSidePage minSidePage = new MinSidePage();
    Faker faker = new Faker();


    @Given("Go til Stikk Ut og Plukk webside")
    public void goTilStikkUtOgPlukkWebside() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }

    @Then("Klikk Logg Inn")
    public void klikkLoggInn() {
        hovedsidePage.loggInn.click();

    }

    @And("Skriv i Telefonnummer")
    public void skrivITelefonnummer() {
        hovedsidePage.telefonnummer.sendKeys(ConfigReader.getProperty("telefonnummer"));
    }

    @And("Klikk Neste")
    public void klikkNeste() {
        hovedsidePage.neste.click();
    }

    @And("Vent {int} sekunder")
    public void ventSekunder(int sekunder) {
        ReusableMethods.wait(sekunder);
    }

    @And("Bekreft logge inn")
    public void bekreftLoggeInn() {
        Assert.assertTrue(minSidePage.loggUt.isDisplayed());
    }

    @And("Skriv i feil Telefonnummer")
    public void skrivIFeilTelefonnummer() {
        hovedsidePage.telefonnummer.sendKeys(faker.phoneNumber().subscriberNumber(8));
    }

    @And("Bekreft kode deler kommer ikke")
    public void bekreftKodeDelerKommerIkke() {
        System.out.println(hovedsidePage.bekreftKode.isDisplayed());
        System.out.println(hovedsidePage.bekreftKode.isEnabled());
        Assert.assertFalse(hovedsidePage.bekreftKode.isEnabled());
        Assert.assertFalse(hovedsidePage.bekreftKode.isDisplayed());
    }

    @And("Bekreft kode deler kommer")
    public void bekreftKodeDelerKommer() {
        Assert.assertTrue(hovedsidePage.bekreftKode.isDisplayed());
    }

    @Then("Skriv i feil kode")
    public void skrivIFeilKode() {
        hovedsidePage.kode.sendKeys("1234");
    }

    @And("Bekreft logge ikke inn")
    public void bekreftLoggeIkkeInn() {
        String obs = "sign in verification failed";
        Assert.assertEquals(obs, hovedsidePage.obs.getText());
    }

    @And("Skriv bokstaver i Telefonnummer")
    public void skrivBokstaverITelefonnummer() {
        hovedsidePage.telefonnummer.sendKeys("telnummr");
    }

    @And("Skriv i Telefonnummer mindre enn 8")
    public void skrivITelefonnummerMindreEnn() {
        hovedsidePage.telefonnummer.sendKeys(faker.number().digits(7));
    }

    @And("Bekreft neste blir ikke aktuelt")
    public void bekreftNesteBlirIkkeAktuelt() {
        Assert.assertTrue(hovedsidePage.neste.isEnabled());
    }

    @And("Skriv i Telefonnummer mer enn 8")
    public void skrivITelefonnummerMerEnn() {
        hovedsidePage.telefonnummer.sendKeys("12345678900110");
    }

    @And("Bekreft nummeret skrives ikke")
    public void bekreftNummeretSkrivesIkke() {
       String value= hovedsidePage.telefonnummer.getAttribute("value");
       Assert.assertTrue(value.length()<=8);
    }

    @And("Klikk Bekreft kode")
    public void klikkBekreftKode() {
        hovedsidePage.bekreftKode.click();
    }
}
