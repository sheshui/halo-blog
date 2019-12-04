package neuqsoft.sheshui.haloblog.model.params;

import lombok.Data;
import neuqsoft.sheshui.haloblog.model.enums.BlogStatus;

@Data
public class PostQuery {

    private String keyword;

    private BlogStatus status;

    private Integer categortId;

}
