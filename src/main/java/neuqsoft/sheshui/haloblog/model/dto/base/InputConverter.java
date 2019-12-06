package neuqsoft.sheshui.haloblog.model.dto.base;


import neuqsoft.sheshui.haloblog.utils.BeanUtils;
import neuqsoft.sheshui.haloblog.utils.ReflectionUtils;

import java.lang.reflect.ParameterizedType;
import java.util.Objects;

public interface InputConverter<DOMAIN> {

    default DOMAIN convertTo(){
        //获取输入数据
        ParameterizedType currentType=parameterizedType();

        //Assert not equal
        Objects.requireNonNull(currentType,"connot fetch actual type because parameterized type is null");

        Class<DOMAIN> domainClass=(Class<DOMAIN>) currentType.getActualTypeArguments()[0];

        return BeanUtils.transformFrom(this,domainClass);

    }

    default void update(DOMAIN domain){
        BeanUtils.updateProperties(this,domain);
    }

    default ParameterizedType parameterizedType(){
        return ReflectionUtils.getParameterizedType(InputConverter.class,this.getClass());
    }
}
