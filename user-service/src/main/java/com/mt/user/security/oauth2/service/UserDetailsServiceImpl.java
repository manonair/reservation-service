package com.mt.user.security.oauth2.service;


 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mt.user.security.oauth2.model.security.User;
import com.mt.user.security.oauth2.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService  {

    @Autowired
    private UserRepository userRepository;
    
    
    
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user != null) {
            return user;
        }

        throw new UsernameNotFoundException(username);
    }
    
    public User saveUser(User user){
		BCryptPasswordEncoder bcryptPassword=new BCryptPasswordEncoder();
		user.setPassword(bcryptPassword.encode(user.getPassword()));
		User savedUser=userRepository.save(user);
		return savedUser;
		
	}

 

	public User getUserByUsername(String userName) {
		// TODO Auto-generated method stub
		User user= userRepository.findByUsername(userName);
		return user;
	}
	
	public User getUserById(long userId){
		User user=  userRepository.findOne(userId);
		return user;
	}
}
