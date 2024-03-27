package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LeverSekkPage {
    public LeverSekkPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//img[@alt='increment']//parent::div")
    public WebElement plus;
    @FindBy(xpath = "//button[starts-with(text(),'Hent sekkekoder for')]")
    public WebElement hentKode;
    @FindBy(css = "span[class^='_fileupload_']")
    public WebElement lastOppBilde;
    @FindBy(css = "div[class='loader']")
    public WebElement loader;
    @FindBy(css = "input[placeholder='Søk etter sted']")
    public WebElement lokasjon;
    @FindBy(css = "select[class*='selectStationDropdown']")
    public WebElement miljostasjon;
    @FindBy(xpath = "//button[text()='Fullfør']")
    public WebElement fullfor;
    @FindBy(xpath = "//button[text()='Tilbake']")
    public WebElement tilbake;
    @FindBy(xpath = "//h3[starts-with(text(),'Er')]")
    public WebElement bekreft;
    @FindBy(xpath = "//button[text()='Ja']")
    public WebElement buttonJa;
    @FindBy(xpath = "//button[text()='Avbryt']")
    public WebElement buttonAvbryt;
    @FindBy(css = "div[class*='logoWrapper']")
    public WebElement stikkUtPlukk;
    @FindBy(css = "div[class*='imageDelete']")
    public WebElement sletteBilde;
    @FindBy(css = "div[class='close']")
    public WebElement lukk;


}
