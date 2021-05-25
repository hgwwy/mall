package com.young.generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.young.generator.entity.Users;
import com.young.generator.mapper.UserMapper;
import com.young.generator.service.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @auther WangWY
 * @create 2021-04-07 16:45:09
 * @describe 服务实现类
 */
@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class UserServiceImpl extends ServiceImpl<com.young.generator.mapper.UserMapper, Users> implements IUserService {
    private final UserMapper UserMapper;
}
