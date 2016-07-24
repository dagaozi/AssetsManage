package com.wyyy.assetsmanage.model;

import java.util.List;

/**
 * Created by haohaibin .（dagaozi@163.com）
 * 创建时间：2016/7/19 17:47
 * 类描述：
 */
public class TestData {

    /**
     * resultcode : 200
     * reason : SUCCESSED!
     * result : [{"data":{"buyFive":"27000","buyFivePri":"10.170","buyFour":"20049","buyFourPri":"10.180","buyOne":"1900","buyOnePri":"10.210","buyThree":"28300","buyThreePri":"10.190","buyTwo":"75480","buyTwoPri":"10.200","competitivePri":"10.210","date":"2016-07-19","gid":"sh601009","increPer":"-1.54","increase":"-0.160","name":"南京银行","nowPri":"10.200","reservePri":"10.220","sellFive":"97237","sellFivePri":"10.260","sellFour":"74480","sellFourPri":"10.250","sellOne":"29500","sellOnePri":"10.220","sellThree":"21920","sellThreePri":"10.240","sellTwo":"26320","sellTwoPri":"10.230","time":"15:00:00","todayMax":"10.430","todayMin":"10.100","todayStartPri":"10.380","traAmount":"292364274.000","traNumber":"286482","yestodEndPri":"10.360"},"dapandata":{"dot":"10.200","name":"南京银行","nowPic":"-0.160","rate":"-1.54","traAmount":"29236","traNumber":"286482"},"gopicture":{"minurl":"http://image.sinajs.cn/newchart/min/n/sh601009.gif","dayurl":"http://image.sinajs.cn/newchart/daily/n/sh601009.gif","weekurl":"http://image.sinajs.cn/newchart/weekly/n/sh601009.gif","monthurl":"http://image.sinajs.cn/newchart/monthly/n/sh601009.gif"}}]
     * error_code : 0
     */

    private String resultcode;
    private String reason;
    private int error_code;
    /**
     * data : {"buyFive":"27000","buyFivePri":"10.170","buyFour":"20049","buyFourPri":"10.180","buyOne":"1900","buyOnePri":"10.210","buyThree":"28300","buyThreePri":"10.190","buyTwo":"75480","buyTwoPri":"10.200","competitivePri":"10.210","date":"2016-07-19","gid":"sh601009","increPer":"-1.54","increase":"-0.160","name":"南京银行","nowPri":"10.200","reservePri":"10.220","sellFive":"97237","sellFivePri":"10.260","sellFour":"74480","sellFourPri":"10.250","sellOne":"29500","sellOnePri":"10.220","sellThree":"21920","sellThreePri":"10.240","sellTwo":"26320","sellTwoPri":"10.230","time":"15:00:00","todayMax":"10.430","todayMin":"10.100","todayStartPri":"10.380","traAmount":"292364274.000","traNumber":"286482","yestodEndPri":"10.360"}
     * dapandata : {"dot":"10.200","name":"南京银行","nowPic":"-0.160","rate":"-1.54","traAmount":"29236","traNumber":"286482"}
     * gopicture : {"minurl":"http://image.sinajs.cn/newchart/min/n/sh601009.gif","dayurl":"http://image.sinajs.cn/newchart/daily/n/sh601009.gif","weekurl":"http://image.sinajs.cn/newchart/weekly/n/sh601009.gif","monthurl":"http://image.sinajs.cn/newchart/monthly/n/sh601009.gif"}
     */

    private List<ResultBean> result;

    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * buyFive : 27000
         * buyFivePri : 10.170
         * buyFour : 20049
         * buyFourPri : 10.180
         * buyOne : 1900
         * buyOnePri : 10.210
         * buyThree : 28300
         * buyThreePri : 10.190
         * buyTwo : 75480
         * buyTwoPri : 10.200
         * competitivePri : 10.210
         * date : 2016-07-19
         * gid : sh601009
         * increPer : -1.54
         * increase : -0.160
         * name : 南京银行
         * nowPri : 10.200
         * reservePri : 10.220
         * sellFive : 97237
         * sellFivePri : 10.260
         * sellFour : 74480
         * sellFourPri : 10.250
         * sellOne : 29500
         * sellOnePri : 10.220
         * sellThree : 21920
         * sellThreePri : 10.240
         * sellTwo : 26320
         * sellTwoPri : 10.230
         * time : 15:00:00
         * todayMax : 10.430
         * todayMin : 10.100
         * todayStartPri : 10.380
         * traAmount : 292364274.000
         * traNumber : 286482
         * yestodEndPri : 10.360
         */

