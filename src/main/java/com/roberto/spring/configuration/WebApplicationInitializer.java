package com.roberto.spring.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.roberto.spring.model.bean.Userz;



public class WebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	

	@Override
    protected Class<?>[] getRootConfigClasses()
    {
        return new Class[] {Userz.class,SecurityConfig.class};
    } 

    @Override
    protected Class<?>[] getServletConfigClasses()
    {
        return new Class[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings()
    {
        return new String[]{"/"};
    }

}
