package by.koronatech.office.interfaces;

import by.koronatech.office.api.dto.CreateEmployeeDto;
import by.koronatech.office.api.dto.GetEmployeeDto;
import by.koronatech.office.models.Department;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface EmployeeServices {

    List<Department> divisionsList();


    GetEmployeeDto createEmployee (Long id, CreateEmployeeDto employeeDto);


    List<GetEmployeeDto> employeesToDepartmentList(Long id);


    GetEmployeeDto changeRangEmployee (Long id, boolean manager);


    GetEmployeeDto changeDataEmployee (Long id,  CreateEmployeeDto employeeDto);


    GetEmployeeDto changeRangEmployee (Long id);
}

