package neuqsoft.sheshui.haloblog.model.enums;

/**
 * @author sheshui
 */

public enum CreateFrom {
    /**
     * CreateFrom Web Admin
     * 发布来源：后台管理
     */
    WEBADMIN(0),
    /**
     * Create From Wechat Application
     */
    WECHAT(1);
    private final Integer value;

    CreateFrom(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
