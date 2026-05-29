package cz.czechitas.automation.assertion;

import cz.czechitas.automation.ElementFinderInterface;

import javax.annotation.ParametersAreNonnullByDefault;
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

      /* Jak rychle vytvaret POMy:
    vedle sebe prohlizec s SelectorsHub a textak a do textaku misto slovniho popisu psat rovnou identifikatory:

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
