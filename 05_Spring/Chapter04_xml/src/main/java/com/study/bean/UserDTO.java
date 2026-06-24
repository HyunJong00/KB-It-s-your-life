package com.study.bean;

import lombok.*;

@Setter
@Getter
public class UserDTO {
    private String name;
    private String id;
    private String pwd;

    @Override
    public String toString() {
        return "name=" + name + ", id=" + id + ", pwd=" + pwd;
    }
}
