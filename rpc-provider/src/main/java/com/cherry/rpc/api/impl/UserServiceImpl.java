package com.cherry.rpc.api.impl;

import cn.hutool.core.lang.UUID;
import com.cherry.rpc.api.UserService;
import com.cherry.rpc.dto.UserDTO;

/**
 * @Author: Cherry
 * @Date: 2021/3/27
 * @Desc: UserServiceImpl
 */
public class UserServiceImpl implements UserService {
    @Override
    public UserDTO addUser(UserDTO userDTO) {
        System.out.println("接收：" + userDTO);
        userDTO.setId(UUID.randomUUID() + "");
        System.out.println("接收：" + userDTO);
        return userDTO;
    }
}
