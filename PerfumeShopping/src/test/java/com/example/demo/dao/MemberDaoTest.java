package com.example.demo.dao;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.impl.MemberDao;
import com.example.demo.domain.MemberBean;





@SpringBootTest
@Transactional
@ExtendWith(SpringExtension.class)
public class MemberDaoTest {
	
	@Resource
    private MemberDao dao;
	

	
	
	@Test
	public void testSave() {
		MemberBean memberBean=new MemberBean();
		memberBean.setName("Mark");
		memberBean.setEmail("a0912753024@gmail.com");
		memberBean.setPhone("0912753024");
		memberBean.setBirth(new Date());
		memberBean.setSex("male");
		memberBean.setAddress("高雄");
		memberBean.setPassword("123");
		memberBean.setCreationtime(memberBean.getCreationtime());
		this.dao.save(memberBean);
		
	}
	
	@Test
	public void testfindbyName() {
		List<MemberBean> list=dao.findByName("Mark");
		for(MemberBean memberBean:list) {
			System.out.println(memberBean);
		}
	}
	
	@Test
	public void testfindbyID() {
		Optional<MemberBean> findidOptional=dao.findById(3);
		
			System.out.println(findidOptional);
		}
	
	
	
	@Test
	public void testupdateMemberNameById() {
		dao.updateMemberNameById("mark", 3);
	}
	
	
	}
	
	
	

