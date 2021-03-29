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
    String profileId;

    @Column(name = "hobby")
    String hobby;

    @Column(name = "youtube")
    String youTube;
}
