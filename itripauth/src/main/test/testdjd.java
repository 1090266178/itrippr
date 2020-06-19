import com.Redis.RedisTool;
import static org.junit.Assert.*;

import com.service.MailserviceInter;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import solr.ItripHotel;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class testdjd {

/*    @Test   //Redis数据验证
    public void gggg(){
        ApplicationContext app = new ClassPathXmlApplicationContext("application.xml");
        System.out.println(app.getBeanDefinitionCount());
        RedisTool rt = (RedisTool) app.getBean("redisTool");
        assertEquals("gggg",rt.get("ddd"));
        assertEquals(true,rt.exists("ddd"));  //asserEquals方法条件为真：正常打印 条件为假：抛出错误并给出错误信息
        System.out.println(rt.get("codes"));
    }*/

/*    @Test    //邮件发送验证
    public void gggg(){
        ApplicationContext app = new ClassPathXmlApplicationContext("application.xml");
        MailserviceInter ma = (MailserviceInter)app.getBean("mailserviceImple");
        ma.sendActiveationMail("x18570421676@163.com","123132");
        for (int i=0 ;i>20;i++){
            ma.sendActiveationMail("x18570421676@163.com","123132");
        }
    }*/

/*    @Test
    public void gggg(){   //时间百万毫秒数测试
        System.out.println(new SimpleDateFormat("yyyyMMdd-HH-mm-ss-s").format(Calendar.getInstance().getTime()));
        System.out.println(Calendar.getInstance().getTimeInMillis());
    }*/

    @Test
    public  void jj() throws IOException, SolrServerException {  //solrApi接口测试
        String url="http://localhost:8080/solr/test/";    //本地solr访问地址 ip:端口号/solr/模块名
        HttpSolrClient httpSolrClient = new HttpSolrClient(url); //执行http请求的客户端
        httpSolrClient.setParser(new XMLResponseParser());   //设置响应解析器
        httpSolrClient.setConnectionTimeout(500);   //建立连接的最长时间
        SolrQuery solrQuery = new SolrQuery();     //新建查询 用于设置查询的对象 创建的同时可以通过构造方法给查询条件
        solrQuery.setQuery("keyword:北京");         //查询条件
        solrQuery.setSort("id",SolrQuery.ORDER.desc);
        solrQuery.setStart(0);
        solrQuery.setRows(10);
        QueryResponse queryResponse = httpSolrClient.query(solrQuery);     //接收返回数据 转换为对象 queryResponse
        List<ItripHotel> hotelList = queryResponse.getBeans(ItripHotel.class);
        for(ItripHotel hotel:hotelList){
            System.out.println(hotel.getId()+"   "+hotel.getHotelName());
        }
    }
}


