package com.service;

import java.util.Map;

public interface SDKServiceInter {
    /**
     * 手机注册发送验证码
     * @param phone
     * @param key
     */
    String phoneActivation(String phone, String key)throws Exception;
}
