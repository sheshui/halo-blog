package neuqsoft.sheshui.haloblog.model.vo;

import lombok.Data;
import neuqsoft.sheshui.haloblog.model.dto.CategoryDTO;
import neuqsoft.sheshui.haloblog.model.dto.TagDTO;

import java.util.List;
import java.util.Set;

/**
 * 博客文章详情
 * @author sheshui
 */
@Data
public class BlogDetailVO {

    private Set<Integer> tagIds;

    private List<TagDTO> tags;

    private Set<Integer> categoryIds;

    private List<CategoryDTO> categories;
}
