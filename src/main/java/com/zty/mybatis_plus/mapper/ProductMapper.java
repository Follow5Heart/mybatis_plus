package com.zty.mybatis_plus.mapper;

import com.zty.mybatis_plus.entity.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

/**
* @author 17939
* @description 针对表【product】的数据库操作Mapper
* @createDate 2022-11-27 20:45:57
* @Entity com.zty.mybatis_plus.entity.Product
*/
@Mapper
public interface ProductMapper extends BaseMapper<Product> {

}




