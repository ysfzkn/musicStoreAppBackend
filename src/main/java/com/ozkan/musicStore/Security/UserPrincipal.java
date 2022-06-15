package com.ozkan.musicStore.Security;

import com.ozkan.musicStore.Model.Role;
import com.ozkan.musicStore.Model.User;
import com.ozkan.musicStore.Util.SecurityUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

@Getter // lombok provides getter methods
@NoArgsConstructor // lombok empty constructor
@AllArgsConstructor // lombok constructor which includes all args
@Builder // lombok build method to using all methods
public class UserPrincipal implements UserDetails
{
    private Long id;
    private String username;
    transient private String password; // Don't show up serialized places. Temporary.
    transient private User user; // It is just login operations, not using in JWT.
    private Set<GrantedAuthority> authorities;

    public static UserPrincipal createSuperUser()
    {
        Set<GrantedAuthority> authorities = Set.of(SecurityUtils.convertAuthority(Role.SYSTEM_MANAGER.name()));

        return UserPrincipal.builder()
                .id(-1L)
                .username("system-admin")
                .authorities(authorities)
                .build();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        return authorities;
    }

    @Override
    public String getPassword()
    {
        return password;
    }

    @Override
    public String getUsername()
    {
        return username;
    }

    // JWT....

    @Override
    public boolean isAccountNonExpired()
    {
        return true;
    }

    @Override
    public boolean isAccountNonLocked()
    {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired()
    {
        return true;
    }

    @Override
    public boolean isEnabled()
    {
        return true;
    }
}
