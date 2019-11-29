package neuqsoft.sheshui.haloblog.controller;

import neuqsoft.sheshui.haloblog.model.entity.Blog;
import neuqsoft.sheshui.haloblog.model.enums.BlogStatus;
import neuqsoft.sheshui.haloblog.repository.base.BaseRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

/**
 * Base blog repository
 *
 * @author sheshui
 */
public interface BlogRepo<BLOG extends Blog> extends BaseRepo<BLOG,Integer> {

    /**
     * Counts visits.(Need to be overridden)
     *
     * @return total visits
     */
    @Query("select sum(p.visits) from Blog p")
    Long countVisit();

    /**
     * Counts likes.(Need to be overridden)
     *
     * @return total likes
     */
    @Query("select sum(p.likes) from Blog p")
    Long countLike();
    /**
     * Finds blog by status and pageable.
     *
     * @param status   post status must not be null
     * @param pageable page info must not be null
     * @return a page of post
     */
    @NonNull
    Page<BLOG> findAllByStatus(@NonNull BlogStatus status, @NonNull Pageable pageable);
    /**
     * Finds blog by status.
     *
     * @param status post status must not be null
     * @return a list of post
     */
    @NonNull
    List<BLOG> findAllByStatus(@NonNull BlogStatus status);
    /**
     * Finds blog by status.
     *
     * @param status post status must not be null
     * @param sort   sort info must not be null
     * @return a list of post
     */
    @NonNull
    List<BLOG> findAllByStatus(@NonNull BlogStatus status, @NonNull Sort sort);
    /**
     * Finds all post by status and create time before.
     *
     * @param status     status must not be null
     * @param createTime create time must not be null
     * @param pageable   page info must not be null
     * @return a page of post
     */
    @NonNull
    Page<BLOG> findAllByStatusAndCreateTimeBefore(@NonNull BlogStatus status,@NonNull Date createTime,@NonNull Pageable pageable);
    /**
     * Finds all post by status and create time after.
     *
     * @param status     status must not be null
     * @param createTime create time must not be null
     * @param pageable   page info must not be null
     * @return a page of post
     */
    @NonNull
    Page<BLOG> findAllByStatusAndCreateTimeAfter(@NonNull BlogStatus status,@NonNull Date createTime,@NonNull Pageable pageable);

}
