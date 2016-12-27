package item;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 2010-7-17
 * Time: 10:05:16
 * To change this template use File | Settings | File Templates.
 */
public class AutoComplete extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //表示页面传过来的字符串，用于和服务器端的单词进行完整匹配
        String word = request.getParameter("word");//获取客户端发送给服务器端的参数值。
        //将字符串保存的request对象中
        request.setAttribute("word",word);
        //将请求转发给视图层（注意AJAX中，这个所谓的视图层不返回页面，听返回数据）
        request.getRequestDispatcher("/item/JQueryAutoComplete.jsp").forward(request, response);//请求转发  //将请求转发给视图（数据）层
        //getRequestDispatcher  。 按给定的路径生成资源转向处理适配器对象。

    }
}
