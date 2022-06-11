package com.example.dao;

import com.example.dao.impl.MemberDao;
import com.example.dao.impl.OrderDao;
import com.example.domain.MemberBean;
import com.example.domain.OrderBean;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;

@SpringBootTest
@Transactional
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class OrderDaoTest {


    @Resource
    private MemberDao memberDao;

    @Resource
    private OrderDao orderDao;


    @Test
    public void testSave() {

        OrderBean orderBean = new OrderBean();
        orderBean.setAddress("楠梓區");
        orderBean.setPhone("0912753024");


        MemberBean memberBean = new MemberBean();
        memberBean.setName("MMM");
        memberBean.setEmail("getter3652097@gmail.com");


        memberBean.setOrderBeans(new ArrayList<OrderBean>());
        memberBean.getOrderBeans().add(orderBean);
        orderBean.setMemberBean(memberBean);

        //memberDao.findOne(memberBean.setMbid(1));
        //存好資料 用斷言 去比對//
        memberDao.save(memberBean);
        orderDao.save(orderBean);


    }
}
