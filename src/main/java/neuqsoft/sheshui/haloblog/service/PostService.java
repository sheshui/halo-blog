package neuqsoft.sheshui.haloblog.service;

import neuqsoft.sheshui.haloblog.model.entity.Blog;
import neuqsoft.sheshui.haloblog.model.enums.BlogStatus;
import neuqsoft.sheshui.haloblog.model.params.PostQuery;
import neuqsoft.sheshui.haloblog.model.vo.ArchiveYearVO;
import neuqsoft.sheshui.haloblog.model.vo.BlogDetailVO;
import neuqsoft.sheshui.haloblog.model.vo.BlogListVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Set;

public interface PostService {
    @NonNull
    Page<Blog> pageBy(@NonNull PostQuery postQuery, @NonNull Pageable pageable);
    @NonNull
    Page<Blog> pageBy(@NonNull String keyword,@NonNull Pageable pageable);

    @NonNull
    BlogDetailVO createBy(@NonNull Blog blog, Set<Integer> tagIds, Set<Integer> categoryIds, boolean autoSave);
    @NonNull
    BlogDetailVO updateBy(@NonNull Blog blogToUpdate, Set<Integer> tagIds, Set<Integer> categoryIds, boolean autoSave);

    @NonNull
    Blog getBy(@NonNull BlogStatus status,@NonNull String url);

    @NonNull
    List<ArchiveYearVO> listYearArchives();
    @NonNull
    List<ArchiveYearVO> listMonthArchives();


    @NonNull
    BlogDetailVO importMarkdown(@NonNull String markdown,String filename);

    @NonNull
    String exportMarkdown(@NonNull Integer id);

    @NonNull
    String exportMarkdown(@NonNull Blog blog);

    @NonNull
    BlogDetailVO convertToDetailVo(@NonNull Blog blog);

    @NonNull
    Page<BlogListVO> convertToListVo(@NonNull Page<Blog> blogPage);

}
