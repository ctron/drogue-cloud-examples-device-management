package io.drogue.examples.devices.admin;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = "*")
public class RouterFilter extends HttpFilter {

    @Override
    protected void doFilter(
            final HttpServletRequest request,
            final HttpServletResponse response,
            final FilterChain chain
    ) throws IOException, ServletException {

        chain.doFilter(request, response);

        if (response.getStatus() == 404) {
            response.setStatus(200);
            request.getRequestDispatcher("/").forward(request, response);
        }

    }
}
