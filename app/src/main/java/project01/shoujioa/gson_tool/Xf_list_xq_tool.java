package project01.shoujioa.gson_tool;

import java.util.List;

public class Xf_list_xq_tool {

    /**
     * statuscode : 200
     * message : success
     * map : {"str":["新建文本文档.txt"],"zhuguanlist":[{"id":"9ad582a0fd1e430b82ae9f9bb2a8dbae","isNewRecord":false,"createDate":"2018-09-28 10:32:48","updateDate":"2018-09-28 10:33:01","userid":"ca6ca4ae2178443f83dfc453877d93f2","linkfield":"1538101821160","qibanriqi":"2018-09-28 10-32-48","banliriqi":"2018-09-28 10-33-01","daiban":"0","yijian":"的舒服撒打发","jibie":"3"}],"keshilist":[{"id":"323539a762d242218c8450e264afcd07","isNewRecord":false,"createDate":"2018-09-28 11:06:52","updateDate":"2018-09-28 11:06:52","userid":"6c723f688cde4a418f9b123477b2e885","linkfield":"1538101821160","qibanriqi":"2018-09-28 11-06-52","daiban":"1","yijian":"办理中▪▪▪▪▪▪▪▪","jibie":"5"}],"julingdao":{"id":"71cfd41e32b146baa2bd3dfc6f99f57c","isNewRecord":false,"createDate":"2018-09-28 10:30:21","updateDate":"2018-09-28 10:32:48","userid":"d121cfee8cef4dda8b6674753b6a32d5","linkfield":"1538101821160","qibanriqi":"2018-09-28 10-30-21","banliriqi":"2018-09-28 10-32-48","daiban":"0","yijian":"地方撒旦飞洒","jibie":"2"},"wsjXinfang":{"id":"9a66fc9ddd5740bd8fca5809b6005ab7","isNewRecord":false,"createDate":"2018-09-28 10:30:21","updateDate":"2018-09-28 11:06:52","name":"是否打算的","xingzhi":"是的发送到","zhuanbr":"阿士大夫撒旦","lxfsjidz":"范德萨","fysjjifs":"sad方法萨顶顶","neirong":"傻傻的奋斗","fujian":"新建文本文档.txt,","beizu":"","jindu":"5","guanlian":"1538101821160"}}
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
         * str : ["新建文本文档.txt"]
         * zhuguanlist : [{"id":"9ad582a0fd1e430b82ae9f9bb2a8dbae","isNewRecord":false,"createDate":"2018-09-28 10:32:48","updateDate":"2018-09-28 10:33:01","userid":"ca6ca4ae2178443f83dfc453877d93f2","linkfield":"1538101821160","qibanriqi":"2018-09-28 10-32-48","banliriqi":"2018-09-28 10-33-01","daiban":"0","yijian":"的舒服撒打发","jibie":"3"}]
         * keshilist : [{"id":"323539a762d242218c8450e264afcd07","isNewRecord":false,"createDate":"2018-09-28 11:06:52","updateDate":"2018-09-28 11:06:52","userid":"6c723f688cde4a418f9b123477b2e885","linkfield":"1538101821160","qibanriqi":"2018-09-28 11-06-52","daiban":"1","yijian":"办理中▪▪▪▪▪▪▪▪","jibie":"5"}]
         * julingdao : {"id":"71cfd41e32b146baa2bd3dfc6f99f57c","isNewRecord":false,"createDate":"2018-09-28 10:30:21","updateDate":"2018-09-28 10:32:48","userid":"d121cfee8cef4dda8b6674753b6a32d5","linkfield":"1538101821160","qibanriqi":"2018-09-28 10-30-21","banliriqi":"2018-09-28 10-32-48","daiban":"0","yijian":"地方撒旦飞洒","jibie":"2"}
         * wsjXinfang : {"id":"9a66fc9ddd5740bd8fca5809b6005ab7","isNewRecord":false,"createDate":"2018-09-28 10:30:21","updateDate":"2018-09-28 11:06:52","name":"是否打算的","xingzhi":"是的发送到","zhuanbr":"阿士大夫撒旦","lxfsjidz":"范德萨","fysjjifs":"sad方法萨顶顶","neirong":"傻傻的奋斗","fujian":"新建文本文档.txt,","beizu":"","jindu":"5","guanlian":"1538101821160"}
         */

        private JulingdaoBean julingdao;
        private WsjXinfangBean wsjXinfang;
        private List<String> str;
        private List<ZhuguanlistBean> zhuguanlist;
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

        public List<ZhuguanlistBean> getZhuguanlist() {
            return zhuguanlist;
        }

        public void setZhuguanlist(List<ZhuguanlistBean> zhuguanlist) {
            this.zhuguanlist = zhuguanlist;
        }

        public List<KeshilistBean> getKeshilist() {
            return keshilist;
        }

        public void setKeshilist(List<KeshilistBean> keshilist) {
            this.keshilist = keshilist;
        }

        public static class JulingdaoBean {
            /**
             * id : 71cfd41e32b146baa2bd3dfc6f99f57c
             * isNewRecord : false
             * createDate : 2018-09-28 10:30:21
             * updateDate : 2018-09-28 10:32:48
             * userid : d121cfee8cef4dda8b6674753b6a32d5
             * linkfield : 1538101821160
             * qibanriqi : 2018-09-28 10-30-21
             * banliriqi : 2018-09-28 10-32-48
             * daiban : 0
             * yijian : 地方撒旦飞洒
             * jibie : 2
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
             * id : 9a66fc9ddd5740bd8fca5809b6005ab7
             * isNewRecord : false
             * createDate : 2018-09-28 10:30:21
             * updateDate : 2018-09-28 11:06:52
             * name : 是否打算的
             * xingzhi : 是的发送到
             * zhuanbr : 阿士大夫撒旦
             * lxfsjidz : 范德萨
             * fysjjifs : sad方法萨顶顶
             * neirong : 傻傻的奋斗
             * fujian : 新建文本文档.txt,
             * beizu :
             * jindu : 5
             * guanlian : 1538101821160
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

        public static class ZhuguanlistBean {
            /**
             * id : 9ad582a0fd1e430b82ae9f9bb2a8dbae
             * isNewRecord : false
             * createDate : 2018-09-28 10:32:48
             * updateDate : 2018-09-28 10:33:01
             * userid : ca6ca4ae2178443f83dfc453877d93f2
             * linkfield : 1538101821160
             * qibanriqi : 2018-09-28 10-32-48
             * banliriqi : 2018-09-28 10-33-01
             * daiban : 0
             * yijian : 的舒服撒打发
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

        public static class KeshilistBean {
            /**
             * id : 323539a762d242218c8450e264afcd07
             * isNewRecord : false
             * createDate : 2018-09-28 11:06:52
             * updateDate : 2018-09-28 11:06:52
             * userid : 6c723f688cde4a418f9b123477b2e885
             * linkfield : 1538101821160
             * qibanriqi : 2018-09-28 11-06-52
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
