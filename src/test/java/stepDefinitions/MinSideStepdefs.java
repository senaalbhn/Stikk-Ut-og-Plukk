package stepDefinitions;

import com.github.javafaker.Faker;
import com.sun.source.tree.AssertTree;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;
import pages.HovedsidePage;
import pages.MinSidePage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

public class MinSideStepdefs {
    HovedsidePage hovedsidePage=new HovedsidePage();
    MinSidePage minSidePage= new MinSidePage();
    Faker faker=new Faker();
    Actions actions= new Actions(Driver.getDriver());
    public static String fornavn1;
    public static String etternavn1;
    public static String epost1;

    @Given("Skriv {string} fornavn")
    public void skrivFornavn(String fornavn) {
        actions.click(minSidePage.fornavn).keyDown(minSidePage.fornavn, Keys.CONTROL).sendKeys("a","x").keyUp(Keys.CONTROL).perform();
        fornavn1=fornavn;
        minSidePage.fornavn.sendKeys(fornavn1);
    }

    @Then("Skriv {string} etternavn")
    public void skrivEtternavn(String etternavn) {
        actions.click(minSidePage.etternavn).keyDown(minSidePage.etternavn, Keys.CONTROL).sendKeys("a","x").keyUp(Keys.CONTROL).perform();
        etternavn1=etternavn;
        minSidePage.etternavn.sendKeys(etternavn1);
    }

    @Then("Skriv {string} epost")
    public void skrivEpost(String epost) {
        actions.click(minSidePage.email).keyDown(minSidePage.email, Keys.CONTROL).sendKeys("a","x").keyUp(Keys.CONTROL).perform();
        epost1=epost;
        minSidePage.email.sendKeys(epost1);
    }
    @And("Klikk Lagre")
    public void klikkLagre() {
        minSidePage.lagre.click();
    }

    @And("Bekreft informasjon til bruken ble lagret")
    public void bekreftInformasjonTilBrukenBleLagret() {
        SoftAssert softAssert= new SoftAssert();
        minSidePage.hovedside.click();
        hovedsidePage.loggInn.click();
        String actualFornavn =minSidePage.fornavn.getAttribute("value");
        String actualEtternavn =minSidePage.etternavn.getAttribute("value");
        String actualEpost =minSidePage.email.getAttribute("value");
        System.out.println(actualFornavn+" "+actualEtternavn+" : "+actualEpost);
        softAssert.assertEquals(fornavn1,actualFornavn);
        softAssert.assertEquals(etternavn1,actualEtternavn);
        softAssert.assertEquals(epost1,actualEpost);
        softAssert.assertAll();
    }

    @And("Bekreft informasjon til bruken ikke ble lagret")
    public void bekreftInformasjonTilBrukenIkkeBleLagret() {
        SoftAssert softAssert= new SoftAssert();
        minSidePage.hovedside.click();
        hovedsidePage.loggInn.click();
        String actualFornavn =minSidePage.fornavn.getAttribute("value");
        String actualEtternavn =minSidePage.etternavn.getAttribute("value");
        String actualEpost =minSidePage.email.getAttribute("value");
        System.out.println(actualFornavn+" "+actualEtternavn+" : "+actualEpost);
        System.out.println(fornavn1+" "+etternavn1+" : "+epost1);
        softAssert.assertNotEquals(fornavn1,actualFornavn);
        softAssert.assertNotEquals(etternavn1,actualEtternavn);
        softAssert.assertNotEquals(epost1,actualEpost);
        softAssert.assertAll();

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
        List<WebElement> kontoerWE= Driver.getDriver().findElements(By.xpath("//div[starts-with(@class,'_bankcard')]//child::span[starts-with(@class,'_accountName')]"));
        List<String> kontoer= new ArrayList<>();
        for (WebElement w : kontoerWE){
            kontoer.add(w.getText());
        }
        Assert.assertTrue(kontoer.contains(kontonavn));
    }

    @And("Klikk Default")
    public void klikkDefault() {
        ReusableMethods.wait(1);
        minSidePage.defaultButton.click();
        minSidePage.defaultButton.click();
        ReusableMethods.wait(1);
    }

    @And("Bekreft konto {string} ble lagret som default")
    public void bekreftKontoBleLagretSomDefault(String kontonavn) {
        String actualData= Driver.getDriver().findElement(By.xpath("//span[text()='"+kontonavn+"']//parent::div")).getAttribute("class");
        Assert.assertTrue(actualData.contains("blue"));

    }

    @Given("Velg {string} bankkonto")
    public void velgBankkonto(String kontonavn) {
        ReusableMethods.wait(1);
        Driver.getDriver().findElement(By.xpath("//span[text()='"+kontonavn+"']")).click();

    }


    @And("Bekreft konto {string} ble ikke lagret")
    public void bekreftKontoBleIkkeLagret(String kontonavn) {

        List<WebElement> kontoerWE= Driver.getDriver().findElements(By.xpath("//div[starts-with(@class,'_bankcard')]//child::span[starts-with(@class,'_accountName')]"));
        List<String> kontoer= new ArrayList<>();
        for (WebElement w : kontoerWE){
            kontoer.add(w.getText());
        }
        System.out.println("kontoer = " + kontoer);
        Assert.assertFalse(kontoer.contains(kontonavn));
    }


    @And("Bekreft bare et konto som er default")
    public void bekreftBareEtKontoSomErDefault() {
        List<WebElement> defaultKontoer= Driver.getDriver().findElements(By.cssSelector("div[class*='_bankcard_plbd1_1 _blueLight_']"));
        Assert.assertEquals(1, defaultKontoer.size());
    }

    @Then("Klikk Slett konto")
    public void klikkSlettKonto() {
        ReusableMethods.wait(1);
        minSidePage.slettButton.click();
        ReusableMethods.wait(1);
    }

    @And("Bekreft konto {string} ble slettet")
    public void bekreftKontoBleSlettet(String kontonavn) {
        ReusableMethods.wait(1);
        List<WebElement> kontoerWE= Driver.getDriver().findElements(By.xpath("//div[starts-with(@class,'_bankcard')]//child::span[starts-with(@class,'_accountName')]"));
        List<String> kontoer= new ArrayList<>();
        for (WebElement w : kontoerWE){
            kontoer.add(w.getText());
        }
        System.out.println("kontoer = " + kontoer);
        Assert.assertFalse(kontoer.contains(kontonavn));
    }
}
