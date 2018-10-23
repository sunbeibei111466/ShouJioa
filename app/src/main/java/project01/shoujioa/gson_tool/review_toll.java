package project01.shoujioa.gson_tool;

import java.util.List;

public class review_toll {

    /**
     * statuscode : 200
     * message : success
     * datas : [{"id":"a97201783b954a82b2338902a64530d4","isNewRecord":false,"remarks":"","createDate":"2018-08-29 19:48:47","updateDate":"2018-08-30 09:41:09","name":"乡镇信息","laiwendanwei":"对对对","wenhao":"22222","guanlian":"1535543327260","fenshu":"5","jindu":"4","chuangjianriqi":"2018-08-29","jinjichengdu":"急","hao":"36","qu":"市","nian":"2018","filename":"精准扶贫接口文档.docx,","daiyue":"1","list":[{"id":"96efe72eb6f1412585936ef000180b78","isNewRecord":false,"createDate":"2018-08-30 09:41:09","updateDate":"2018-08-30 18:47:48","userid":"edb8b8071baf4da8bebb396cc434befe","linkfield":"1535543327260","qibanriqi":"2018-08-30 09-41-09","daiban":"1","daiyue":"2","caogao":"0","guanzhu":"0","cuiban":"0","jibie":"4"}]}]
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
         * id : a97201783b954a82b2338902a64530d4
         * isNewRecord : false
         * remarks :
         * createDate : 2018-08-29 19:48:47
         * updateDate : 2018-08-30 09:41:09
         * name : 乡镇信息
         * laiwendanwei : 对对对
         * wenhao : 22222
         * guanlian : 1535543327260
         * fenshu : 5
         * jindu : 4
         * chuangjianriqi : 2018-08-29
         * jinjichengdu : 急
         * hao : 36
         * qu : 市
         * nian : 2018
         * filename : 精准扶贫接口文档.docx,
         * daiyue : 1
         * list : [{"id":"96efe72eb6f1412585936ef000180b78","isNewRecord":false,"createDate":"2018-08-30 09:41:09","updateDate":"2018-08-30 18:47:48","userid":"edb8b8071baf4da8bebb396cc434befe","linkfield":"1535543327260","qibanriqi":"2018-08-30 09-41-09","daiban":"1","daiyue":"2","caogao":"0","guanzhu":"0","cuiban":"0","jibie":"4"}]
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
        private String daiyue;
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

        public String getDaiyue() {
            return daiyue;
        }

        public void setDaiyue(String daiyue) {
            this.daiyue = daiyue;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * id : 96efe72eb6f1412585936ef000180b78
             * isNewRecord : false
             * createDate : 2018-08-30 09:41:09
             * updateDate : 2018-08-30 18:47:48
             * userid : edb8b8071baf4da8bebb396cc434befe
             * linkfield : 1535543327260
             * qibanriqi : 2018-08-30 09-41-09
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
