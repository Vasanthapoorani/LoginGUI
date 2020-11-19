package java4s;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OnServletLogin extends HttpServlet  
{
    protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");

		String user=req.getParameter("userName");
		int pass=Integer.parseInt(req.getParameter("userPassword"));

		if(user.equals("Pooja")&&pass==1234) 
                 pw.println("<h1>Login Success...!</h1>"); 
        else
                 pw.println("<h1>Login Failed...!</h1>");
		 pw.close();

	}

}
