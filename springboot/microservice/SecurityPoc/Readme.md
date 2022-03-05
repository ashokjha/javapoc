**Spring Security**
Following spring boot functionality used for authentication and authorization sthe application

|Library|Version|
|----------------------------|---------|
|java|1.8|
|spring-boot|2.6.4|
|spring-boot-starter-web||
|spring-boot-starter-security||
|spring-boot-starter-data-jpa||
|h2||
|jjwt|0.9.1|

```
package com.ashu.sbt.micro.service.security.cfg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.ashu.sbt.micro.service.security.flt.TokenFilter;
import com.ashu.sbt.micro.service.security.srv.CustUserDetailSrv;

/**
 * @author Ashok Kumar Jha (ashu.kr.jha@gmail.com)
 *
 */
@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {
    @Autowired
    private CustUserDetailSrv userDetailSrv;

    @Autowired
    private TokenFilter filter;

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.userDetailsService(userDetailSrv);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // super.configure(http);
        http.csrf().disable().authorizeRequests().antMatchers("/auth")
                .permitAll().anyRequest().authenticated().and()
                .exceptionHandling().and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(filter,
                UsernamePasswordAuthenticationFilter.class);
    }

}
```
**Filter**
```
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
```
