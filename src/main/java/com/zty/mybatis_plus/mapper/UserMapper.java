package com.zty.mybatis_plus.mapper;

import com.zty.mybatis_plus.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
* @author 17939
* @description 针对表【user】的数据库操作Mapper
* @createDate 2022-11-27 14:27:11
* @Entity com.zty.mybatis_plus.entity.User
*/
@Mapper
@MapperScan
public interface UserMapper extends BaseMapper<User> {
    /**
     * 通过name更新数据
     * @param user
     * @return
     */
    int updateByName(User user);


    /**
     * @return
     */
    List<User> getAllUsers();

    /**
     * @param id
     * @return
     */
    int logicDeleteById(String id);
}




