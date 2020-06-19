package com.service;

import com.Pojo.ItripUserBean;
import org.apache.ibatis.annotations.Param;

public interface ItripUserServiceInter {
    /**
     * 登录
     * @param itripUserBean
     * @return
     */
    ItripUserBean Login(ItripUserBean itripUserBean);
    /**
     * 用户注册
     * @param itripUserBean
     * @return
     */
    int addUser(ItripUserBean itripUserBean);
    /**
     * 修改激活状态
     * @return
     */
    int updateActivated(@Param("id") int id, @Param("activated")int activated);
}
