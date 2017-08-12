package cn.dlx.ssm.mapper;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.dlx.ssm.pojo.User;

public class UserMapperTest {

	private UserMapper userMapper;

	@Before
	public void setUp() throws Exception {
		/*String resource = "mybatis/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = factory.openSession();
		this.userMapper = session.getMapper(UserMapper.class);*/

		ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml",
				"spring/applicationContext-mybatis.xml");
		this.userMapper = context.getBean(UserMapper.class);
	}

	@Test
	public void testQueryUserById() {
		User user = this.userMapper.queryUserById(1l);
		System.out.println(user);
	}

}
