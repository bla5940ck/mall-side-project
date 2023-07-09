package com.rick.mall.userService;

import com.rick.mall.model.entity.User;
import com.rick.mall.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class SpringUserService implements UserDetailsService {

    @Autowired
    private IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        try {
            User user = userService.getUserByUserName(username);

            return new org.springframework.security.core.userdetails.User(
                    user.getUserName(),user.getPassword(), Collections.emptyList());
        } catch (Exception e) {
            throw new UsernameNotFoundException("UserName is wrong");
        }

    }
}
