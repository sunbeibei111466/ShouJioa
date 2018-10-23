package project01.shoujioa.gson_tool;

import java.util.List;

public class new_btn_sign_in {

    /**
     * statuscode : 200
     * message : success
     * datas : [{"id":"e1ba30835bc74fc29cb1dcc886b3e35d","isNewRecord":false,"createDate":"2018-08-13 15:53:37","updateDate":"2018-08-13 15:53:37","bt":"方法方法付付","lx":"新闻期刊","xwnr":"三十多岁所多多所","fbr":"系统管理员","scfile":"123.txt,","back1":"1","back2":"0","back3":"1"}]
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
         * id : e1ba30835bc74fc29cb1dcc886b3e35d
         * isNewRecord : false
         * createDate : 2018-08-13 15:53:37
         * updateDate : 2018-08-13 15:53:37
         * bt : 方法方法付付
         * lx : 新闻期刊
         * xwnr : 三十多岁所多多所
         * fbr : 系统管理员
         * scfile : 123.txt,
         * back1 : 1
         * back2 : 0
         * back3 : 1
         */

        private String id;
        private boolean isNewRecord;
        private String createDate;
        private String updateDate;
        private String bt;
        private String lx;
        private String xwnr;
        private String fbr;
        private String scfile;
        private String back1;
        private String back2;
        private String back3;

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

        public String getBt() {
            return bt;
        }

        public void setBt(String bt) {
            this.bt = bt;
        }

        public String getLx() {
            return lx;
        }

        public void setLx(String lx) {
            this.lx = lx;
        }

        public String getXwnr() {
            return xwnr;
        }

        public void setXwnr(String xwnr) {
            this.xwnr = xwnr;
        }

        public String getFbr() {
            return fbr;
        }

        public void setFbr(String fbr) {
            this.fbr = fbr;
        }

        public String getScfile() {
            return scfile;
        }

        public void setScfile(String scfile) {
            this.scfile = scfile;
        }

        public String getBack1() {
            return back1;
        }

        public void setBack1(String back1) {
            this.back1 = back1;
        }

        public String getBack2() {
            return back2;
        }

        public void setBack2(String back2) {
            this.back2 = back2;
        }

        public String getBack3() {
            return back3;
        }

        public void setBack3(String back3) {
            this.back3 = back3;
        }
    }
}
