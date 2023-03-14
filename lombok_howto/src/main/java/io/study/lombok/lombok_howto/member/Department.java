package io.study.lombok.lombok_howto.member;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data
public class Department {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String deptName;

    @OneToMany(mappedBy = "department")
    private List<Member> members = new ArrayList<>();
}
