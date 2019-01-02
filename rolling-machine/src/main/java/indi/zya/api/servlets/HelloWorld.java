package indi.zya.api.servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HelloWorld extends HttpServlet {

  private String message;

  public void init() throws ServletException
  {
      message = "Hello World";
      System.out.println("init HellowWorld");
  }

  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException
  {
      response.setContentType("text/html");

      PrintWriter out = response.getWriter();
      out.println("abc");
  }

  public void destroy()
  {
      System.out.println("destroy HellowWorld");
  }
}
