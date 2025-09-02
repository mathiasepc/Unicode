package org.example.unicode.repositories;

import org.example.unicode.models.Unicode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UnicodeRepository extends JpaRepository<Unicode, Integer> {
    Optional<Unicode> findByUnicode(int unicode);
    Optional<Unicode> findByCharacter(char character);

}
