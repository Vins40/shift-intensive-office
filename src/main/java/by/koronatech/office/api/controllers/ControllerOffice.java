package by.koronatech.office.api.controllers;

import by.koronatech.office.api.dto.CreateEmployeeDto;
import by.koronatech.office.api.dto.GetDepartamentDto;
import by.koronatech.office.api.dto.GetEmployeeDto;
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

    @GetMapping("/department") // Получение всех отделов
    public List<GetDepartamentDto> divisionsList()
    {
        return services.divisionsList();
    }

    @PostMapping("/add") //Добавление сотрудника в отдел
    public List<GetEmployeeDto> createEmployee (@RequestBody CreateEmployeeDto employeeDto)
    {
        return services.createEmployee(employeeDto);
    }

    @GetMapping("/department/list") // Получение всех сотрудников отдела
    public List<GetEmployeeDto> employeesToDepartmentList(@RequestParam String department)
    {
       return services.employeesToDepartmentList(department);
    }

    @PutMapping("/manager/{id}") //Сделать сотрудника менеджером отдела
    public GetEmployeeDto makeManagerDepartment (@PathVariable Long id)
    {
        return services.makeManagerDepartment(id);
    }
    @PutMapping("/employee/{id}") //Изменение существующей информации о сотруднике
    public List<GetEmployeeDto> changeDataEmployee (@PathVariable Long id, @RequestBody GetEmployeeDto employeeDto)
    {
        return services.changeDataEmployee(id, employeeDto);
    }

    @DeleteMapping("/delete/{id}") //Удаление сотрудника из отдела
    public List<GetEmployeeDto> deleteEmployee (@PathVariable Long id)
    {
            services.delete(id);
            return services.listEmployee();
    }

}
