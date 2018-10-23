package project01.shoujioa.gson_tool;

import java.util.List;

public class Office_Tool {

    /**
     * statuscode : 200
     * message : success
     * datas : [{"id":"c34c08c834a84b96b693116ddbfab6a6","isNewRecord":false,"createDate":"2018-09-17 16:07:15","updateDate":"2018-09-17 16:07:15","nian":"2018","ci":"45","yt":"1537171635626","hbks":1537286400000,"chry":"1537171635626","scfile":""},{"id":"251c3911e6564146b1c4189eb4c4ef21","isNewRecord":false,"createDate":"2018-09-17 15:05:50","updateDate":"2018-09-17 15:05:50","nian":"2018","ci":"6","yt":"1537167949578","hbks":1537113600000,"chry":"1537167949578","scfile":"精准扶贫接口文档.docx,批量下载.txt,"},{"id":"1ba3e35259344f81bb44688e15f1a946","isNewRecord":false,"createDate":"2018-09-14 15:52:47","updateDate":"2018-09-14 15:52:47","nian":"2018","ci":"12","yt":"1536911567409","hbks":1536854400000,"chry":"1536911567409","scfile":"精准扶贫接口文档.docx,"},{"id":"6c2cebc541824bb3bf4bb0fa0c446a9c","isNewRecord":false,"createDate":"2018-09-14 15:47:23","updateDate":"2018-09-14 15:47:23","nian":"2018","ci":"4","yt":"1536911243178","hbks":1536940800000,"chry":"1536911243178","scfile":","},{"id":"493efe98f4ba417285520deed4c29816","isNewRecord":false,"createDate":"2018-09-14 15:40:12","updateDate":"2018-09-14 15:40:12","nian":"2018","ci":"5","yt":"1536910811991","hbks":1536854400000,"chry":"1536910811991","scfile":"批量下载.txt,"}]
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
         * id : c34c08c834a84b96b693116ddbfab6a6
         * isNewRecord : false
         * createDate : 2018-09-17 16:07:15
         * updateDate : 2018-09-17 16:07:15
         * nian : 2018
         * ci : 45
         * yt : 1537171635626
         * hbks : 1537286400000
         * chry : 1537171635626
         * scfile :
         */

        private String id;
        private boolean isNewRecord;
        private String createDate;
        private String updateDate;
        private String nian;
        private String ci;
        private String yt;
        private String hbks;
        private String chry;
        private String scfile;

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

        public String getNian() {
            return nian;
        }

        public void setNian(String nian) {
            this.nian = nian;
        }

        public String getCi() {
            return ci;
        }

        public void setCi(String ci) {
            this.ci = ci;
        }

        public String getYt() {
            return yt;
        }

        public void setYt(String yt) {
            this.yt = yt;
        }

        public String getHbks() {
            return hbks;
        }

        public void setHbks(String hbks) {
            this.hbks = hbks;
        }

        public String getChry() {
            return chry;
        }

        public void setChry(String chry) {
            this.chry = chry;
        }

        public String getScfile() {
            return scfile;
        }

        public void setScfile(String scfile) {
            this.scfile = scfile;
        }
    }
}
