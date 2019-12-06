package neuqsoft.sheshui.haloblog.service;

import neuqsoft.sheshui.haloblog.model.entity.User;
import neuqsoft.sheshui.haloblog.model.params.UserParam;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.Optional;

/**
 * @author sheshui
 */
public interface UserService {

    String LOGIN_FAILURE_COUNT_KEY="login.failure.count";

    int MAX_LOGIN_TRY =5;

    int LOCK_MINUTES =10;

    /**
     * 获取当前用户
     * gets current user.
     *
     * @return an optional user
     */
    @NonNull
    Optional<User> getCurrentUser();

    /**
     * 按用户名获取用户
     * Gets user by username.
     * @param username username must not be blank
     * @return an optional user
     */
    @NonNull
    Optional<User> getByUsername(@NonNull String username);

    /**
     * 按用户名获取一个非空用户
     * Gets non null user by username.
     *
     * @param username username
     * @return user info
     * @throws NotFoundException throws when the username does not exist
     */
    @NonNull
    User getByUsernameOfNonNull(@NonNull String username);

    /**
     * 按邮箱地址获取用户
     * Gets user by email.
     * @param email email must not be blank
     * @return an optional user
     */
    @NonNull
    Optional<User> getByEmail(@NonNull String email);

    /**
     * Gets non null user by email.
     *
     * @param email email
     * @return user info
     * @throws NotFoundException throws when the username does not exist
     */
    @NonNull
    User getByEmailOfNonNull(@NonNull String email);

    /**
     * Update user password.
     * @param oldPassword old password must not be blank
     * @param newPassword new password must not be blank
     * @param userId user id must not be blank
     * @return updated user detail
     */
    @NonNull
    User updatePassword(@NonNull String oldPassword,@NonNull String newPassword,@NonNull Integer userId);

    /**
     * Creates an user.
     *
     * @param userParam user param must not be null.
     * @return created user
     */
    @NonNull
    User createBy(@NonNull UserParam userParam);

    /**
     * The user must not expire.
     *
     * @param user user info must not be null
     * @throws ForbiddenException throws if the given user has been expired
     */
    void mustNotExpire(@NonNull User user);

    /**
     * 判断用户名是否已经存在
     * the username is exist
     *
     * @param username username 用户名
     * @return is exist 是否存在
     */
    boolean isRegisted(@NonNull String username);

    /**
     * Checks the password is match the user password.
     *
     * @param user          user info must not be null
     * @param plainPassword plain password
     * @return true if the given password is match the user password; false otherwise
     */
    boolean passwordMatch(@NonNull User user, @Nullable String plainPassword);


    /**
     * Set user password.
     *
     * @param user          user must not be null
     * @param plainPassword plain password must not be blank
     */
    void setPassword(@NonNull User user, @NonNull String plainPassword);

    /**
     * verify user's email and username
     *
     * @param username username must not be null
     * @param password password must not be null
     * @return boolean
     */
    boolean verifyUser(@NonNull String username, @NonNull String password);

}
