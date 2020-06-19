package com.service;

import com.Pojo.ItripUserBean;

public interface TokenServiceInter {
    /**
     * 生成Token的键
     * @param userAgent
     * @param userBean
     * @return
     */
    String getGenerateToken(String userAgent, ItripUserBean userBean);

    /**
     * 保存Token信息到Redis中
     * @param token
     * @param userBean
     */
    void saveToken(String token,ItripUserBean userBean);

    /**
     * 在Redis中删除Token信息
     * @param token
     */
    void deleteToken(String token);

    /**
     * 验证token是否存在
     * @param userAgent
     * @param token
     * @return
     * @throws Exception
     */
    boolean validate(String userAgent,String token) ;


    /**
     *
     * @param userAgent
     * @param token
     * @return
     */
    String reloadToken(String userAgent,String token)throws Exception;
}
