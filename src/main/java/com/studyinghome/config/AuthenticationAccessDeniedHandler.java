package com.studyinghome.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.studyinghome.result.CodeMsg;
import com.studyinghome.result.Result;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * AuthenticationAccessDeniedHandler
 *
 * @author Leslie
 * @email panxiang_work@163.com
 * @create 2019/4/29 11:50
 */
@Component
public class AuthenticationAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse resp,
                       AccessDeniedException e) throws IOException {
        resp.setStatus(HttpServletResponse.SC_FORBIDDEN);
        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        Result error = Result.error(CodeMsg.SECURITY_ERROR);
        out.write(new ObjectMapper().writeValueAsString(error));
        out.flush();
        out.close();
    }
}