package cj.demo.bo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EmployeeBO {

    private Long id;
    private String name;
    private Float monthlyAmount;
    private Boolean statusActive;

    // Constructors, additional methods, and other annotations can be added as needed

    @Override
    public String toString() {
        return "Employee{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", monthlyAmount=" + monthlyAmount +
            ", statusActive=" + statusActive +
            '}';
    }
}
