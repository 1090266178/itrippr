package com.Dao;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.client.solrj.response.QueryResponse;
import solr.ItripHotel;

import java.io.IOException;
import java.util.List;

public class BaseDaoSolr<T> {

    private HttpSolrClient httpSolrClient=null; //执行http请求的客户端
    private QueryResponse queryResponse=null; //接收返回数据 转换为对象 queryResponse

    public BaseDaoSolr(String url){
        httpSolrClient = new HttpSolrClient(url); //执行http请求的客户端
        httpSolrClient.setParser(new XMLResponseParser());   //设置响应解析器
        httpSolrClient.setConnectionTimeout(500);   //建立连接的最长时间
    }

    public List<T> getSolrResult(SolrQuery solrQuery,Class clazz) throws IOException, SolrServerException {
        queryResponse = httpSolrClient.query(solrQuery);     //接收返回数据 转换为对象 queryResponse
        List<T> hotelList = queryResponse.getBeans(clazz);
        return hotelList;
    }
}
