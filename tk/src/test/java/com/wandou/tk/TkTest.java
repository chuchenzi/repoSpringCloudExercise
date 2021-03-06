package com.wandou.tk;

import com.wandou.tk.mapper.AreaMapper;
import com.wandou.tk.mapper.UserMapper;
import com.wandou.tk.po.Area;
import com.wandou.tk.po.User;
import com.wandou.tk.util.IdUtil;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TkTest {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private IdUtil idUtil;
    @Autowired
    private AreaMapper areaMapper;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testGet() {
        User user = userMapper.selectByPrimaryKey(2L);
        System.out.println(user.getRealName());

        User user1 = new User();
        user1.setRealName("乔峰");
        Example example = new Example(User.class);
        List<User> users = userMapper.selectByExample(example);
        System.out.println(users);
    }

    @Test
    public void testSelectList() {
        List<User> users = userMapper.selectAll();
        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i));
        }
    }

    @Test
    public void t3() {
        //todo 物理删除哦
        int i = userMapper.deleteByPrimaryKey(5L);
        System.out.println(i);
    }

    @Test
    public void t4() {
        User user = new User();
        user.setPhone("133-0000-0000");
        user.setRealName("小龙女");
        user.setWechat("xiaolongnv");
        user.setSex(1);
        user.setUsername(RandomStringUtils.random(6, false, true));
        user.setUpdateTime(DateUtils.addDays(new Date(), -2));
        int i = userMapper.insertSelective(user);
        System.out.println(i);
    }

    @Test
    public void updateTest() {
//        User user = new User();
//        user.setId(9L);
//        user.setUpdateTime(new Date());
//        userMapper.updateByPrimaryKey(user);
        User user2 = new User();
        user2.setId(8L);
        user2.setWechat("selective11112");
        userMapper.updateByPrimaryKeySelective(user2);
    }

    @Test
    public void m4GlobalId() {
        for (int i = 0; i < 1; i++) {
            Long aLong = idUtil.genGlobalId(1, null);
            System.out.println(aLong);
        }
    }

    @Test
    public void m5Mybatis() {
        List<Area> list = areaMapper.list();
        System.out.println(list);
    }

}
