package com.codegym.socialNetwork.repository;

import com.codegym.socialNetwork.model.Friend;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendRepo extends JpaRepository<Friend, Long> {

}
