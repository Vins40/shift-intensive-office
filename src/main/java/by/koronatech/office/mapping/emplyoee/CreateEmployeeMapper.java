package by.koronatech.office.mapping.emplyoee;

import by.koronatech.office.api.dto.CreateEmployeeDto;
import by.koronatech.office.api.dto.GetEmployeeDto;
import by.koronatech.office.mapping.BaseMapper;
import by.koronatech.office.models.Employee;
import org.mapstruct.*;

@Mapper(config = BaseMapper.class, componentModel = "spring")
public interface CreateEmployeeMapper extends BaseMapper<Employee, CreateEmployeeDto> {


    @Override
    Employee toEntity(CreateEmployeeDto getEmployeeDto);


}
