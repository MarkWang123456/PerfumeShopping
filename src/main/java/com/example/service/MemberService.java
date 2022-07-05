package com.example.service;

import java.util.List;

import com.example.domain.Member;
import com.example.domain.Role;

public interface MemberService {
	Member saveMember (Member member);
	Role saveRole(Role role);
	void addRoleToMember(String membername,String rolename);
	Member getMember(String membername);
	List<Member>getMembers();
}
