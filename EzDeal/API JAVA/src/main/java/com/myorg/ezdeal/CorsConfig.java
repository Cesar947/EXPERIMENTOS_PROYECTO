package com.myorg.ezdeal;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/*
@Slf4j
@Component
public class CorsFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(final HttpServletRequest request, final HttpServletResponse response,
                                    final FilterChain filterChain) throws ServletException, IOException {
       response.addHeader("Access-Control-Allow-Origin", "*");
       response.addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, PATCH, HEAD, OPTIONS");
       //response.addHeader("Access-Control-Allow-Headers", "Origin, Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers, X-Auth-Token");
       response.addHeader("Access-Control-Allow-Headers", "Content-Type");
       response.addHeader("Access-Control-Expose-Headers", "Access-Control-Allow-Origin, Access-Control-Allow-Credentials");
       response.addHeader("Access-Control-Allow-Credentials", "true");
       response.addIntHeader("Access-Control-Max-Age", 86400);

       if(request.getMethod().equals("OPTIONS")){
           log.info("***********************");
           log.info("Opchons");
       }

       log.info(request.getMethod(),toString());
       log.info("***********************");
       log.info("QUE PASAAAAAAAAAA");

       filterChain.doFilter(request, response);
    }
}

 */

public class CorsConfig{

    @Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurer() {

            @Override
            public void addCorsMappings(CorsRegistry registry){
                registry.addMapping("/**")
                        .allowedMethods("GET","POST","PUT","PATCH","DELETE")
                        .allowedHeaders("*")
                        .allowedOrigins("*");
            }
        };
    }

}