package com.young.generator.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.young.generator.entity.Users;
import com.young.generator.vo.UserQueryVO;
import com.young.generator.vo.UserSaveVo;
import com.young.generator.vo.UserVo;

import java.util.List;

/**
 * @auther WangWY
 * @create 2021-04-07 16:45:09
 * @describe 服务类
 */
public interface IUserService extends IService<Users> {

    Boolean insert(UserSaveVo user);

    Boolean update(UserSaveVo user);

    Boolean del(String id);

    UserVo findById(String id);

    UserVo findByName(String name);

    IPage<UserVo> page(UserQueryVO vo);

}
