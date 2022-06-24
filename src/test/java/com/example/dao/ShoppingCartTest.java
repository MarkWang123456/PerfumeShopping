package com.example.dao;

import com.example.dao.impl.CommodityDao;
import com.example.dao.impl.ShoppingCartStorageDao;
import com.example.dao.impl.MemberDao;
import com.example.dao.impl.OrderDao;
import com.example.dao.impl.ShoppingCartDao;
import com.example.domain.Commodity;
import com.example.domain.ShoppingCartStorage;
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

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
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
    
    @Resource
    private ShoppingCartStorageDao shoppingCartStorageDao;

//    @Test  //新增購物車(同時增加會員及商品)
//    @Rollback(false)
//    public HashMap<Long, Integer> testAdd() {
//        ShoppingCart shoppingCart = new ShoppingCart();
//        ShoppingCartStorage shoppingCartStorage=new ShoppingCartStorage();
//               
//        Optional<Member> member=memberDao.findById(2L);
//        
//        HashMap<Long, Integer> whatBuyHowMany = new HashMap<Long, Integer>();
//        whatBuyHowMany.put(2L, 7);
//        whatBuyHowMany.put(3L, 8);
//        whatBuyHowMany.put(4L, 9);
//       
//        List<Commodity> commodityList=new ArrayList<Commodity>(); //不要用null和collections.empty 會報錯
//          
//        for(Entry<Long, Integer> e : whatBuyHowMany.entrySet()) {
//        	Optional<Commodity> commodity=commodityDao.findById(e.getKey()); 
//        	commodityList.add(commodity.get());
//        }
//        if(member.isPresent()) {        	      	
//        	shoppingCart.setMember(member.get());  //建立會員關係
//        	for(Commodity commodity:commodityList) {  //建立商品關係
//        		commodity.getShoppingCarts().add(shoppingCart);
//        		shoppingCart.getCommodities().add(commodity);
//        		commodityDao.save(commodity);  
//        	}   		
//
//    		shoppingCartDao.save(shoppingCart);	
//    		
////    		List<CommodityNumber> list=commodityNumberDao.findByShoppingcartId(4L);
////    		for(Entry<Long, Integer> e : whatBuyHowMany.entrySet()) {
////            	list.
////            }
//        }   
//    }
    
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
