/**
 * 
 */
package com.ashu.sbt.micro.service.security.ent;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Ashok Kumar Jha (ashu.kr.jha@gmail.com)
 *
 */
@Entity
@Table(name = "UsersTb")
public class User {
    @Id
    private int id;
    private String userName;
    private String password;
    private String email;
    /**
     * @param id
     * @param userName
     * @param password
     * @param email
     */
    public User(int id, String userName, String password, String email) {
        super();
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
    }
    /**
     * 
     */
    public User() {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    /**
     * @param id
     *            the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }
    /**
     * @param userName
     *            the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }
    /**
     * @param password
     *            the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }
    /**
     * @param email
     *            the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return String.format("User [id=%s, userName=%s, password=%s, email=%s]",
                id, userName, password, email);
    }

}
