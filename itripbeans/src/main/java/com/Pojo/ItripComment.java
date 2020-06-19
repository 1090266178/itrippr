package com.Pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.solr.client.solrj.beans.Field;

import java.util.Date;
@ApiModel(value = "ItripComment",description = "酒店评论表")
public class ItripComment {
    @Field("id")
    private int id;
    @ApiModelProperty(value = "必填",notes = "酒店的id")
    @Field("hotelId")
    private int  hotelId;
    @ApiModelProperty(value="必填",notes = "房型的id")
    @Field("productId")
    private int productId;
    @ApiModelProperty(value="必填",notes = "订单的id")
    @Field("orderId")
    private int  orderId;
    @ApiModelProperty(value="必填",notes = "商品的类型 方便扩展 后台已处理")
    @Field("productType")
    private int productType;
    @Field("content")
    private String  content;
    @ApiModelProperty(value="必填",notes = "用户的id 后台处理token获取")
    @Field("userId")
    private int userId;
    @ApiModelProperty(value="必填",notes = "是否上传了照片 默认没有照片")
    @Field("isHavingImg")
    private int  isHavingImg;
    @Field("positionScore")
    private int positionScore;
    @Field("facilitiesScore")
    private int  facilitiesScore;
    @Field("serviceScore")
    private int  serviceScore;
    @ApiModelProperty(value="必填",notes = "卫生评分")
    @Field("hygieneScore")
    private int  hygieneScore;
    @Field("score")
    private int score;
    @Field("tripMode")
    private int tripMode;
    @Field("isOk")
    private int isOk;
    @ApiModelProperty(value="必填",notes = "创建时间 后台处理")
    @Field("creationDate")
    private Date creationDate;
    @Field("createdBy")
    private int createdBy;
    @Field("modifyDate")
    private Date  modifyDate;
    @Field("modifiedBy")
    private int  modifiedBy;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductType() {
        return productType;
    }

    public void setProductType(int productType) {
        this.productType = productType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getIsHavingImg() {
        return isHavingImg;
    }

    public void setIsHavingImg(int isHavingImg) {
        this.isHavingImg = isHavingImg;
    }

    public int getPositionScore() {
        return positionScore;
    }

    public void setPositionScore(int positionScore) {
        this.positionScore = positionScore;
    }

    public int getFacilitiesScore() {
        return facilitiesScore;
    }

    public void setFacilitiesScore(int facilitiesScore) {
        this.facilitiesScore = facilitiesScore;
    }

    public int getServiceScore() {
        return serviceScore;
    }

    public void setServiceScore(int serviceScore) {
        this.serviceScore = serviceScore;
    }

    public int getHygieneScore() {
        return hygieneScore;
    }

    public void setHygieneScore(int hygieneScore) {
        this.hygieneScore = hygieneScore;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getTripMode() {
        return tripMode;
    }

    public void setTripMode(int tripMode) {
        this.tripMode = tripMode;
    }

    public int getIsOk() {
        return isOk;
    }

    public void setIsOk(int isOk) {
        this.isOk = isOk;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public int getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(int modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}
