package ru.kopr.demokoprapi2.service;

import ru.kopr.demokoprapi2.dto.request.PersonCreateRequest;
import ru.kopr.demokoprapi2.dto.request.PersonUpdateRequest;
import ru.kopr.demokoprapi2.model.PersonEntity;

import java.util.List;

public interface PersonService {
    List<PersonEntity> getAllPersons();

    PersonEntity getPersonById(Long id);

    void addPerson(PersonCreateRequest person);

    void updateById(PersonUpdateRequest person, Long id);

    void deleteById(Long id);
}
