package neuqsoft.sheshui.haloblog.model.params;

import lombok.Data;
import neuqsoft.sheshui.haloblog.model.dto.base.InputConverter;
import neuqsoft.sheshui.haloblog.model.entity.User;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author sheshui
 */
@Data
public class SignUpParam implements InputConverter<User> {

    @NotBlank(message = "用户名不能为空")
    @Size(max = 255, message = "用户名长度不能超过 {max}")
    private String username;


    @NotBlank(message = "邮箱不能为空")
    @Size(max = 255, message = "邮箱长度不能超过 {max}")
    private String email;


    @NotBlank(message = "登录密码不能为空")
    @Size(max = 100, message = "用户密码长度不能超过 {max}")
    private String password;

    @NotBlank(message = "登录密码不能为空")
    @Size(max = 100, message = "用户密码长度不能超过 {max}")
    private String confirmPassword;
}
