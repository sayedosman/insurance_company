package com.example.demo.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class TokenUtiles {

	private long TOKEN_VALIDITY = 604800L; // 7 day
	private String TOKEN_SECRET = "shopping-api";

	public String generateToken(String username,String type) {
		Map<String, Object> clims = new HashMap<>();
		clims.put("sub", username);
		clims.put("type", type);
		clims.put("created", new Date());

		return Jwts.builder().setClaims(clims).setExpiration(getExpriationDate())
				.signWith(SignatureAlgorithm.HS512, TOKEN_SECRET).compact();
	}

	
	private Date getExpriationDate() {

		return new Date(System.currentTimeMillis() + TOKEN_VALIDITY * 1000);
	}

	public String getUserNameFromToken(String token) {

		Claims claims = getClaims(token);

		return claims.getSubject();

	}

	public boolean isTokenValid(String token) {

		return ( !isTokenExpired(token));
	}

	private boolean isTokenExpired(String token) {
		Date expiration = getClaims(token).getExpiration();
		return expiration.before(new Date());
	}

	public  Claims getClaims(String token) {
		Claims claims;
		try {
			claims = Jwts.parser().setSigningKey(TOKEN_SECRET).parseClaimsJws(token).getBody();
		} catch (Exception ex) {
			claims = null;
		}

		return claims;
	}
}
