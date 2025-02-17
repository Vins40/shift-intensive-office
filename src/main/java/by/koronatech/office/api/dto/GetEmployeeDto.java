package by.koronatech.office.api.dto;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@RequiredArgsConstructor
public class GetEmployeeDto {
    private Long id;
    private String name;
    private Short salary;
    private String department;
    private boolean manager;

}
