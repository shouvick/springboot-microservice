package com.shouvick.user.service;

import com.shouvick.user.entity.User;
import com.shouvick.user.interaction.responseTemplateInteraction;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User saveUser(User user);

    responseTemplateInteraction getUserWithDepartment(Long userId);
}
