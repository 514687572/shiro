package com.stip.net.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerExceptionResolverComposite;

import com.stip.net.utils.Log;

@Component
public class StipExceptionHandler  extends HandlerExceptionResolverComposite {
	public static Log log = new Log(LoggerFactory.getLogger(HandlerExceptionResolverComposite.class));

	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) {
		e.printStackTrace();
		if (e instanceof UnauthorizedException) {
			return new ModelAndView("error/noperms");
		} else {
			return new ModelAndView("error/500");
		}
	}
}
