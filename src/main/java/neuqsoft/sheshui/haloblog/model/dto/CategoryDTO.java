package neuqsoft.sheshui.haloblog.model.dto;

import lombok.Data;

import java.util.Date;

/**
 * Category output dto.
 * 分类DTO（数据传输对象data transfer object）
 * @author sheshui
 */
@Data
public class CategoryDTO {

    private Integer id;

    private String name;

    private String slugName;

    private String description;

    private Integer parentId;

    private Date createTime;

}
