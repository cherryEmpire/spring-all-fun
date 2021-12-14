package com.cherry.rpc.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: Cherry
 * @Date: 2021/3/27
 * @Desc: UserDTO
 */
@Data
public class UserDTO implements Serializable {

    private static final long serialVersionUID = 3725434043028682061L;

    private String id;

    private String name;

    private Integer age;
}
