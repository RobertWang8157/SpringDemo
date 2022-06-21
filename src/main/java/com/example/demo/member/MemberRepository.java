package com.example.demo.member;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Member;

public interface MemberRepository extends JpaRepository<Member,Integer>{

	Member findByName(String name);

}
