package project01.shoujioa.gson_tool;

import java.util.List;

public class XW_tool {

    /**
     * statuscode : 200
     * message : success
     * map : {"str":["动监所行政处罚结果公示2018.9.18.xls"],"wsjXwzx":{"id":"4e1d73316a99453d9f1c14ff233a2a84","isNewRecord":false,"createDate":"2018-09-29 16:06:59","updateDate":"2018-09-29 16:06:59","bt":"test","lx":"新闻期刊","xwnr":"<p>\r\n\ttest<\/p>","fbr":"白雪","scfile":"动监所行政处罚结果公示2018.9.18.xls,","back1":"2e94efe55bf147128dbda33424d99dc2","back2":"0","back3":"1","back4":"信息中心","user":{"isNewRecord":true,"name":"朱树宏","loginFlag":"1","admin":false,"roleNames":""}}}
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
         * str : ["动监所行政处罚结果公示2018.9.18.xls"]
         * wsjXwzx : {"id":"4e1d73316a99453d9f1c14ff233a2a84","isNewRecord":false,"createDate":"2018-09-29 16:06:59","updateDate":"2018-09-29 16:06:59","bt":"test","lx":"新闻期刊","xwnr":"<p>\r\n\ttest<\/p>","fbr":"白雪","scfile":"动监所行政处罚结果公示2018.9.18.xls,","back1":"2e94efe55bf147128dbda33424d99dc2","back2":"0","back3":"1","back4":"信息中心","user":{"isNewRecord":true,"name":"朱树宏","loginFlag":"1","admin":false,"roleNames":""}}
         */

        private WsjXwzxBean wsjXwzx;
        private List<String> str;

        public WsjXwzxBean getWsjXwzx() {
            return wsjXwzx;
        }

        public void setWsjXwzx(WsjXwzxBean wsjXwzx) {
            this.wsjXwzx = wsjXwzx;
        }

        public List<String> getStr() {
            return str;
        }

        public void setStr(List<String> str) {
            this.str = str;
        }

        public static class WsjXwzxBean {
            /**
             * id : 4e1d73316a99453d9f1c14ff233a2a84
             * isNewRecord : false
             * createDate : 2018-09-29 16:06:59
             * updateDate : 2018-09-29 16:06:59
             * bt : test
             * lx : 新闻期刊
             * xwnr : <p>
             test</p>
             * fbr : 白雪
             * scfile : 动监所行政处罚结果公示2018.9.18.xls,
             * back1 : 2e94efe55bf147128dbda33424d99dc2
             * back2 : 0
             * back3 : 1
             * back4 : 信息中心
             * user : {"isNewRecord":true,"name":"朱树宏","loginFlag":"1","admin":false,"roleNames":""}
             */

            private String id;
            private boolean isNewRecord;
            private String createDate;
            private String updateDate;
            private String bt;
            private String lx;
            private String xwnr;
            private String fbr;
            private String scfile;
            private String back1;
            private String back2;
            private String back3;
            private String back4;
            private UserBean user;

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

            public String getBt() {
                return bt;
            }

            public void setBt(String bt) {
                this.bt = bt;
            }

            public String getLx() {
                return lx;
            }

            public void setLx(String lx) {
                this.lx = lx;
            }

            public String getXwnr() {
                return xwnr;
            }

            public void setXwnr(String xwnr) {
                this.xwnr = xwnr;
            }

            public String getFbr() {
                return fbr;
            }

            public void setFbr(String fbr) {
                this.fbr = fbr;
            }

            public String getScfile() {
                return scfile;
            }

            public void setScfile(String scfile) {
                this.scfile = scfile;
            }

            public String getBack1() {
                return back1;
            }

            public void setBack1(String back1) {
                this.back1 = back1;
            }

            public String getBack2() {
                return back2;
            }

            public void setBack2(String back2) {
                this.back2 = back2;
            }

            public String getBack3() {
                return back3;
            }

            public void setBack3(String back3) {
                this.back3 = back3;
            }

            public String getBack4() {
                return back4;
            }

            public void setBack4(String back4) {
                this.back4 = back4;
            }

            public UserBean getUser() {
                return user;
            }

            public void setUser(UserBean user) {
                this.user = user;
            }

            public static class UserBean {
                /**
                 * isNewRecord : true
                 * name : 朱树宏
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
