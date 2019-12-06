package neuqsoft.sheshui.haloblog.repository.base;

import neuqsoft.sheshui.haloblog.model.entity.Blog;
import neuqsoft.sheshui.haloblog.model.enums.BlogStatus;
import neuqsoft.sheshui.haloblog.repository.base.BaseRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Base blog repository
 *
 * @author sheshui
 */
public interface BaseBlogRepo<BLOG extends Blog> extends BaseRepo<BLOG, Integer> {

    /**
     * 查询访问总数
     * Counts visits.(Need to be overridden)
     *
     * @return total visits
     */
    @Query("select sum(p.visits) from Blog p")
    Long countVisit();

    /**
     * 查询喜欢总数
     * Counts likes.(Need to be overridden)
     *
     * @return total likes
     */
    @Query("select sum(p.likes) from Blog p")
    Long countLike();

    /**
     * 依照发布状态和页面信息查询
     * Finds blog by status and pageable.
     *
     * @param status   blog status must not be null
     * @param pageable page info must not be null
     * @return a page of blog
     */
    @NonNull
    Page<BLOG> findAllByStatus(@NonNull BlogStatus status, @NonNull Pageable pageable);

    /**
     * 依照发布状态查询
     * Finds blog by status.
     *
     * @param status blog status must not be null
     * @return a list of blog
     */
    @NonNull
    List<BLOG> findAllByStatus(@NonNull BlogStatus status);

    /**
     * 依照发布状态查询排序结果
     * Finds blog by status.
     *
     * @param status post status must not be null
     * @param sort   sort info must not be null
     * @return a list of blog
     */
    @NonNull
    List<BLOG> findAllByStatus(@NonNull BlogStatus status, @NonNull Sort sort);

    /**
     * 按照发布状态、页面信息和时间查找之前的博客
     * Finds all blog by status and create time before.
     *
     * @param status     status must not be null
     * @param createTime create time must not be null
     * @param pageable   page info must not be null
     * @return a page of blog
     */
    @NonNull
    Page<BLOG> findAllByStatusAndCreateTimeBefore(@NonNull BlogStatus status, @NonNull Date createTime, @NonNull Pageable pageable);

    /**
     * 按照发布状态、页面信息和时间查找之后的博客
     * Finds all blog by status and create time after.
     *
     * @param status     status must not be null
     * @param createTime create time must not be null
     * @param pageable   page info must not be null
     * @return a page of blog
     */
    @NonNull
    Page<BLOG> findAllByStatusAndCreateTimeAfter(@NonNull BlogStatus status, @NonNull Date createTime, @NonNull Pageable pageable);

    /**
     * 按照博客链接和发布状态获取Optional对象
     * Gets blog by url and status.
     *
     * @param url    url must not be blank
     * @param status statis must not be null
     * @return an optional blog
     */
    @NonNull
    Optional<BLOG> getByUrlAndStatus(@NonNull String url, @NonNull BlogStatus status);

    /**
     * 按照发布状态查询发布博客数
     * Counts blog by status and type.
     *
     * @param status status
     * @return blog count
     */
    long countByStatus(@NonNull BlogStatus status);

    /**
     * 按照标题判断博客是否存在
     *
     * @param title blog title
     * @return if blog is exist
     */
    boolean existsByUrl(@NonNull String title);

    /**
     * 按照标题和id判断博客是否存在
     *
     * @param id    blog id
     * @param title blog title
     * @return if blog is exit
     */
    boolean existsByIdAndUrl(@NonNull Integer id, @NonNull String title);

    /**
     * 按照博客链接获取博客
     * Get blog by url
     *
     * @param url blog url
     * @return an optional of blog
     */
    Optional<BLOG> getByUrl(@NonNull String url);

    /**
     * 更新访问数
     *
     * @param visit  访问数
     * @param blogId 博客id
     * @return int
     */
    @Modifying
    @Query("update Blog p set p.visits=p.visits+:visits where p.id=:blogId")
    int updateVisit(@Param("visit") long visit, @Param("blogId") @NonNull Integer blogId);

    /**
     * 更新喜欢数
     * @param likes 喜欢数
     * @param blogId 博客id
     * @return int
     */
    @Modifying
    @Query("update Blog p set p.likes=p.likes+:likes where p.id=:blogId")
    int updateLikes(@Param("likes") long likes, @Param("blogId") @NonNull Integer blogId);
}
