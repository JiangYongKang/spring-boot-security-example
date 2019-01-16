package com.vincent.security.example.repository;

import com.vincent.security.example.model.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Author: vincent
 * DateTime: 2019/1/15 23:30
 * Comment:
 */

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Integer> {

    Optional<MemberEntity> findByEmail(String email);

}
