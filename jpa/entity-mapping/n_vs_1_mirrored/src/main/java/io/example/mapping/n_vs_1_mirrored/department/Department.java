package io.example.mapping.n_vs_1_mirrored.department;

import io.example.mapping.n_vs_1_mirrored.employee.Employee;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
@SequenceGenerator(
    schema = "public",
    sequenceName = "DEPT_SEQ",
    name = "department_seq",
    initialValue = 1,
    allocationSize = 1
)
@Table(name = "DEPARTMENT", schema = "public")
public class Department {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "DEPT_ID")
    private Long id;

    @Column(name = "DEPT_NAME")
    private String deptName;

    @OneToMany(mappedBy = "dept")
    private List<Employee> employees = new ArrayList<>();


    @Builder(builderMethodName = "defaultBuilder")
    public Department(String deptName) {
        this.deptName = deptName;
    }

}
