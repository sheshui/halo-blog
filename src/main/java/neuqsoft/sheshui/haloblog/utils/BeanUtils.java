package neuqsoft.sheshui.haloblog.utils;


import org.springframework.beans.BeanWrapperImpl;
import org.springframework.lang.NonNull;
import org.springframework.util.Assert;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;

public class BeanUtils {

    public static void updateProperties(@NonNull Object source,@NonNull Object target) {
        Assert.notNull(source,"source object must not be null");
        Assert.notNull(target,"target object must not be null");

        try {
            org.springframework.beans.BeanUtils.copyProperties(source,target,getNullPropertyNames(source));
        }catch (Exception e){
            throw e;
        }
    }
    @NonNull
    private static String[] getNullPropertyNames(@NonNull Object source){
        return getNullPropertyNameSet(source).toArray(new String[0]);
    }
    /**
     * Gets null names set of property.
     *
     * @param source object data must not be null
     * @return null name set of property
     */
    @NonNull
    private static Set<String> getNullPropertyNameSet(@NonNull Object source) {

        Assert.notNull(source, "source object must not be null");
        BeanWrapperImpl beanWrapper = new BeanWrapperImpl(source);
        PropertyDescriptor[] propertyDescriptors = beanWrapper.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<>();

        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            String propertyName = propertyDescriptor.getName();
            Object propertyValue = beanWrapper.getPropertyValue(propertyName);

            // if property value is equal to null, add it to empty name set
            if (propertyValue == null) {
                emptyNames.add(propertyName);
            }
        }

        return emptyNames;
    }
}
