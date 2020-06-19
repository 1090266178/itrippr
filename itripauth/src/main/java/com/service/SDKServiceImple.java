package com.service;

import com.JavaSDK.YunTongXunSDK;
import com.Redis.RedisTool;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

@Service
public class SDKServiceImple implements SDKServiceInter {

    @Resource(name="redisTool")
    private RedisTool redisTool;
    /**
     *
     * @param phone 手机号码
     * @param key 表示要比较的键
     * @return map 返回消息结果
     */
    @Override
    public String phoneActivation(String phone, String key)throws Exception {
        Map map = new HashMap();
        String code = redisTool.get(key); //获取保存在Redis中对应的验证码
        if(code!=null){   //判断redis是否存在验证码 有就发送短信
            String result=YunTongXunSDK.MessageSDK(phone,"1",new String[]{"你好你的激活码是:"+code,"1"});
            return result;
        }else {
            throw new Exception("激活码失效");
        }
    }

    /**
     * 正则表达式 验证手机号码
     * @param phone
     * @return
     */
    public boolean phoneVerify(String phone){
        String regex ="^[1][3,4,5,7,8][0-9]{9}$";
        return Pattern.compile(regex).matcher(phone).find();
    }
}
