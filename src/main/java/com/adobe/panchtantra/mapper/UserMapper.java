package com.adobe.panchtantra.mapper;

import com.adobe.panchtantra.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User convertUserToModelUser(com.adobe.panchtantra.entity.User user) {
        User modelUser = new User();

        modelUser.setEmail(user.getName());
        modelUser.setId(user.getId());
        modelUser.setName(user.getName());

        return modelUser;
    }
}
