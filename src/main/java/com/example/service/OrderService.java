package com.example.service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.impl.CommodityDao;
import com.example.dao.impl.MemberDao;
import com.example.dao.impl.OrderDao;
import com.example.domain.Member;
import com.example.domain.Order;

@Service
@Transactional
public class OrderService {
	@Resource
	private OrderDao orderDao;
	
	@Resource
	private MemberDao memberDao;
	
	@Resource
	private CommodityDao commodityDao;
	
//	public List<Order> useMemberFindAllOrder(Member member){
//		List<Order> result=null;	
//			List<Order> orderList=orderDao.findAllByMember(member);
//			if (orderList!=null) {
//				result=orderList;
//			}else {
//				result=Collections.emptyList();
//			}		
//		return result;	
//	}
	
	public void updateStatus(Member member) {
		
	}
	

}
