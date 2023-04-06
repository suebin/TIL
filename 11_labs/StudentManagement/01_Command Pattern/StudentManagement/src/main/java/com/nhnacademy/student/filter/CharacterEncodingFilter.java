package com.nhnacademy.student.filter;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * 모든 요청의 character set 을 설정하는 Servlet Filter.
 */
@WebFilter(
        filterName = "characterEncodingFilter",
        urlPatterns = "/*",
        initParams = {
                @WebInitParam(name = "encoding", value = "UTF-8")
        }
)
public class CharacterEncodingFilter implements Filter {
    private String encoding;

    @Override
    public void init(FilterConfig filterConfig) {
        this.encoding = filterConfig.getInitParameter("encoding");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding(this.encoding);
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
