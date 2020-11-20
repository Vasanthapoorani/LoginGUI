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
import javax.servlet.http.HttpServletResponse;

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
		String user=req.getParameter("userName");
		if(user.startsWith("employee")||user.equals("admin"))
			{
				if(user.startsWith("employee")&&pass==1234)	
					((HttpServletResponse) response).sendRedirect("employee.html");
					//chain.doFilter(request, response);
				else
					pw.println("<h1>It is not a user login</h1>");
					//((HttpServletResponse) response).sendRedirect("employee.html");
				if(user.equals("admin")&&pass==1234)
					((HttpServletResponse) response).sendRedirect("admin.html");
				//chain.doFilter(request, response);
				else
					pw.println("<h1>It is not a admin login</h1>");
		
			}
		else
			pw.println("<h1 style=\"margin-top: 240px;text-align: center;color:red;font-size:60px;\">User Unauthorized...</h1>");
			
	}

}
