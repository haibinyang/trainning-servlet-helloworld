package top.yhb123;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ReadConfig extends HttpServlet {
    private String message;

    @Override
    public void init() throws ServletException {
        System.out.println("[HB]init");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置响应内容类型
        resp.setContentType("text/html");

        //设置逻辑实现
        PrintWriter out = resp.getWriter();

        String adminEmail = getServletConfig().getInitParameter("adminEmail");
        out.println("Admin Email = " + adminEmail);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}