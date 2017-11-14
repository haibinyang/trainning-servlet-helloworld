package top.yhb123;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class DownloadJar extends HttpServlet {
    private String message;

    @Override
    public void init() throws ServletException {
        message = "Hello world, this message is from servlet!";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置响应内容类型
        resp.setContentType("application/jar");

        ServletContext ctx = getServletContext();
        InputStream is = ctx.getResourceAsStream("/audit4j-core-2.3.0.jar");

        int read = 0;
        byte[] buf = new byte[1024];

        OutputStream os = resp.getOutputStream();
        while ((read = is.read(buf)) != -1) {
            os.write(buf, 0, read);
        }

        os.flush();
        os.close();
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}