/**
 * 
 */
package com.ashu.sbt.micro.service.security.flt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.ashu.sbt.micro.service.security.srv.CustUserDetailSrv;
import com.ashu.sbt.micro.service.security.util.JwtUtil;

/**
 * @author Ashok Kumar Jha (ashu.kr.jha@gmail.com)
 *
 */
@Service
public class TokenFilter extends OncePerRequestFilter {
    private static final String BEARER = "Bearer ";
    @Autowired
    private JwtUtil jwtutl;

    @Autowired
    private CustUserDetailSrv userDetailSrv;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
            HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String token = null;
        String username = null;
        String authHeader = request.getHeader("Authorization");
        if (StringUtils.hasLength(authHeader)
                && authHeader.startsWith(BEARER)) {
            token = authHeader.substring(BEARER.length());
            username = jwtutl.extractUsername(token);
        }

        if (StringUtils.hasLength(username) && SecurityContextHolder
                .getContext().getAuthentication() == null) {
            UserDetails ud = userDetailSrv.loadUserByUsername(username);
            if (jwtutl.validateToken(token, ud)) {
                UsernamePasswordAuthenticationToken upat = new UsernamePasswordAuthenticationToken(
                        ud, null, ud.getAuthorities());
                upat.setDetails(new WebAuthenticationDetailsSource()
                        .buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(upat);
            }
        }
        filterChain.doFilter(request, response);

    }
}
