package com.VO;

public class itripTokenVo {

    /**
     * token信息 用户的认证凭据
     */
    private String token;

    /**
     * 过期时间 token的失效时间 单位毫秒
     */
    private long expTime;

    /**
     * 创建token的时间 单位毫秒
     */
    private long genTime;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getExpTime() {
        return expTime;
    }

    public void setExpTime(long expTime) {
        this.expTime = expTime;
    }

    public long getGenTime() {
        return genTime;
    }

    public void setGenTime(long genTime) {
        this.genTime = genTime;
    }

    public itripTokenVo() {
    }

    public itripTokenVo(String token, long expTime, long genTime) {
        this.token = token;
        this.expTime = expTime;
        this.genTime = genTime;
    }
}
