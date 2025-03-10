package ru.kopr.demokoprapi2.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(schema = "public", name = "persons")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private Boolean gender;
    private LocalDate birthDate;

    private PersonEntity(Long id, String name, String surname, Boolean gender, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.birthDate = birthDate;
    }

    public static PersonEntity fromParams(Long id, String name, String surname, Boolean gender, LocalDate birthDate) {
        return new PersonEntity(id, name, surname, gender, birthDate);
    }

    public static PersonEntity fromParams(String name, String surname, Boolean gender, LocalDate birthDate) {
        return new PersonEntity(null, name, surname, gender, birthDate);
    }
}