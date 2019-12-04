package neuqsoft.sheshui.haloblog.model.dto.blog;

import neuqsoft.sheshui.haloblog.model.dto.base.OutputConverter;
import neuqsoft.sheshui.haloblog.model.entity.Blog;
import neuqsoft.sheshui.haloblog.model.enums.BlogStatus;

import java.util.Date;

public class BaseBlogMinimalDTO implements OutputConverter<BaseBlogMinimalDTO, Blog> {
    private Integer id;
    private String title;
    private BlogStatus status;
    private String url;
    private Date updateTime;
    private Date createTime;
    private Date editTime;
}
