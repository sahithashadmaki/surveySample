package SurveyApplication;

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
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class SessionFilter
 */
@WebFilter("/SessionFilter")
public class SessionFilter implements Filter {

    /**
     * Default constructor. 
     */
    public SessionFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		String path = ((HttpServletRequest) request).getRequestURI();
		System.out.println(path);
		
		boolean value=path.endsWith("/");
		System.out.println(value);
		
		boolean value1=path.endsWith("UserLogin.jsp");
		System.out.println(value1);
		
		System.out.println("filter called");
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        //request.getRequestDispatcher("link.html").include(request, response);  
        HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response; 
		HttpSession session =req.getSession(false);
		String sessionValid = null;
		boolean s=(session==null);
		System.out.println("session==null: "+s);
		
		boolean a=path.startsWith("/SurveyApplication/");
		System.out.println("a:  "+a);
		if(path.startsWith("/SurveyApplication/") && (!path.endsWith("/") && !path.endsWith("/Userlogin.jsp") )){
			System.out.println("---------");
			 sessionValid=(String) session.getAttribute("isvalid");
		}else{
			sessionValid="invalid";
		}
		//String sessionValid=(String) session.getAttribute("isvalid");
		
	
        if(session==null && path.endsWith("/")){  
        	System.out.println("if");
        	chain.doFilter(request, response);
        	//out.print("<br><h2>Please login first</h2></br>");
        	
        }  else if(session!=null && (path.endsWith("UserLogin.jsp") || path.endsWith("AdminServlet"))){
        	System.out.println("else if");
           	chain.doFilter(request, response);
        }
        else if(session==null || !sessionValid.equals("isvalid")){  
        	System.out.println("22 else if");
        	request.setAttribute("errorMsg", "Invalid session");
        	request.getRequestDispatcher("UserLogin.jsp").include(request, response);
              
        }  else{
        	System.out.println(" else");
        	chain.doFilter(request, response);
        }
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
