package project01.shoujioa.gson_tool;

import java.util.List;

public class Office_mian_Tool {

    /**
     * statuscode : 200
     * message : success
     * map : {"str":["灵寿县精准扶贫动态管理档案（电子版）.xlsx","批量下载.txt"],"wsjYtap":{"id":"bf06868ed0aa49099fe798b4ce0914e0","isNewRecord":false,"createDate":"2018-08-20 18:48:15","updateDate":"2018-08-20 18:48:15","nian":"2018","ci":"6","yt":"1534762095087","chry":"1534762095087","scfile":"灵寿县精准扶贫动态管理档案（电子版）.xlsx,批量下载.txt,","user":{"isNewRecord":true,"name":"孙科长,钱科长,张主管领导,赵科员,李主管领导,王公文人员,李主管领导,张公文人员,赵科员,系统管理员,王公文人员,赵主管领导,张公文人员,赵主管领导,王公文人员,系统管理员,局办主任,赵主管领导,局办主任,赵科员,局办主任,系统管理员,局办主任,王公文人员,王公文人员,孙科长,孙科长,赵主管领导,孙科长,赵科员,张公文人员,张主管领导,李主管领导,系统管理员,王公文人员,孙科长,钱科长,钱科长,李主管领导,系统管理员,赵主管领导,张主管领导,李主管领导,钱科长,李主管领导,张公文人员,局办主任,张主管领导,张公文人员,张公文人员,钱科长,系统管理员,赵科员,局办主任,张主管领导,王公文人员,系统管理员,钱科长,赵科员,张主管领导,赵主管领导,张主管领导,赵主管领导,孙科长,钱科长,赵科员,李主管领导,局办主任,张公文人员,孙科长,","loginFlag":"1","admin":false,"roleNames":""},"ytapList":[{"id":"827fde145866410883f3cd8de4264cfc","isNewRecord":false,"yt":"6723673f87d14c1ab5ab0d4093d96ac1","hbr":"6c723f688cde4a418f9b123477b2e885","clbh":"1","ids":"1534762095087"}]}}
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
         * str : ["灵寿县精准扶贫动态管理档案（电子版）.xlsx","批量下载.txt"]
         * wsjYtap : {"id":"bf06868ed0aa49099fe798b4ce0914e0","isNewRecord":false,"createDate":"2018-08-20 18:48:15","updateDate":"2018-08-20 18:48:15","nian":"2018","ci":"6","yt":"1534762095087","chry":"1534762095087","scfile":"灵寿县精准扶贫动态管理档案（电子版）.xlsx,批量下载.txt,","user":{"isNewRecord":true,"name":"孙科长,钱科长,张主管领导,赵科员,李主管领导,王公文人员,李主管领导,张公文人员,赵科员,系统管理员,王公文人员,赵主管领导,张公文人员,赵主管领导,王公文人员,系统管理员,局办主任,赵主管领导,局办主任,赵科员,局办主任,系统管理员,局办主任,王公文人员,王公文人员,孙科长,孙科长,赵主管领导,孙科长,赵科员,张公文人员,张主管领导,李主管领导,系统管理员,王公文人员,孙科长,钱科长,钱科长,李主管领导,系统管理员,赵主管领导,张主管领导,李主管领导,钱科长,李主管领导,张公文人员,局办主任,张主管领导,张公文人员,张公文人员,钱科长,系统管理员,赵科员,局办主任,张主管领导,王公文人员,系统管理员,钱科长,赵科员,张主管领导,赵主管领导,张主管领导,赵主管领导,孙科长,钱科长,赵科员,李主管领导,局办主任,张公文人员,孙科长,","loginFlag":"1","admin":false,"roleNames":""},"ytapList":[{"id":"827fde145866410883f3cd8de4264cfc","isNewRecord":false,"yt":"6723673f87d14c1ab5ab0d4093d96ac1","hbr":"6c723f688cde4a418f9b123477b2e885","clbh":"1","ids":"1534762095087"}]}
         */

        private WsjYtapBean wsjYtap;


        public WsjYtapBean getWsjYtap() {
            return wsjYtap;
        }

        public void setWsjYtap(WsjYtapBean wsjYtap) {
            this.wsjYtap = wsjYtap;
        }


