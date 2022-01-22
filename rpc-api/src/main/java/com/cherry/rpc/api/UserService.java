package com.cherry.rpc.api;

import com.cherry.rpc.dto.UserDTO;

/**
 * @Author: Cherry
 * @Date: 2021/3/27
 * @Desc: UserService
 */
public interface UserService {

    public UserDTO addUser(UserDTO userDTO);
}
