package ru.kopr.demokoprapi2.errors;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ru.kopr.demokoprapi2.constants.ValidationConstants;

import java.util.HashMap;

@RequiredArgsConstructor
@Getter
public enum ErrorCodes {
    UNKNOWN(1, ValidationConstants.UNKNOWN),
    PERSON_NOT_FOUND(2, ValidationConstants.PERSON_NOT_FOUND),
    PERSON_NAME_NOT_NULL(3, ValidationConstants.PERSON_NAME_NOT_NULL),
    PERSON_NAME_SIZE_NOT_VALID(4, ValidationConstants.PERSON_NAME_SIZE_NOT_VALID),
    PERSON_SURNAME_NOT_NULL(5, ValidationConstants.PERSON_SURNAME_NOT_NULL),
    PERSON_SURNAME_SIZE_NOT_VALID(6, ValidationConstants.PERSON_SURNAME_SIZE_NOT_VALID),
    PERSON_GENDER_NOT_NULL(7, ValidationConstants.PERSON_GENDER_NOT_NULL),
    PERSON_BIRTHDATE_NOT_NULL(8, ValidationConstants.PERSON_BIRTHDATE_NOT_NULL),
    PERSON_BIRTHDATE_NOT_BE_PAST(9, ValidationConstants.PERSON_BIRTHDATE_NOT_BE_PAST);

    private static final HashMap<String, Integer> errorCodes = new HashMap<>();

    private final Integer errorCode;

    private final String errorMessage;

    public static Integer getErrorCodeByMessage(String message) {
        return errorCodes.getOrDefault(message, UNKNOWN.getErrorCode());
    }

    static {
        for (ErrorCodes code: ErrorCodes.values()) {
            errorCodes.put(code.getErrorMessage(), code.getErrorCode());
        }
    }
}