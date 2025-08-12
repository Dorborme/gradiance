package com.uwec.gradiance.database;

import com.uwec.gradiance.model.RoleEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

public class enrollments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "enrollment_id")
    @Getter
    private Long enrollment_id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="course_id", referencedColumnName = "course_id")
    private courses course_id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", referencedColumnName = "student_id")
    private Users student_id;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    @Getter
    @Setter
    private RoleEnum role;

    //constructors
    public enrollments(courses course_id, Users student_id, RoleEnum role){
        this.course_id = course_id;
        this.student_id = student_id;
        this.role = role;
    }
}
