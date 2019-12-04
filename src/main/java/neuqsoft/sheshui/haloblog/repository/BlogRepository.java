package neuqsoft.sheshui.haloblog.repository;

import neuqsoft.sheshui.haloblog.model.entity.Blog;
import neuqsoft.sheshui.haloblog.repository.base.BaseRepo;
import neuqsoft.sheshui.haloblog.repository.base.BlogRepo;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface BlogRepository extends BlogRepo<Blog>, JpaSpecificationExecutor<Blog> {
    @Override
    @Query("select sum(p.visits) from Blog p")
    Long countVisit();

    @Override
    @Query("select sum(p.likes) from Blog p")
    Long countLike();
}