        private DataBean data;
        /**
         * dot : 10.200
         * name : 南京银行
         * nowPic : -0.160
         * rate : -1.54
         * traAmount : 29236
         * traNumber : 286482
         */

        private DapandataBean dapandata;
        /**
         * minurl : http://image.sinajs.cn/newchart/min/n/sh601009.gif
         * dayurl : http://image.sinajs.cn/newchart/daily/n/sh601009.gif
         * weekurl : http://image.sinajs.cn/newchart/weekly/n/sh601009.gif
         * monthurl : http://image.sinajs.cn/newchart/monthly/n/sh601009.gif
         */

        private GopictureBean gopicture;

        public DataBean getData() {
            return data;
        }

        public void setData(DataBean data) {
            this.data = data;
        }

        public DapandataBean getDapandata() {
            return dapandata;
        }

        public void setDapandata(DapandataBean dapandata) {
            this.dapandata = dapandata;
        }

        public GopictureBean getGopicture() {
            return gopicture;
        }

        public void setGopicture(GopictureBean gopicture) {
            this.gopicture = gopicture;
        }

        public static class DataBean {
            private String buyFive;
            private String buyFivePri;
            private String buyFour;
            private String buyFourPri;
            private String buyOne;
            private String buyOnePri;
            private String buyThree;
            private String buyThreePri;
            private String buyTwo;
            private String buyTwoPri;
            private String competitivePri;
            private String date;
            private String gid;
            private String increPer;
            private String increase;
            private String name;
            private String nowPri;
            private String reservePri;
            private String sellFive;
            private String sellFivePri;
            private String sellFour;
            private String sellFourPri;
            private String sellOne;
            private String sellOnePri;
            private String sellThree;
            private String sellThreePri;
            private String sellTwo;
            private String sellTwoPri;
            private String time;
            private String todayMax;
            private String todayMin;
            private String todayStartPri;
            private String traAmount;
            private String traNumber;
            private String yestodEndPri;

            public String getBuyFive() {
                return buyFive;
            }

            public void setBuyFive(String buyFive) {
                this.buyFive = buyFive;
            }

            public String getBuyFivePri() {
                return buyFivePri;
            }

            public void setBuyFivePri(String buyFivePri) {
                this.buyFivePri = buyFivePri;
            }

            public String getBuyFour() {
                return buyFour;
            }

            public void setBuyFour(String buyFour) {
                this.buyFour = buyFour;
            }

            public String getBuyFourPri() {
                return buyFourPri;
            }

            public void setBuyFourPri(String buyFourPri) {
                this.buyFourPri = buyFourPri;
            }

            public String getBuyOne() {
                return buyOne;
            }

            public void setBuyOne(String buyOne) {
                this.buyOne = buyOne;
            }

            public String getBuyOnePri() {
                return buyOnePri;
            }

            public void setBuyOnePri(String buyOnePri) {
                this.buyOnePri = buyOnePri;
            }

            public String getBuyThree() {
                return buyThree;
            }

            public void setBuyThree(String buyThree) {
                this.buyThree = buyThree;
            }

            public String getBuyThreePri() {
                return buyThreePri;
            }

            public void setBuyThreePri(String buyThreePri) {
                this.buyThreePri = buyThreePri;
            }

            public String getBuyTwo() {
                return buyTwo;
            }

            public void setBuyTwo(String buyTwo) {
                this.buyTwo = buyTwo;
            }

            public String getBuyTwoPri() {
                return buyTwoPri;
            }

            public void setBuyTwoPri(String buyTwoPri) {
                this.buyTwoPri = buyTwoPri;
            }

            public String getCompetitivePri() {
                return competitivePri;
            }

