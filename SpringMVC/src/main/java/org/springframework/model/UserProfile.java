package org.springframework.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "user_profile")
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profile_id")
    Integer profileId;

    @Column(name = "hobby")
    String hobby;

    @Column(name = "youtube")
    String youTube;

//    @OneToOne(mappedBy = "userProfile", cascade = CascadeType.ALL)//name in user class
    @OneToOne(mappedBy = "userProfile", cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE,
    CascadeType.REFRESH})//name in user class
    User user;
}
