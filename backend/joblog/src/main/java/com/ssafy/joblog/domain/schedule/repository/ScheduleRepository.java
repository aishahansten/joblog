package com.ssafy.joblog.domain.schedule.repository;

import com.ssafy.joblog.domain.board.entity.Post;
import com.ssafy.joblog.domain.schedule.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
    // is_delete=0인 스케쥴만 조회
    List<Schedule> findByUserIdAndIsDeleteIsFalse(Integer userId);

    Optional<Schedule> findByIdAndIsDeleteIsFalse(Integer id);

    @Modifying
    @Query("UPDATE Schedule schedule SET schedule.isDelete = true WHERE schedule.id = :id")
    void markDeletedSchedule(@Param("id") int id);

    List<Schedule> findAllByEndDateBetweenAndIsDeleteFalse(LocalDateTime endDate1, LocalDateTime endDate2);
}