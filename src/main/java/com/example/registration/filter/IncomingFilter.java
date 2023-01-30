//package com.example.registration.filter;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.core.annotation.Order;
//import org.springframework.http.HttpMethod;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Order(1)
//@Component
//@Slf4j
//public class IncomingFilter implements Filter {
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        log.info("handling incoming");
//        HttpServletResponse servletResponse = (HttpServletResponse) response;
//        servletResponse.setHeader("Access-Control-Allow-Headers","*");
//        servletResponse.setHeader("Access-Control-Allow-Methods","*");
//        servletResponse.setHeader("Access-Control-Allow-Origin","*");
//
//
//        if (HttpMethod.OPTIONS.name().equalsIgnoreCase(((HttpServletRequest) request).getMethod())) {
//            servletResponse.setStatus(HttpServletResponse.SC_OK);
//            log.info("Processing options request");
//        } else {
//
//            log.info("Processing request");
//            chain.doFilter(request, servletResponse);
//        }
//
//        chain.doFilter(request,response);
//    }
//}