            public void setCompetitivePri(String competitivePri) {
                this.competitivePri = competitivePri;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getGid() {
                return gid;
            }

            public void setGid(String gid) {
                this.gid = gid;
            }

            public String getIncrePer() {
                return increPer;
            }

            public void setIncrePer(String increPer) {
                this.increPer = increPer;
            }

            public String getIncrease() {
                return increase;
            }

            public void setIncrease(String increase) {
                this.increase = increase;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getNowPri() {
                return nowPri;
            }

            public void setNowPri(String nowPri) {
                this.nowPri = nowPri;
            }

            public String getReservePri() {
                return reservePri;
            }

            public void setReservePri(String reservePri) {
                this.reservePri = reservePri;
            }

            public String getSellFive() {
                return sellFive;
            }

            public void setSellFive(String sellFive) {
                this.sellFive = sellFive;
            }

            public String getSellFivePri() {
                return sellFivePri;
            }

            public void setSellFivePri(String sellFivePri) {
                this.sellFivePri = sellFivePri;
            }

            public String getSellFour() {
                return sellFour;
            }

            public void setSellFour(String sellFour) {
                this.sellFour = sellFour;
            }

            public String getSellFourPri() {
                return sellFourPri;
            }

            public void setSellFourPri(String sellFourPri) {
                this.sellFourPri = sellFourPri;
            }

            public String getSellOne() {
                return sellOne;
            }

            public void setSellOne(String sellOne) {
                this.sellOne = sellOne;
            }

            public String getSellOnePri() {
                return sellOnePri;
            }

            public void setSellOnePri(String sellOnePri) {
                this.sellOnePri = sellOnePri;
            }

            public String getSellThree() {
                return sellThree;
            }

            public void setSellThree(String sellThree) {
                this.sellThree = sellThree;
            }

            public String getSellThreePri() {
                return sellThreePri;
            }

            public void setSellThreePri(String sellThreePri) {
                this.sellThreePri = sellThreePri;
            }

            public String getSellTwo() {
                return sellTwo;
            }

            public void setSellTwo(String sellTwo) {
                this.sellTwo = sellTwo;
            }

            public String getSellTwoPri() {
                return sellTwoPri;
            }

            public void setSellTwoPri(String sellTwoPri) {
                this.sellTwoPri = sellTwoPri;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public String getTodayMax() {
                return todayMax;
            }

            public void setTodayMax(String todayMax) {
                this.todayMax = todayMax;
            }

            public String getTodayMin() {
                return todayMin;
            }

            public void setTodayMin(String todayMin) {
                this.todayMin = todayMin;
            }

            public String getTodayStartPri() {
                return todayStartPri;
            }

            public void setTodayStartPri(String todayStartPri) {
                this.todayStartPri = todayStartPri;
            }

            public String getTraAmount() {
                return traAmount;
            }

            public void setTraAmount(String traAmount) {
                this.traAmount = traAmount;
            }

            public String getTraNumber() {
                return traNumber;
            }

            public void setTraNumber(String traNumber) {
                this.traNumber = traNumber;
            }

            public String getYestodEndPri() {
                return yestodEndPri;
            }

            public void setYestodEndPri(String yestodEndPri) {
                this.yestodEndPri = yestodEndPri;
            }
        }

        public static class DapandataBean {
            private String dot;
            private String name;
            private String nowPic;
            private String rate;
            private String traAmount;
            private String traNumber;

            public String getDot() {
                return dot;
            }

            public void setDot(String dot) {
                this.dot = dot;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getNowPic() {
                return nowPic;
            }

            public void setNowPic(String nowPic) {
                this.nowPic = nowPic;
            }

            public String getRate() {
                return rate;
            }

            public void setRate(String rate) {
                this.rate = rate;
            }

            public String getTraAmount() {
                return traAmount;
            }

            public void setTraAmount(String traAmount) {
                this.traAmount = traAmount;
            }

            public String getTraNumber() {
                return traNumber;
            }

            public void setTraNumber(String traNumber) {
                this.traNumber = traNumber;
            }
        }

        public static class GopictureBean {
            private String minurl;
            private String dayurl;
            private String weekurl;
            private String monthurl;

            public String getMinurl() {
                return minurl;
            }

            public void setMinurl(String minurl) {
                this.minurl = minurl;
            }

            public String getDayurl() {
                return dayurl;
            }

            public void setDayurl(String dayurl) {
                this.dayurl = dayurl;
            }

            public String getWeekurl() {
                return weekurl;
            }

            public void setWeekurl(String weekurl) {
                this.weekurl = weekurl;
            }

            public String getMonthurl() {
                return monthurl;
            }

            public void setMonthurl(String monthurl) {
                this.monthurl = monthurl;
            }
        }
    }
}
