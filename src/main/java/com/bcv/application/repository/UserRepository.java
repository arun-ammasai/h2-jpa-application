package com.bcv.application.repository;

import com.bcv.application.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("select o from User o where o.address = ?1")
    List<User> fetchUsersById(String city);

    @Query("select o from User o where o.address = :city")
    Optional<List<User>> fetchUsersById1(@Param("city") String city);
}
