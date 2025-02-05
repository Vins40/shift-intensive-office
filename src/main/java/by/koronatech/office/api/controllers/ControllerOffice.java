package by.koronatech.office.api.controllers;

import by.koronatech.office.api.dto.CreateEmployeeDto;
import by.koronatech.office.api.dto.GetEmployeeDto;
import by.koronatech.office.models.Department;
import by.koronatech.office.services.EmployeeServicesImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/office")
@Slf4j
@RequiredArgsConstructor
public class ControllerOffice {

    private final EmployeeServicesImpl services;

    @GetMapping("department") // Получение всех отделов
    public List<Department> divisionsList()
    {
        return services.divisionsList();
    }

    @PostMapping("{id}") //Добавление сотрудника в отдел где id 'это id отдела
    public GetEmployeeDto createEmployee (@PathVariable Long id, @RequestBody CreateEmployeeDto employeeDto)
    {
        return new GetEmployeeDto(null, null, null, null, false);
    }

    @GetMapping("department/{id}") // Получение всех сотрудников отдела
    public List<GetEmployeeDto> employeesToDepartmentList(@PathVariable Long id)
    {
        return null;
    }

    @PutMapping("{id}") //Сделать сотрудника менеджером отдела
    public GetEmployeeDto changeRangEmployee (@PathVariable Long id, @RequestParam boolean manager)
    {
        return new GetEmployeeDto(null, null, null, null, false);
    }
    @PutMapping("employee/{id}") //Изменение существующей информации о сотруднике
    public GetEmployeeDto changeDataEmployee (@PathVariable Long id, @RequestBody CreateEmployeeDto employeeDto)
    {
        return new GetEmployeeDto(null, null, null, null, false);
    }

    @DeleteMapping("delete/{id}") //Удаление сотрудника из отдела
    public void deleteEmployee (@PathVariable Long id)
    {

    }

}
