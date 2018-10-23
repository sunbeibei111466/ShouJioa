package project01.shoujioa.gson_tool;

import java.util.List;

public class tong_tool {

    /**
     * statuscode : 200
     * message : success
     * datas : [{"id":"edb8b8071baf4da8bebb396cc434befe","isNewRecord":false,"remarks":"","createDate":"2018-07-31 15:53:20","updateDate":"2018-09-18 13:25:41","loginName":"yuantx","no":"54543","name":"苑天晓","email":"","phone":"","mobile":"18813022823","userType":"","loginIp":"0:0:0:0:0:0:0:1","loginDate":"2018-09-27 17:27:30","loginFlag":"1","photo":"/Weishengju/userfiles/edb8b8071baf4da8bebb396cc434befe/images/photo/2018/09/beijing1.jpg","oldLoginIp":"0:0:0:0:0:0:0:1","oldLoginDate":"2018-09-27 17:27:30","admin":false,"roleNames":""}]
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
         * id : edb8b8071baf4da8bebb396cc434befe
         * isNewRecord : false
         * remarks :
         * createDate : 2018-07-31 15:53:20
         * updateDate : 2018-09-18 13:25:41
         * loginName : yuantx
         * no : 54543
         * name : 苑天晓
         * email :
         * phone :
         * mobile : 18813022823
         * userType :
         * loginIp : 0:0:0:0:0:0:0:1
         * loginDate : 2018-09-27 17:27:30
         * loginFlag : 1
         * photo : /Weishengju/userfiles/edb8b8071baf4da8bebb396cc434befe/images/photo/2018/09/beijing1.jpg
         * oldLoginIp : 0:0:0:0:0:0:0:1
         * oldLoginDate : 2018-09-27 17:27:30
         * admin : false
         * roleNames :
         */

        private String id;
        private boolean isNewRecord;
        private String remarks;
        private String createDate;
        private String updateDate;
        private String loginName;
        private String no;
        private String name;
        private String email;
        private String phone;
        private String mobile;
        private String userType;
        private String loginIp;
        private String loginDate;
        private String loginFlag;
        private String photo;
        private String oldLoginIp;
        private String oldLoginDate;
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

        public String getLoginName() {
            return loginName;
        }

        public void setLoginName(String loginName) {
            this.loginName = loginName;
        }

        public String getNo() {
            return no;
        }

        public void setNo(String no) {
            this.no = no;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getUserType() {
            return userType;
        }

        public void setUserType(String userType) {
            this.userType = userType;
        }

        public String getLoginIp() {
            return loginIp;
        }

        public void setLoginIp(String loginIp) {
            this.loginIp = loginIp;
        }

        public String getLoginDate() {
            return loginDate;
        }

        public void setLoginDate(String loginDate) {
            this.loginDate = loginDate;
        }

        public String getLoginFlag() {
            return loginFlag;
        }

        public void setLoginFlag(String loginFlag) {
            this.loginFlag = loginFlag;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public String getOldLoginIp() {
            return oldLoginIp;
        }

        public void setOldLoginIp(String oldLoginIp) {
            this.oldLoginIp = oldLoginIp;
        }

        public String getOldLoginDate() {
            return oldLoginDate;
        }

        public void setOldLoginDate(String oldLoginDate) {
            this.oldLoginDate = oldLoginDate;
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
