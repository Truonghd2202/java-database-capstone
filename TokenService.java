package com.project.back_end.services;

public class TokenService {

    public String generateToken(String username) {
        // chỉ là mã giả để minh họa
        return "token-for-" + username;
    }

    public boolean validateToken(String token) {
        return token != null && token.startsWith("token-for-");
    }

    public String getUsernameFromToken(String token) {
        if (validateToken(token)) {
            return token.replace("token-for-", "");
        }
        return null;
    }
}
