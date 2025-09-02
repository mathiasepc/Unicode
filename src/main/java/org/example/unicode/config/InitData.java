package org.example.unicode.config;

import lombok.AllArgsConstructor;
import org.example.unicode.models.Unicode;
import org.example.unicode.repositories.UnicodeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@AllArgsConstructor
public class InitData implements CommandLineRunner {
    private final UnicodeRepository unicodeRepository;

    @Override
    public void run(String... args) throws Exception {
        List<Unicode> unicodes = new ArrayList<>();

        for (char c = Character.MIN_VALUE; c <= Character.MAX_VALUE; c++) {
            if (Character.isDefined(c) && Character.isLetterOrDigit(c)) {
                Unicode unicode = new Unicode();
                unicode.setCharacter(c);
                unicode.setUnicode((int) c);
                // Fortæller hvilket skriftsystem de er en del af.
                unicode.setSubscription("Skriftsystem: " + Character.UnicodeBlock.of(c).toString());
                unicodes.add(unicode);
            }

            // Det tog for langtid at loade alle millioner af tegn, som der eksisterer.
            if(unicodes.size() == 10000)
                break;
        }

        unicodeRepository.saveAll(unicodes);
    }
}
