package neuqsoft.sheshui.haloblog.repository;

import neuqsoft.sheshui.haloblog.model.entity.Blog;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * @author sheshui
 */
public interface BaseBlogRepository extends JpaSpecificationExecutor<Blog> {

    @Query("select sum(p.visits) from Blog p")
    Long countVisit();


    @Query("select sum(p.likes) from Blog p")
    Long countLike();
}
