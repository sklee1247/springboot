package com.example.springboot.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.security.web.session.HttpSessionEventPublisher;

/**
 * We customize {@link AbstractSecurityWebApplicationInitializer} to enable the
 * {@link HttpSessionEventPublisher}.
 *
 * @author Rob Winch
 */
public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {

	@Override
	protected boolean enableHttpSessionEventPublisher() {
		return true;
	}

}