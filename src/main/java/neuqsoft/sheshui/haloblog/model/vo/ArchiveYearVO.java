package neuqsoft.sheshui.haloblog.model.vo;

import lombok.Data;
import neuqsoft.sheshui.haloblog.model.dto.blog.BaseBlogMinimalDTO;

import java.util.Comparator;
import java.util.List;

@Data
public class ArchiveYearVO {
    private Integer year;
    private List<BaseBlogMinimalDTO> blogs;
    public static class ArchiveComparator implements Comparator<ArchiveYearVO>{
        @Override
        public int compare(ArchiveYearVO left, ArchiveYearVO right) {
            return right.getYear()-left.getYear();
        }
    }
}
