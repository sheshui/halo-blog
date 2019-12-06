package neuqsoft.sheshui.haloblog.security.token;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author sheshui
 */
@Data
public class AuthToken {

    /**
     * Access token
     */
    @JsonProperty("access_token")
    private String accessToken;

    /**
     * Expired in.(seconds)
     */
    @JsonProperty("expired_in")
    private String expiredIn;

    /**
     * Refresh token
     */
    @JsonProperty("refresh_token")
    private String refreshToken;


}
