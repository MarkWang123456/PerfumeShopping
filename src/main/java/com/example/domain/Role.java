package com.example.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@ToString(exclude= {"members"},doNotUseGetters = true)
@Data
@Table(name="t_role")
@NoArgsConstructor
@AllArgsConstructor
public class Role {
		



		@Id
		 @GeneratedValue(strategy = GenerationType.IDENTITY)
		 @Column(name="id")
		 private Long id;

		 @Column(name="name" )
		 private String name;
		 
		 
		 @ManyToMany(mappedBy = "roles",fetch = FetchType.LAZY)
		 @JsonIgnore
		 private Collection<Member> members =new ArrayList<>();
}

