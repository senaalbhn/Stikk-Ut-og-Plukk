package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HovedsidePage {
    public HovedsidePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //Logg Inn
    @FindBy(css = "div[class*='buttonLogin']")
    public WebElement loggInn;
    @FindBy(css = "input[maxlength='8']")
    public WebElement telefonnummer;
    @FindBy(xpath = "//button[text()='Neste']")
    public WebElement neste;
    @FindBy(xpath = "(//input[@maxlength='4'])[1]")
    public WebElement kode;
    @FindBy(xpath = "//button[text()='Bekreft kode']")
    public WebElement bekreftKode;
    @FindBy(xpath = "//div[text()='sign in verification failed']")
    public WebElement obs;


    @FindBy(xpath = "//p[text()='Logg inn']")
    public WebElement loggInnNede;
    @FindBy(xpath = "//div[@class='column right']//button[text()='Fortsett levering']")
    public WebElement fortsettLevering;
    @FindBy(xpath = "//span[text()='ofte stilte spørsmål']")
    public WebElement ofteStilte;
    @FindBy(xpath = "//a[text()='post@stikkut.no']")
    public WebElement post;
    @FindBy(xpath = "//span[text()='Betingelser']")
    public WebElement betingelser;
    @FindBy(xpath = "//span[text()='Personvern']")
    public WebElement personvern;



}
