package project01.shoujioa.gson_tool;

import java.util.List;

public class Filed_main_tool {


    /**
     * statuscode : 200
     * message : success
     * map : {"str":["流行性腮腺炎真麻烦.doc"],"wsjNewfile":{"id":"cec725f7a1214cfcb3556493694a3756","isNewRecord":false,"createDate":"2018-09-26 17:28:42","updateDate":"2018-09-26 17:28:42","headline":"流行性腮腺炎真麻烦.doc","chuchu":"是","name":"苑天晓","nameTime":"2018-09-26 17:28:42","user":{"id":"1537954121662","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"uploadFiles":"流行性腮腺炎真麻烦.doc,","createby":"edb8b8071baf4da8bebb396cc434befe","caogaoxiang":"1","beizhu":"ggggggg"}}
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
         * str : ["流行性腮腺炎真麻烦.doc"]
         * wsjNewfile : {"id":"cec725f7a1214cfcb3556493694a3756","isNewRecord":false,"createDate":"2018-09-26 17:28:42","updateDate":"2018-09-26 17:28:42","headline":"流行性腮腺炎真麻烦.doc","chuchu":"是","name":"苑天晓","nameTime":"2018-09-26 17:28:42","user":{"id":"1537954121662","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"uploadFiles":"流行性腮腺炎真麻烦.doc,","createby":"edb8b8071baf4da8bebb396cc434befe","caogaoxiang":"1","beizhu":"ggggggg"}
         */

        private WsjNewfileBean wsjNewfile;
        private List<String> str;

        public WsjNewfileBean getWsjNewfile() {
            return wsjNewfile;
        }

        public void setWsjNewfile(WsjNewfileBean wsjNewfile) {
            this.wsjNewfile = wsjNewfile;
        }

        public List<String> getStr() {
            return str;
        }

        public void setStr(List<String> str) {
            this.str = str;
        }

        public static class WsjNewfileBean {
            /**
             * id : cec725f7a1214cfcb3556493694a3756
             * isNewRecord : false
             * createDate : 2018-09-26 17:28:42
             * updateDate : 2018-09-26 17:28:42
             * headline : 流行性腮腺炎真麻烦.doc
             * chuchu : 是
             * name : 苑天晓
             * nameTime : 2018-09-26 17:28:42
             * user : {"id":"1537954121662","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""}
             * uploadFiles : 流行性腮腺炎真麻烦.doc,
             * createby : edb8b8071baf4da8bebb396cc434befe
             * caogaoxiang : 1
             * beizhu : ggggggg
             */

            private String id;
            private boolean isNewRecord;
            private String createDate;
            private String updateDate;
            private String headline;
            private String chuchu;
            private String name;
            private String nameTime;
            private UserBean user;
            private String uploadFiles;
            private String createby;
            private String caogaoxiang;
            private String beizhu;

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

            public String getHeadline() {
                return headline;
            }

            public void setHeadline(String headline) {
                this.headline = headline;
            }

            public String getChuchu() {
                return chuchu;
            }

            public void setChuchu(String chuchu) {
                this.chuchu = chuchu;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getNameTime() {
                return nameTime;
            }

            public void setNameTime(String nameTime) {
                this.nameTime = nameTime;
            }

            public UserBean getUser() {
                return user;
            }

            public void setUser(UserBean user) {
                this.user = user;
            }

            public String getUploadFiles() {
                return uploadFiles;
            }

            public void setUploadFiles(String uploadFiles) {
                this.uploadFiles = uploadFiles;
            }

            public String getCreateby() {
                return createby;
            }

            public void setCreateby(String createby) {
                this.createby = createby;
            }

            public String getCaogaoxiang() {
                return caogaoxiang;
            }

            public void setCaogaoxiang(String caogaoxiang) {
                this.caogaoxiang = caogaoxiang;
            }

            public String getBeizhu() {
                return beizhu;
            }

            public void setBeizhu(String beizhu) {
                this.beizhu = beizhu;
            }

            public static class UserBean {
                /**
                 * id : 1537954121662
                 * isNewRecord : false
                 * loginFlag : 1
                 * admin : false
                 * roleNames :
                 */

                private String id;
                private boolean isNewRecord;
                private String loginFlag;
                private boolean admin;
                private String roleNames;

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
