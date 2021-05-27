package com.young.common.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.young.common.entity.BasePoJo;
import com.young.common.utils.UserContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.reflection.MetaObject;

import java.util.Date;

@Slf4j
public class PoJoMetaObjectHandler implements MetaObjectHandler {
    /**
     * 获取当前交易的用户，为空返回默认system
     *
     * @return
     */
    private String getCurrentUsername() {
        return StringUtils.defaultIfBlank(UserContextHolder.getInstance().getUsername(), BasePoJo.DEFAULT_USERNAME);
    }

    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "createdBy", String.class, getCurrentUsername());
        this.strictInsertFill(metaObject, "createdTime", () -> new Date(), Date.class);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "updatedBy", String.class, getCurrentUsername());
        this.strictUpdateFill(metaObject, "updatedTime", () -> new Date(), Date.class);
    }
}