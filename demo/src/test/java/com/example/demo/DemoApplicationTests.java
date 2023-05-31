package com.example.demo;

import com.demo.sys.entity.User;
import com.demo.sys.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;
@SpringBootTest
class DemoApplicationTests {
	@Resource
	private UserMapper userMapper;
	@Test
	void testMapper() {
		List<User> users = userMapper.selectList(null);
//		System.out.println("长度是" + users.size());
		users.forEach(System.out::println);
	}

}
