package com.markerhub.vueblog.service.impl;

import com.markerhub.vueblog.entity.User;
import com.markerhub.vueblog.mapper.UserMapper;
import com.markerhub.vueblog.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author local
 * @since 2022-08-15
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
