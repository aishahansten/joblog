package com.ssafy.joblog.domain.user.entity;


import com.ssafy.joblog.domain.alarm.entity.Alarm;
import com.ssafy.joblog.domain.board.entity.Post;
import com.ssafy.joblog.domain.board.entity.PostComment;
import com.ssafy.joblog.domain.board.entity.PostCommentLike;
import com.ssafy.joblog.domain.board.entity.PostLike;
import com.ssafy.joblog.domain.user.dto.request.UserUpdateRequestDto;
import com.ssafy.joblog.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;

import java.sql.Array;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@DynamicInsert
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

    @ColumnDefault("0")
    private int companyCode;
    @ColumnDefault("'-'")
    private String nickname;
    @ColumnDefault("0")
    private Integer objective;
    @ColumnDefault("'-'")
    private String realName;
    @ColumnDefault("'-'")
    private String englishName;
    @ColumnDefault("'-'")
    private String address;
    @ColumnDefault("'-'")
    private String userEmail;
    @ColumnDefault("'-'")
    private String profileImageName;
    @ColumnDefault("'-'")
    private String profileImageUrl;
    @ColumnDefault("'-'")
    private String phoneNumber;
    @ColumnDefault("'2000-01-01'")
    private LocalDate birthDate;

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

    @OneToMany(mappedBy = "following")
    private List<Follow> followings = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Alarm> alarms = new ArrayList<>();


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

    public void updateUser(UserUpdateRequestDto userUpdateRequestDto) {
        this.nickname = userUpdateRequestDto.getNickname();
        this.objective = userUpdateRequestDto.getObjective();
        this.realName = userUpdateRequestDto.getRealName();
        this.englishName = userUpdateRequestDto.getEnglishName();
        this.address = userUpdateRequestDto.getAddress();
        this.userEmail = userUpdateRequestDto.getUserEmail();
        this.profileImageName = userUpdateRequestDto.getProfileImageName();
        this.profileImageUrl = userUpdateRequestDto.getProfileImageUrl();
        this.phoneNumber = userUpdateRequestDto.getPhoneNumber();
        this.birthDate = userUpdateRequestDto.getBirthDate();
    }

    public void deleteUser() {
        this.isDelete = true;
    }


    public void changeRole() {
        this.role = UserRole.ROLE_JUNIOR;
    }

    public void updateFile(String newName, String newUrl){
        this.profileImageName = newName;
        this.profileImageUrl = newUrl;
    }
}
