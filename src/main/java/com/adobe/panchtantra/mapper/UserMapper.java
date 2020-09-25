package com.adobe.panchtantra.mapper;

import com.adobe.panchtantra.entity.UserEntity;
import com.adobe.panchtantra.model.UserModel;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserModel convertUserToModelUser(UserEntity userEntity) {
        UserModel modelUser = new UserModel();

        modelUser.setEmail(userEntity.getEmail());
        modelUser.setId(userEntity.getId());
        modelUser.setName(userEntity.getName());

        return modelUser;
    }
}
