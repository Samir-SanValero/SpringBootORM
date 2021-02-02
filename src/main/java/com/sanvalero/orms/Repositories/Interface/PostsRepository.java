package com.sanvalero.orms.Repositories.Interface;

import java.util.List;

import com.sanvalero.orms.Repositories.Entities.PostEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PostsRepository extends JpaRepository<PostEntity, Long>{

    @Query(value = "SELECT p " + " FROM Posts p " + " WHERE userId = :userId")
    List<PostEntity> findByUserId(@Param("userId") Long userId);

    @Query(value = "SELECT p " + " FROM Posts p" + " INNER JOIN Users u " + " WHERE salary > :salary")
    List<PostEntity> filterSalary(@Param("salary") Long salary);
}
