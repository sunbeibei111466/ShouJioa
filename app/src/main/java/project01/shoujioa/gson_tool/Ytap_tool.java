package project01.shoujioa.gson_tool;

import java.util.List;

public class Ytap_tool {

    /**
     * statuscode : 200
     * message : success
     * map : {"str":["精准扶贫接口文档.docx"],"wsjHyyt":{"id":"2a19c96204524122830ab576e48b6cb2","isNewRecord":false,"createDate":"2018-09-07 15:31:43","updateDate":"2018-10-15 11:10:08","ytmc":"卢卡雷利","sbks":"进口红酒看见了","hbr":"1","hbsj":"2018-09-07","xgkshqyj":"","zqyjfw":"1536305503252","tqhyjdsx":"","jylxks":"1536305503252","scfile":"精准扶贫接口文档.docx,","bak1":"","bak2":"0","user2":{"isNewRecord":true,"name":"系统管理员","loginFlag":"1","admin":false,"roleNames":""}}}
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
         * wsjHyyt : {"id":"2a19c96204524122830ab576e48b6cb2","isNewRecord":false,"createDate":"2018-09-07 15:31:43","updateDate":"2018-10-15 11:10:08","ytmc":"卢卡雷利","sbks":"进口红酒看见了","hbr":"1","hbsj":"2018-09-07","xgkshqyj":"","zqyjfw":"1536305503252","tqhyjdsx":"","jylxks":"1536305503252","scfile":"精准扶贫接口文档.docx,","bak1":"","bak2":"0","user2":{"isNewRecord":true,"name":"系统管理员","loginFlag":"1","admin":false,"roleNames":""}}
         */

        private WsjHyytBean wsjHyyt;
        private List<String> str;

        public WsjHyytBean getWsjHyyt() {
            return wsjHyyt;
        }

        public void setWsjHyyt(WsjHyytBean wsjHyyt) {
            this.wsjHyyt = wsjHyyt;
        }

        public List<String> getStr() {
            return str;
        }

        public void setStr(List<String> str) {
            this.str = str;
        }

        public static class WsjHyytBean {
            /**
             * id : 2a19c96204524122830ab576e48b6cb2
             * isNewRecord : false
             * createDate : 2018-09-07 15:31:43
             * updateDate : 2018-10-15 11:10:08
             * ytmc : 卢卡雷利
             * sbks : 进口红酒看见了
             * hbr : 1
             * hbsj : 2018-09-07
             * xgkshqyj :
             * zqyjfw : 1536305503252
             * tqhyjdsx :
             * jylxks : 1536305503252
             * scfile : 精准扶贫接口文档.docx,
             * bak1 :
             * bak2 : 0
             * user2 : {"isNewRecord":true,"name":"系统管理员","loginFlag":"1","admin":false,"roleNames":""}
             */

            private String id;
            private boolean isNewRecord;
            private String createDate;
            private String updateDate;
            private String ytmc;
            private String sbks;
            private String hbr;
            private String hbsj;
            private String xgkshqyj;
            private String zqyjfw;
            private String tqhyjdsx;
            private String jylxks;
            private String scfile;
            private String bak1;
            private String bak2;
            private User2Bean user2;

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

            public String getYtmc() {
                return ytmc;
            }

            public void setYtmc(String ytmc) {
                this.ytmc = ytmc;
            }

            public String getSbks() {
                return sbks;
            }

            public void setSbks(String sbks) {
                this.sbks = sbks;
            }

            public String getHbr() {
                return hbr;
            }

            public void setHbr(String hbr) {
                this.hbr = hbr;
            }

            public String getHbsj() {
                return hbsj;
            }

            public void setHbsj(String hbsj) {
                this.hbsj = hbsj;
            }

            public String getXgkshqyj() {
                return xgkshqyj;
            }

            public void setXgkshqyj(String xgkshqyj) {
                this.xgkshqyj = xgkshqyj;
            }

            public String getZqyjfw() {
                return zqyjfw;
            }

            public void setZqyjfw(String zqyjfw) {
                this.zqyjfw = zqyjfw;
            }

            public String getTqhyjdsx() {
                return tqhyjdsx;
            }

            public void setTqhyjdsx(String tqhyjdsx) {
                this.tqhyjdsx = tqhyjdsx;
            }

            public String getJylxks() {
                return jylxks;
            }

            public void setJylxks(String jylxks) {
                this.jylxks = jylxks;
            }

            public String getScfile() {
                return scfile;
            }

            public void setScfile(String scfile) {
                this.scfile = scfile;
            }

            public String getBak1() {
                return bak1;
            }

            public void setBak1(String bak1) {
                this.bak1 = bak1;
            }

            public String getBak2() {
                return bak2;
            }

            public void setBak2(String bak2) {
                this.bak2 = bak2;
            }

            public User2Bean getUser2() {
                return user2;
            }

            public void setUser2(User2Bean user2) {
                this.user2 = user2;
            }

            public static class User2Bean {
                /**
                 * isNewRecord : true
                 * name : 系统管理员
                 * loginFlag : 1
                 * admin : false
                 * roleNames :
                 */

                private boolean isNewRecord;
                private String name;
                private String loginFlag;
                private boolean admin;
                private String roleNames;

                public boolean isIsNewRecord() {
                    return isNewRecord;
                }

                public void setIsNewRecord(boolean isNewRecord) {
                    this.isNewRecord = isNewRecord;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getLoginFlag() {
                    return loginFlag;
                }

                public void setLoginFlag(String loginFlag) {
                    this.loginFlag = loginFlag;
                }

                public boolean isAdmin() {
                    return admin;
                }

                public void setAdmin(boolean admin) {
                    this.admin = admin;
                }

                public String getRoleNames() {
                    return roleNames;
                }

                public void setRoleNames(String roleNames) {
                    this.roleNames = roleNames;
                }
            }
        }
    }
}
