package neuqsoft.sheshui.haloblog.model.enums;

/**
 * @author sheshui
 */

public enum BlogStatus {
    /**
     * Published status.
     * 已发布
     */
    PUBLISHED(0),
    /**
     * Draft status.
     * 草稿
     */
    DRAFT(1),
    /**
     * Recycle status.
     * 回收站
     */
    RECYCLE(2),
    /**
     * Intimate status.
     * 已删除
     */
    INTIMATE(3);


    private final int value;

    BlogStatus(int value) {
        this.value=value;
    }
    public Integer getValue(){return value;}
}
