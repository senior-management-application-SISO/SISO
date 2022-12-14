package siso.project;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import siso.project.web.interceptor.LoginCheckInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginCheckInterceptor())
                .order(1)
                .addPathPatterns("/**")
                .excludePathPatterns("/", "/restapi/**",  "/villagehall/**", "/admins/add", "/countyOffice/**", "/login", "/logout", "/fonts/**", "/css/**", "/plugin/**", "/scripts/**", "/*.ico", "/error");
    }
}
