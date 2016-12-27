package item;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class GetStocksInfo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private HashMap<String,Stock> stocks;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        stocks = new HashMap<String, Stock>();
        //创建股票
        Stock szzs = new Stock(3000.0,200.1,"上证指数","200001");
        Stock pufy = new Stock(23.2,32.3,"浦发银行","1000002");
        //将两只股票保存在stocks的map中
        stocks.put(szzs.getId(), szzs);
        stocks.put(pufy.getId(), pufy);
        System.out.println(stocks);//用来测试
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //返回两只股票的价格信息。
         //计算随机数
        double sz = Math.random()*20;
        double pf = Math.random()*0.5;
        //通过随机数是奇数还是偶数来判断股票上涨还是下跌
        boolean flagsz = ((int)(Math.random()*10))%2==0;
         boolean flagpf = ((int)(Math.random()*10))%2==0;
         //将随机数和股票的当前价格进行加减的操作，得到新的当前价格

        Stock szzx= stocks.get("200001");
        Stock pufy = stocks.get("1000002");
        double temp;
        if(flagsz){
            temp = szzx.getNewPrice()+sz;

        }else{
            temp =szzx.getNewPrice()-sz;
        }

        temp=(int)(temp*100)/100.0;//对当前价格进行截取，保留小数点后两位
        szzx.setNewPrice(temp);

        if(flagpf){
            temp = pufy.getNewPrice()+pf;
        }else{
            temp = pufy.getNewPrice()-pf;
        }

        temp=(int)(temp*100)/100.0;//对当前价格进行截取，保留小数点后两位
        pufy.setNewPrice(temp);
        //测试是否生成正确的数据
        response.setContentType("text/html;charset=gbk");
        PrintWriter out = response.getWriter();
//        out.println(szzx+"<br/>"+pufy);
        
        //返回两只股票的昨天收盘，今天开盘和当前价格
        //采用Json的格式返回股票的信息
        //1、采用数组的方式回传两个股票对象
        StringBuilder builder = new StringBuilder();
//        builder.append("[{name:\"").append(szzx.getName()).append("\",id:\"").append(szzx.getId())
//                .append("\",yes:").append(szzx.getYesterdayPrice()).append(",tod:").append(szzx.getTodayPrice())
//                .append(",new:").append(szzx.getNewPrice()).append("},")
//                .append("{name:\"").append(pufy.getName()).append("\",id:\"").append(pufy.getId())
//                .append("\",yes:").append(pufy.getYesterdayPrice()).append(",tod:").append(pufy.getTodayPrice())
//                .append(",new:").append(pufy.getNewPrice()).append("}]");
////        System.out.println(builder);
        
        out.println(builder);

        //输出后的格式要求
//[{
// name:"上证指数",
// id:"200001",
// yes:3000.0,
// tod:200.1,
// new:191.88
// },{
// name:"浦发银行",
// id:"0000002",
// yes:23.2,
// tod:32.3,
// new:40.51
//}]

        //采用对象的方式回传两个股票对象
        builder.delete(0,builder.length());
        builder.append("({").append(szzx.getId()).append(":{name:\"").append(szzx.getName())
                .append("\",yes:").append(szzx.getYesterdayPrice()).append(",tod:").append(szzx.getTodayPrice())
                .append(",newprice:").append(szzx.getNewPrice()).append("},")
                .append(pufy.getId()).append(":{name:\"").append(pufy.getName())
                .append("\",yes:").append(pufy.getYesterdayPrice()).append(",tod:").append(pufy.getTodayPrice())
                .append(",newprice:").append(pufy.getNewPrice()).append("}})");
//            out.println(builder);
        out.print(builder);
//{
// 200001:{name:"上证指数",yes:3000.0,tod:200.1,newprice:216.82},
// 0000002:{name:"浦发银行",yes:23.2,tod:32.3,newprice:49.02}
//}

















    }
}
