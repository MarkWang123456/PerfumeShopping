package com.example.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.authority.SimpleGrantedAuthority;


import com.example.dao.impl.MemberDao;
import com.example.dao.impl.RoleDao;
import com.example.domain.Member;
import com.example.domain.Role;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class MemberServiceImpl implements MemberService, UserDetailsService {

	private final MemberDao memberDao;
	private final RoleDao roleDao;
	private final PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String membername) throws UsernameNotFoundException {
		Member member=memberDao.findByName(membername);
		if(member==null) {
			log.error("資料庫中沒有此成員");
			throw new UsernameNotFoundException("資料庫中沒有此成員");
		}else {
			log.info("在資料庫中有找到:{}",membername);
		} 
		Collection<SimpleGrantedAuthority> authorites=new ArrayList<>(); //SimpleGrantedAuthority:存儲String授予 Authentication對象的權限的表示。
		member.getRoles().forEach(role ->{
			authorites.add(new SimpleGrantedAuthority(role.getName()));
		});
		return new org.springframework.security.core.userdetails.User(member.getName(),member.getPassword(), authorites);
	}

	@Override
	public Member saveMember(Member member) {
		member.setPassword(passwordEncoder.encode(member.getPassword()));
		return memberDao.save(member);
	}

	@Override
	public Role saveRole(Role role) {
		// TODO Auto-generated method stub
		return roleDao.save(role);
	}

	@Override
	public void addRoleToMember(String membername, String rolename) {
		Member member = memberDao.findByName(membername);
		Role role = roleDao.findByName(rolename);
		member.getRoles().add(role);

	}

	@Override
	public Member getMember(String memberName) {
		// TODO Auto-generated method stub
		return memberDao.findByName(memberName);
	}

	@Override
	public List<Member> getMembers() {
		// TODO Auto-generated method stub
		return memberDao.findAll();
	}

}
