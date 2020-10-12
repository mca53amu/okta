package com.test.okta;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	@GetMapping("/")
	public ResponseEntity<String> okta(@AuthenticationPrincipal OidcUser user) {
		
		return ResponseEntity.ok().body(user.getIdToken().getTokenValue());
	}
	
	@GetMapping("/test")
	public String test() {
		System.out.println("hi");
		return "Hi";
	}
	
	@PostMapping("/test")
	public String test3() {
		System.out.println("hello");
		return "Hellow";
	}
}
