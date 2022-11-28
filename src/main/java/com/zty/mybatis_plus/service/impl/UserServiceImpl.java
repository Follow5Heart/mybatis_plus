package com.zty.mybatis_plus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zty.mybatis_plus.entity.User;
import com.zty.mybatis_plus.service.UserService;
import com.zty.mybatis_plus.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author 17939
* @description 针对表【user】的数据库操作Service实现
* @createDate 2022-11-27 14:27:11
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{



}




