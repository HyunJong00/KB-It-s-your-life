package org.scoula.ex4;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PerformanceMonitorFilter implements Filter {

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String url = httpRequest.getRequestURI();
        String receivedAt = LocalDateTime.now().format(FORMATTER);
        long start = System.currentTimeMillis();

        chain.doFilter(request, response);

        long elapsed = System.currentTimeMillis() - start;
        System.out.println("[" + receivedAt + "] " + url + " - " + elapsed + "ms 소요.");
    }
}
