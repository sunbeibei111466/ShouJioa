package project01.shoujioa.gson_tool;

import java.util.List;

public class Xfxq_tool {

    /**
     * statuscode : 200
     * message : success
     * map : {"str":["热线回复样本.doc"],"zhuguanlist":[{"id":"dfdafee723e1416eb1cd4cde13ccb937","isNewRecord":false,"createDate":"2018-09-25 15:44:58","updateDate":"2018-09-25 15:45:25","userid":"ca6ca4ae2178443f83dfc453877d93f2","linkfield":"1537860708902","qibanriqi":"2018-09-25 03-44-58","banliriqi":"2018-09-25 03-45-25","daiban":"0","yijian":"寻寻觅觅，冷冷清清，凄凄惨惨戚戚","jibie":"3"}],"keshilist":[{"id":"f151b15da80e4282ab2fb5d641d69529","isNewRecord":false,"createDate":"2018-09-25 15:46:16","updateDate":"2018-09-25 15:46:40","userid":"3258277a091449f9996965509ca93d53","linkfield":"1537860708902","qibanriqi":"2018-09-25 03-46-16","banliriqi":"2018-09-25 03-46-40","daiban":"0","yijian":"寻寻觅觅，冷冷清清，凄凄惨惨戚戚","jibie":"5"},{"id":"f130c2eec9cc4f018af6eddc688c95bf","isNewRecord":false,"createDate":"2018-09-25 15:45:53","updateDate":"2018-09-25 15:46:16","userid":"6c723f688cde4a418f9b123477b2e885","linkfield":"1537860708902","qibanriqi":"2018-09-25 03-45-53","banliriqi":"2018-09-25 03-46-16","daiban":"0","yijian":"寻寻觅觅，冷冷清清，凄凄惨惨戚戚","jibie":"5"}],"julingdao":{"id":"4ae72064d72e4a97ac8c0fe08d8fb58f","isNewRecord":false,"createDate":"2018-09-25 15:31:48","updateDate":"2018-09-25 15:44:58","userid":"d121cfee8cef4dda8b6674753b6a32d5","linkfield":"1537860708902","qibanriqi":"2018-09-25 03-31-48","banliriqi":"2018-09-25 03-44-58","daiban":"0","yijian":"寻寻觅觅，冷冷清清，凄凄惨惨戚戚","jibie":"2"},"wsjXinfang":{"id":"fb83f58416134f8a91b710447efa3b4f","isNewRecord":false,"createDate":"2018-09-25 15:31:48","updateDate":"2018-09-25 15:46:40","name":"无所谓","xingzhi":"三点多","zhuanbr":"有所谓","lxfsjidz":"123232233","fysjjifs":"2222222","neirong":"寻寻觅觅，冷冷清清，凄凄惨惨戚戚","fujian":"热线回复样本.doc,","beizu":"","jindu":"6","guanlian":"1537860708902"}}
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
         * str : ["热线回复样本.doc"]
         * zhuguanlist : [{"id":"dfdafee723e1416eb1cd4cde13ccb937","isNewRecord":false,"createDate":"2018-09-25 15:44:58","updateDate":"2018-09-25 15:45:25","userid":"ca6ca4ae2178443f83dfc453877d93f2","linkfield":"1537860708902","qibanriqi":"2018-09-25 03-44-58","banliriqi":"2018-09-25 03-45-25","daiban":"0","yijian":"寻寻觅觅，冷冷清清，凄凄惨惨戚戚","jibie":"3"}]
         * keshilist : [{"id":"f151b15da80e4282ab2fb5d641d69529","isNewRecord":false,"createDate":"2018-09-25 15:46:16","updateDate":"2018-09-25 15:46:40","userid":"3258277a091449f9996965509ca93d53","linkfield":"1537860708902","qibanriqi":"2018-09-25 03-46-16","banliriqi":"2018-09-25 03-46-40","daiban":"0","yijian":"寻寻觅觅，冷冷清清，凄凄惨惨戚戚","jibie":"5"},{"id":"f130c2eec9cc4f018af6eddc688c95bf","isNewRecord":false,"createDate":"2018-09-25 15:45:53","updateDate":"2018-09-25 15:46:16","userid":"6c723f688cde4a418f9b123477b2e885","linkfield":"1537860708902","qibanriqi":"2018-09-25 03-45-53","banliriqi":"2018-09-25 03-46-16","daiban":"0","yijian":"寻寻觅觅，冷冷清清，凄凄惨惨戚戚","jibie":"5"}]
         * julingdao : {"id":"4ae72064d72e4a97ac8c0fe08d8fb58f","isNewRecord":false,"createDate":"2018-09-25 15:31:48","updateDate":"2018-09-25 15:44:58","userid":"d121cfee8cef4dda8b6674753b6a32d5","linkfield":"1537860708902","qibanriqi":"2018-09-25 03-31-48","banliriqi":"2018-09-25 03-44-58","daiban":"0","yijian":"寻寻觅觅，冷冷清清，凄凄惨惨戚戚","jibie":"2"}
         * wsjXinfang : {"id":"fb83f58416134f8a91b710447efa3b4f","isNewRecord":false,"createDate":"2018-09-25 15:31:48","updateDate":"2018-09-25 15:46:40","name":"无所谓","xingzhi":"三点多","zhuanbr":"有所谓","lxfsjidz":"123232233","fysjjifs":"2222222","neirong":"寻寻觅觅，冷冷清清，凄凄惨惨戚戚","fujian":"热线回复样本.doc,","beizu":"","jindu":"6","guanlian":"1537860708902"}
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
             * id : 4ae72064d72e4a97ac8c0fe08d8fb58f
             * isNewRecord : false
             * createDate : 2018-09-25 15:31:48
             * updateDate : 2018-09-25 15:44:58
             * userid : d121cfee8cef4dda8b6674753b6a32d5
             * linkfield : 1537860708902
             * qibanriqi : 2018-09-25 03-31-48
             * banliriqi : 2018-09-25 03-44-58
             * daiban : 0
             * yijian : 寻寻觅觅，冷冷清清，凄凄惨惨戚戚
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
             * id : fb83f58416134f8a91b710447efa3b4f
             * isNewRecord : false
             * createDate : 2018-09-25 15:31:48
             * updateDate : 2018-09-25 15:46:40
             * name : 无所谓
             * xingzhi : 三点多
             * zhuanbr : 有所谓
             * lxfsjidz : 123232233
             * fysjjifs : 2222222
             * neirong : 寻寻觅觅，冷冷清清，凄凄惨惨戚戚
             * fujian : 热线回复样本.doc,
             * beizu :
             * jindu : 6
             * guanlian : 1537860708902
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
             * id : dfdafee723e1416eb1cd4cde13ccb937
             * isNewRecord : false
             * createDate : 2018-09-25 15:44:58
             * updateDate : 2018-09-25 15:45:25
             * userid : ca6ca4ae2178443f83dfc453877d93f2
             * linkfield : 1537860708902
             * qibanriqi : 2018-09-25 03-44-58
             * banliriqi : 2018-09-25 03-45-25
             * daiban : 0
             * yijian : 寻寻觅觅，冷冷清清，凄凄惨惨戚戚
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
             * id : f151b15da80e4282ab2fb5d641d69529
             * isNewRecord : false
             * createDate : 2018-09-25 15:46:16
             * updateDate : 2018-09-25 15:46:40
             * userid : 3258277a091449f9996965509ca93d53
             * linkfield : 1537860708902
             * qibanriqi : 2018-09-25 03-46-16
             * banliriqi : 2018-09-25 03-46-40
             * daiban : 0
             * yijian : 寻寻觅觅，冷冷清清，凄凄惨惨戚戚
             * jibie : 5
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
    }
}
