package cz.czechitas.automation;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Objects;

/**
 * Login/logout specific selenium actions
 *
 * @author Jiri Koudelka
 * @since 1.0.0
 */
@ParametersAreNonnullByDefault
final class RegisterAction {

    private final ElementFinder elementFinder;

    RegisterAction(ElementFinder elementFinder)
    {
        this.elementFinder = Objects.requireNonNull(elementFinder);
    }

    // JanaJ
    /* [19.5.2026 po] :
        Registrace noveho uzivatele - postup klikani na webu:
        0. baseUrl
        1. klik vpravo nahore link "Prihlasit"
        2. klik uprostred tlac "Zaregistrujte se" (wait)
        3. vepis inputboxy Jmeno a prijmeni, Email, Heslo, Kontrola hesla
        4. klik tlac "Zaregistrovat"
     */
    // na https://lecturers.datcj26.czechitas.online
    void klikLinkPrihlasit() {
        var elem = elementFinder.findByXPath("(//a[contains(@class,'nav-item nav-link')])[3]");
        elem.click();
    }
    void klikTlacZaregistrujteSe() {
        var elem = elementFinder.findByXPath("//a[normalize-space()='Zaregistrujte se']");
        elem.click();
    }

    // na https://lecturers.datcj26.czechitas.online/registrace:
    void vepisJmenoPrijmeni(String text) {
        var elem = elementFinder.findByXPath("//input[@id='name']");
        elem.sendKeys(text);
    }
    void vepisInputboxEmail(String text) {
        var elem = elementFinder.findByXPath("//input[@id='email']");
        elem.sendKeys(text);
    }
    void vepisInputboxHeslo(String text) {
        var elem = elementFinder.findByXPath("//input[@id='password']");
        elem.sendKeys(text);
    }
    void vepisInputboxKontrolaHesla(String text) {
        var elem = elementFinder.findByXPath("//input[@id='password-confirm']");
        elem.sendKeys(text);
    }
    void klikTlacZaregistrovat() {
        var elem = elementFinder.findByXPath("//button[normalize-space()='Zaregistrovat']");
        elem.click();
    }


    /* Jak rychle vytvaret POMy:
    vedle sebe prohlizec s SelectorsHub a textak a do textaku misto slovniho popisu psat rovnou identifikatory:
    a klikTlacZaregistrovat b xpathhhhhhh c
    a vepisInputboxKontrolaHesla b xpathhhhhhhh c

    Potom replace
    a->void,
    b-> () {
        var elem = elementFinder.findByXPath("
    c-> ");
        elem.click();
    }
     */
}
