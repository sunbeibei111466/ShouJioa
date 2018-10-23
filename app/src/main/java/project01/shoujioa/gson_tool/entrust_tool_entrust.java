package project01.shoujioa.gson_tool;

public class entrust_tool_entrust {

    /**
     * statuscode : 200
     * message : success
     * map : {"wsjWtsq":{"id":"2316da93898b4021ad682ae03acdfb0c","isNewRecord":false,"createDate":"2018-09-06 10:46:31","updateDate":"2018-09-06 10:46:31","wtrId":"1","strId":"5","user":{"isNewRecord":true,"name":"系统管理员","loginFlag":"1","roleNames":"","admin":false},"user1":{"isNewRecord":true,"name":"孙科长","loginFlag":"1","roleNames":"","admin":false},"qishisj":"2018-09-06 00:00:00","jieshusj":"2018-09-06 00:00:00"}}
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
         * wsjWtsq : {"id":"2316da93898b4021ad682ae03acdfb0c","isNewRecord":false,"createDate":"2018-09-06 10:46:31","updateDate":"2018-09-06 10:46:31","wtrId":"1","strId":"5","user":{"isNewRecord":true,"name":"系统管理员","loginFlag":"1","roleNames":"","admin":false},"user1":{"isNewRecord":true,"name":"孙科长","loginFlag":"1","roleNames":"","admin":false},"qishisj":"2018-09-06 00:00:00","jieshusj":"2018-09-06 00:00:00"}
         */

        private WsjWtsqBean wsjWtsq;

        public WsjWtsqBean getWsjWtsq() {
            return wsjWtsq;
        }

        public void setWsjWtsq(WsjWtsqBean wsjWtsq) {
            this.wsjWtsq = wsjWtsq;
        }

        public static class WsjWtsqBean {
            /**
             * id : 2316da93898b4021ad682ae03acdfb0c
             * isNewRecord : false
             * createDate : 2018-09-06 10:46:31
             * updateDate : 2018-09-06 10:46:31
             * wtrId : 1
             * strId : 5
             * user : {"isNewRecord":true,"name":"系统管理员","loginFlag":"1","roleNames":"","admin":false}
             * user1 : {"isNewRecord":true,"name":"孙科长","loginFlag":"1","roleNames":"","admin":false}
             * qishisj : 2018-09-06 00:00:00
             * jieshusj : 2018-09-06 00:00:00
             */

            private String id;
            private boolean isNewRecord;
            private String createDate;
            private String updateDate;
            private String wtrId;
            private String strId;
            private UserBean user;
            private User1Bean user1;
            private String qishisj;
            private String jieshusj;

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

            public String getWtrId() {
                return wtrId;
            }

            public void setWtrId(String wtrId) {
                this.wtrId = wtrId;
            }

            public String getStrId() {
                return strId;
            }

            public void setStrId(String strId) {
                this.strId = strId;
            }

            public UserBean getUser() {
                return user;
            }

            public void setUser(UserBean user) {
                this.user = user;
            }

            public User1Bean getUser1() {
                return user1;
            }

            public void setUser1(User1Bean user1) {
                this.user1 = user1;
            }

            public String getQishisj() {
                return qishisj;
            }

            public void setQishisj(String qishisj) {
                this.qishisj = qishisj;
            }

            public String getJieshusj() {
                return jieshusj;
            }

            public void setJieshusj(String jieshusj) {
                this.jieshusj = jieshusj;
            }

            public static class UserBean {
                /**
                 * isNewRecord : true
                 * name : 系统管理员
                 * loginFlag : 1
                 * roleNames :
                 * admin : false
                 */

                private boolean isNewRecord;
                private String name;
                private String loginFlag;
                private String roleNames;
                private boolean admin;

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

                public String getRoleNames() {
                    return roleNames;
                }

                public void setRoleNames(String roleNames) {
                    this.roleNames = roleNames;
                }

                public boolean isAdmin() {
                    return admin;
                }

                public void setAdmin(boolean admin) {
                    this.admin = admin;
                }
            }

            public static class User1Bean {
                /**
                 * isNewRecord : true
                 * name : 孙科长
                 * loginFlag : 1
                 * roleNames :
                 * admin : false
                 */

                private boolean isNewRecord;
                private String name;
                private String loginFlag;
                private String roleNames;
                private boolean admin;

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

                public String getRoleNames() {
                    return roleNames;
                }

                public void setRoleNames(String roleNames) {
                    this.roleNames = roleNames;
                }

                public boolean isAdmin() {
                    return admin;
                }

                public void setAdmin(boolean admin) {
                    this.admin = admin;
                }
            }
        }
    }
}
