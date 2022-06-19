package com.example.dao;

import com.example.dao.impl.MemberDao;
import com.example.dao.impl.OrderDao;
import com.example.dao.impl.ShoppingCartDao;
import com.example.domain.Member;
import com.example.domain.ShoppingCart;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Optional;


@SpringBootTest
@Transactional
@ExtendWith(SpringExtension.class)
public class ShoppingCartDaoTest {

    @Resource
    private OrderDao dao;

    @Resource
    private MemberDao memberDao;

    @Resource
    private ShoppingCartDao shoppingCartDao;


//    @Test
//    public void testAdd() {
//        ShoppingCart shoppingCartBean = new ShoppingCart();
//        Member memberBean = new Member();
//
//        memberBean.setIdMember(1);
//
//        shoppingCartBean.setIdCommodity(8);
//        shoppingCartBean.setNumber(2);
//        memberBean.getShoppingCartBeans().add(shoppingCartBean);
//        Member expected = memberDao.save(memberBean);
//
//        Member actual = memberDao.findByIdMember(1);
//
//        Assertions.assertEquals(expected, actual);
//
//
//    }
//
//    @Test
//    public void testDelete() {
//        Optional<ShoppingCart> result = shoppingCartDao.findById(3);
//        Assertions.assertTrue(result.isPresent());
////        ShoppingCartBean expected = shoppingCartDao.findByIdShoppingCart(3);
////        Assertions.assertNotNull(expected);
//
//        shoppingCartDao.deleteByIdShoppingCart(3);
//
//        Assertions.assertFalse(shoppingCartDao.findById(3).isPresent());
//
//    }

}
