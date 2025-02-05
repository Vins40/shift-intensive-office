package by.koronatech.office.api.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class GetEmployeeDto {
    private Long id;
    private String name;
    private Short salary;
    private String department;
    private boolean manager;
}
