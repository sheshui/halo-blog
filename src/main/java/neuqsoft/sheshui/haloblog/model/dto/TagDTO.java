package neuqsoft.sheshui.haloblog.model.dto;

import lombok.Data;

import java.util.Date;

/**
 * tag output dto.
 * 标签DTO（数据传输对象data transfer object）
 * @author Administrator
 */
@Data
public class TagDTO {

    private Integer id;

    private String name;

    private String slugName;

    private Date createTime;
}
