package java4s;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class filter1
 */
@WebFilter("/login")
public class filter1 implements Filter {

    
	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("Wow, Its working");
		PrintWriter pw=response.getWriter();
		HttpServletRequest req=(HttpServletRequest) request;
		int pass=Integer.parseInt(req.getParameter("userPassword"));
		if(pass<10000)
			chain.doFilter(request, response);
		else
			pw.println("<h1>Please enter the password within the range 10000</h1>");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
