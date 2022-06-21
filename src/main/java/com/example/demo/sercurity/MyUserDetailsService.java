package com.example.demo.sercurity;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.Member;
import com.example.demo.member.MemberService;
@Service
public class MyUserDetailsService implements UserDetailsService{
	@Autowired
	MemberService memberService;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Member currentMember =memberService.findByMemberName(username);

		return new User(currentMember.getName(),currentMember.getPwd(),new ArrayList());
	}

}
