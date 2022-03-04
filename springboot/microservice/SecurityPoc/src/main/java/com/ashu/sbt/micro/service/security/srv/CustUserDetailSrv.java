/**
 * 
 */
package com.ashu.sbt.micro.service.security.srv;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ashu.sbt.micro.service.security.ent.User;
import com.ashu.sbt.micro.service.security.rep.IUserRepo;

/**
 * @author Ashok Kumar Jha (ashu.kr.jha@gmail.com)
 *
 */
@Service
public class CustUserDetailSrv implements UserDetailsService {

    @Autowired
    private IUserRepo usrRepo;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User usr = usrRepo.getByUserName(username);
        return new org.springframework.security.core.userdetails.User(
                usr.getUserName(), usr.getPassword(), new ArrayList<>());
    }

}
