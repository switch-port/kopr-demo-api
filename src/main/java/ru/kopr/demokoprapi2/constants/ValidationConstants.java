package ru.kopr.demokoprapi2.constants;

// Интерфейс констант валидации.

public interface ValidationConstants {
    String UNKNOWN = "Unknown";

    String PERSON_NOT_FOUND = "Person not found";

    String PERSON_NAME_SIZE_NOT_VALID = "Person name size should be between 2 and 25";

    String PERSON_NAME_NOT_NULL = "Person name must be is not null";

    String PERSON_SURNAME_SIZE_NOT_VALID = "Person surname size should be between 2 and 25";

    String PERSON_SURNAME_NOT_NULL = "Person surname must be is not null";

    String PERSON_BIRTHDATE_NOT_NULL = "Person birthdate must be is not null";

    String PERSON_GENDER_NOT_NULL = "Person gender must be is not null";

    String PERSON_BIRTHDATE_NOT_BE_PAST = "Person birthdate must be not be past";
}

