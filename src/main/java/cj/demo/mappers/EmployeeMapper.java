package cj.demo.mappers;

import cj.demo.bo.EmployeeBO;
import cj.demo.models.Employee;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = ComponentModel.SPRING,
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface EmployeeMapper {

    List<EmployeeBO> toBOList(List<Employee> employee);
}
