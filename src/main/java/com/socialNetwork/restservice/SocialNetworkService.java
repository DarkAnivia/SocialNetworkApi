package com.socialNetwork.restservice;

import org.springframework.stereotype.Service;

@Service
public interface SocialNetworkService {

    public boolean register (User user);
    
}