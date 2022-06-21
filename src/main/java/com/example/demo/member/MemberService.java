package com.example.demo.member;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
//import javax.transaction.Transactional;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.example.demo.model.Member;

@Service

public class MemberService {

	@Autowired
	private MemberRepository memberRepository;

	public Member save(Member member) {

		return memberRepository.save(member);
	}

	public List<Member> saveAll(List<Member> members) throws Exception {
		List<Member> insMember = memberRepository.saveAll(members);

		return insMember;
	}
	@Transactional
	public List<Member> getMembers() {

		return memberRepository.findAll();
	}

	public Member findByMemberName(String name) {

		return memberRepository.findByName(name);

	}
	public Member findById(int id) {
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(id);
		return memberRepository.findAllById(ids).size() >= 1 ? memberRepository.findAllById(ids).get(0) : null;
	}
	
	
	public void delete(int id) throws Exception {
		memberRepository.deleteById(id);

	}
}
