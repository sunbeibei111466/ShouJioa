package project01.shoujioa.gson_tool;

import java.util.List;

public class review_tool {

    /**
     * statuscode : 200
     * message : success
     * datas : [{"id":"a819526ffc224d8fba50f5eb5220fd24","isNewRecord":false,"remarks":"ddfffggghghy","createDate":"2018-08-30 21:25:43","updateDate":"2018-08-30 21:26:59","name":"44333dddddd","laiwendanwei":"wwwwwww","wenhao":"444444","guanlian":"1535635543211","fenshu":"555","jindu":"4","chuangjianriqi":"2018-08-30","jinjichengdu":"特急","hao":"12","qu":"区","nian":"2018","filename":"JAVA安全编码规范.doc,","bid":"2656a4fb45e94b95b208430187ba684d","list":[{"id":"9e6c8b16c53e43968eb42189656eec2c","isNewRecord":false,"createDate":"2018-08-30 21:26:59","updateDate":"2018-08-30 21:26:59","userid":"edb8b8071baf4da8bebb396cc434befe","linkfield":"1535635543211","qibanriqi":"2018-08-30 09-26-59","daiban":"1","daiyue":"2","caogao":"0","guanzhu":"0","cuiban":"0","jibie":"4"}]},{"id":"70599a5a96d3407ca3e59a381847c51e","isNewRecord":false,"remarks":"dffffffffff","createDate":"2018-08-30 21:25:10","updateDate":"2018-08-30 21:26:11","name":"sfsghjhjhjjj","laiwendanwei":"zhahahahhaha","wenhao":"2222","guanlian":"1535635510083","fenshu":"11","jindu":"5","chuangjianriqi":"2018-08-30","jinjichengdu":"紧急","hao":"41","qu":"市","nian":"2018","filename":"addressbook(1).xls,","bid":"eeab1a8ce6bf42eda2dcc9e9eff1daee","list":[{"id":"3b98a51bd7764fe0a9cc702bbae07123","isNewRecord":false,"createDate":"2018-08-30 21:26:11","updateDate":"2018-08-30 21:27:18","userid":"6c723f688cde4a418f9b123477b2e885","linkfield":"1535635510083","qibanriqi":"2018-08-30 09-26-11","daiban":"1","daiyue":"2","caogao":"0","guanzhu":"0","cuiban":"0","jibie":"5"}]}]
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
         * bid : 2656a4fb45e94b95b208430187ba684d
         * list : [{"id":"9e6c8b16c53e43968eb42189656eec2c","isNewRecord":false,"createDate":"2018-08-30 21:26:59","updateDate":"2018-08-30 21:26:59","userid":"edb8b8071baf4da8bebb396cc434befe","linkfield":"1535635543211","qibanriqi":"2018-08-30 09-26-59","daiban":"1","daiyue":"2","caogao":"0","guanzhu":"0","cuiban":"0","jibie":"4"}]
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
        private String bid;
        private List<ListBean> list;

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

        public String getBid() {
            return bid;
        }

        public void setBid(String bid) {
            this.bid = bid;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * id : 9e6c8b16c53e43968eb42189656eec2c
             * isNewRecord : false
             * createDate : 2018-08-30 21:26:59
             * updateDate : 2018-08-30 21:26:59
             * userid : edb8b8071baf4da8bebb396cc434befe
             * linkfield : 1535635543211
             * qibanriqi : 2018-08-30 09-26-59
             * daiban : 1
             * daiyue : 2
             * caogao : 0
             * guanzhu : 0
             * cuiban : 0
             * jibie : 4
             */

            private String id;
            private boolean isNewRecord;
            private String createDate;
            private String updateDate;
            private String userid;
            private String linkfield;
            private String qibanriqi;
            private String daiban;
            private String daiyue;
            private String caogao;
            private String guanzhu;
            private String cuiban;
            private String jibie;

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

            public String getUserid() {
                return userid;
            }

            public void setUserid(String userid) {
                this.userid = userid;
            }

            public String getLinkfield() {
                return linkfield;
            }

            public void setLinkfield(String linkfield) {
                this.linkfield = linkfield;
            }

            public String getQibanriqi() {
                return qibanriqi;
            }

            public void setQibanriqi(String qibanriqi) {
                this.qibanriqi = qibanriqi;
            }

            public String getDaiban() {
                return daiban;
            }

            public void setDaiban(String daiban) {
                this.daiban = daiban;
            }

            public String getDaiyue() {
                return daiyue;
            }

            public void setDaiyue(String daiyue) {
                this.daiyue = daiyue;
            }

            public String getCaogao() {
                return caogao;
            }

            public void setCaogao(String caogao) {
                this.caogao = caogao;
            }

            public String getGuanzhu() {
                return guanzhu;
            }

            public void setGuanzhu(String guanzhu) {
                this.guanzhu = guanzhu;
            }

            public String getCuiban() {
                return cuiban;
            }

            public void setCuiban(String cuiban) {
                this.cuiban = cuiban;
            }

            public String getJibie() {
                return jibie;
            }

            public void setJibie(String jibie) {
                this.jibie = jibie;
            }
        }
    }
}
