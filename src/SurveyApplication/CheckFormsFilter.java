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

import org.apache.log4j.Logger;

import DAO.CheckFormsDAO;

/**
 * Servlet Filter implementation class CheckFormsFilter
 */
@WebFilter("/CheckFormsFilter")
public class CheckFormsFilter implements Filter {
	CheckFormsDAO chkForm;
	 private static final Logger logr = Logger.getLogger(CheckFormsFilter.class.getName());
    /**
     * Default constructor. 
     */
    public CheckFormsFilter() {
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

		// pass the request along the filter chain
		PrintWriter out=response.getWriter();
		 HttpServletRequest req = (HttpServletRequest) request;
			HttpServletResponse res = (HttpServletResponse) response; 
			HttpSession session =req.getSession(false);
		String formId=request.getParameter("id");
		AdminInfoClass admin = (AdminInfoClass) session.getAttribute("admin");
		int adminId=admin.getId();
		boolean value=chkForm.formCheck(Integer.parseInt(formId), adminId);
		if(value){
		chain.doFilter(request, response);
		}
		else{
			logr.error("----cannot edit the form----");
			out.println("cannot edit the form");
			
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	 chkForm= CheckFormsDAO.getObj();
	}

}
