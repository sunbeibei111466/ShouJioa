package project01.shoujioa.Fragment_main;

import java.util.List;

public class read_toll {


    /**
     * statuscode : 200
     * message : success
     * datas : [{"id":"a819526ffc224d8fba50f5eb5220fd24","isNewRecord":false,"remarks":"ddfffggghghy","createDate":"2018-08-30 21:25:43","updateDate":"2018-08-30 21:26:59","name":"44333dddddd","laiwendanwei":"wwwwwww","wenhao":"444444","guanlian":"1535635543211","fenshu":"555","jindu":"4","chuangjianriqi":"2018-08-30","jinjichengdu":"特急","hao":"12","qu":"区","nian":"2018","filename":"JAVA安全编码规范.doc,","guanzhu":"1"},{"id":"70599a5a96d3407ca3e59a381847c51e","isNewRecord":false,"remarks":"dffffffffff","createDate":"2018-08-30 21:25:10","updateDate":"2018-08-30 21:26:11","name":"sfsghjhjhjjj","laiwendanwei":"zhahahahhaha","wenhao":"2222","guanlian":"1535635510083","fenshu":"11","jindu":"5","chuangjianriqi":"2018-08-30","jinjichengdu":"紧急","hao":"41","qu":"市","nian":"2018","filename":"addressbook(1).xls,","guanzhu":"1"}]
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
         * id : a819526ffc224d8fba50f5eb5220fd24
         * isNewRecord : false
         * remarks : ddfffggghghy
         * createDate : 2018-08-30 21:25:43
         * updateDate : 2018-08-30 21:26:59
         * name : 44333dddddd
         * laiwendanwei : wwwwwww
         * wenhao : 444444
         * guanlian : 1535635543211
         * fenshu : 555
         * jindu : 4
         * chuangjianriqi : 2018-08-30
         * jinjichengdu : 特急
         * hao : 12
         * qu : 区
         * nian : 2018
         * filename : JAVA安全编码规范.doc,
         * guanzhu : 1
         */

        private String id;
        private boolean isNewRecord;
        private String remarks;
        private String createDate;
        private String updateDate;
        private String name;
        private String laiwendanwei;
        private String wenhao;
        private String guanlian;
        private String fenshu;
        private String jindu;
        private String chuangjianriqi;
        private String jinjichengdu;
        private String hao;
        private String qu;
        private String nian;
        private String filename;
        private String guanzhu;

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

        public String getRemarks() {
            return remarks;
        }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
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

        public String getLaiwendanwei() {
            return laiwendanwei;
        }

        public void setLaiwendanwei(String laiwendanwei) {
            this.laiwendanwei = laiwendanwei;
        }

        public String getWenhao() {
            return wenhao;
        }

        public void setWenhao(String wenhao) {
            this.wenhao = wenhao;
        }

        public String getGuanlian() {
            return guanlian;
        }

        public void setGuanlian(String guanlian) {
            this.guanlian = guanlian;
        }

        public String getFenshu() {
            return fenshu;
        }

        public void setFenshu(String fenshu) {
            this.fenshu = fenshu;
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

        public String getJinjichengdu() {
            return jinjichengdu;
        }

        public void setJinjichengdu(String jinjichengdu) {
            this.jinjichengdu = jinjichengdu;
        }

        public String getHao() {
            return hao;
        }

        public void setHao(String hao) {
            this.hao = hao;
        }

        public String getQu() {
            return qu;
        }

        public void setQu(String qu) {
            this.qu = qu;
        }

        public String getNian() {
            return nian;
        }

        public void setNian(String nian) {
            this.nian = nian;
        }

        public String getFilename() {
            return filename;
        }

        public void setFilename(String filename) {
            this.filename = filename;
        }

        public String getGuanzhu() {
            return guanzhu;
        }

        public void setGuanzhu(String guanzhu) {
            this.guanzhu = guanzhu;
        }
    }
}
