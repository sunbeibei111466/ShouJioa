package project01.shoujioa.gson_tool;

import java.util.List;

public class File_unload_tool {

    /**
     * statuscode : 200
     * message : success
     * datas : [{"id":"3c4e515724464af398e66627327f62eb","isNewRecord":false,"headline":"灵寿县精准扶贫动态管理档案（电子版）.xlsx","name":"系统管理员","nameTime":"2018-08-10 17:19:29","user":{"id":"1533892769302","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"uploadFiles":"灵寿县精准扶贫动态管理档案（电子版）.xlsx,","caogaoxiang":"1","beizhu":""}]
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
         * id : 3c4e515724464af398e66627327f62eb
         * isNewRecord : false
         * headline : 灵寿县精准扶贫动态管理档案（电子版）.xlsx
         * name : 系统管理员
         * nameTime : 2018-08-10 17:19:29
         * user : {"id":"1533892769302","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""}
         * uploadFiles : 灵寿县精准扶贫动态管理档案（电子版）.xlsx,
         * caogaoxiang : 1
         * beizhu :
         */

        private String id;
        private boolean isNewRecord;
        private String headline;
        private String name;
        private String nameTime;
        private UserBean user;
        private String uploadFiles;
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

        public String getHeadline() {
            return headline;
        }

        public void setHeadline(String headline) {
            this.headline = headline;
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
             * id : 1533892769302
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
