package com.codegym.socialNetwork.repository;

import com.codegym.socialNetwork.model.Relationship;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendRequestRepo extends JpaRepository <Relationship, Long>  {

}
