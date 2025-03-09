package ru.kopr.demokoprapi2.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kopr.demokoprapi2.dto.request.PersonCreateRequest;
import ru.kopr.demokoprapi2.dto.request.PersonUpdateRequest;
import ru.kopr.demokoprapi2.errors.CustomException;
import ru.kopr.demokoprapi2.errors.ErrorCodes;
import ru.kopr.demokoprapi2.model.PersonEntity;
import ru.kopr.demokoprapi2.repository.PersonRepository;
import ru.kopr.demokoprapi2.service.PersonService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;

    @Override
    public List<PersonEntity> getAllPersons() {
        return personRepository.findAll();
    }

    @Override
    public PersonEntity getPersonById(Long id) {
        return personRepository.findById(id).orElseThrow(() -> new CustomException(ErrorCodes.PERSON_NOT_FOUND));
    }

    /**
     * Перекладываем провалидированные данные из дто в сущность и сохраняем
     * */
    @Override
    public void addPerson(PersonCreateRequest createRequest) {
        PersonEntity personEntity = new PersonEntity();

        personEntity.setName(createRequest.name());
        personEntity.setSurname(createRequest.surname());
        personEntity.setGender(createRequest.gender());
        personEntity.setBirthDate(createRequest.birthDate());

        personRepository.save(personEntity);
    }

    @Override
    public void updateById(PersonUpdateRequest request, Long id) {
        Optional<PersonEntity> personEntityOptional = personRepository.findById(id);

        if (personEntityOptional.isPresent()) {
            PersonEntity personEntity = new PersonEntity();

            personEntity.setId(id);

            personEntity.setName(
                    request.name() == null
                        ? personEntityOptional.get().getName()
                        : request.name()
            );

            personEntity.setSurname(
                    request.surname() == null
                        ? personEntityOptional.get().getSurname()
                        : request.surname()
            );

            personEntity.setGender(
                    request.gender() == null
                        ? personEntityOptional.get().getGender()
                        : request.gender()
            );

            personEntity.setBirthDate(
                    request.birthDate() == null
                        ? personEntityOptional.get().getBirthDate()
                        : request.birthDate()
            );

            personRepository.save(personEntity);
        } else {
            throw new CustomException(ErrorCodes.PERSON_NOT_FOUND);
        }
    }

    @Override
    public void deleteById(Long id) {
        Optional<PersonEntity> personEntityOptional = personRepository.findById(id);

        if (personEntityOptional.isPresent()) {
            personRepository.deleteById(id);
        } else {
            throw new CustomException(ErrorCodes.PERSON_NOT_FOUND);
        }
    }
}
