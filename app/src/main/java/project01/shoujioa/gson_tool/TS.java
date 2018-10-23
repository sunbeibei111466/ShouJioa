package project01.shoujioa.gson_tool;

import java.util.List;

public class TS {

    /**
     * statuscode : 200
     * message : success
     * datas : [{"id":"8321ef6ffe244304929dc3692c12d5bd","isNewRecord":false,"createDate":"2018-09-25 15:33:54","updateDate":"2018-09-25 15:33:54","bianhao":"123","laiyuan":"北京市","danwei":"哈哈哈","fujian":"登记单.xlsx,","guanlian":"1537860834475","jindu":"3","chuangjianriqi":"2018-09-25"},{"id":"ff75b1132d884dc4ab873fde48c0a171","isNewRecord":false,"createDate":"2018-09-25 13:47:41","updateDate":"2018-09-25 13:47:56","bianhao":"闪电法师","laiyuan":"撒飞洒的","danwei":"所得税法撒旦","fujian":"456.txt,","guanlian":"1537854461764","jindu":"4","chuangjianriqi":"2018-09-25"}]
     */

    private String statuscode;
    private String message;
    private List<DatasBean> datas;

    public String getStatuscode() {
        return statuscode;
    }

    public void setStatuscode(String statuscode) {
        this.statuscode = statuscode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DatasBean> getDatas() {
        return datas;
    }

    public void setDatas(List<DatasBean> datas) {
        this.datas = datas;
    }

    public static class DatasBean {
        /**
         * id : 8321ef6ffe244304929dc3692c12d5bd
         * isNewRecord : false
         * createDate : 2018-09-25 15:33:54
         * updateDate : 2018-09-25 15:33:54
         * bianhao : 123
         * laiyuan : 北京市
         * danwei : 哈哈哈
         * fujian : 登记单.xlsx,
         * guanlian : 1537860834475
         * jindu : 3
         * chuangjianriqi : 2018-09-25
         */

        private String id;
        private boolean isNewRecord;
        private String createDate;
        private String updateDate;
        private String bianhao;
        private String laiyuan;
        private String danwei;
        private String fujian;
        private String guanlian;
        private String jindu;
        private String chuangjianriqi;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public boolean isIsNewRecord() {
            return isNewRecord;
        }

        public void setIsNewRecord(boolean isNewRecord) {
            this.isNewRecord = isNewRecord;
        }

        public String getCreateDate() {
            return createDate;
        }

        public void setCreateDate(String createDate) {
            this.createDate = createDate;
        }

        public String getUpdateDate() {
            return updateDate;
        }

        public void setUpdateDate(String updateDate) {
            this.updateDate = updateDate;
        }

        public String getBianhao() {
            return bianhao;
        }

        public void setBianhao(String bianhao) {
            this.bianhao = bianhao;
        }

        public String getLaiyuan() {
            return laiyuan;
        }

        public void setLaiyuan(String laiyuan) {
            this.laiyuan = laiyuan;
        }

        public String getDanwei() {
            return danwei;
        }

        public void setDanwei(String danwei) {
            this.danwei = danwei;
        }

        public String getFujian() {
            return fujian;
        }

        public void setFujian(String fujian) {
            this.fujian = fujian;
        }

        public String getGuanlian() {
            return guanlian;
        }

        public void setGuanlian(String guanlian) {
            this.guanlian = guanlian;
        }

        public String getJindu() {
            return jindu;
        }

        public void setJindu(String jindu) {
            this.jindu = jindu;
        }

        public String getChuangjianriqi() {
            return chuangjianriqi;
        }

        public void setChuangjianriqi(String chuangjianriqi) {
            this.chuangjianriqi = chuangjianriqi;
        }
    }
}
