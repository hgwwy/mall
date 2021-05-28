package com.young.generator.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.young.common.response.Result;
import com.young.generator.service.IUserService;
import com.young.generator.vo.UserQueryVO;
import com.young.generator.vo.UserSaveVo;
import com.young.generator.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@Api("用户管理")
@RestController
@RequestMapping(value = "/user")
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class UserController {

    private final IUserService userService;

    @ApiOperation(value = "新增用户")
    @PostMapping
    public Result save(@Valid @RequestBody UserSaveVo vo) {
        log.info("新增用户:{}", vo);
        return Result.success(userService.insert(vo));
    }

    @ApiOperation(value = "更新用户")
    @PutMapping
    public Result update(@Valid @RequestBody UserSaveVo vo) {
        return Result.success(userService.update(vo));
    }

    @ApiOperation(value = "删除用户")
    @DeleteMapping("/{id}")
    public Result del(@PathVariable String id) {
        return Result.success(userService.del(id));
    }

    @ApiOperation(value = "分页获取用户列表")
    @PostMapping("/page")
    public Result page(@RequestBody UserQueryVO vo) {
        IPage<UserVo> page = userService.page(vo);
        return Result.success(page);
    }

    @ApiOperation(value = "根据id获取用户")
    @GetMapping("/{id}")
    public Result getById(@PathVariable String id) {
        return Result.success(userService.findById(id));
    }

    @ApiOperation(value = "根据名称获取用户")
    @GetMapping
    public Result getByName(@RequestParam String name) {
        return Result.success(userService.findByName(name));
    }
}
