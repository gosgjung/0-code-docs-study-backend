package io.example.mapping.n_vs_1_mirrored.mapping_test;

import io.example.mapping.n_vs_1_mirrored.department.Department;
import io.example.mapping.n_vs_1_mirrored.employee.Employee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@SpringBootTest
@Transactional
public class MappingTestOnlyEmployeeTest {

    @Autowired
    EntityManager em;

    @Test
    @DisplayName("연관관계 편의메서드 테스트")
    public void TEST1(){
        Department deptTrader = Department.defaultBuilder()
                .deptName("TRADER")
                .build();

        Department deptSinger = Department.defaultBuilder()
                .deptName("SINGER")
                .build();

        em.persist(deptTrader);
        em.persist(deptSinger);

        Employee peter = Employee.defaultBuilder().name("Peter Lynch").dept(deptTrader).build();
        Employee buffet = Employee.defaultBuilder().name("Warren Buffet").dept(deptTrader).build();
        Employee beatles = Employee.defaultBuilder().name("Beatles").dept(deptSinger).build();

        em.persist(peter);
        em.persist(buffet);
        em.persist(beatles);

        em.flush();
        System.out.println("Trader 직원 수 : " + deptTrader.getEmployees().size());
        System.out.println("Singer 직원 수 : " + deptSinger.getEmployees().size());
    }
}