        public static class WsjYtapBean {
            /**
             * id : bf06868ed0aa49099fe798b4ce0914e0
             * isNewRecord : false
             * createDate : 2018-08-20 18:48:15
             * updateDate : 2018-08-20 18:48:15
             * nian : 2018
             * ci : 6
             * yt : 1534762095087
             * chry : 1534762095087
             * scfile : 灵寿县精准扶贫动态管理档案（电子版）.xlsx,批量下载.txt,
             * user : {"isNewRecord":true,"name":"孙科长,钱科长,张主管领导,赵科员,李主管领导,王公文人员,李主管领导,张公文人员,赵科员,系统管理员,王公文人员,赵主管领导,张公文人员,赵主管领导,王公文人员,系统管理员,局办主任,赵主管领导,局办主任,赵科员,局办主任,系统管理员,局办主任,王公文人员,王公文人员,孙科长,孙科长,赵主管领导,孙科长,赵科员,张公文人员,张主管领导,李主管领导,系统管理员,王公文人员,孙科长,钱科长,钱科长,李主管领导,系统管理员,赵主管领导,张主管领导,李主管领导,钱科长,李主管领导,张公文人员,局办主任,张主管领导,张公文人员,张公文人员,钱科长,系统管理员,赵科员,局办主任,张主管领导,王公文人员,系统管理员,钱科长,赵科员,张主管领导,赵主管领导,张主管领导,赵主管领导,孙科长,钱科长,赵科员,李主管领导,局办主任,张公文人员,孙科长,","loginFlag":"1","admin":false,"roleNames":""}
             * ytapList : [{"id":"827fde145866410883f3cd8de4264cfc","isNewRecord":false,"yt":"6723673f87d14c1ab5ab0d4093d96ac1","hbr":"6c723f688cde4a418f9b123477b2e885","clbh":"1","ids":"1534762095087"}]
             */

            private String id;
            private boolean isNewRecord;
            private String createDate;
            private String updateDate;
            private String nian;
            private String ci;
            private String yt;
            private String chry;
            private String scfile;
            private UserBean user;
            private List<YtapListBean> ytapList;

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

            public String getNian() {
                return nian;
            }

            public void setNian(String nian) {
                this.nian = nian;
            }

            public String getCi() {
                return ci;
            }

            public void setCi(String ci) {
                this.ci = ci;
            }

            public String getYt() {
                return yt;
            }

            public void setYt(String yt) {
                this.yt = yt;
            }

            public String getChry() {
                return chry;
            }

            public void setChry(String chry) {
                this.chry = chry;
            }

            public String getScfile() {
                return scfile;
            }

            public void setScfile(String scfile) {
                this.scfile = scfile;
            }

            public UserBean getUser() {
                return user;
            }

            public void setUser(UserBean user) {
                this.user = user;
            }

            public List<YtapListBean> getYtapList() {
                return ytapList;
            }

            public void setYtapList(List<YtapListBean> ytapList) {
                this.ytapList = ytapList;
            }

            public static class UserBean {
                /**
                 * isNewRecord : true
                 * name : 孙科长,钱科长,张主管领导,赵科员,李主管领导,王公文人员,李主管领导,张公文人员,赵科员,系统管理员,王公文人员,赵主管领导,张公文人员,赵主管领导,王公文人员,系统管理员,局办主任,赵主管领导,局办主任,赵科员,局办主任,系统管理员,局办主任,王公文人员,王公文人员,孙科长,孙科长,赵主管领导,孙科长,赵科员,张公文人员,张主管领导,李主管领导,系统管理员,王公文人员,孙科长,钱科长,钱科长,李主管领导,系统管理员,赵主管领导,张主管领导,李主管领导,钱科长,李主管领导,张公文人员,局办主任,张主管领导,张公文人员,张公文人员,钱科长,系统管理员,赵科员,局办主任,张主管领导,王公文人员,系统管理员,钱科长,赵科员,张主管领导,赵主管领导,张主管领导,赵主管领导,孙科长,钱科长,赵科员,李主管领导,局办主任,张公文人员,孙科长,
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

            public static class YtapListBean {
                /**
                 * id : 827fde145866410883f3cd8de4264cfc
                 * isNewRecord : false
                 * yt : 6723673f87d14c1ab5ab0d4093d96ac1
                 * hbr : 6c723f688cde4a418f9b123477b2e885
                 * clbh : 1
                 * ids : 1534762095087
                 */

                private String id;
                private boolean isNewRecord;
                private String yt;
                private String hbr;
                private String clbh;
                private String ids;

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

                public String getYt() {
                    return yt;
                }

                public void setYt(String yt) {
                    this.yt = yt;
                }

                public String getHbr() {
                    return hbr;
                }

                public void setHbr(String hbr) {
                    this.hbr = hbr;
                }

                public String getClbh() {
                    return clbh;
                }

                public void setClbh(String clbh) {
                    this.clbh = clbh;
                }

                public String getIds() {
                    return ids;
                }

                public void setIds(String ids) {
                    this.ids = ids;
                }
            }
        }
    }
}
