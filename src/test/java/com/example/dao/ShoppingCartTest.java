package com.example.dao;

import com.example.dao.impl.CommodityDao;
import com.example.dao.impl.MemberDao;
import com.example.dao.impl.OrderDao;
import com.example.dao.impl.ShoppingCartDao;
import com.example.domain.Commodity;
import com.example.domain.Member;
import com.example.domain.ShoppingCart;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@SpringBootTest
@Transactional
@ExtendWith(SpringExtension.class)
public class ShoppingCartTest {

    @Resource
    private OrderDao dao;

    @Resource
    private MemberDao memberDao;

    @Resource
    private ShoppingCartDao shoppingCartDao;
    
    @Resource
    private CommodityDao commodityDao;

    @Test  //新增購物車(同時增加會員及商品)
    @Rollback(false)
    public void testAdd() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setNumber(17);
        
        List<ShoppingCart> shoppingCarts=new ArrayList<ShoppingCart>();
     
        Optional<Commodity> commodity1=commodityDao.findById(3L);      
        Optional<Member> member=memberDao.findById(2L);
	
        if(member.isPresent()) {        	
        	shoppingCarts.add(shoppingCart);
        	shoppingCart.setMember(member.get());
        	commodity1.get().getShoppingCarts().add(shoppingCart);
        	shoppingCart.getCommodities().add(commodity1.get());
		
    		shoppingCartDao.save(shoppingCart);	
    		commodityDao.save(commodity1.get());        	
        }   

    }
    
//    @Test
//    @Rollback(false)
//    public void testUpdateNumber() {
//    	shoppingCartDao.find
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
