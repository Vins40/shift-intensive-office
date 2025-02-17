package by.koronatech.office.mapping.department;

import by.koronatech.office.api.dto.GetDepartamentDto;
import by.koronatech.office.mapping.BaseMapper;
import by.koronatech.office.models.Department;
import org.mapstruct.*;

import java.util.List;

@Mapper(config = BaseMapper.class, componentModel = "spring")
public interface GetDepartmentMapper extends BaseMapper <Department, GetDepartamentDto>

{
    @Override
    GetDepartamentDto toDto(Department department);

    @Override
    List<GetDepartamentDto> toDtos(Iterable<Department> list);

}
