package com.markerhub.vueblog.shiro;

import org.apache.shiro.authc.AuthenticationToken;
/*
shiro默认supports的是UsernamePasswordToken，
而现在采用了jwt的方式，所以这里自定义一个JwtToken，来完成shiro的supports方法。
 */
public class JwtToken implements AuthenticationToken {

    private String token;

    public JwtToken(String jwt){
        this.token = jwt;
    }

    /*
     * 返回身份信息，相当于用户的用户名
     */
    @Override
    public Object getPrincipal() {
        return token;
    }

    /*
     * 返回用户凭证信息，相当于用户的用户密码
     */
    @Override
    public Object getCredentials() {
        return token;
    }
}
