package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MinSidePage {
    public MinSidePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//label[text()='Fornavn']//parent::div[@class='_inputgroup_125ea_1']//child::input[@class='_input_125ea_1']")
    public WebElement fornavn;
    @FindBy(xpath = "//label[text()='Etternavn']//parent::div[@class='_inputgroup_125ea_1']//child::input[@class='_input_125ea_1']")
    public WebElement etternavn;
    @FindBy(xpath = "//label[text()='Epost-adresse']//parent::div[@class='_inputgroup_125ea_1']//child::input[@class='_input_125ea_1']")
    public WebElement email;
    @FindBy(xpath = "//label[text()='Telefonnummer']//parent::div[@class='_inputgroup_125ea_1']//child::input[@class='_input_125ea_1']")
    public WebElement telefonnummer;
    @FindBy(xpath = "//button[text()='Lagre']")
    public WebElement lagre;
    @FindBy(xpath = "//div[text()='Legg til bankkonto']")
    public WebElement leggTilBankkonto;
    @FindBy(xpath = "//label[text()='Kontonavn']//parent::div[@class='_inputgroup_125ea_1']//child::input[@class='_input_125ea_1']")
    public WebElement kontoNavn;
    @FindBy(xpath = "//label[text()='Bankkonto']//parent::div[@class='_inputgroup_125ea_1']//child::input[@class='_input_125ea_1']")
    public WebElement kontonummer;
    @FindBy(css = "label[class*='switch'] input")
    public WebElement defaultButton;
    @FindBy(xpath = "//button[text()='Logg ut']")
    public WebElement loggUt;
    @FindBy(xpath = "//a[text()='Vilkår']")
    public WebElement vilkor;
    @FindBy(xpath = "//a[text()='Personvern']")
    public WebElement personvern;
    @FindBy(css = "div[class='_logoWrapper_1x3qn_1']")
    public WebElement hovedside;


}
