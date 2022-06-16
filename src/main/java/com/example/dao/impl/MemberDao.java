package com.example.dao.impl;

import java.util.List;
import java.util.Optional;

import com.example.domain.MemberBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

//* 符合SpringDataJpa的dao層介面規範
//*      JpaRepository<操作的實體類型別，實體類中主鍵的型別>
//*          *封裝了基本CRUD操作
//*      JpaSpecificationExecutor<操作的實體類型別>
//*          *封裝了複雜查詢（分頁)

@Repository
public interface MemberDao extends JpaRepository<MemberBean, Integer>,JpaSpecificationExecutor<MemberBean>{
	
	List<MemberBean> findByName(String name);
	
	Optional<MemberBean> findById(Integer id);
	
	MemberBean findByIdMember(Integer idMember);
	
	@org.springframework.data.jpa.repository.Modifying  //需要執行一個更新操作
	@Query("update MemberBean set name = :name where mbid = :mbid")
	void updateMemberNameById(String name,Integer mbid);

	  
}
