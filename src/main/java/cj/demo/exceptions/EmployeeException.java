package cj.demo.exceptions;

import java.io.Serial;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class EmployeeException extends Exception{

    @Serial
    private static final long serialVersionUID = -662323679246543540L;
    private long employeeId;

}
