package project01.shoujioa.XQTOOL_all;

import java.util.List;

public class TSXQ_toll {

    /**
     * statuscode : 200
     * message : success
     * map : {"str":["精准扶贫接口文档.docx"],"keshilist":[{"id":"5e64fb07a7574de2bb6b7c85c7561ee1","isNewRecord":false,"createDate":"2018-09-28 14:35:32","updateDate":"2018-09-28 14:35:32","userid":"a4eafa0edbb149769f6d6c2b79baa519","linkfield":"1538115194925","qibanriqi":"2018-09-28 02-34-16","daiban":"1","yijian":"办理中▪▪▪▪▪▪▪▪","jibie":"5"},{"id":"5ae105511f2340208e091c643b977d1b","isNewRecord":false,"createDate":"2018-09-28 14:35:18","updateDate":"2018-09-28 14:35:18","userid":"08b9c6954640468c9dcb09a7b1cda3f3","linkfield":"1538115194925","qibanriqi":"2018-09-28 02-34-16","daiban":"1","yijian":"办理中▪▪▪▪▪▪▪▪","jibie":"5"},{"id":"e73567898e5d45b18e3cdd67a7eb7e2e","isNewRecord":false,"createDate":"2018-09-28 14:35:03","updateDate":"2018-09-28 14:35:03","userid":"8463f82f6b2b4bea80d3c523d66f2a58","linkfield":"1538115194925","qibanriqi":"2018-09-28 02-34-16","daiban":"1","yijian":"办理中▪▪▪▪▪▪▪▪","jibie":"5"},{"id":"accf083da72649018b7c7788fed5a121","isNewRecord":false,"createDate":"2018-09-28 14:34:36","updateDate":"2018-09-28 14:34:36","userid":"6c723f688cde4a418f9b123477b2e885","linkfield":"1538115194925","qibanriqi":"2018-09-28 02-34-16","daiban":"1","yijian":"办理中▪▪▪▪▪▪▪▪","jibie":"5"}],"julingdao":{"id":"1efdd78f24a342348d3d473758d4bb82","isNewRecord":false,"createDate":"2018-09-28 14:13:14","updateDate":"2018-09-28 14:13:33","userid":"d121cfee8cef4dda8b6674753b6a32d5","linkfield":"1538115194925","qibanriqi":"2018-09-28 02-13-14","banliriqi":"2018-09-28 02-13-33","daiban":"0","yijian":"是的发送到的发送到","jibie":"3"},"wsjXinfang":{"id":"9f026b4858ee478ab1cdcc8e1eafc30c","isNewRecord":false,"createDate":"2018-09-28 14:13:14","updateDate":"2018-09-28 14:35:34","bianhao":"风飒飒","laiyuan":"所发生的发生f","danwei":"方式发斯蒂芬","fujian":"精准扶贫接口文档.docx,","guanlian":"1538115194925","jindu":"5","chuangjianriqi":"2018-09-28"}}
     */

    private String statuscode;
    private String message;
    private MapBean map;

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

    public MapBean getMap() {
        return map;
    }

    public void setMap(MapBean map) {
        this.map = map;
    }

    public static class MapBean {
        /**
         * str : ["精准扶贫接口文档.docx"]
         * keshilist : [{"id":"5e64fb07a7574de2bb6b7c85c7561ee1","isNewRecord":false,"createDate":"2018-09-28 14:35:32","updateDate":"2018-09-28 14:35:32","userid":"a4eafa0edbb149769f6d6c2b79baa519","linkfield":"1538115194925","qibanriqi":"2018-09-28 02-34-16","daiban":"1","yijian":"办理中▪▪▪▪▪▪▪▪","jibie":"5"},{"id":"5ae105511f2340208e091c643b977d1b","isNewRecord":false,"createDate":"2018-09-28 14:35:18","updateDate":"2018-09-28 14:35:18","userid":"08b9c6954640468c9dcb09a7b1cda3f3","linkfield":"1538115194925","qibanriqi":"2018-09-28 02-34-16","daiban":"1","yijian":"办理中▪▪▪▪▪▪▪▪","jibie":"5"},{"id":"e73567898e5d45b18e3cdd67a7eb7e2e","isNewRecord":false,"createDate":"2018-09-28 14:35:03","updateDate":"2018-09-28 14:35:03","userid":"8463f82f6b2b4bea80d3c523d66f2a58","linkfield":"1538115194925","qibanriqi":"2018-09-28 02-34-16","daiban":"1","yijian":"办理中▪▪▪▪▪▪▪▪","jibie":"5"},{"id":"accf083da72649018b7c7788fed5a121","isNewRecord":false,"createDate":"2018-09-28 14:34:36","updateDate":"2018-09-28 14:34:36","userid":"6c723f688cde4a418f9b123477b2e885","linkfield":"1538115194925","qibanriqi":"2018-09-28 02-34-16","daiban":"1","yijian":"办理中▪▪▪▪▪▪▪▪","jibie":"5"}]
         * julingdao : {"id":"1efdd78f24a342348d3d473758d4bb82","isNewRecord":false,"createDate":"2018-09-28 14:13:14","updateDate":"2018-09-28 14:13:33","userid":"d121cfee8cef4dda8b6674753b6a32d5","linkfield":"1538115194925","qibanriqi":"2018-09-28 02-13-14","banliriqi":"2018-09-28 02-13-33","daiban":"0","yijian":"是的发送到的发送到","jibie":"3"}
         * wsjXinfang : {"id":"9f026b4858ee478ab1cdcc8e1eafc30c","isNewRecord":false,"createDate":"2018-09-28 14:13:14","updateDate":"2018-09-28 14:35:34","bianhao":"风飒飒","laiyuan":"所发生的发生f","danwei":"方式发斯蒂芬","fujian":"精准扶贫接口文档.docx,","guanlian":"1538115194925","jindu":"5","chuangjianriqi":"2018-09-28"}
         */

