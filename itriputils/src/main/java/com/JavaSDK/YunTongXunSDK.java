package com.JavaSDK;

import com.cloopen.rest.sdk.CCPRestSmsSDK;

import java.util.HashMap;
import java.util.Set;

public class YunTongXunSDK {
    /**
     * 发送短信激活
     * @param to  //to是接收短信的手机号
     * @param templateId //templateId是云通讯的短信模板 测试用户使用1
     * @param datas //只用两个值有用 第一个是内容 第二个参数是时间
     * return String 返回发送短信成功与否的提示
     */
    public static String MessageSDK(String to,String templateId,String[] datas){
        String serverIp = "app.cloopen.com";
        //请求端口
        String serverPort = "8883";
        //主账号,登陆云通讯网站后,可在控制台首页看到开发者主账号ACCOUNT SID和主账号令牌AUTH TOKEN
        String accountSId = "8aaf07087291adde01729cb1deb906aa";
        String accountToken = "e7ad5242f7be48268fd22bee716d8d37";

        CCPRestSmsSDK sdk = new CCPRestSmsSDK();
        sdk.init(serverIp, serverPort);
        sdk.setAccount(accountSId, accountToken);
        sdk.setAppId("8aaf07087291adde01729cb1df9406b1");
        HashMap<String, Object> result = sdk.sendTemplateSMS(to,templateId,datas);  //to是接收短信的手机号 templateId是云通讯的短信模板 datas是具体发送的短信内容
        if("000000".equals(result.get("statusCode"))){
            //正常返回输出data包体信息（map）
            HashMap<String,Object> data = (HashMap<String, Object>) result.get("data");
            Set<String> keySet = data.keySet();
            for(String key:keySet){
                Object object = data.get(key);
                System.out.println(key +" = "+object);   //返回发送成功结果
            }
        }else{
            //异常返回输出错误码和错误信息
            System.out.println("错误码=" + result.get("statusCode") +" 错误信息= "+result.get("statusMsg"));
            return ""+result.get("statusMsg");
        }
        return "发送成功";
    }
    public static  void main(String[] ags){
        MessageSDK("15274277200","1",new String[]{"恭喜你喜提阿尔法一辆，万事如意心想事成","two"});
    }
}
