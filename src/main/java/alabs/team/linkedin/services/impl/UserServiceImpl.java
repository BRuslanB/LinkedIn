package alabs.team.linkedin.services.impl;

import alabs.team.linkedin.model.Company;
import alabs.team.linkedin.model.Role;
import alabs.team.linkedin.model.Speciality;
import alabs.team.linkedin.model.User;
import alabs.team.linkedin.repository.CompanyRepository;
import alabs.team.linkedin.repository.RoleRepository;
import alabs.team.linkedin.repository.SpecialityRepository;
import alabs.team.linkedin.repository.UserRepository;
import alabs.team.linkedin.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserDetailsService, UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private SpecialityRepository specialityRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findAllByEmail(username);
        if (user != null) {
            return user;
        } else {
            throw new UsernameNotFoundException("USER NOT FOUND");
        }
    }

    @Override
    public List<User> findByAllUsers(Long companyId, Long specialityId, String operand) {
        switch (operand) {
            case ("OR") -> {
                if (companyId != null && specialityId != null){
                    return userRepository.findByAllCompanyORSpeciality(companyId, specialityId);
                } else if (companyId != null) {
                    return userRepository.findByAllCompany(companyId);
                } else if (specialityId != null) {
                    return userRepository.findByAllSpeciality(specialityId);
                } else {
                    return null;
                }
            }
            case ("AND") -> {
                if (companyId != null && specialityId != null) {
                    return userRepository.findByAllCompanyAndSpeciality(companyId, specialityId);
                } else if (companyId != null) {
                    return userRepository.findByAllCompany(companyId);
                } else if (specialityId != null) {
                    return userRepository.findByAllSpeciality(specialityId);
                } else {
                    return null;
                }
            }
        }
        return null;
    }

    @Override
    public User registerUser(String userEmail, String password, String fullName, Long companyId, Long specialityId){
        User checkUser = userRepository.findAllByEmail(userEmail);
        if (checkUser == null){
            User newUser = new User();
            newUser.setEmail(userEmail);
            Role userRole = roleRepository.findByRole("ROLE_USER");
            ArrayList<Role> roles = new ArrayList<>();
            roles.add(userRole);
            newUser.setRoles(roles);
            newUser.setPassword(passwordEncoder.encode(password));
            newUser.setFullName(fullName);
            if (companyId != null) {
                Company company = companyRepository.getReferenceById(companyId);
                newUser.setCompany(company);
            }
            if (specialityId != null) {
                Speciality speciality = specialityRepository.getReferenceById(specialityId);
                newUser.setSpeciality(speciality);
            }
            return userRepository.save(newUser);
        }
        return null;
    }

    @Override
    public User updatePassword(User user, String oldPassword, String newPassword){
        User currentUser = userRepository.findById(user.getId()).orElse(null);
        if (currentUser != null){
            if (passwordEncoder.matches(oldPassword, currentUser.getPassword())){
                currentUser.setPassword(passwordEncoder.encode(newPassword));
                return userRepository.save(currentUser);
            }
        }
        return null;
    }

    public User resetPassword(Long userId, String newPassword){
        User user = userRepository.findById(userId).orElse(null);
        if (user != null){
            user.setPassword(passwordEncoder.encode(newPassword));
            return userRepository.save(user);
        }
        return null;
    }

    public User updateProfile(User user, String fullName, Long companyId, Long specialityId){
        User currentUser = userRepository.findById(user.getId()).orElse(null);
        if (currentUser != null){
            currentUser.setFullName(fullName);
            if (companyId != null) {
                Company company = companyRepository.getReferenceById(companyId);
                currentUser.setCompany(company);
            }
            if (specialityId != null) {
                Speciality speciality = specialityRepository.getReferenceById(specialityId);
                currentUser.setSpeciality(speciality);
            }
            return userRepository.save(currentUser);
        }
        return null;
    }

    @Override
    public User getUser(Long id){
        return userRepository.findById(id).orElseThrow();
    }

    @Override
    public User getUser(String userName){
        return userRepository.findAllByEmail(userName);
    }

    @Override
    public List<User> getAllUsers(){
        return userRepository.findAllByOrderByIdAsc();
    }
}