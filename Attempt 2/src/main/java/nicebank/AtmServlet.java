package nicebank;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AtmServlet extends HttpServlet
{
	private static final long serialVersionUID = -6136363346177332739L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
                                                throws ServletException, IOException
    {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println(
             "<html><head><title>ATM</title></head>" +
             "<body>" + 
             "<form action=\"/balance\" method=\"get\">" + 
             "<button type=\"submit\" id=\"balance\">Balance</button></form>" +
             "<form action=\"/withdraw\" method=\"post\">" +
             "<label for=\"amount\">Amount</label>" +
             "<input type=\"text\" id=\"amount\" name=\"amount\">" +
             "<button type=\"submit\" id=\"withdraw\">Withdraw</button>" +
             "</form></body></html>");
    }
}
