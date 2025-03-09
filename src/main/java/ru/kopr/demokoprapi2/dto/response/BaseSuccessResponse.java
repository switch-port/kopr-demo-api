package ru.kopr.demokoprapi2.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class BaseSuccessResponse {
    private Integer statusCode = 0;
    private Boolean statusSuccess = true;
}
