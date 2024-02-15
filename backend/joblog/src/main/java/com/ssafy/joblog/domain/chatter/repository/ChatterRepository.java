package com.ssafy.joblog.domain.chatter.repository;

import com.ssafy.joblog.domain.chatter.entity.ChatterProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ChatterRepository extends JpaRepository<ChatterProfile, Integer> {
    // 전체조회
    List<ChatterProfile> findAllByIsDeleteIsFalseOrderByModifiedDateDesc();
    //상세조회, 수정
    Optional<ChatterProfile> findByUserIdAndIsDeleteIsFalse(Integer userId);

    @Modifying
    @Query("UPDATE ChatterProfile chatter SET chatter.isDelete = true WHERE chatter.id = :id")
    void markDeletedChatter(@Param("id") int id);

    // 채터 프로필 중복 생성 방지
    boolean existsByUserId(int userId);
}
