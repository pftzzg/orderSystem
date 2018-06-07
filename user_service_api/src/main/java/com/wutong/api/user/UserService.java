package com.wutong.api.user;

import com.wutong.user.modle.UserDTO;

/**
 * Created by zzg on 2018/6/2.
 */
public interface UserService {
    public UserDTO getUserById(int id) throws Exception ;
    public UserDTO getUserByName(String username) throws Exception ;
    public void regiserUser(UserDTO UserDTO) throws Exception ;

}
