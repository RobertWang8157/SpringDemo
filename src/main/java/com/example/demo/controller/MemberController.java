package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.jwt.AuthenticationRequest;
import com.example.demo.jwt.AuthenticationResponse;
import com.example.demo.jwt.JwtUtil;
import com.example.demo.member.MemberService;
import com.example.demo.model.Member;

@RestController
@RequestMapping(path = "member")
public class MemberController {
	private final MemberService memberService;
	@Resource
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private JwtUtil jwtUtil;

	public MemberController(MemberService memberService) {
		this.memberService = memberService;

	}


	@Transactional
	@RequestMapping(value = "/getall")
	public List<Member> getMember() {
		return memberService.getMembers();

	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public List<Member> add(@RequestBody List<Member> members) throws Exception {

		return memberService.saveAll(members);

	}

	@RequestMapping(value = "/get/{id}")

	public Member getById(@PathVariable("id") int id) {

		return Optional.ofNullable(memberService.findById(id)).orElseThrow();
	}

	@RequestMapping(value = "/auth", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationManager(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUserName(), authenticationRequest.getPassword()));
		} catch (Exception e) {
			throw new Exception("Incorrect username and password!");
		}

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUserName());
		final String jwt = jwtUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
	
	
	@RequestMapping(value = "/delete/{id}")
	public void deleteMember(@PathVariable("id") int id) throws Exception {
		memberService.delete(id);
	}
}
