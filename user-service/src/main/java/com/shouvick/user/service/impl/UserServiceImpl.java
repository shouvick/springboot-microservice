package com.shouvick.user.service.impl;


import com.shouvick.user.entity.User;
import com.shouvick.user.interaction.Department;
import com.shouvick.user.interaction.responseTemplateInteraction;
import com.shouvick.user.repository.UserRepository;
import com.shouvick.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl implements UserService {
    private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public User saveUser(User user) {
        log.info("User save method called");
        return userRepository.save(user);
    }

    @Override
    public responseTemplateInteraction getUserWithDepartment(Long userId) {
        log.info("User with department method called");
        User user = userRepository.findByUserId(userId);
        responseTemplateInteraction restTemplateInteraction = new responseTemplateInteraction();
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId() , Department.class);
        restTemplateInteraction.setUser(user);
        restTemplateInteraction.setDepartment(department);
        return restTemplateInteraction;
    }
}
