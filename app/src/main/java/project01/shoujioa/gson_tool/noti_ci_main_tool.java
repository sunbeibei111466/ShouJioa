package project01.shoujioa.gson_tool;

public class noti_ci_main_tool {

    /**
     * statuscode : 200
     * message : success
     * map : {"str":["精准扶贫接口文档.docx","灵寿县精准扶贫动态管理档案（电子版）.xlsx","批量下载.txt"],"wsjGggl":{"id":"2072a257d1c84053b11d5364b245fa47","isNewRecord":false,"createDate":"2018-08-22 09:04:55","updateDate":"2018-08-22 09:04:55","bt":"地方咯看","lx":"值班安排","ggnr":"发广告","fbr":"系统管理员","scfile":"精准扶贫接口文档.docx,灵寿县精准扶贫动态管理档案（电子版）.xlsx,批量下载.txt,","spzt":"0","spr":"系统管理员","gsbm":"本部","back2":"1","back4":"3","fbfw":"1534899894708","user":{"isNewRecord":true,"name":"系统管理员,局办主任,张主管领导,李主管领导,钱科长,赵主管领导,张公文人员,赵科员,王公文人员,孙科长,","loginFlag":"1","admin":false,"roleNames":""}}}
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
         * str : ["精准扶贫接口文档.docx","灵寿县精准扶贫动态管理档案（电子版）.xlsx","批量下载.txt"]
         * wsjGggl : {"id":"2072a257d1c84053b11d5364b245fa47","isNewRecord":false,"createDate":"2018-08-22 09:04:55","updateDate":"2018-08-22 09:04:55","bt":"地方咯看","lx":"值班安排","ggnr":"发广告","fbr":"系统管理员","scfile":"精准扶贫接口文档.docx,灵寿县精准扶贫动态管理档案（电子版）.xlsx,批量下载.txt,","spzt":"0","spr":"系统管理员","gsbm":"本部","back2":"1","back4":"3","fbfw":"1534899894708","user":{"isNewRecord":true,"name":"系统管理员,局办主任,张主管领导,李主管领导,钱科长,赵主管领导,张公文人员,赵科员,王公文人员,孙科长,","loginFlag":"1","admin":false,"roleNames":""}}
         */

        private WsjGgglBean wsjGggl;

        public WsjGgglBean getWsjGggl() {
            return wsjGggl;
        }

        public void setWsjGggl(WsjGgglBean wsjGggl) {
            this.wsjGggl = wsjGggl;
        }


        public static class WsjGgglBean {
            /**
             * id : 2072a257d1c84053b11d5364b245fa47
             * isNewRecord : false
             * createDate : 2018-08-22 09:04:55
             * updateDate : 2018-08-22 09:04:55
             * bt : 地方咯看
             * lx : 值班安排
             * ggnr : 发广告
             * fbr : 系统管理员
             * scfile : 精准扶贫接口文档.docx,灵寿县精准扶贫动态管理档案（电子版）.xlsx,批量下载.txt,
             * spzt : 0
             * spr : 系统管理员
             * gsbm : 本部
             * back2 : 1
             * back4 : 3
             * fbfw : 1534899894708
             * user : {"isNewRecord":true,"name":"系统管理员,局办主任,张主管领导,李主管领导,钱科长,赵主管领导,张公文人员,赵科员,王公文人员,孙科长,","loginFlag":"1","admin":false,"roleNames":""}
             */

            private String id;
            private boolean isNewRecord;
            private String createDate;
            private String updateDate;
            private String bt;
            private String lx;
            private String ggnr;
            private String fbr;
            private String scfile;
            private String spzt;
            private String spr;
            private String gsbm;
            private String back2;
            private String back4;
            private String fbfw;
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

            public String getGgnr() {
                return ggnr;
            }

            public void setGgnr(String ggnr) {
                this.ggnr = ggnr;
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

            public String getSpzt() {
                return spzt;
            }

            public void setSpzt(String spzt) {
                this.spzt = spzt;
            }

            public String getSpr() {
                return spr;
            }

            public void setSpr(String spr) {
                this.spr = spr;
            }

            public String getGsbm() {
                return gsbm;
            }

            public void setGsbm(String gsbm) {
                this.gsbm = gsbm;
            }

            public String getBack2() {
                return back2;
            }

            public void setBack2(String back2) {
                this.back2 = back2;
            }

            public String getBack4() {
                return back4;
            }

            public void setBack4(String back4) {
                this.back4 = back4;
            }

            public String getFbfw() {
                return fbfw;
            }

            public void setFbfw(String fbfw) {
                this.fbfw = fbfw;
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
                 * name : 系统管理员,局办主任,张主管领导,李主管领导,钱科长,赵主管领导,张公文人员,赵科员,王公文人员,孙科长,
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
