package ru.kopr.demokoprapi2.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomSuccessResponse<T> {
    private T data;

    private Integer statusCode = 0;

    private Boolean statusSuccess = true;

    private List<Integer> statusCodesList;

    private List<String> errorMessagesList;

    public CustomSuccessResponse(T data) {
        this.data = data;
    }

    public CustomSuccessResponse(Integer statusCode, List<Integer> statusCodesList, List<String> errorMessagesList, Boolean statusSuccess) {
        this.statusCode = statusCode;
        this.statusCodesList = statusCodesList;
        this.errorMessagesList = errorMessagesList;
        this.statusSuccess = statusSuccess;
    }
}
