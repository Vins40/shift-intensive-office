package by.koronatech.office.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Employee {
    private Long id;
    private String name;
    private Short salary;
    private String department;
    private boolean manager;
}
