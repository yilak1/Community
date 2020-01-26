package com.lds.Community;

import com.lds.Community.dao.DiscussPostMapper;
import com.lds.Community.dao.UserMapper;
import com.lds.Community.entity.DiscussPost;
import com.lds.Community.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
class CommunityApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private DiscussPostMapper discussPostMapper;

	@Test
	public void findById(){
		User user = userMapper.selectById(101);
		System.out.println(user);
	}

	@Test
	public void findByName(){
		User user = userMapper.selectByName("lihonghe");
		System.out.println(user);
	}

	@Test
	public void findByEmail(){
		User user = userMapper.selectByEmail("nowcoder146@sina.com");
		System.out.println(user);
	}

	@Test
	public void insert(){
		User user = new User();
		user.setUsername("hello");
		user.setPassword("123");
		user.setEmail("sdf");
		user.setHeaderUrl("123");
		user.setActivationCode("123");
		user.setStatus(1);
		user.setCreateTime(new Date());
		user.setSalt("123");
		user.setType(0);
		userMapper.insertUser(user);
		System.out.println(user);
	}

	@Test
	public void discussPostSelect(){
		List<DiscussPost> discussPosts = discussPostMapper.selectDiscussPosts(101, 0, 100);
		System.out.println(discussPosts);

	}

}
