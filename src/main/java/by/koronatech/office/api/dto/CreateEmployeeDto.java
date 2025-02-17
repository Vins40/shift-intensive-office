package by.koronatech.office.api.dto;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
public class CreateEmployeeDto {
    private String name;
    private Short salary;
    private String department;
    private boolean manager;
}
