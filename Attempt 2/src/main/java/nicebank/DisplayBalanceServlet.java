package nicebank;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DisplayBalanceServlet extends HttpServlet {
	private static final long serialVersionUID = -50611199891837616L;
	
	private Account account;
    
    public DisplayBalanceServlet(Account account) {
        this.account = account;
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
                                                throws ServletException, IOException
    {
        String balance = account.getBalance().toString();

        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println(
             "<html><head><title>ATM</title></head>" +
                      "<body>Your Balance is $" + balance + "</body></html>");
    }
}
