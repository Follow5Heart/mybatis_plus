package com.zty.mybatis_plus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zty.mybatis_plus.entity.Product;
import com.zty.mybatis_plus.service.ProductService;
import com.zty.mybatis_plus.mapper.ProductMapper;
import org.springframework.stereotype.Service;

/**
* @author 17939
* @description 针对表【product】的数据库操作Service实现
* @createDate 2022-11-27 20:45:57
*/
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product>
    implements ProductService{

}




