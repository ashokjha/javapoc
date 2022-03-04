/**
 * 
 */
package com.ashu.sbt.micro.service.security.rep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashu.sbt.micro.service.security.ent.User;

/**
 * @author Ashok Kumar Jha (ashu.kr.jha@gmail.com)
 *
 */
@Repository
public interface IUserRepo extends JpaRepository<User, Integer> {

    /**
     * @param username
     * @return
     */
    User getByUserName(String username);

}
