package by.koronatech.office.services;

import by.koronatech.office.api.dto.CreateEmployeeDto;
import by.koronatech.office.api.dto.GetEmployeeDto;
import by.koronatech.office.interfaces.EmployeeServices;
import by.koronatech.office.models.Department;
import by.koronatech.office.models.Employee;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Getter
public class EmployeeServicesImpl implements EmployeeServices {

    private List <Employee> listEmployee = new ArrayList<>();


    private final List<Department> cacheDepartment = new ArrayList<>(List.of(
        Department.builder().id(1L).name("Ohrana truda").build(),
        Department.builder().id(2L).name("Programmer").build(),
        Department.builder().id(3L).name("Desing").build()));

    @Override
    public List<Department> divisionsList() {
        return getCacheDepartment();
    }

    @Override
    public GetEmployeeDto createEmployee(Long id, CreateEmployeeDto employeeDto) {
        return null;
    }

    @Override
    public List<GetEmployeeDto> employeesToDepartmentList(Long id) {
        return null;
    }

    @Override
    public GetEmployeeDto changeRangEmployee(Long id, boolean manager) {
        return null;
    }

    @Override
    public GetEmployeeDto changeDataEmployee(Long id, CreateEmployeeDto employeeDto) {
        return null;
    }

    @Override
    public GetEmployeeDto changeRangEmployee(Long id) {
        return null;
    }

    private Employee findById (Long id)
    {
        return listEmployee.stream().filter(employee -> employee.getId().equals(id))
            .findFirst()
            .orElseThrow(() -> new RuntimeException(String.format("Пользователя с id: %s не найден", id)));
    }
}
