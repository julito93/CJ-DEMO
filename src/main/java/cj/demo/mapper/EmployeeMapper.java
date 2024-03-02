package cj.demo.mapper;

import cj.demo.bo.EmployeeBO;
import cj.demo.model.Employee;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(
    componentModel = ComponentModel.SPRING
)
public interface EmployeeMapper {

    List<EmployeeBO> toBOList(List<Employee> employee);
}
