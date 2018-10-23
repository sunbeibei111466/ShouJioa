package project01.shoujioa.gson_tool;

import java.util.List;

public class Enreust_mian_tool {

    /**
     * statuscode : 200
     * message : success
     * datas : [{"id":"2316da93898b4021ad682ae03acdfb0c","isNewRecord":false,"createDate":"2018-09-06 10:46:31","updateDate":"2018-09-06 10:46:31","wtrId":"1","strId":"5","qishisj":"2018-09-06 00:00:00","jieshusj":"2018-09-06 00:00:00"},{"id":"cb06fd810e8d4f0aa7d8dcd49e3e1dc4","isNewRecord":false,"createDate":"2018-09-06 10:46:17","updateDate":"2018-09-06 10:46:17","wtrId":"1","strId":"5","qishisj":"2018-09-07 00:00:00","jieshusj":"2018-09-10 00:00:00"},{"id":"bc97eaa88c52420ab37ac2d7dab62d48","isNewRecord":false,"createDate":"2018-08-27 18:10:33","updateDate":"2018-08-27 18:10:33","wtrId":"1","strId":"5","qishisj":"2018-08-27 00:00:00","jieshusj":"2018-08-27 00:00:00"}]
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
         * id : 2316da93898b4021ad682ae03acdfb0c
         * isNewRecord : false
         * createDate : 2018-09-06 10:46:31
         * updateDate : 2018-09-06 10:46:31
         * wtrId : 1
         * strId : 5
         * qishisj : 2018-09-06 00:00:00
         * jieshusj : 2018-09-06 00:00:00
         */

        private String id;
        private boolean isNewRecord;
        private String createDate;
        private String updateDate;
        private String wtrId;
        private String strId;
        private String qishisj;
        private String jieshusj;

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

        public String getWtrId() {
            return wtrId;
        }

        public void setWtrId(String wtrId) {
            this.wtrId = wtrId;
        }

        public String getStrId() {
            return strId;
        }

        public void setStrId(String strId) {
            this.strId = strId;
        }

        public String getQishisj() {
            return qishisj;
        }

        public void setQishisj(String qishisj) {
            this.qishisj = qishisj;
        }

        public String getJieshusj() {
            return jieshusj;
        }

        public void setJieshusj(String jieshusj) {
            this.jieshusj = jieshusj;
        }
    }
}
