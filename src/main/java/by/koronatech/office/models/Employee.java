package by.koronatech.office.models;


import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor

public class Employee {
    private Long id;
    private String name;
    private Short salary;
    private String department;
    private boolean manager;
}
