package com.terry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.terry.domain.MsgBox;
import com.terry.repository.MsgBoxRepository;

public class MsgBoxServiceImpl {
    @Autowired
    private MsgBoxRepository repository;
    
    //@Override
    @Transactional
    public MsgBox save(final MsgBox user) {
        return repository.save(user);
    }

    //@Override
    @Transactional(readOnly = true)
    public List<MsgBox> getList() {
        return repository.findAll();
    }
}
