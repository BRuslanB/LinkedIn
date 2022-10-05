package alabs.team.LinkedIn.services;

import alabs.team.LinkedIn.model.User;

import java.util.List;

public interface UserService {
    User registerUser(String userEmail, String password, String fullName, Long companyId, Long specialityId);
    User updatePassword(User user, String oldPassword, String newPassword);
    User getUser(Long id);
    User getUser(String userName);
    List<User> getAllUsers();
    List<User> findByAllUsers(Long companyId, Long specialityId, String operand);
}