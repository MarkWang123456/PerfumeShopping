package com.example.dao;

import com.example.dao.impl.MemberDao;
import com.example.domain.MemberBean;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;


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
		memberBean.setCreationTime(new Date());
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
	

	
	
	}
	
	
	

