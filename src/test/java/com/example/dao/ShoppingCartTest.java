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

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static org.hamcrest.CoreMatchers.nullValue;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;


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

    @Test  //新增購物車(同時增加會員及商品)
    @Rollback(false)
    public void testAdd() throws JSONException {
        ShoppingCart shoppingCart = new ShoppingCart();
                  
        Optional<Member> member=memberDao.findById(4L);
        
        String aString="{\"購物車清單\":[{\"商品ID\":1,\"商品數量\":3},{\"商品ID\":3,\"商品數量\":6}]}";         
        JSONObject y=new JSONObject(aString);
                 
//        System.out.println(y.getJSONArray("購物車清單").length());
//        System.out.println(y.getJSONArray("購物車清單").getJSONObject(0).getInt("商品ID"));
   
//        Iterator<String> keys = y.keys();
//        while(keys.hasNext()) {
//            String key = keys.next();
//            Integer commodity=(int)y.getJSONObject(key).getInt("商品ID");
//            Integer number=(int)y.getJSONObject(key).getInt("商品數量");
//            System.out.println(commodity);
//            System.out.println( number);
//           
//        }
              
//        List<Commodity> commodityList=new ArrayList<Commodity>(); //不要用null和collections.empty 會報錯
//          
//        for(int i=0;i<y.getJSONArray("購物車清單").length();i++) {
//        	Optional<Commodity> commodity=commodityDao.findById((long)y.getJSONArray("購物車清單").getJSONObject(i).getInt("商品ID")); 
//        	commodityList.add(commodity.get());
//        }
        
             	      	
//        	shoppingCart.setMember(member.get());  //建立會員關係
//        	for(Commodity commodity:commodityList) {  //建立商品關係
//        		commodity.getShoppingCarts().add(shoppingCart);
//        		shoppingCart.getCommodities().add(commodity);
//        		commodityDao.save(commodity);  
//         	 } 	

    		shoppingCartDao.save(shoppingCart);	
//    		
//    		Set<ShoppingCartStorage> shoppingCartStorage=shoppingCartStorageDao.findByShoppingCart(shoppingCartDao.findByMember(member.get()));
//    		for(int i=0;i<shoppingCartStorage.size();i++) {
//    			shoppingCartStorage.get(i).setNumber(y.getJSONArray("購物車清單").getJSONObject(i).getInt("商品數量"));
//    			
//    		};
//    		shoppingCartStorageDao.saveAll(shoppingCartStorage);
    		
    		
//    		List<CommodityNumber> list=commodityNumberDao.findByShoppingcartId(4L);
//    		for(Entry<Long, Integer> e : whatBuyHowMany.entrySet()) {
//            	list.
//            }
         
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
