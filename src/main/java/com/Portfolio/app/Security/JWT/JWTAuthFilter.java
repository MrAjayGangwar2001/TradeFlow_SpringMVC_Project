package com.Portfolio.app.Security.JWT;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;
import com.Portfolio.app.Security.UserData.User;

import com.Portfolio.app.Security.UserData.UserReposit;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class JWTAuthFilter extends OncePerRequestFilter {

    @Autowired
    private JWTService JService;
    @Autowired
    private UserReposit urepo;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");

        // Token :
        // eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI2IiwiZW1haWwiOiJhamF5QDVnbWFpbC5jb20iLCJpYXQiOjE3NjIyNTkwMjUsImV4cCI6MTc2MjI1OTA4NX0.lhVEEm86mirJmivwr_C0i4ONikUZht4vepsFSaxTMxg

        // If header is missing OR not Bearer token → skip the filter
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        // Extract token safely
        String token = authHeader.substring(7).trim();

        // Expired token → skip
        if (JService.isExpired(token)) {
            filterChain.doFilter(request, response);
            return;
        }

        // Get email from token
        String emailFromToken = JService.FetchEmail(token);

        if (emailFromToken != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            Optional<User> userOptional = urepo.findByEmail(emailFromToken);

            if (userOptional.isPresent()) {

                User user = userOptional.get();

                if (JService.isTokenValid(token, user)) {

                    // Session Stored

                    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(user, null,
                            user.getAuthorities());

                    authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    SecurityContextHolder.getContext().setAuthentication(authToken);
                }
            }

            filterChain.doFilter(request, response);
        }
    }
}
