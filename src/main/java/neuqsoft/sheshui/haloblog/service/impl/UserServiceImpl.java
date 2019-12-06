package neuqsoft.sheshui.haloblog.service.impl;

import neuqsoft.sheshui.haloblog.model.entity.User;
import neuqsoft.sheshui.haloblog.model.params.SignUpParam;
import neuqsoft.sheshui.haloblog.repository.UserRepository;
import neuqsoft.sheshui.haloblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public Optional<User> getCurrentUser() {
        return Optional.empty();
    }

    @Override
    public Optional<User> getByUsername(String username) {
        return Optional.empty();
    }

    @Override
    public User getByUsernameOfNonNull(String username) {
        return null;
    }

    @Override
    public Optional<User> getByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public User getByEmailOfNonNull(String email) {
        return null;
    }

    @Override
    public User updatePassword(String oldPassword, String newPassword, Integer userId) {
        return null;
    }

    @Override
    public User createBy(SignUpParam signUpParam) {
        return null;
    }

    @Override
    public void mustNotExpire(User user) {

    }

    @Override
    public boolean isSigned(SignUpParam signUpParam) {
        Assert.notNull(signUpParam.getUsername(),"Username must not be null");
        Assert.notNull(signUpParam.getEmail(),"Email must not be null");

        boolean isExist=false;
        List<User> users=userRepository.findAll();
        for (User user:users){
            if (user.getUsername().equals(signUpParam.getUsername())||user.getEmail().equals(signUpParam.getEmail())){
                isExist=true;
                break;
            }
        }
        return isExist;
    }

    @Override
    public boolean passwordMatch(User user, String plainPassword) {
        return false;
    }

    @Override
    public void setPassword(User user, String plainPassword) {

    }

    @Override
    public boolean verifyUser(String username, String password) {
        return false;
    }
}
