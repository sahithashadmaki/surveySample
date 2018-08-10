/*package SurveyApplication;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

*//**
 * Application Lifecycle Listener implementation class MyContextListener
 *
 *//*
@WebListener
public class MyContextListener implements ServletContextListener {

    *//**
     * Default constructor. 
     *//*
    public MyContextListener() {
        // TODO Auto-generated constructor stub
    }

	*//**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     *//*
    public void contextDestroyed(ServletContextEvent event)  { 
         
    }

	*//**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     *//*
    public void contextInitialized(ServletContextEvent event)  { 
        ServletContext ctx=event.getServletContext();
        String url="jdbc:sqlserver://ggku3ser2;instanceName=SQL2016;databaseName=JavaSurveyDB";
		String uname="sa";
		String pass="Welcome@1234";
		DBConnection db=new DBConnection(url,uname,pass);
		ctx.setAttribute("db", db);
		
        
    }
	
}
*/