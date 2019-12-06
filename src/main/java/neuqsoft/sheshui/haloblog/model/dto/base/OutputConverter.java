package neuqsoft.sheshui.haloblog.model.dto.base;

import org.hibernate.validator.internal.util.DomainNameUtil;
import org.springframework.lang.NonNull;

import static neuqsoft.sheshui.haloblog.utils.BeanUtils.updateProperties;

public interface OutputConverter<DTO extends OutputConverter<DTO, DOMAIN>,DOMAIN> {
    /**
     * 由实体类转换为DTO接口类
     * @param domain 实体类
     * @param <T> DTO接口类
     * @return dto
     */
    @NonNull
    default <T extends DTO> T convertFrom(@NonNull DOMAIN domain){
        updateProperties(domain,this);
        return (T) this;
    }
}
