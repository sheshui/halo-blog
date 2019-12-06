package neuqsoft.sheshui.haloblog.repository;

import neuqsoft.sheshui.haloblog.model.entity.User;
import org.springframework.lang.NonNull;

import java.util.Optional;

/**
 * @author sheshui
 */
public interface UserRepository {

    /**
     * 按用户名查询用户
     *  get user by username.
     *
     * @param username username must not be blank
     * @return an optional user
     */
    @NonNull
    Optional<User> findByUsername(@NonNull String username);

    /**
     * 按照邮箱获取
     * get user by email.
     *
     * @param email email must not be blank
     * @return an optional user
     */
    @NonNull
    Optional<User> findByEmail(@NonNull String email);
}
