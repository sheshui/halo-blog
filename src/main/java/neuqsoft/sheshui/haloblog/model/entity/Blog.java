package neuqsoft.sheshui.haloblog.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import neuqsoft.sheshui.haloblog.model.enums.BlogStatus;
import neuqsoft.sheshui.haloblog.model.enums.CreateFrom;

import javax.persistence.*;
import java.util.Date;

/**
 * 博客内容实体类
 * Blog base entity
 * @author sheshui
 */
@Data
@Entity(name = "Blog")
@Table(name = "blog")
@EqualsAndHashCode(callSuper = true)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.INTEGER, columnDefinition = "int default 0")
public class Blog extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 博客标题
     * Blog title.
     */
    @Column(name = "title", columnDefinition = "varchar(100) not null")
    private String title;
    /**
     * 博客的状态
     * Blog status.
     */
    @Column(name = "status", columnDefinition = "int default 1")
    private BlogStatus status;
    /**
     * 博客链接
     * Blog url.
     */
    @Column(name = "url", columnDefinition = "varchar(255) not null", unique = true)
    private String url;
    /**
     * 原生文本
     * Original content,not format.
     */
    @Column(name = "original_content", columnDefinition = "text not null")
    private String originalContent;

    /**
     * Rendered content.
     * 转换后的文本
     * @see package neuqsoft.sheshui.haloblog.utils.MarkdownUtils#renderHtml(String)
     */
    @Column(name = "formate_content", columnDefinition = "text not null")
    private String formatContent;
    /**
     * 博客简介
     * Blog summary.
     */
    @Column(name = "summary", columnDefinition = "varchar(500) default ''")
    private String summary;
    /**
     * 封面缩略图
     * Cover thumbnail of the Blog.
     */
    @Column(name = "thumbnail", columnDefinition = "varchar(500) default ''")
    private String thumbnail;
    /**
     * 博客访问量
     * Blog visits.
     */
    @Column(name = "visits", columnDefinition = "bigint default 0")
    private Long visits;
    /**
     * 是否允许评论
     * Whether to allow comments.
     */
    @Column(name = "disallow_comment", columnDefinition = "int default 0")
    private Boolean disallowComment;
    /**
     * 私密博客密码
     * Blog password.
     */
    @Column(name = "password", columnDefinition = "varchar(255) default ''")
    private String password;
    /**
     * 自定义模板
     * Custom template.
     */
    @Column(name = "template", columnDefinition = "varchar(255) default ''")
    private String template;
    /**
     * 是否置顶
     * whether to the topBlog
     */
    @Column(name = "top_priority", columnDefinition = "int default ''")
    private Integer topPriority;
    /**
     * 创建方式
     * Create from,server or WeChat.
     */
    @Column(name = "create_from", columnDefinition = "int default ''")
    private CreateFrom createFrom;
    /**
     * 喜欢数
     * Likes
     */
    @Column(name = "likes", columnDefinition = "bigint default 0")
    private Long likes;

    /**
     * 编辑时间
     * Edit time.
     */
    @Column(name = "edit_time", columnDefinition = "timestamp default CURRENT_TIMESTAMP")
    private Date editTime;

    @Override
    public void prePersist() {
        super.prePersist();

        id = null;

        if (editTime == null) {
            editTime = getCreateTime();
        }
        if (status == null) {
            status = BlogStatus.DRAFT;
        }
        if (summary == null) {
            summary = "";
        }
        if (thumbnail == null) {
            thumbnail = "";
        }
        if (disallowComment == null) {
            disallowComment = false;
        }
        if (password == null) {
            password = "";
        }
        if (template == null) {
            template = "";
        }
        if (topPriority == null) {
            topPriority = 0;
        }
        if (createFrom == null) {
            createFrom = CreateFrom.WEBADMIN;
        }
        if (visits == null || visits < 0) {
            visits = 0L;
        }
        if (likes == null || likes < 0) {
            likes = 0L;
        }
        if (formatContent == null) {
            formatContent = "";
        }
    }

}
