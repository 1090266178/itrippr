package com.Service;

import org.apache.solr.client.solrj.SolrServerException;
import solr.ItripHotel;

import java.io.IOException;
import java.util.List;

public interface HotelServiceInter {
    /**
     * 用户输入 到solr拿取信息列表 错误抛给控制层 给控制层返回错误信息给前端
     * @param keyword
     * @return
     * @throws IOException
     * @throws SolrServerException
     */
    public List<ItripHotel> getHotelList(String keyword,Integer start,Integer rows) throws IOException, SolrServerException;

}
