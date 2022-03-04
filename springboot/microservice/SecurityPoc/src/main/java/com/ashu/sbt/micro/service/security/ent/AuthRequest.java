/**
 * 
 */
package com.ashu.sbt.micro.service.security.ent;

/**
 * @author Ashok Kumar Jha (ashu.kr.jha@gmail.com)
 *
 */
public class AuthRequest {

    private String userName;
    private String ukey;
    /**
     * @return the password
     */
    public String getUkey() {
        return ukey;
    }
    /**
     * 
     */
    public AuthRequest() {
        super();
    }
    /**
     * @param username
     * @param ukey
     */
    public AuthRequest(String userName, String ukey) {
        super();
        this.userName = userName;
        this.ukey = ukey;
    }
    /**
     * @param ukey
     *            the ekey to set
     */
    public void setPassword(String ukey) {
        this.ukey = ukey;
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

}
