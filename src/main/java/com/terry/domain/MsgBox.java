package com.terry.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class MsgBox {
    @Id
    @SequenceGenerator(name = "MsgId", sequenceName = "MSG_ID_SEQ")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "MsgId")
    @Column(name = "id", nullable = false, updatable = false)
    @Size(max = 64)
    private long id;
    
    @NotNull
    @Column(name = "fromUser")
    private String fromUser;

    @NotNull
    @Column(name = "toUser")
    private String toUser;
    
    @NotNull
    @Column(name = "msg")
    private String msg;
    
    @NotNull
    @Column(name = "createTime")
    private Date createTime;
    
    @NotNull
    @Column(name = "status")
    private String status; // sent, read 
    
    
    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the fromUser
     */
    public String getFromUser() {
        return fromUser;
    }

    /**
     * @param fromUser the fromUser to set
     */
    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    /**
     * @return the toUser
     */
    public String getToUser() {
        return toUser;
    }

    /**
     * @param toUser the toUser to set
     */
    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }
}
