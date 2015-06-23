package com.terry.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.terry.domain.MsgBox;

public interface MsgBoxRepository extends JpaRepository<MsgBox, String>{

    /**
     * Returns the MsgBox with the given UserId.
     * select * from MsgBox where fromUser = ?
     * @param fromUser to search for.
     * @return
     */
    List<MsgBox> findByFromUser(String fromUser);
    
    
    List<MsgBox> findByToUser(String toUser);
    
    
}
