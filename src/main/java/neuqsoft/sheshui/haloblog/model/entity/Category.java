package neuqsoft.sheshui.haloblog.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * Category entity.
 * 标签实体类
 * @author sheshui
 */
@Data
@Entity
@Table(name = "categories")
@EqualsAndHashCode(callSuper = true)
public class Category extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 标签名
     * Category name.
     */
    @Column(name = "name",columnDefinition = "varchar(50) not null")
    private String name;
    /**
     * 别名
     * Category slug name.
     */
    @Column(name = "slug_name",columnDefinition = "varchar(50) not null",unique = true)
    private String slugName;
    /**
     * 描述
     * Description，can be display on category page.
     */
    @Column(name = "description",columnDefinition = "varchar(100) default ''")
    private String description;
    /**
     * 父标签
     * Parent category.
     */
    private Integer parentId;

    @Override
    public void prePersist(){
        super.prePersist();
        id=null;
        if (description==null){
            description="";
        }
        if (parentId==null||parentId<0){
            parentId=0;
        }
    }
}
