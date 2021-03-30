package org.springframework.model;

import lombok.Data;

import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "user")
@Transactional
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    Integer userId;

    @NotNull
    @Column(name = "name")
    String name;

    @NotNull
    @Column(name = "age")
    Integer age;

    @NotNull
    @Column(name = "email")
    String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id") //name specified in table as foreign key
    UserProfile userProfile;

    @OneToMany(mappedBy = "user",cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE,CascadeType.DETACH})
    List<Course> courses;

    public void addUserToCourse(Course course){

        if (courses == null){
            courses = new ArrayList<>();
        }
        course.setUser(this);
        courses.add(course);
    }

}
