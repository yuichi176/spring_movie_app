//package com.example.spring_movie_app.security;
//
//import org.springframework.security.web.authentication.ExceptionMappingAuthenticationFailureHandler;
//
//import javax.naming.AuthenticationException;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//public class SecurityConfigAuthenticationFailureHandler extends ExceptionMappingAuthenticationFailureHandler {
//
//    private HttpServletRequest request;
//
//    private HttpServletResponse response;
//
//    private AuthenticationException exception;
//
//    @Override
//    public void onAuthenticationFailure(
//            HttpServletRequest request,
//            HttpServletResponse response,
//            AuthenticationException exception) throws IOException, ServletException {
//
//        this.request = request;
//        this.response = response;
//        this.exception = exception;
//
//        super.onAuthenticationFailure(response, request, exception);
//    }
//}
