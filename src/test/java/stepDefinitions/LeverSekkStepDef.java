package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HovedsidePage;
import pages.LeverSekkPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class LeverSekkStepDef {
    HovedsidePage hovedsidePage= new HovedsidePage();
    LeverSekkPage leverSekkPage=new LeverSekkPage();
    Actions actions=new Actions(Driver.getDriver());
    Random random=new Random();
    @Given("Klikk Lever sekk")
    public void klikkLeverSekk() {
        hovedsidePage.leverSekk.click();
    }

    @Then("Velg {string} konto")
    public void velgKonto(String kontonavn) {
        Driver.getDriver().findElement(By.xpath("//span[text()='"+kontonavn+"']//parent::div")).click();
    }

    @And("Velg {int} sekker")
    public void velgSekker(int sekk) {
        for (int i = 0; i < sekk; i++) {
            leverSekkPage.plus.click();
        }
    }

    @And("Klikk Hent sekkekoder")
    public void klikkHentSekkekoder() {
        leverSekkPage.hentKode.click();
    }

    @And("Bekreft er {int} hente koder")
    public void bekreftErHenteKoder(int sekker) {
        List<WebElement> koderWE= Driver.getDriver().findElements(By.cssSelector("div[class^='_bagtagswrapper_'] div div"));
        Assert.assertEquals(sekker,koderWE.size());
    }

    @Then("Last opp {string} bilde")
    public void lastOppBilde(String bilde) {
        leverSekkPage.lastOppBilde.click();
        ReusableMethods.wait(1);
        String filbane = "C:\\Users\\SenaAlbahan\\Downloads\\" + bilde + ".jpg";
        ReusableMethods.uploadFile(filbane);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.invisibilityOf(leverSekkPage.loader));
    }

    @Then("Velg {string} lokasjon")
    public void velgLokasjon(String lokasjon) {
        leverSekkPage.lokasjon.sendKeys(lokasjon);

    }

    @Then("Velg miljostasjon")
    public void velgMiljostasjon() {
        List<WebElement> stasjoner= Driver.getDriver().findElements(By.cssSelector("select option"));
        ReusableMethods.ddmIndex(leverSekkPage.miljostasjon,random.nextInt(stasjoner.size()));
    }

    @And("Klikk Fullfor")
    public void klikkFullfor() {
        leverSekkPage.fullfor.click();
    }

    @And("Bekreft sekker ble levert")
    public void bekreftSekkerBleLevert() {
        Assert.assertEquals("Er du klar for å levere?",leverSekkPage.bekreft.getText());
        leverSekkPage.buttonJa.click();
    }

    @Given("Klikk Stikk ut og plukk")
    public void klikkStikkUtOgPlukk() {
        ReusableMethods.wait(1);
        leverSekkPage.stikkUtPlukk.click();
        ReusableMethods.wait(1);
    }

    @And("Bekreft sekker ble ikke levert")
    public void bekreftSekkerBleIkkeLevert() {
        String allert= Driver.getDriver().switchTo().alert().getText();
        Assert.assertTrue(allert.contains("Du har ikke fylt inn all nødvendig informasjon"));
    }

    @And("Klikk Tilbake")
    public void klikkTilbake() {
        leverSekkPage.tilbake.click();
    }

    @Then("Klikk Slette bilde")
    public void klikkSletteBilde() {
        leverSekkPage.sletteBilde.click();
        leverSekkPage.buttonJa.click();
        Driver.getDriver().switchTo().alert().accept();
    }

    @And("Bekreft bilde slettet")
    public void bekreftBildeSlettet() {
        WebElement bekreft= Driver.getDriver().findElement(By.cssSelector("div[class='image-placeholder__text']"));
        Assert.assertEquals("Ingen bilder",bekreft.getText());
    }

    @Then("Klikk Slette lokasjon")
    public void klikkSletteLokasjon() {
    }

    @And("Bekreft lokasjon slettet")
    public void bekreftLokasjonSlettet() {
    }

    @And("Klikk Lukk")
    public void klikkLukk() {
        leverSekkPage.lukk.click();
    }


    @Given("Klikk Fortsat Levering")
    public void klikkFortsatLevering() {
        hovedsidePage.fortsettLevering.click();
    }
}
