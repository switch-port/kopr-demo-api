package ru.kopr.demokoprapi2.dto.request;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.With;
import ru.kopr.demokoprapi2.constants.ValidationConstants;

import java.time.LocalDate;

@With
public record PersonUpdateRequest(
        //Валидация принимаемых данных
        @Size(min = 2, max = 50, message = ValidationConstants.PERSON_NAME_SIZE_NOT_VALID)
        String name,

        @Size(min = 2, max = 50, message = ValidationConstants.PERSON_SURNAME_SIZE_NOT_VALID)
        String surname,

        Boolean gender,

        @Past(message = ValidationConstants.PERSON_BIRTHDATE_NOT_BE_PAST)
        LocalDate birthDate
) {
}
