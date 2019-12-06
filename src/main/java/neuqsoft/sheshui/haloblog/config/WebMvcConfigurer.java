package neuqsoft.sheshui.haloblog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

/**
 * @author sheshui
 */
@Configuration
public class WebMvcConfigurer implements org.springframework.web.servlet.config.annotation.WebMvcConfigurer {
    /**
     * 视图跳转控制器
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/admin").setViewName("admin");
        registry.addViewController("/login").setViewName("login");
    }

    /**
     * 静态资源管理
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("templates/themes/")
                .addResourceLocations("templates/admin/")
                .addResourceLocations("classpath:/admin/")
                .addResourceLocations("static/");
        registry.addResourceHandler("/upload/**")
                .addResourceLocations("upload/");
        registry.addResourceHandler("/backup/**")
                .addResourceLocations("backup/");
        registry.addResourceHandler("/admin/**")
                .addResourceLocations("classpath:/admin/");
    }

    /**
     * 注册拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/account/signin","/account/signup","/admin/**")
                .excludePathPatterns("/js/**","/css/**");
    }
}
