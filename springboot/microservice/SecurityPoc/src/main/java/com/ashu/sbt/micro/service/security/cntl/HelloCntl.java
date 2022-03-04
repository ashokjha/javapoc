/**
 * 
 */
package com.ashu.sbt.micro.service.security.cntl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashu.sbt.micro.service.security.ent.AuthRequest;
import com.ashu.sbt.micro.service.security.srv.CustUserDetailSrv;
import com.ashu.sbt.micro.service.security.util.JwtUtil;

/**
 * @author Ashok Kumar Jha (ashu.kr.jha@gmail.com)
 *
 */
@RestController
@RequestMapping("/")
public class HelloCntl {

    @Autowired
    private AuthenticationManager authm;

    @Autowired
    private JwtUtil jwtutl;

    @Autowired
    private CustUserDetailSrv userDetail;

    @GetMapping()
    public String welcome() {
        return ("Welcome To Boot with JWT Security by Ashu");
    }
    @PostMapping("auth")
    public String autheticate(@RequestBody AuthRequest ar) throws Exception {
        try {
            authm.authenticate(new UsernamePasswordAuthenticationToken(
                    ar.getUserName(), ar.getUkey()));
            return jwtutl.generateToken(
                    userDetail.loadUserByUsername(ar.getUserName()));

        } catch (AuthenticationException exp) {
            throw new Exception(
                    "Invalid Username/Password ->" + exp.getMessage());
        }
    }

    @GetMapping("b")
    public String bello() {
        return ("bello S");
    }
}
