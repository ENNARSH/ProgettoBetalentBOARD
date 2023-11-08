package com.progetto.betalent.board.service;




import com.progetto.betalent.board.entitys.Employee;
import com.progetto.betalent.board.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private EmployeeRepo employeeRepo;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Employee user = employeeRepo.findByEmail(email);
        if (user == null){
            throw new UsernameNotFoundException("Username or passowrd not found");
        }
        return new CustomUserDetails(
                user.getEmail(),
                user.getPassword(),
                authorities(),
                user.getEmployeename());
    }

    public Collection<? extends GrantedAuthority> authorities (){
        return Arrays.asList(new SimpleGrantedAuthority("USER"));
    }
}
