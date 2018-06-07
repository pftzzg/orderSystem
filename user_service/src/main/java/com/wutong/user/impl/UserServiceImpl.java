package com.wutong.user.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.wutong.api.user.UserService;
import com.wutong.user.beans.UserInfo;
import com.wutong.user.mapper.UserMapper;
import com.wutong.user.modle.UserDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zzg on 2018/6/2.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper courseMapper;

    @Override
    public UserDTO getUserById(int id) throws Exception {
        UserInfo u = courseMapper.getUserById(id);
        UserDTO d = bean2Dto(u);
        return d;

    }

    @Override
    public UserDTO getUserByName(String username) throws Exception {
        return bean2Dto(courseMapper.getUserByName(username));
    }

    @Override
     public void regiserUser(UserDTO dto) throws Exception {


        courseMapper.registerUser(dto2Bean(dto));

    }

    private UserDTO bean2Dto(UserInfo bean) {
        if (bean == null) return null;
        UserDTO dto = new UserDTO();
        BeanUtils.copyProperties(bean, dto);
        return dto;
    }

    private UserInfo dto2Bean(UserDTO dto) {
        if (dto == null) return null;
        UserInfo info = new UserInfo();
        BeanUtils.copyProperties(dto, info);
        return info;
    }
}
