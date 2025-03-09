package ru.kopr.demokoprapi2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kopr.demokoprapi2.model.PersonEntity;

public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
}
