package project01.shoujioa.gson_tool;

import java.util.List;

public class xf_list_tool {

    /**
     * statuscode : 200
     * message : success
     * datas : [{"id":"1a0fd77a9c3d43cb9163d8f58be0828a","isNewRecord":false,"createDate":"2018-09-25 13:45:01","updateDate":"2018-09-25 13:46:32","name":"粉丝大大","xingzhi":"发送到","zhuanbr":"富士达","lxfsjidz":"傻傻的","fysjjifs":"发","neirong":"士大夫撒旦","fujian":"精准扶贫接口文档.docx,","beizu":"","jindu":"6","guanlian":"1537854301456"}]
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
         * id : 1a0fd77a9c3d43cb9163d8f58be0828a
         * isNewRecord : false
         * createDate : 2018-09-25 13:45:01
         * updateDate : 2018-09-25 13:46:32
         * name : 粉丝大大
         * xingzhi : 发送到
         * zhuanbr : 富士达
         * lxfsjidz : 傻傻的
         * fysjjifs : 发
         * neirong : 士大夫撒旦
         * fujian : 精准扶贫接口文档.docx,
         * beizu :
         * jindu : 6
         * guanlian : 1537854301456
         */

        private String id;
        private boolean isNewRecord;
        private String createDate;
        private String updateDate;
        private String name;
        private String xingzhi;
        private String zhuanbr;
        private String lxfsjidz;
        private String fysjjifs;
        private String neirong;
        private String fujian;
        private String beizu;
        private String jindu;
        private String guanlian;

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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getXingzhi() {
            return xingzhi;
        }

        public void setXingzhi(String xingzhi) {
            this.xingzhi = xingzhi;
        }

        public String getZhuanbr() {
            return zhuanbr;
        }

        public void setZhuanbr(String zhuanbr) {
            this.zhuanbr = zhuanbr;
        }

        public String getLxfsjidz() {
            return lxfsjidz;
        }

        public void setLxfsjidz(String lxfsjidz) {
            this.lxfsjidz = lxfsjidz;
        }

        public String getFysjjifs() {
            return fysjjifs;
        }

        public void setFysjjifs(String fysjjifs) {
            this.fysjjifs = fysjjifs;
        }

        public String getNeirong() {
            return neirong;
        }

        public void setNeirong(String neirong) {
            this.neirong = neirong;
        }

        public String getFujian() {
            return fujian;
        }

        public void setFujian(String fujian) {
            this.fujian = fujian;
        }

        public String getBeizu() {
            return beizu;
        }

        public void setBeizu(String beizu) {
            this.beizu = beizu;
        }

        public String getJindu() {
            return jindu;
        }

        public void setJindu(String jindu) {
            this.jindu = jindu;
        }

        public String getGuanlian() {
            return guanlian;
        }

        public void setGuanlian(String guanlian) {
            this.guanlian = guanlian;
        }
    }
}
