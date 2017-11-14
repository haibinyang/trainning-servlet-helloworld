package top.yhb123;

import top.yhb123.model.Dog;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ReadContext extends HttpServlet {
    private String message;

    @Override
    public void init() throws ServletException {
        System.out.println("[HB]init");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置响应内容类型
        resp.setContentType("text/html");
        resp.setContentType("utf-8");

        //设置逻辑实现
        PrintWriter out = resp.getWriter();

        String appConfig = getServletContext().getInitParameter("appConfig");
        out.println("Context param = " + appConfig + "<br/>");
        out.println("ServerInfo = " + getServletContext().getServerInfo());
        out.println("MajorVersion = " + getServletContext().getMajorVersion());
        getServletContext().log("hb");

        Dog dog = (Dog) getServletContext().getAttribute("dog");
        out.println("Dog's breed is " + dog.getBreed());
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}