package com.uwec.gradiance.database;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Users") // Case-sensitive for H2!
public class Users {

    public Users() {
        // Default constructor for JPA
    }

    public Users(String email, String finalHash) {
        this.email = email;
        this.password = finalHash;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "article_gen")
    @SequenceGenerator(name="article_gen", sequenceName="user_serverid_seq")
    @Column(name = "user_id")
    @Getter
    @Setter
    private Long user_id;

    @Column(name = "student_id", unique = true, length = 20)
    @Getter
    @Setter
    private String studentId;

    @Column(name = "first_name", length = 50)
    @Getter
    @Setter
    private String firstName;

    @Column(name = "middle_initial", length = 1)
    @Getter
    @Setter
    private String middleInitial;

    @Column(name = "last_name", length = 50)
    @Getter
    @Setter
    private String lastName;

    @Column(name = "email", nullable = false, unique = true, length = 100)
    @Getter
    @Setter
    private String email;

    @Column(name = "password_hash", nullable = false)
    @Getter
    @Setter
    private String password;

    @Column(name = "admin_rights", nullable = false)
    @Getter
    @Setter
    private int adminRights;

    // === Getters and Setters ===

    // Methods
}
