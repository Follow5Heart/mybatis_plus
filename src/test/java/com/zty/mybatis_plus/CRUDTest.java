package com.zty.mybatis_plus;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zty.mybatis_plus.entity.Product;
import com.zty.mybatis_plus.entity.User;
import com.zty.mybatis_plus.mapper.ProductMapper;
import com.zty.mybatis_plus.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.internal.Maps;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static net.sf.jsqlparser.util.validation.metadata.NamedObject.user;

@Slf4j
@SpringBootTest
public class CRUDTest {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ProductMapper productMapper;


    @Test
    public void insertUser(){

        User user = new User();
        user.setName("张三");
        user.setAge(16);
        user.setEmail("111111@qq.com");

//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//
//
//        user.setCreateTime(dtf.format(LocalDateTime.now()));
        int insert = userMapper.insert(user);
        System.out.println("影响了"+insert+"行");
        System.out.println("用户的id"+user.getId());




    }

    @Test
    public void updateUser(){
        User user = new User();
        user.setName("李四");
        user.setAge(16);
        user.setId(1L);

        int i = userMapper.updateById(user);
        System.out.println("影响user的行数："+i);


    }

    /**
     * 自定义失败了  这块
     */
    @Test
    public void customUpdateUser(){
        User user = new User();
        user.setName("李四");
        user.setAge(100);

        int result= userMapper.updateByName(user);
        System.out.println("影响的行数："+result);

    }

    @Test
    public void testGetAllUsers(){
        List<User> allUsers = userMapper.getAllUsers();
        allUsers.forEach(System.out::println);


    }


    /**
     * 乐观锁
     */
    @Test
    public void testLock() throws Exception {
        //小王获取当前的产品钱数
        Product product = productMapper.selectById(1);

        //小李也开始获取数据
        Product product1 = productMapper.selectById(1);


        product.setPrice(product.getPrice()+50);
        log.info("Product"+product);
        product1.setPrice(product1.getPrice()-30);
        log.info("Product1"+product1);

        //更新数据
        int i = productMapper.updateById(product);
        System.out.println("影响了"+i+"行");

        //也开始保存数据
        int i1 = productMapper.updateById(product1);
        if (i1==0) {
            //throw new Exception("当前数据正在被操作！");
            Product product2 = productMapper.selectById(1);
            product2.setPrice(product2.getPrice()-30);
            productMapper.updateById(product2);
        }
        System.out.println("影响了"+i1+"行");


    }


    @Test
    public void getUsersByBatchIds(){
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        users.forEach(System.out::println);

    }

    @Test
    public void getUserByMap(){
        HashMap<String, Object> map = new HashMap<>();

        map.put("name","李四");
        map.put("age",16);

        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);


    }

    @Test
    public void testSelectPage(){
        IPage<User> userIPage = new Page<>(2,5);

        IPage<User> page = userMapper.selectPage(userIPage, null);
        //获取分页查询结果
        List<User> records = page.getRecords();
        records.forEach(System.out::println);

        //获取总页数
        System.out.println(page.getPages());

        //总记录数
        System.out.println(page.getTotal());


    }

    /**
     * 分页maps查询
     */
    @Test
    public void selectMpsPage(){

        //创建page对象
        Page<Map<String,Object>> userPage = new Page<>(1,5);

        //创建queryWarrper对象
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();

        userQueryWrapper.select("id","name");

        Page<Map<String, Object>> mapPage = userMapper.selectMapsPage(userPage, userQueryWrapper);

        List<Map<String, Object>> records = mapPage.getRecords();
        records.forEach(System.out::println);


    }

    @Test
    public void deleteTest(){
        int i = userMapper.deleteById("1596796478544904193");
        System.out.println("影响的行数"+i);

    }

    /**
     * 批量删除
     */
    @Test
    public void deleteBatchByIds(){
        int i= userMapper.deleteBatchIds(Arrays.asList("1596795578422124546", "1596795328542175234"));
        System.out.println("影响的行数"+i);


    }
}
