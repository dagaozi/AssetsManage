package com.wyyy.assetsmanage.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by haohaibin .（dagaozi@163.com）
 * 创建时间：2016/7/19 9:33
 * 类描述：
 */
public class test222 {

    /**
     * code : 0
     * data : {"country":"美国","country_id":"US","area":"","area_id":"","region":"","region_id":"","city":"","city_id":"","county":"","county_id":"","isp":"","isp_id":"","ip":"21.22.11.33"}
     */

    private int code;
    /**
     * country : 美国
     * country_id : US
     * area :
     * area_id :
     * region :
     * region_id :
     * city :
     * city_id :
     * county :
     * county_id :
     * isp :
     * isp_id :
     * ip : 21.22.11.33
     */

    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean implements Parcelable {
        private String country;
        private String country_id;
        private String area;
        private String area_id;
        private String region;
        private String region_id;
        private String city;
        private String city_id;
        private String county;
        private String county_id;
        private String isp;
        private String isp_id;
        private String ip;

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getCountry_id() {
            return country_id;
        }

        public void setCountry_id(String country_id) {
            this.country_id = country_id;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getArea_id() {
            return area_id;
        }

        public void setArea_id(String area_id) {
            this.area_id = area_id;
        }

        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }

        public String getRegion_id() {
            return region_id;
        }

        public void setRegion_id(String region_id) {
            this.region_id = region_id;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCity_id() {
            return city_id;
        }

        public void setCity_id(String city_id) {
            this.city_id = city_id;
        }

        public String getCounty() {
            return county;
        }

        public void setCounty(String county) {
            this.county = county;
        }

        public String getCounty_id() {
            return county_id;
        }

        public void setCounty_id(String county_id) {
            this.county_id = county_id;
        }

        public String getIsp() {
            return isp;
        }

        public void setIsp(String isp) {
            this.isp = isp;
        }

        public String getIsp_id() {
            return isp_id;
        }

        public void setIsp_id(String isp_id) {
            this.isp_id = isp_id;
        }

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.country);
            dest.writeString(this.country_id);
            dest.writeString(this.area);
            dest.writeString(this.area_id);
            dest.writeString(this.region);
            dest.writeString(this.region_id);
            dest.writeString(this.city);
            dest.writeString(this.city_id);
            dest.writeString(this.county);
            dest.writeString(this.county_id);
            dest.writeString(this.isp);
            dest.writeString(this.isp_id);
            dest.writeString(this.ip);
        }

        public DataBean() {
        }

        protected DataBean(Parcel in) {
            this.country = in.readString();
            this.country_id = in.readString();
            this.area = in.readString();
            this.area_id = in.readString();
            this.region = in.readString();
            this.region_id = in.readString();
            this.city = in.readString();
            this.city_id = in.readString();
            this.county = in.readString();
            this.county_id = in.readString();
            this.isp = in.readString();
            this.isp_id = in.readString();
            this.ip = in.readString();
        }

        public static final Parcelable.Creator<DataBean> CREATOR = new Parcelable.Creator<DataBean>() {
            @Override
            public DataBean createFromParcel(Parcel source) {
                return new DataBean(source);
            }

            @Override
            public DataBean[] newArray(int size) {
                return new DataBean[size];
            }
        };
    }
}
