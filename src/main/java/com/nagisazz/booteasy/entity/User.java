package com.nagisazz.booteasy.entity;

import com.nagisazz.booteasy.base.entity.BaseEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mybatis.annotations.Column;
import org.springframework.data.mybatis.annotations.Entity;
import org.springframework.data.mybatis.annotations.Id;

/**
 * @author NagisaZZ
 * @description: User
 * @date 2019/4/22  10:02
 */
@Entity(table = "user")
@Setter
@ToString
@Getter
public class User implements BaseEntity<Long> {

    @Id(strategy = Id.GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    @Transient
    public boolean isNew() {
        return false;
    }
}
