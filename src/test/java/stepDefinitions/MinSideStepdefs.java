package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.HovedsidePage;
import pages.MinSidePage;
import utilities.Driver;

public class MinSideStepdefs {
    HovedsidePage hovedsidePage=new HovedsidePage();
    MinSidePage minSidePage= new MinSidePage();
    Faker faker=new Faker();
    public static String fornavn ="Olav";
    public static String etternavn="Berg";
    public static String epost="OlavBerg@exp.com";

    @Then("Skriv fornavn")
    public void skrivFornavn() {
        minSidePage.fornavn.sendKeys(fornavn);
    }

    @Then("Skriv etternavn")
    public void skrivEtternavn() {
        minSidePage.etternavn.sendKeys(etternavn);
    }

    @Then("Skriv epost")
    public void skrivEpost() {
        minSidePage.email.sendKeys(epost);
    }

    @And("Klikk Lagre")
    public void klikkLagre() {
        minSidePage.lagre.click();
    }

    @And("Bekreft informasjon til bruken ble lagret")
    public void bekreftInformasjonTilBrukenBleLagret() {
        minSidePage.hovedside.click();
        hovedsidePage.loggInn.click();
        String actualFornavn =minSidePage.fornavn.getAttribute("value");
        String actualEtternavn =minSidePage.etternavn.getAttribute("value");
        String actualEpost =minSidePage.email.getAttribute("value");
        Assert.assertEquals(fornavn,actualFornavn);
        Assert.assertEquals(etternavn,actualEtternavn);
        Assert.assertEquals(epost,actualEpost);
    }

    @Given("Klikk Legg til bankkonto")
    public void klikkLeggTilBankkonto() {
        minSidePage.leggTilBankkonto.click();
    }


    @Then("Skriv {string} i Kontonavn")
    public void skrivIKontonavn(String kontonavn) {
        minSidePage.kontoNavn.sendKeys(kontonavn);
    }

    @Then("Skriv {string} i Bankkonto")
    public void skrivIBankkonto(String kontoNummer) {
        minSidePage.kontonummer.sendKeys(kontoNummer);
    }

    @And("Bekreft konto {string} ble lagret")
    public void bekreftKontoBleLagret(String kontonavn) {
        String actualData= Driver.getDriver().findElement(By.xpath("//span[text()='"+kontonavn+"']")).getText();
        Assert.assertEquals(kontonavn,actualData);
    }

    @And("Klikk Default")
    public void klikkDefault() {
        minSidePage.defaultButton.click();
    }

    @And("Bekreft konto {string} ble lagret som default")
    public void bekreftKontoBleLagretSomDefault(String kontonavn) {
        String actualData= Driver.getDriver().findElement(By.xpath("//span[text()='"+kontonavn+"']//parent::div")).getAttribute("class");
        Assert.assertTrue(actualData.contains("blue"));

    }

    @Given("Velg {string} bankkonto")
    public void velgBankkonto(String kontonavn) {
        Driver.getDriver().findElement(By.xpath("//span[text()='"+kontonavn+"']")).click();
    }

    @Given("Skriv {string} fornavn")
    public void skrivFornavn(String fornavn) {
        minSidePage.fornavn.sendKeys(fornavn);
    }

    @Then("Skriv {string} etternavn")
    public void skrivEtternavn(String etternavn) {
    minSidePage.etternavn.sendKeys(etternavn);
    }

    @Then("Skriv {string} epost")
    public void skrivEpost(String epost) {
        minSidePage.email.sendKeys(epost);
    }
}
