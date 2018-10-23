package project01.shoujioa.gson_tool;

import java.util.List;

public class zh_xz_tool {

    /**
     * statuscode : 200
     * message : success
     * map : {"minlader":[{"id":"42ee7081440042b5b37c6df1ce585b65","isNewRecord":false,"type":"1","jibie":"3","userid":"ca6ca4ae2178443f83dfc453877d93f2","user":{"isNewRecord":true,"name":"安学军,","loginFlag":"1","roleNames":"","admin":false}}]}
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
        private List<MinladerBean> minlader;

        public List<MinladerBean> getMinlader() {
            return minlader;
        }

        public void setMinlader(List<MinladerBean> minlader) {
            this.minlader = minlader;
        }

        public static class MinladerBean {
            /**
             * id : 42ee7081440042b5b37c6df1ce585b65
             * isNewRecord : false
             * type : 1
             * jibie : 3
             * userid : ca6ca4ae2178443f83dfc453877d93f2
             * user : {"isNewRecord":true,"name":"安学军,","loginFlag":"1","roleNames":"","admin":false}
             */

            private String id;
            private boolean isNewRecord;
            private String type;
            private String jibie;
            private String userid;
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

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getJibie() {
                return jibie;
            }

            public void setJibie(String jibie) {
                this.jibie = jibie;
            }

            public String getUserid() {
                return userid;
            }

            public void setUserid(String userid) {
                this.userid = userid;
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
                 * name : 安学军,
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
