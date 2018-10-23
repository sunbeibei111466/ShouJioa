package project01.shoujioa.gson_tool;

import java.util.List;

public class follow_tool {


    /**
     * statuscode : 200
     * message : 暂无数据
     * datas : [""]
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
         * id : 065b4a5e948945138b9ee47f9aecca79
         * isNewRecord : false
         * remarks : 范德萨
         * createDate : 2018-08-17 14:56:59
         * updateDate : 2018-08-17 15:01:59
         * name : 大幅度啥打法是否
         * laiwendanwei : 的撒啊啊是
         * wenhao : 2301456
         * guanlian : 1534489019564
         * fenshu : 100
         * jindu : 6
         * chuangjianriqi : 2018-08-17 02-56-59
         * jinjichengdu : 特急
         * hao : 33
         * qu : 市
         * nian : 2018
         * filename : 精准扶贫接口文档.docx,灵寿县精准扶贫动态管理档案（电子版）.xlsx,批量下载.txt,
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
    }
}
