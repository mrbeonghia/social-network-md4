package com.codegym.socialNetwork.service.friend;

import com.codegym.socialNetwork.model.Friend;
import com.codegym.socialNetwork.repository.FriendRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FriendService implements IFriendService {

    @Autowired
    private FriendRepo friendRepo;
    @Override
    public Iterable<Friend> findAll() {
        return friendRepo.findAll();
    }

    @Override
    public Optional<Friend> findById(Long id) {
        return friendRepo.findById(id);
    }

    @Override
    public void save(Friend friend) {
        friendRepo.save(friend);
    }

    @Override
    public void remove(Long id) {
        friendRepo.deleteById(id);
    }
}
