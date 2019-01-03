package indi.zya.api.servlets;

import java.io.*;
import javax.servlet.http.*;

public class HelloWorld extends HttpServlet {

  private String message;

  public void init()
  {
      message = "Hello World";
      System.out.println("init HellowWorld");
  }

  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
            throws IOException
  {
      response.setContentType("text/html");

      PrintWriter out = response.getWriter();
      out.println(message);
  }

  public void destroy()
  {
      System.out.println("destroy HellowWorld");
  }
}
