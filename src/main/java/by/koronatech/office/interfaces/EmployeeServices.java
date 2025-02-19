package by.koronatech.office.interfaces;

import by.koronatech.office.api.dto.CreateEmployeeDto;
import by.koronatech.office.api.dto.GetDepartamentDto;
import by.koronatech.office.api.dto.GetEmployeeDto;

import java.util.List;

public interface EmployeeServices {

    List<GetDepartamentDto> divisionsList();

    GetDepartamentDto returnDepart(int id);


    List<GetEmployeeDto> createEmployee (CreateEmployeeDto employeeDto, Integer page, Integer size) throws IllegalAccessException;


    List<GetEmployeeDto> employeesToDepartmentList(String department);


    GetEmployeeDto makeManagerDepartment(Long id);




    List<GetEmployeeDto> changeDataEmployee (Long id, GetEmployeeDto employeeDto);


    void delete (Long id);

}

