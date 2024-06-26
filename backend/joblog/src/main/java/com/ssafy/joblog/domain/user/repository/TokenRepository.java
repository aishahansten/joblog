package com.ssafy.joblog.domain.user.repository;

import com.ssafy.joblog.domain.user.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository<Token, Integer>  {

}
