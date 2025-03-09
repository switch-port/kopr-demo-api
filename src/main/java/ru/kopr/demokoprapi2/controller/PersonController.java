package ru.kopr.demokoprapi2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.kopr.demokoprapi2.dto.request.PersonCreateRequest;
import ru.kopr.demokoprapi2.dto.request.PersonUpdateRequest;
import ru.kopr.demokoprapi2.dto.response.BaseSuccessResponse;
import ru.kopr.demokoprapi2.dto.response.CustomSuccessResponse;
import ru.kopr.demokoprapi2.model.PersonEntity;
import ru.kopr.demokoprapi2.service.PersonService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/person")
@Validated
public class PersonController {
    private final PersonService personService;

    @GetMapping("get_all")
    public ResponseEntity<CustomSuccessResponse<List<PersonEntity>>> getAllPersons() {
        return ResponseEntity.ok(new CustomSuccessResponse<>(personService.getAllPersons()));
    }

    @GetMapping("get_by_id/{id}")
    public ResponseEntity<CustomSuccessResponse<PersonEntity>> getPersonById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(new CustomSuccessResponse<>(personService.getPersonById(id)));
    }

    @PostMapping("add")
    public ResponseEntity<BaseSuccessResponse> addPerson(@Validated @RequestBody PersonCreateRequest person) {
        personService.addPerson(person);
        return ResponseEntity.ok(new BaseSuccessResponse());
    }

    @PutMapping("update_by_id/{id}")
    public ResponseEntity<BaseSuccessResponse> updatePersonById(@Validated @RequestBody PersonUpdateRequest person, @PathVariable Long id) {
        personService.updateById(person, id);
        return ResponseEntity.ok(new BaseSuccessResponse());
    }

    @DeleteMapping("delete_by_id/{id}")
    public ResponseEntity<BaseSuccessResponse> deletePersonById(@PathVariable("id") Long id) {
        personService.deleteById(id);
        return ResponseEntity.ok(new BaseSuccessResponse());
    }
}
