package com.realdolmen.backend.config;

import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Configuration
public class WebMvcConfig implements Filter {

    private final List<String> allowedOrigins = Arrays.asList("http://localhost:4200");

    @Override
    public void doFilter(ServletRequest request, ServletResponse servletResponse, FilterChain chain)
            throws IOException, ServletException
    {
        final HttpServletResponse response = (javax.servlet.http.HttpServletResponse) servletResponse;
        HttpServletRequest req = (HttpServletRequest) request;
        String origin = req.getHeader("Origin");
        response.setHeader("Access-Control-Allow-Origin", allowedOrigins.contains(origin) ? origin : "");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type");
        response.setHeader("Access-Control-Max-Age", "3600");
        if ("OPTIONS".equalsIgnoreCase(((HttpServletRequest) request).getMethod())) {
            response.setStatus(javax.servlet.http.HttpServletResponse.SC_OK);
        } else {
            chain.doFilter(request, servletResponse);
        }
    }


}
