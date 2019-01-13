package com.vincent.security.example.config;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;

import java.util.Collection;

/**
 * Author: vincent
 * Date: 2019-01-13 23:16:00
 * Comment:
 */

public class SmsLoginAuthenticationToken extends AbstractAuthenticationToken {

    private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

    private final String mobile;

    public SmsLoginAuthenticationToken(String mobile) {
        super(null);
        this.mobile = mobile;
        setAuthenticated(false);
    }

    public SmsLoginAuthenticationToken(String mobile, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.mobile = mobile;
        super.setAuthenticated(true);
    }

    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        if (isAuthenticated)
            throw new IllegalArgumentException("Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");
        super.setAuthenticated(false);
    }

    @Override
    public Object getPrincipal() {
        return mobile;
    }

    @Override
    public Object getCredentials() {
        throw new IllegalArgumentException("非法的调用！短信验证码无需密码！");
    }
}
