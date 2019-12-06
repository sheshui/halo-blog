package neuqsoft.sheshui.haloblog.controller;

import io.swagger.annotations.ApiOperation;
import neuqsoft.sheshui.haloblog.model.entity.User;
import neuqsoft.sheshui.haloblog.model.params.LoginParam;
import neuqsoft.sheshui.haloblog.model.params.SignUpParam;
import neuqsoft.sheshui.haloblog.security.token.AuthToken;
import neuqsoft.sheshui.haloblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 处理用户登录登出
 * @author sheshui
 */
@RestController
public class LoginController {

    @Autowired
    UserService userService;

    @PostMapping("/signin")
    @ApiOperation(value = "登录")
    public AuthToken login(@RequestBody LoginParam loginParam){
        return null;
    }

    @PostMapping("/signup")
    @ApiOperation(value = "注册")
    public User signUp(@RequestBody SignUpParam signUpParam){
        return userService.createBy(signUpParam);
    }
}
