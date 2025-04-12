package com.example.config;

import java.util.Date;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTUtils {
	@Value("${jwt.secret}")
	private String SECRET_KEY;
	
	@Value("${jwt.expiration}")
    private long EXPIRATION_TIME;

	
	public String generateToken(UserDetails userDetails) {
		return Jwts.builder()
				.setSubject(userDetails.getUsername())
				.claim("role", userDetails.getAuthorities().iterator().next().getAuthority())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS256, SECRET_KEY.getBytes())
				.compact();
	}
	
	public String extractUserName(String token) {
		return extractAllClaims(token).getSubject();
	}
	
	
	private boolean isTokenExpired(String token) {
		final Date expiration = extractAllClaims(token).getExpiration();
		return expiration.before(new Date());
	}
	
	public boolean validateToken(String token,UserDetails userDetails) {
		final String username = extractUserName(token);
		return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
	}
	
	
	
	private Claims extractAllClaims(String token) {
	    return Jwts.parser()
	            .setSigningKey(SECRET_KEY.getBytes())
	            .parseClaimsJws(token)
	            .getBody();
	}
		
	
	
}
