package com.young.generator.service.impl;

import com.alicp.jetcache.anno.CacheInvalidate;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.Cached;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.young.generator.entity.Users;
import com.young.generator.exception.UserNotFoundException;
import com.young.generator.mapper.UserMapper;
import com.young.generator.service.IUserService;
import com.young.generator.vo.UserQueryVO;
import com.young.generator.vo.UserSaveVo;
import com.young.generator.vo.UserVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * @auther WangWY
 * @create 2021-04-07 16:45:09
 * @describe 服务实现类
 */
@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class UserServiceImpl extends ServiceImpl<UserMapper, Users> implements IUserService {
    private final UserMapper UserMapper;


    @Override
    @Transactional
    public Boolean insert(UserSaveVo user) {
        Users users = new Users();
        BeanUtils.copyProperties(user, users);
        return UserMapper.insert(users) == 1;
    }

    @Override
    @Transactional
    @CacheInvalidate(name = "user::", key = "#user.id")
    public Boolean update(UserSaveVo user) {
        Users users = new Users();
        BeanUtils.copyProperties(user, users);
        return UserMapper.updateById(users) == 1;
    }

    @Override
    @Transactional
    @CacheInvalidate(name = "user::", key = "#id")
    public Boolean del(String id) {
        return UserMapper.deleteById(id) == 1;
    }

    @Override
    @Cached(name = "user::", key = "#id", cacheType = CacheType.BOTH)
    public UserVo findById(String id) {
        Users users = UserMapper.selectById(id);
        return new UserVo(users);
    }

    @Override
    @Cached(name = "user::", key = "#name", cacheType = CacheType.BOTH)
    public UserVo findByName(String name) {
        if (StringUtils.isEmpty(name)) {
            throw new UserNotFoundException("user not found with name:" + name);
        }
        Users users = UserMapper.selectOne(Wrappers.lambdaQuery(Users.class).eq(Users::getName, name));
        return new UserVo(users);
    }

    @Override
    public IPage<UserVo> page(UserQueryVO vo) {
        Page<Users> page = new Page<>(vo.getPageNum(), vo.getPageSize());
        LambdaQueryWrapper<Users> wrapper = Wrappers.lambdaQuery(Users.class)
                .eq(vo.getName() != null, Users::getName, vo.getName())
                .eq(vo.getSex() != null, Users::getSex, vo.getSex())
                .eq(vo.getEmail() != null, Users::getEmail, vo.getEmail())
                .eq(vo.getBirthday() != null, Users::getBirthday, vo.getBirthday())
                .eq(vo.getCreatedBy() != null, Users::getCreatedBy, vo.getCreatedBy())
                .eq(vo.getUpdatedBy() != null, Users::getUpdatedBy, vo.getUpdatedBy())
                .ge(vo.getCreatedTimeS() != null, Users::getCreatedTime, vo.getCreatedTimeS())
                .le(vo.getCreatedTimeE() != null, Users::getCreatedTime, vo.getCreatedTimeE());
        Page<Users> usersPage = UserMapper.selectPage(page, wrapper);
        return usersPage.convert(UserVo::new);
    }
}
