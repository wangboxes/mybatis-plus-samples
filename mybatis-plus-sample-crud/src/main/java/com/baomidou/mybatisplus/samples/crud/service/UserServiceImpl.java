package com.baomidou.mybatisplus.samples.crud.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.samples.crud.entity.User;
import com.baomidou.mybatisplus.samples.crud.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @describe：
 * @Date：2020/4/18 14:42
 * @author：wbx
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper mapper;

    @Override
    @Transactional
    public void insertCount() {
        QueryWrapper wrapper = new QueryWrapper();
        Integer count = mapper.selectCount(wrapper);
        System.out.println("count = " + count);


        User user = new User();
        user.setName("小羊");
        user.setAge(3);
        user.setEmail("abc@mp.com");
        mapper.insert(user);

        //验证在事务中，插入数据后，能否立马count到 ---> 结论：可以
        Integer count2 = mapper.selectCount(wrapper);
        System.out.println("count2 = " + count2);
    }
}
