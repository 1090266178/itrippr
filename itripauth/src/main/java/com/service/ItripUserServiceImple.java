package com.service;

import com.Dao.ItripUserMapper;
import com.Pojo.ItripUserBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ItripUserServiceImple implements ItripUserServiceInter {

    @Resource(name="itripUserMapper")
    private ItripUserMapper itripUserMapper;

    @Override
    public ItripUserBean Login(ItripUserBean itripUserBean) {
        return itripUserMapper.Login(itripUserBean);
    }

    @Override
    public int addUser(ItripUserBean itripUserBean) {
        return itripUserMapper.addUser(itripUserBean);
    }

    @Override
    public int updateActivated(int id, int activated) {
        return itripUserMapper.updateActivated(id,activated);
    }
}
