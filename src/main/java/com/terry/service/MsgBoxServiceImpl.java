package com.terry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.terry.domain.MsgBox;
import com.terry.domain.User;
import com.terry.repository.MsgBoxRepository;

@Service
public class MsgBoxServiceImpl implements MsgBoxService {
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
