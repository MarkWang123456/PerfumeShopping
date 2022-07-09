package com.example.service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.impl.CommodityDao;
import com.example.dao.impl.MemberDao;
import com.example.dao.impl.OrderDao;
import com.example.domain.Member;
import com.example.domain.Order;
import org.springframework.util.ObjectUtils;

@Service
@Transactional
public class OrderService {
	@Resource
	private OrderDao orderDao;
	
	@Resource
	private MemberDao memberDao;
	
	@Resource
	private CommodityDao commodityDao;
	
	
	
	public List<Order> useMemberFindAllOrder(Member member){
		List<Order> result=null;	
			List<Order> order=orderDao.findByMember(member);
			if (null!=order) {
				result=order;
			}else {
				result=Collections.emptyList();
			}		
		return result;	
	}

	public List<Order> findAllPaging(Integer page){
		Page<Order> pageResult = orderDao.findAll(PageRequest.of(page, 5, Sort.by("id").descending()));

		List<Order> result = pageResult.getContent();

		return result;
	}

	public Page<Order> findByMemberPaging(Member member, Integer page){
		Page<Order> result = null;

		Pageable pageable = PageRequest.of(page, 5, Sort.by("id").ascending());
		Page<Order> pageResult = orderDao.findOrdersByMember(member, pageable);
		pageResult.getTotalPages();
		pageResult.getTotalElements();
		if(pageResult != null){
			result = pageResult;
		}
		return result;
	}

	public List<Order> findAll(){
		List<Order> result = null;
		List<Order> orderList = orderDao.findAll();
		result = orderList;
		return result;
	}

	public Order update(Order order){
		Order result = null;
		if(!ObjectUtils.isEmpty(order) && null != order.getId()){
			Optional<Order> select = orderDao.findById(order.getId());

			if(select.isPresent() && !order.isPay()){
				Order target = select.get();
				target.setPay(true);

				result = target;
			}
		}
		return result;
	}

	public Order updatePay(Order order){
		Order result = null;
		if(!ObjectUtils.isEmpty(order) && null != order.getId()){
			Optional<Order> select = orderDao.findById(order.getId());

			if(select.isPresent() && order.isPay() && !order.isShipping()){
				Order target = select.get();
				target.setShipping(true);

				result = target;
			}
		}
		return result;
	}

	
	public void updateStatus(Member member) {
		
	}
	

}
