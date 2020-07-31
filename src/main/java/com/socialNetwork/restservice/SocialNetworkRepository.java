package com.socialNetwork.restservice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SocialNetworkRepository extends JpaRepository<User, Long> {

    boolean findByName(String name);
    
}