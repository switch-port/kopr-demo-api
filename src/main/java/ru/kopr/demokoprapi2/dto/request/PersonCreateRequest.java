package ru.kopr.demokoprapi2.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.With;
import ru.kopr.demokoprapi2.constants.ValidationConstants;

import java.time.LocalDate;

@With
public record PersonCreateRequest(
        //Валидация принимаемых данных
        @NotBlank(message = ValidationConstants.PERSON_NAME_NOT_NULL)
        @Size(min = 2, max = 50, message = ValidationConstants.PERSON_NAME_SIZE_NOT_VALID)
        String name,

        @Size(min = 2, max = 50, message = ValidationConstants.PERSON_SURNAME_SIZE_NOT_VALID)
        @NotBlank(message = ValidationConstants.PERSON_SURNAME_NOT_NULL)
        String surname,

        @NotNull(message = ValidationConstants.PERSON_GENDER_NOT_NULL)
        Boolean gender,

        @Past(message = ValidationConstants.PERSON_BIRTHDATE_NOT_BE_PAST)
        @NotNull(message = ValidationConstants.PERSON_BIRTHDATE_NOT_NULL)
        LocalDate birthDate
) {}
