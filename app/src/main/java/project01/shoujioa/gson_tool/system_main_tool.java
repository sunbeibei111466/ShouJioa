package project01.shoujioa.gson_tool;

import java.util.List;

public class system_main_tool {

    /**
     * statuscode : 200
     * message : success
     * map : {"str":["灵寿县精准扶贫动态管理档案（电子版）.xlsx"],"wsjSystem":{"id":"2bb14c302ee94ab681d8c1c0c7a1c29f","isNewRecord":false,"createDate":"2018-09-04 15:31:36","updateDate":"2018-09-04 15:31:36","name":"系统管理员","heTitle":"几个号","creationTime":"2018-09-04 15:31:36","systemName":"灵寿县精准扶贫动态管理档案（电子版）.xlsx,","type":"干活发个","chuchu":"更好的"}}
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
         * str : ["灵寿县精准扶贫动态管理档案（电子版）.xlsx"]
         * wsjSystem : {"id":"2bb14c302ee94ab681d8c1c0c7a1c29f","isNewRecord":false,"createDate":"2018-09-04 15:31:36","updateDate":"2018-09-04 15:31:36","name":"系统管理员","heTitle":"几个号","creationTime":"2018-09-04 15:31:36","systemName":"灵寿县精准扶贫动态管理档案（电子版）.xlsx,","type":"干活发个","chuchu":"更好的"}
         */

        private WsjSystemBean wsjSystem;
        private List<String> str;

        public WsjSystemBean getWsjSystem() {
            return wsjSystem;
        }

        public void setWsjSystem(WsjSystemBean wsjSystem) {
            this.wsjSystem = wsjSystem;
        }

        public List<String> getStr() {
            return str;
        }

        public void setStr(List<String> str) {
            this.str = str;
        }

        public static class WsjSystemBean {
            /**
             * id : 2bb14c302ee94ab681d8c1c0c7a1c29f
             * isNewRecord : false
             * createDate : 2018-09-04 15:31:36
             * updateDate : 2018-09-04 15:31:36
             * name : 系统管理员
             * heTitle : 几个号
             * creationTime : 2018-09-04 15:31:36
             * systemName : 灵寿县精准扶贫动态管理档案（电子版）.xlsx,
             * type : 干活发个
             * chuchu : 更好的
             */

            private String id;
            private boolean isNewRecord;
            private String createDate;
            private String updateDate;
            private String name;
            private String heTitle;
            private String creationTime;
            private String systemName;
            private String type;
            private String chuchu;

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

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getHeTitle() {
                return heTitle;
            }

            public void setHeTitle(String heTitle) {
                this.heTitle = heTitle;
            }

            public String getCreationTime() {
                return creationTime;
            }

            public void setCreationTime(String creationTime) {
                this.creationTime = creationTime;
            }

            public String getSystemName() {
                return systemName;
            }

            public void setSystemName(String systemName) {
                this.systemName = systemName;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getChuchu() {
                return chuchu;
            }

            public void setChuchu(String chuchu) {
                this.chuchu = chuchu;
            }
        }
    }
}
