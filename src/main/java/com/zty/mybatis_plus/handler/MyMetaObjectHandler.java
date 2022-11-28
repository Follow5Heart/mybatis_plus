package com.zty.mybatis_plus.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 实现元对象处理器接口 对你当前传进来的数据进行特殊处理，也就相当于对user里面的createTime 重新复制，也是setCreateTime
 * @author 17939
 */
@Log4j2
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("正在进行插入操作，对创建时间进行赋值");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        this.strictInsertFill(metaObject,"createTime",()-> dtf.format(LocalDateTime.now()),String.class);
        this.strictInsertFill(metaObject,"updateTime",()-> dtf.format(LocalDateTime.now()),String.class);


    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("正在进行插入操作，对更新时间进行赋值");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.strictInsertFill(metaObject,"updateTime",()-> dtf.format(LocalDateTime.now()),String.class);
    }
}
