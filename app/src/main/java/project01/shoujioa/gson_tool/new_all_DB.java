package project01.shoujioa.gson_tool;

import java.util.List;

public class new_all_DB {

    /**
     * statuscode : 200
     * message : success
     * map : {"wsjdb":[{"id":"9a66fc9ddd5740bd8fca5809b6005ab7","isNewRecord":false,"name":"是否打算的","type":"是的发送到","time":"2018-09-28","flag":"4"},{"id":"755f54ccfe8147ffb2407f17f0217a91","isNewRecord":false,"name":"发撒打发","type":"发士大夫撒","time":"2018-09-28","flag":"5"},{"id":"ff75b1132d884dc4ab873fde48c0a171","isNewRecord":false,"name":"闪电法师","type":"所得税法撒旦","time":"2018-09-25","flag":"5"},{"id":"ae61db09ae1a45e197756cf0c2ee7221","isNewRecord":false,"name":"第三方度过是否跟得上的","type":"新闻期刊","time":"2018-09-28","flag":"3"},{"id":"c0f477a8e4744030b6de9d55047973f8","isNewRecord":false,"name":"吧阿达撒发撒的","time":"2018-09-28","flag":"1","jinji":"急","cuiban":"0"}]}
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
        private List<WsjdbBean> wsjdb;

        public List<WsjdbBean> getWsjdb() {
            return wsjdb;
        }

        public void setWsjdb(List<WsjdbBean> wsjdb) {
            this.wsjdb = wsjdb;
        }

        public static class WsjdbBean {
            /**
             * id : 9a66fc9ddd5740bd8fca5809b6005ab7
             * isNewRecord : false
             * name : 是否打算的
             * type : 是的发送到
             * time : 2018-09-28
             * flag : 4
             * jinji : 急
             * cuiban : 0
             */

            private String id;
            private boolean isNewRecord;
            private String name;
            private String type;
            private String time;
            private String flag;
            private String jinji;
            private String cuiban;

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

            public String getJinji() {
                return jinji;
            }

            public void setJinji(String jinji) {
                this.jinji = jinji;
            }

            public String getCuiban() {
                return cuiban;
            }

            public void setCuiban(String cuiban) {
                this.cuiban = cuiban;
            }
        }
    }
}
