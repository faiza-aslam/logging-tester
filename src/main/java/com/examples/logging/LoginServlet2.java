package com.examples.logging;

import static com.examples.logging.EventLogger.logEvent;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.examples.logging.EventLogger;
import com.examples.logging.EventLogger.EventLevel;
import com.examples.logging.util.EventMessageProperties;

/**
 * Sample Servlet implementation class to demonstrate JDBC Logger
 */
@WebServlet("/loginFailure")
public class LoginServlet2 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet2() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logEvent(EventLevel.INFO, 
				"john.doe" /* or get principal name from servlet request*/, 
				EventLogger.EventType.LOGIN, 
				EventMessageProperties.getFormattedMessageByKey("login.failed", "Invalid Credentials"));
		
		response.getWriter().append("Served at : ").append(request.getRequestURI());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
