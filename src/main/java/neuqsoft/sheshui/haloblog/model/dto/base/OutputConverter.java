package neuqsoft.sheshui.haloblog.model.dto.base;

import org.hibernate.validator.internal.util.DomainNameUtil;
import org.springframework.lang.NonNull;

import static neuqsoft.sheshui.haloblog.utils.BeanUtils.updateProperties;

public interface OutputConverter<DTO extends OutputConverter<DTO, DOMAIN>,DOMAIN> {

    @NonNull
    default <T extends DTO> T convertFrom(@NonNull DOMAIN domain){
        updateProperties(domain,this);
        return (T) this;
    }
}
