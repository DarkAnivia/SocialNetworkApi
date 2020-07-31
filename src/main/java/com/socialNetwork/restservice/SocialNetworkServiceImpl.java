package com.socialNetwork.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SocialNetworkServiceImpl implements SocialNetworkService{

    @Autowired
    private SocialNetworkRepository socialNetworkRepository;
    
    public boolean register (User user){
        System.out.print("register");
        if(user.getName().length()<=10 & user.getName().length()>=5){

            if(user.getPwd().length()<=12 & user.getPwd().length()>=8){
                System.out.println("************************everything ok **************************");

                if(!socialNetworkRepository.existsByName(user.getName())){

                    socialNetworkRepository.save(new User(user));
                    return true;

                }else{
                    throw new RegisterUnsuccesfulException("name", "name already in use");
                }
            }else{
                throw new RegisterUnsuccesfulException("password", "password must have between 8 and 12 alfanumerics");
            }
        }else{
            throw new RegisterUnsuccesfulException("name", "name must have between 5 and 10 alfanumerics");
        }
    }



}