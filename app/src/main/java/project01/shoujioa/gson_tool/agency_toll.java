package project01.shoujioa.gson_tool;

import java.util.List;

public class agency_toll {


    /**
     * statuscode : 200
     * message : success
     * datas : [{"id":"9c9ca6bcd54f42c7a5a0b68e8f7bd942","isNewRecord":false,"remarks":"21212121","createDate":"2018-08-22 10:55:09","updateDate":"2018-08-22 11:09:43","name":"212121","laiwendanwei":"千万前无群无群","wenhao":"121212121","guanlian":"1534906509082","fenshu":"1","jindu":"4","chuangjianriqi":"2018-08-22 10-55-09","jinjichengdu":"紧急","hao":"34","qu":"市","nian":"2018","filename":"TMS刀具库管理系统.docx,","cuiban":"0","time":"2018-08-22 11-09-43"}]
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
         * id : 9c9ca6bcd54f42c7a5a0b68e8f7bd942
         * isNewRecord : false
         * remarks : 21212121
         * createDate : 2018-08-22 10:55:09
         * updateDate : 2018-08-22 11:09:43
         * name : 212121
         * laiwendanwei : 千万前无群无群
         * wenhao : 121212121
         * guanlian : 1534906509082
         * fenshu : 1
         * jindu : 4
         * chuangjianriqi : 2018-08-22 10-55-09
         * jinjichengdu : 紧急
         * hao : 34
         * qu : 市
         * nian : 2018
         * filename : TMS刀具库管理系统.docx,
         * cuiban : 0
         * time : 2018-08-22 11-09-43
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
        private String cuiban;
        private String time;

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

        public String getCuiban() {
            return cuiban;
        }

        public void setCuiban(String cuiban) {
            this.cuiban = cuiban;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }
}
