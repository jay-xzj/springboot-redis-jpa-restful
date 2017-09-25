package com.crm.login.filter;

import com.asiainfo.portal.framework.busiclient.BusiConf;
import com.asiainfo.portal.framework.busiclient.BusiSSOFilter;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Created by SS on 2017/3/20.
 */
@Component
public class PortalFilter extends BusiSSOFilter {
    @Value("${sso.url}")
    String ssoUrl;

    @Value("${sso.errPage}")
    String errPage;

    @Value("${crm.resKey}")
    String crmResKey;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ssoHomePage = ssoUrl;
        homePage = errPage;
        super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
     HttpServletRequest httprequest = (HttpServletRequest) servletRequest;
        String resKey = httprequest.getParameter("resKey");
        if (StringUtils.isEmpty(resKey)) {
            super.resKey = crmResKey;
        } else {
            super.resKey = BusiConf.getStrValue("resKey");
        }
        super.doFilter(servletRequest, servletResponse, filterChain);
        HttpServletResponse httpresponse = (HttpServletResponse)servletResponse;
        int a =httpresponse.getStatus();
    	//filterChain.doFilter(servletRequest, servletResponse);
    }
}
