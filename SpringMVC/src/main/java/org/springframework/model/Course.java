package org.springframework.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    Integer courseId;

    @Column(name = "name")
    String name;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    User user;

}
