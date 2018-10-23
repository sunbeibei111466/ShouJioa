package project01.shoujioa.gson_tool;

import java.util.List;

public class Spinner_tool {

    /**
     * statuscode : 200
     * message : success
     * datas : [{"id":"bd9d5e2519054af6bf062f0148ace0fd","isNewRecord":false,"userid":"edb8b8071baf4da8bebb396cc434befe","cyy":"为对方即可"},{"id":"f3a9bb8b98eb46e5899661e7b5bb5acd","isNewRecord":false,"userid":"edb8b8071baf4da8bebb396cc434befe","cyy":"erewrw"}]
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
         * id : bd9d5e2519054af6bf062f0148ace0fd
         * isNewRecord : false
         * userid : edb8b8071baf4da8bebb396cc434befe
         * cyy : 为对方即可
         */

        private String id;
        private boolean isNewRecord;
        private String userid;
        private String cyy;

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

        public String getUserid() {
            return userid;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }

        public String getCyy() {
            return cyy;
        }

        public void setCyy(String cyy) {
            this.cyy = cyy;
        }
    }
}
