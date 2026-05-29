package cz.czechitas.automation;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Objects;

/**
 * Profile specific selenium actions
 *
 * @author Jiri Koudelka
 * @since 1.0.0
 */
@ParametersAreNonnullByDefault
final class Stranka2Akce {

    private final ElementFinder elementFinder;

    Stranka2Akce(ElementFinder elementFinder) {
        this.elementFinder = Objects.requireNonNull(elementFinder);
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

    nebo elem.clear, elem.sendKeys, ... dropbox je slozitejsi
     */

}
