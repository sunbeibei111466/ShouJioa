package project01.shoujioa.gson_tool;

public class tool_login_sign_in {

    /**
     * statuscode : 200
     * message : success
     * user : {"id":"0bb7ca2188ed4ea88518c8fab89debc3","isNewRecord":false,"remarks":"","createDate":"2018-07-31 15:45:29","updateDate":"2018-07-31 15:45:29","companyName":"西城区卫计委","officeName":"委领导","loginName":"songqing","no":"0007","name":"宋青","email":"","phone":"58360833","mobile":"13910965125","userType":"","loginIp":"0:0:0:0:0:0:0:1","loginDate":"2018-08-15 14:27:20","loginFlag":"1","photo":"","oldLoginIp":"0:0:0:0:0:0:0:1","oldLoginDate":"2018-08-15 14:27:20","admin":false,"roleNames":"主管领导权限,局办主任"}
     */

    private String statuscode;
    private String message;
    private UserBean user;

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

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public static class UserBean {
        /**
         * id : 0bb7ca2188ed4ea88518c8fab89debc3
         * isNewRecord : false
         * remarks :
         * createDate : 2018-07-31 15:45:29
         * updateDate : 2018-07-31 15:45:29
         * companyName : 西城区卫计委
         * officeName : 委领导
         * loginName : songqing
         * no : 0007
         * name : 宋青
         * email :
         * phone : 58360833
         * mobile : 13910965125
         * userType :
         * loginIp : 0:0:0:0:0:0:0:1
         * loginDate : 2018-08-15 14:27:20
         * loginFlag : 1
         * photo :
         * oldLoginIp : 0:0:0:0:0:0:0:1
         * oldLoginDate : 2018-08-15 14:27:20
         * admin : false
         * roleNames : 主管领导权限,局办主任
         */

        private String id;
        private boolean isNewRecord;
        private String remarks;
        private String createDate;
        private String updateDate;
        private String companyName;
        private String officeName;
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

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public String getOfficeName() {
            return officeName;
        }

        public void setOfficeName(String officeName) {
            this.officeName = officeName;
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
