package com.simplefanc.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

public class StartWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	/**
	 * SpringContext中相关的bean
	 *
	 * @return
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[]{SpringRootConfig.class};
	}

	/**
	 * DispatcherServlet中上下文相关的Bean
	 *
	 * @return
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[]{MVCConfig.class};
	}

	/**
	 * ServLet请求映射路径
	 *
	 * @return
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}

	/**
	 * 拦截并处理请求的编码
	 *
	 * @return
	 */
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
		filter.setEncoding("UTF-8");
		filter.setForceEncoding(true);
		return new Filter[]{filter};
	}
}
