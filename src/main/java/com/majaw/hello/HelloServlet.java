package com.majaw.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "Hello", urlPatterns = {"/api"})
public class HelloServlet extends HttpServlet {
    private final Logger logger = LoggerFactory.getLogger(HelloServlet.class);

    private HelloService service;

    public HelloServlet() {
        this(new HelloService());
    }

    HelloServlet(HelloService service) {
        this.service = service;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Request got with param");
        String name = req.getParameter("name");
        String lang = req.getParameter("lang");
        Integer langId = null;
        try {
            langId = Integer.valueOf(lang);

        } catch (NumberFormatException e) {
            logger.warn("Non-numeric language id used: " + lang);
        }
        resp.setContentType("application/json;charset=UTF-8");
        resp.getWriter().write(service.prepareGreetings(name, langId));
    }
}
