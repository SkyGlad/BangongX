package org.hdxy.bangong.config.security;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 当访问权限不足时候 自定义返回接口
 */
@Component
public class RestfulAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        //设置响应状态码
        httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
        //设置响应数据格式
        httpServletResponse.setContentType("application/json;charset=utf-8");
        //输入响应内容
        PrintWriter writer = httpServletResponse.getWriter();
        String json="{\"status\":\"403\",\"msg\":\"拒绝访问\"}";
        writer.write(json);
        writer.flush();
    }
}
