package com.example.springrocking.Filters;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.UnsupportedCharsetException;

import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StreamUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.server.ServletServerHttpRequest;


@Component
public class LoggingFilter implements Filter{


    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingFilter.class);


    @Override
    public void doFilter(ServletRequest request,ServletResponse response, FilterChain filterChain) throws ServletException, IOException{

        /* ContentCachingRequestWrapper httpRequest = new ContentCachingRequestWrapper((HttpServletRequest)request) ;
        ContentCachingResponseWrapper httpResponse = new ContentCachingResponseWrapper((HttpServletResponse)response);

        //HttpServletRequest httpRequest = (HttpServletRequest) request;

        //HttpServletResponse httpResponse = (HttpServletResponse) response;
 
        //byte[] body = StreamUtils.copyToByteArray(request.getInputStream());
 
        //Map<String, Object> jsonRequest = new ObjectMapper().readValue(body, Map.class);
 
        //System.out.println(jsonRequest);

        
        long startTime = System.currentTimeMillis();

        String requestBody = getStringValue(httpRequest.getContentAsByteArray(), request.getCharacterEncoding());

        performRequestAudit(httpRequest);

        filterChain.doFilter(request, response);

        System.out.println(requestBody + "-------");

        long time_took = System.currentTimeMillis() - startTime;


        //String responseBody = getStringValue(httpResponse.getContentAsByteArray(), response.getCharacterEncoding());

        LOGGER.info(
                "FINISHED PROCESSING : METHOD={}; REQUESTURI={}; REQUEST PAYLOAD={}; RESPONSE CODE={}; RESPONSE={}; TIM TAKEN={}, request body={}",
                httpRequest.getMethod(), httpRequest.getRequestURI(), "request",httpResponse.getStatus(), "",
                time_took, requestBody);
                //httpRequest.getReader().lines().collect(Collectors.joining(System.lineSeparator()))
        //
        //responseWrapper.copyBodyToResponse(); */

        if (request instanceof HttpServletRequest && response instanceof HttpServletResponse) {
            ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper((HttpServletRequest) request);
            ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper((HttpServletResponse) response);
            try {
                filterChain.doFilter(requestWrapper, responseWrapper);
            } finally {
                performRequestAudit(requestWrapper);
                performResponseAudit(responseWrapper);
            }
        } else {
            filterChain.doFilter(request, response);
        }
        
    }


    private String getStringValue(byte[] contentAsByteArray, String characterEncoding) {
        try{
            return new String(contentAsByteArray, 0, contentAsByteArray.length, characterEncoding);
        }
        catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        return "";
    }

    private void performRequestAudit(ContentCachingRequestWrapper requestWrapper) {
        if (requestWrapper != null && requestWrapper.getContentAsByteArray() != null && requestWrapper.getContentAsByteArray().length > 0) {
            LOGGER.info("\n Headers:: {} \n Request Body:: {}", new ServletServerHttpRequest((HttpServletRequest)requestWrapper.getRequest()).getHeaders(),
                    getPayLoadFromByteArray(requestWrapper.getContentAsByteArray(), requestWrapper.getCharacterEncoding()));
        }
    }

    private void performResponseAudit(ContentCachingResponseWrapper responseWrapper)
        throws IOException {
        if (responseWrapper != null && responseWrapper.getContentAsByteArray() != null
                && responseWrapper.getContentAsByteArray().length > 0) {
                    LOGGER.info("Response Body:: {}", getPayLoadFromByteArray(responseWrapper.getContentAsByteArray(),
                    responseWrapper.getCharacterEncoding()));
        } else {
            performErrorResponseAudit(responseWrapper);
        }
        responseWrapper.copyBodyToResponse();
    }

    private void performErrorResponseAudit(ContentCachingResponseWrapper responseWrapper) {
        LOGGER.warn("HTTP Error Status Code::" + responseWrapper.getStatus());
    }

    private String getPayLoadFromByteArray(byte[] requestBuffer, String charEncoding) {
        String payLoad = "";
        try {
            payLoad = new String(requestBuffer, charEncoding);
        } catch (UnsupportedEncodingException unex) {
            payLoad = "Unsupported-Encoding";
        }
        return payLoad;
    }
    
}
