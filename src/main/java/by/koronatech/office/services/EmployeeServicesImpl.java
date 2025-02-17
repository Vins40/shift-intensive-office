package by.koronatech.office.services;

import by.koronatech.office.api.dto.CreateEmployeeDto;
import by.koronatech.office.api.dto.GetDepartamentDto;
import by.koronatech.office.api.dto.GetEmployeeDto;
import by.koronatech.office.interfaces.EmployeeServices;
import by.koronatech.office.mapping.department.GetDepartmentMapper;
import by.koronatech.office.mapping.emplyoee.CreateEmployeeMapper;
import by.koronatech.office.mapping.emplyoee.GetEmployeeMapper;
import by.koronatech.office.models.Department;
import by.koronatech.office.models.Employee;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeServicesImpl implements EmployeeServices  {

    private static long id =0;

   private final CreateEmployeeMapper createEmployeeMapper;

   private final GetEmployeeMapper getEmployeeMapper;

    private final GetDepartmentMapper getDepartmentMapper;

    private List<Employee> listEmployee = new ArrayList<>();


    private final List<Department> cacheDepartment = new ArrayList<>(List.of(
        Department.builder().id(1L).name("Hi-Tech").build(),
        Department.builder().id(2L).name("Programmer").build(),
        Department.builder().id(3L).name("Design").build(),
        Department.builder().id(4L).name("OTK").build()));

    @Override
    public List<GetDepartamentDto> divisionsList() {
        return getDepartmentMapper.toDtos(cacheDepartment);
    }

    @Override
    public GetDepartamentDto returnDepart(int id) {
        return getDepartmentMapper.toDto(cacheDepartment.get(id));
    }

    @Override
    public List<GetEmployeeDto> createEmployee(CreateEmployeeDto employeeDto) {

        if(employeeDto.getName()==null||employeeDto.getSalary()==null||employeeDto.getDepartment()==null)
        {
            throw new RuntimeException("Попытка ввода не существуещего работника!!!");
        }
        Employee employee = createEmployeeMapper.toEntity(employeeDto);
        employee.setId(id);
        listEmployee.add(employee);
        id++;
        return getEmployeeMapper.toDtos(listEmployee);
    }

    @Override
    public List<GetEmployeeDto> employeesToDepartmentList(String depart) {
        List<GetEmployeeDto> list = getEmployeeMapper.toDtos(listEmployee.stream().filter(department -> department.getDepartment().equals(depart))
                .collect(Collectors.toList()));
        System.out.println(list);
        return list;

    }


    @Override
    public GetEmployeeDto makeManagerDepartment(Long id) {
       int index = 0;
        for(Employee e : listEmployee)
        {
            if(e.getId().equals(id))
            {
                e.setManager(true);
                listEmployee.set(index, e);
                break;
            }
            index++;
        }

      return getEmployeeMapper.toDto(listEmployee.get(index));

    }

    @Override
    public List<GetEmployeeDto> changeDataEmployee(Long id, GetEmployeeDto employeeDto) {
        Employee employee = findById(id);
        getEmployeeMapper.merge(employee, employeeDto);
        return getEmployeeMapper.toDtos(listEmployee);
    }



    @Override
    public void delete(Long id) {
        listEmployee.remove(findById(id));
    }


    private Employee findById(Long id) {
        return listEmployee.stream().filter(employee -> employee.getId().equals(id))
            .findFirst()
            .orElseThrow(() -> new RuntimeException(String.format("Пользователя с id: %s не найден", id)));
    }

    public List<GetEmployeeDto> listEmployee()
    {
        return getEmployeeMapper.toDtos(listEmployee);
    }
}
