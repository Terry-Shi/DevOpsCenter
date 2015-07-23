package com.terry.service;

import java.util.List;

import com.terry.domain.MsgBox;

public interface MsgBoxService {
    MsgBox save(MsgBox user);
    List<MsgBox> getList();
}
