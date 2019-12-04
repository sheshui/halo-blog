package neuqsoft.sheshui.haloblog.model.vo;

import lombok.Data;
import neuqsoft.sheshui.haloblog.model.dto.CategoryDTO;
import neuqsoft.sheshui.haloblog.model.dto.TagDTO;
import neuqsoft.sheshui.haloblog.model.dto.blog.BaseBlogSimpleDTO;

import java.util.List;

@Data
public class BlogListVO extends BaseBlogSimpleDTO {
    private Long commentCount;
    private List<TagDTO> tags;
    private List<CategoryDTO> categorys;
}
