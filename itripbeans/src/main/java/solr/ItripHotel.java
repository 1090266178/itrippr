package solr;

import org.apache.solr.client.solrj.beans.Field;

import java.io.Serializable;
import java.util.Date;

public class ItripHotel implements Serializable {
    @Field("id")
    private int id;
    @Field("hotelName")
    private String hotelName;
    @Field("countryId")
    private int countryId;
    @Field("provinceId")
    private int provinceId;
    @Field("cityId")
    private int cityId;
    @Field("address")
    private String address;
    @Field("details")
    private String details;
    @Field("facilities")
    private String facilities;
    @Field("hotelPolicy")
    private String hotelPolicy;
    @Field("hotelType")
    private int hotelType;
    @Field("hotelLevel")
    private int hotelLevel;
    @Field("isGroupPurchase")
    private int isGroupPurchase;
    @Field("redundantCityName")
    private String redundantCityName;
    @Field("redundantProvinceName")
    private String redundantProvinceName;
    @Field("redundantCountryName")
    private String redundantCountryName;
    @Field("redundantHotelStore")
    private int redundantHotelStore;
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

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getFacilities() {
        return facilities;
    }

    public void setFacilities(String facilities) {
        this.facilities = facilities;
    }

    public String getHotelPolicy() {
        return hotelPolicy;
    }

    public void setHotelPolicy(String hotelPolicy) {
        this.hotelPolicy = hotelPolicy;
    }

    public int getHotelType() {
        return hotelType;
    }

    public void setHotelType(int hotelType) {
        this.hotelType = hotelType;
    }

    public int getHotelLevel() {
        return hotelLevel;
    }

    public void setHotelLevel(int hotelLevel) {
        this.hotelLevel = hotelLevel;
    }

    public int getIsGroupPurchase() {
        return isGroupPurchase;
    }

    public void setIsGroupPurchase(int isGroupPurchase) {
        this.isGroupPurchase = isGroupPurchase;
    }

    public String getRedundantCityName() {
        return redundantCityName;
    }

    public void setRedundantCityName(String redundantCityName) {
        this.redundantCityName = redundantCityName;
    }

    public String getRedundantProvinceName() {
        return redundantProvinceName;
    }

    public void setRedundantProvinceName(String redundantProvinceName) {
        this.redundantProvinceName = redundantProvinceName;
    }

    public String getRedundantCountryName() {
        return redundantCountryName;
    }

    public void setRedundantCountryName(String redundantCountryName) {
        this.redundantCountryName = redundantCountryName;
    }

    public int getRedundantHotelStore() {
        return redundantHotelStore;
    }

    public void setRedundantHotelStore(int redundantHotelStore) {
        this.redundantHotelStore = redundantHotelStore;
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
