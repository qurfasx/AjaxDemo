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
        //������Ʊ
        Stock szzs = new Stock(3000.0,200.1,"��ָ֤��","200001");
        Stock pufy = new Stock(23.2,32.3,"�ַ�����","1000002");
        //����ֻ��Ʊ������stocks��map��
        stocks.put(szzs.getId(), szzs);
        stocks.put(pufy.getId(), pufy);
        System.out.println(stocks);//��������
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //������ֻ��Ʊ�ļ۸���Ϣ��
         //���������
        double sz = Math.random()*20;
        double pf = Math.random()*0.5;
        //ͨ�����������������ż�����жϹ�Ʊ���ǻ����µ�
        boolean flagsz = ((int)(Math.random()*10))%2==0;
         boolean flagpf = ((int)(Math.random()*10))%2==0;
         //��������͹�Ʊ�ĵ�ǰ�۸���мӼ��Ĳ������õ��µĵ�ǰ�۸�

        Stock szzx= stocks.get("200001");
        Stock pufy = stocks.get("1000002");
        double temp;
        if(flagsz){
            temp = szzx.getNewPrice()+sz;

        }else{
            temp =szzx.getNewPrice()-sz;
        }

        temp=(int)(temp*100)/100.0;//�Ե�ǰ�۸���н�ȡ������С�������λ
        szzx.setNewPrice(temp);

        if(flagpf){
            temp = pufy.getNewPrice()+pf;
        }else{
            temp = pufy.getNewPrice()-pf;
        }

        temp=(int)(temp*100)/100.0;//�Ե�ǰ�۸���н�ȡ������С�������λ
        pufy.setNewPrice(temp);
        //�����Ƿ�������ȷ������
        response.setContentType("text/html;charset=gbk");
        PrintWriter out = response.getWriter();
//        out.println(szzx+"<br/>"+pufy);
        
        //������ֻ��Ʊ���������̣����쿪�̺͵�ǰ�۸�
        //����Json�ĸ�ʽ���ع�Ʊ����Ϣ
        //1����������ķ�ʽ�ش�������Ʊ����
        StringBuilder builder = new StringBuilder();
//        builder.append("[{name:\"").append(szzx.getName()).append("\",id:\"").append(szzx.getId())
//                .append("\",yes:").append(szzx.getYesterdayPrice()).append(",tod:").append(szzx.getTodayPrice())
//                .append(",new:").append(szzx.getNewPrice()).append("},")
//                .append("{name:\"").append(pufy.getName()).append("\",id:\"").append(pufy.getId())
//                .append("\",yes:").append(pufy.getYesterdayPrice()).append(",tod:").append(pufy.getTodayPrice())
//                .append(",new:").append(pufy.getNewPrice()).append("}]");
////        System.out.println(builder);
        
        out.println(builder);

        //�����ĸ�ʽҪ��
//[{
// name:"��ָ֤��",
// id:"200001",
// yes:3000.0,
// tod:200.1,
// new:191.88
// },{
// name:"�ַ�����",
// id:"0000002",
// yes:23.2,
// tod:32.3,
// new:40.51
//}]

        //���ö���ķ�ʽ�ش�������Ʊ����
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
// 200001:{name:"��ָ֤��",yes:3000.0,tod:200.1,newprice:216.82},
// 0000002:{name:"�ַ�����",yes:23.2,tod:32.3,newprice:49.02}
//}

















    }
}
