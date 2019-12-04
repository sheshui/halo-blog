package neuqsoft.sheshui.haloblog.model.dto.blog;

import lombok.Data;
import neuqsoft.sheshui.haloblog.model.enums.CreateFrom;

@Data
public class BaseBlogSimpleDTO extends BaseBlogMinimalDTO{
    private String summary;
    private String thumbnail;
    private Long visits=0L;
    private Boolean disallowComment;
    private String password;
    private String template;
    private Integer topPriority=0;
    private CreateFrom createFrom;
    private Long likes=0L;
}
