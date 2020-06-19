package com.Pojo;

import org.apache.solr.client.solrj.beans.Field;

import java.util.Date;

public class ItripHotelRoom {
    @Field("id")
   private int id;
    @Field("hotelId")
    private int  hotelId;
    @Field("roomTitle")
    private String roomTitle;
    @Field("roomPrice")
    private double  roomPrice;
    @Field("roomBedTypeId")
    private int roomBedTypeId;
    @Field("isHavingBreakfast")
    private int isHavingBreakfast;
    @Field("payType")
    private int  payType;
    @Field("satisfaction")
    private double   satisfaction;
    @Field("isBook")
    private int isBook;
    @Field("isCancel")
    private int  isCancel;
    @Field("isTimelyResponse")
    private int isTimelyResponse;
    @Field("creationDate")
    private Date creationDate;
    @Field("createdBy")
    private int createdBy;
    @Field("modifyDate")
    private Date modifyDate;
    @Field("modifiedBy")
    private int modifiedBy;

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

    public String getRoomTitle() {
        return roomTitle;
    }

    public void setRoomTitle(String roomTitle) {
        this.roomTitle = roomTitle;
    }

    public double getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(double roomPrice) {
        this.roomPrice = roomPrice;
    }

    public int getRoomBedTypeId() {
        return roomBedTypeId;
    }

    public void setRoomBedTypeId(int roomBedTypeId) {
        this.roomBedTypeId = roomBedTypeId;
    }

    public int getIsHavingBreakfast() {
        return isHavingBreakfast;
    }

    public void setIsHavingBreakfast(int isHavingBreakfast) {
        this.isHavingBreakfast = isHavingBreakfast;
    }

    public int getPayType() {
        return payType;
    }

    public void setPayType(int payType) {
        this.payType = payType;
    }

    public double getSatisfaction() {
        return satisfaction;
    }

    public void setSatisfaction(double satisfaction) {
        this.satisfaction = satisfaction;
    }

    public int getIsBook() {
        return isBook;
    }

    public void setIsBook(int isBook) {
        this.isBook = isBook;
    }

    public int getIsCancel() {
        return isCancel;
    }

    public void setIsCancel(int isCancel) {
        this.isCancel = isCancel;
    }

    public int getIsTimelyResponse() {
        return isTimelyResponse;
    }

    public void setIsTimelyResponse(int isTimelyResponse) {
        this.isTimelyResponse = isTimelyResponse;
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
