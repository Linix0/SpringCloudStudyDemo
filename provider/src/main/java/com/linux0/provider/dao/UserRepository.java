package com.linux0.provider.dao;

import com.linux0.provider.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author chenhang
 * @Title: UserRepository
 * @ProjectName SpringCloudStudyDemo
 * @Description: TODO
 * @date 2019/10/22 002216:07
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findById(Long id);
}
