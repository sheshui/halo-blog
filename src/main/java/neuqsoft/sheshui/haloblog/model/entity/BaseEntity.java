package neuqsoft.sheshui.haloblog.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 所有实体类的父类
 * 用于标注生成和更新时间
 * @author sheshui
 */
@Data
public class BaseEntity {

    @Column(name = "create_time", columnDefinition = "timestamp default CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    @Column(name = "update_time", columnDefinition = "timestamp default CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    @Column(name = "deleted", columnDefinition = "TINYINT default 0")
    private Boolean deleted = false;

    protected void prePersist() {
        deleted = false;
        Date now = new Date();
        if (createTime == null) {
            createTime = now;
        }
        if (updateTime == null) {
            updateTime = now;
        }

    }

    @PreUpdate
    protected void preUpdate() {
        updateTime = new Date();
    }

    @PreRemove
    protected void preRemote() {
        updateTime = new Date();
    }
}
