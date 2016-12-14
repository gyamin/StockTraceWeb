package com.gyamin.stocktrace.entity;

import java.time.LocalDate;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 */
@Entity(listener = UsersListener.class)
@Table(name = "users")
public class Users {

    /** */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    /** */
    @Column(name = "login_id")
    String loginId;

    /** */
    @Column(name = "user_name")
    String userName;

    /** */
    @Column(name = "password")
    String password;

    /** */
    @Column(name = "role")
    String role;

    /** */
    @Column(name = "last_login")
    LocalDate lastLogin;

    /** 
     * Returns the id.
     * 
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /** 
     * Sets the id.
     * 
     * @param id the id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /** 
     * Returns the loginId.
     * 
     * @return the loginId
     */
    public String getLoginId() {
        return loginId;
    }

    /** 
     * Sets the loginId.
     * 
     * @param loginId the loginId
     */
    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    /** 
     * Returns the userName.
     * 
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /** 
     * Sets the userName.
     * 
     * @param userName the userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /** 
     * Returns the password.
     * 
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /** 
     * Sets the password.
     * 
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /** 
     * Returns the role.
     * 
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /** 
     * Sets the role.
     * 
     * @param role the role
     */
    public void setRole(String role) {
        this.role = role;
    }

    /** 
     * Returns the lastLogin.
     * 
     * @return the lastLogin
     */
    public LocalDate getLastLogin() {
        return lastLogin;
    }

    /** 
     * Sets the lastLogin.
     * 
     * @param lastLogin the lastLogin
     */
    public void setLastLogin(LocalDate lastLogin) {
        this.lastLogin = lastLogin;
    }
}