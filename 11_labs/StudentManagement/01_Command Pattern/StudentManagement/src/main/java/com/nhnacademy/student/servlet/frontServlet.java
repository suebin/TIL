package com.nhnacademy.student.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nhnacademy.student.command.Command;
import com.nhnacademy.student.controller.*;
import lombok.extern.slf4j.Slf4j;

import static javax.servlet.RequestDispatcher.*;

/**
 * 모든 요청을 받아서 처리해주는 Servlet.
 */
@Slf4j
@WebServlet(name = "frontServlet", urlPatterns = "*.do")
public class frontServlet extends HttpServlet {
    private static final String REDIRECT_PREFIX = "redirect";

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        try {
            Command command = resolveCommand(req.getServletPath(), req.getMethod());
            String view = command.execute(req, resp);

            if (view.startsWith(REDIRECT_PREFIX)) {
                log.error("redirect-url : {}", view.substring(REDIRECT_PREFIX.length() + 1));
                resp.sendRedirect(view.substring(REDIRECT_PREFIX.length() + 1));
            } else {
                RequestDispatcher rd = req.getRequestDispatcher(view);
                rd.include(req, resp);
            }

        } catch (Exception e) {
            req.setAttribute("status_code", req.getAttribute(ERROR_STATUS_CODE));
            req.setAttribute("exception_type", req.getAttribute(ERROR_EXCEPTION_TYPE));
            req.setAttribute("message", req.getAttribute(ERROR_MESSAGE));
            req.setAttribute("exception", req.getAttribute(ERROR_EXCEPTION));
            req.setAttribute("request_uri", req.getAttribute(ERROR_REQUEST_URI));

            RequestDispatcher rd = req.getRequestDispatcher("/error/error.jsp");
            rd.forward(req, resp);
        }
    }

    private Command resolveCommand(String servletPath, String method) {
        Command command = null;

        if ("/student/list.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
            command = new StudentListController();
        } else if ("/student/register.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
            command = new StudentRegisterFormController();
        } else if ("/student/register.do".equals(servletPath) && "POST".equalsIgnoreCase(method)) {
            command = new StudentRegisterController();
        } else if ("/student/view.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
            command = new StudentViewController();
        } else if ("/student/update.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
            command = new StudentUpdateFormController();
        } else if ("/student/update.do".equals(servletPath) && "POST".equalsIgnoreCase(method)) {
            command = new StudentUpdateController();
        } else if ("/student/delete.do".equals(servletPath) && "POST".equalsIgnoreCase(method)) {
            command = new StudentDeleteController();
        } else if ("/error.do".equals(servletPath)) {
            command = new ErrorController();
        }

        return command;
    }
}
