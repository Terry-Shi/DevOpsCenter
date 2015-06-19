package com.terry.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.terry.domain.MsgBox;
import com.terry.domain.User;

public interface MsgBoxRepository extends JpaRepository<User, String>{

    /**
     * Returns the MsgBox with the given UserId.
     * select * from MsgBox where fromUser = ?
     * @param fromUser to search for.
     * @return
     */
    List<MsgBox> findByFromUser(String fromUser);
    
    
    List<MsgBox> findByToUser(String toUser);
    
    
}
