package project01.shoujioa.gson_tool;

import java.util.List;

public class xinfang_tool {

    /**
     * statuscode : 200
     * message : success
     * map : {"wsjXfDb":[{"id":"ff75b1132d884dc4ab873fde48c0a171","isNewRecord":false,"name":"闪电法师","type":"所得税法撒旦","time":"2018-09-25","flag":"2"}]}
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
        private List<WsjXfDbBean> wsjXfDb;

        public List<WsjXfDbBean> getWsjXfDb() {
            return wsjXfDb;
        }

        public void setWsjXfDb(List<WsjXfDbBean> wsjXfDb) {
            this.wsjXfDb = wsjXfDb;
        }

        public static class WsjXfDbBean {
            /**
             * id : ff75b1132d884dc4ab873fde48c0a171
             * isNewRecord : false
             * name : 闪电法师
             * type : 所得税法撒旦
             * time : 2018-09-25
             * flag : 2
             */

            private String id;
            private boolean isNewRecord;
            private String name;
            private String type;
            private String time;
            private String flag;

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

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public String getFlag() {
                return flag;
            }

            public void setFlag(String flag) {
                this.flag = flag;
            }
        }
    }
}
