package com.ssafy.joblog.domain.user.entity;


import com.ssafy.joblog.domain.board.entity.Post;
import com.ssafy.joblog.domain.board.entity.PostComment;
import com.ssafy.joblog.domain.board.entity.PostCommentLike;
import com.ssafy.joblog.domain.board.entity.PostLike;
import com.ssafy.joblog.global.entity.BaseEntity;
import com.ssafy.joblog.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String email;

    @Enumerated(EnumType.STRING)
    private UserRole role; //유저역할 [ROLE_ADMIN, ROLE_APPLICANT, ROLE_JUNIOR, ROLE_MIDDLE, ROLE_SENIOR, ROLE_EXPERT]

    private String provider;
    private String providerId;

    private String nickname;
    private String objective;
    private String realName;
    private String englishName;
    private String address;
    private String userEmail;
    private String profileImageName;
    private String profileImageUrl;
    private String phoneNumber;
    private Date birthDate;

    //연관관계 주인x
    @OneToMany(mappedBy = "user")
    private List<Post> posts = new ArrayList<>();

    //연관관계 주인x
    @OneToMany(mappedBy = "user")
    private List<PostComment> comments = new ArrayList<>();

    //연관관계 주인x
    @OneToMany(mappedBy = "user")
    private List<PostLike> postLikes = new ArrayList<>();

    //연관관계 주인x
    @OneToMany(mappedBy = "user")
    private List<PostCommentLike> commentLikes = new ArrayList<>();

    //연관관계 주인x
    @OneToOne(mappedBy = "user")
    private Token token;


    //Spring Security에서 사용
    @Builder
    public User(int id, String username, String email, UserRole role, String provider, String providerId) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.role = role;
        this.provider = provider;
        this.providerId = providerId;
    }

}