        private JulingdaoBean julingdao;
        private WsjXinfangBean wsjXinfang;
        private List<String> str;
        private List<KeshilistBean> keshilist;

        public JulingdaoBean getJulingdao() {
            return julingdao;
        }

        public void setJulingdao(JulingdaoBean julingdao) {
            this.julingdao = julingdao;
        }

        public WsjXinfangBean getWsjXinfang() {
            return wsjXinfang;
        }

        public void setWsjXinfang(WsjXinfangBean wsjXinfang) {
            this.wsjXinfang = wsjXinfang;
        }

        public List<String> getStr() {
            return str;
        }

        public void setStr(List<String> str) {
            this.str = str;
        }

        public List<KeshilistBean> getKeshilist() {
            return keshilist;
        }

        public void setKeshilist(List<KeshilistBean> keshilist) {
            this.keshilist = keshilist;
        }

        public static class JulingdaoBean {
            /**
             * id : 1efdd78f24a342348d3d473758d4bb82
             * isNewRecord : false
             * createDate : 2018-09-28 14:13:14
             * updateDate : 2018-09-28 14:13:33
             * userid : d121cfee8cef4dda8b6674753b6a32d5
             * linkfield : 1538115194925
             * qibanriqi : 2018-09-28 02-13-14
             * banliriqi : 2018-09-28 02-13-33
             * daiban : 0
             * yijian : 是的发送到的发送到
             * jibie : 3
             */

            private String id;
            private boolean isNewRecord;
            private String createDate;
            private String updateDate;
            private String userid;
            private String linkfield;
            private String qibanriqi;
            private String banliriqi;
            private String daiban;
            private String yijian;
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

            public String getBanliriqi() {
                return banliriqi;
            }

            public void setBanliriqi(String banliriqi) {
                this.banliriqi = banliriqi;
            }

            public String getDaiban() {
                return daiban;
            }

            public void setDaiban(String daiban) {
                this.daiban = daiban;
            }

            public String getYijian() {
                return yijian;
            }

            public void setYijian(String yijian) {
                this.yijian = yijian;
            }

            public String getJibie() {
                return jibie;
            }

            public void setJibie(String jibie) {
                this.jibie = jibie;
            }
        }

        public static class WsjXinfangBean {
            /**
             * id : 9f026b4858ee478ab1cdcc8e1eafc30c
             * isNewRecord : false
             * createDate : 2018-09-28 14:13:14
             * updateDate : 2018-09-28 14:35:34
             * bianhao : 风飒飒
             * laiyuan : 所发生的发生f
             * danwei : 方式发斯蒂芬
             * fujian : 精准扶贫接口文档.docx,
             * guanlian : 1538115194925
             * jindu : 5
             * chuangjianriqi : 2018-09-28
             */

            private String id;
            private boolean isNewRecord;
            private String createDate;
            private String updateDate;
            private String bianhao;
            private String laiyuan;
            private String danwei;
            private String fujian;
            private String guanlian;
            private String jindu;
            private String chuangjianriqi;

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

            public String getBianhao() {
                return bianhao;
            }

            public void setBianhao(String bianhao) {
                this.bianhao = bianhao;
            }

            public String getLaiyuan() {
                return laiyuan;
            }

            public void setLaiyuan(String laiyuan) {
                this.laiyuan = laiyuan;
            }

            public String getDanwei() {
                return danwei;
            }

            public void setDanwei(String danwei) {
                this.danwei = danwei;
            }

            public String getFujian() {
                return fujian;
            }

            public void setFujian(String fujian) {
                this.fujian = fujian;
            }

            public String getGuanlian() {
                return guanlian;
            }

            public void setGuanlian(String guanlian) {
                this.guanlian = guanlian;
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
        }

        public static class KeshilistBean {
            /**
             * id : 5e64fb07a7574de2bb6b7c85c7561ee1
             * isNewRecord : false
             * createDate : 2018-09-28 14:35:32
             * updateDate : 2018-09-28 14:35:32
             * userid : a4eafa0edbb149769f6d6c2b79baa519
             * linkfield : 1538115194925
             * qibanriqi : 2018-09-28 02-34-16
             * daiban : 1
             * yijian : 办理中▪▪▪▪▪▪▪▪
             * jibie : 5
             */

            private String id;
            private boolean isNewRecord;
            private String createDate;
            private String updateDate;
            private String userid;
            private String linkfield;
            private String qibanriqi;
            private String daiban;
            private String yijian;
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

            public String getYijian() {
                return yijian;
            }

            public void setYijian(String yijian) {
                this.yijian = yijian;
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
