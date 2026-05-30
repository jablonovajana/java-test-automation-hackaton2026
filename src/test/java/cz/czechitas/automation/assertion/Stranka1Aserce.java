package cz.czechitas.automation.assertion;

import cz.czechitas.automation.ElementFinderInterface;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.NoSuchElementException;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Application specific assertions
 *
 * @author Jiri Koudelka
 * @since 1.0.0
 */
@ParametersAreNonnullByDefault
public final class Stranka1Aserce {

    private final ElementFinderInterface elementFinder;

    public Stranka1Aserce(ElementFinderInterface elementFinder)
    {
        this.elementFinder = Objects.requireNonNull(elementFinder);
    }

    public void checkPaymentMethod(String paymentMethod) {
        var paymentMethodElement = elementFinder.findByXPath("//table/tbody//td[text()='Způsoby úhrady kurzu:']/..//strong");
        assertThat(paymentMethodElement.getText()).isEqualTo(paymentMethod);
    }

    public void cekniNeco(String hodnota) {
        var elem = elementFinder.findByXPath("");
        assertTrue(elem.getText().contains(""));
    }

    public void cekniPrihlaseno() {
        // Pritomnost ikony panacka vpravo nahore; panacek je svg, mozne problemy.
        // Hm, tak to nevyslo, nenajde ten element.
        // Tak radsi testovani na nepritomnost tlacitka Prihlasit se
        // V to ale narazim na to, ze low-code framework mi tu zpristupnuje jenom elementFinder
        // a na ostatni fce Selenia se ted nevim jak dostat. Takze misto stourani se v Jave jsem to udelala takto
        // inspirace: https://stackoverflow.com/questions/6353259/how-do-i-verify-that-an-element-does-not-exist-in-selenium-2
        var elemFound = true;
        try {
            var elem = elementFinder.findByXPath("//button[contains(text(),'Přihlásit se')]");
            // System.out.println("element asi nalezen");
        } catch (Exception e) { // (org.openqa.selenium.NoSuchElementException e) {
            elemFound = false;
            // System.out.println("jsme v catchi");
        }
        assertTrue(!elemFound);
        // element should not be visible

    }

      /* Jak rychle vytvaret POMy:
    vedle sebe prohlizec s SelectorsHub a IDE a misto slovniho popisu psat rovnou identifikatory:

    a klikTlacZaregistrovat b xpathhhhhhh c
    a vepisInputboxKontrolaHesla b xpathhhhhhhh c

    Potom replace
    a->public void,
    b-> () {
        var elem = elementFinder.findByXPath("
    c-> ");
        assertThat(elem.getText()).contains("");
    }

    nebo elem.clear, elem.sendKeys, ... dropbox je slozitejsi
     */
}
