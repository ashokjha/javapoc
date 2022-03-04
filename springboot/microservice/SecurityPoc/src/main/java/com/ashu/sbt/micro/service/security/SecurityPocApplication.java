package com.ashu.sbt.micro.service.security;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ashu.sbt.micro.service.security.ent.User;
import com.ashu.sbt.micro.service.security.rep.IUserRepo;

@SpringBootApplication
public class SecurityPocApplication {
    @Autowired
    private IUserRepo usrRp;

    public static void main(String[] args) {
        SpringApplication.run(SecurityPocApplication.class, args);
    }

    @PostConstruct
    public void initUsers() {
        List<User> users = Stream
                .of(new User(101, "Ashu", "Ashu", "ashu.kr.jha@gmail.com"),
                        new User(102, "Ashukr", "Ashukr",
                                "ashujha@yahoo.co.uk"))
                .collect(Collectors.toList());
        usrRp.saveAll(users);
    }

}
