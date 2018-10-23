package project01.shoujioa.gson_tool;

public class YL_tool {

    /**
     * statuscode : 200
     * message : success
     * map : {"ctxPath":"uploadfile/gongwen/北京市西城区卫生局网站监测报告.docx"}
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
         * ctxPath : uploadfile/gongwen/北京市西城区卫生局网站监测报告.docx
         */

        private String ctxPath;

        public String getCtxPath() {
            return ctxPath;
        }

        public void setCtxPath(String ctxPath) {
            this.ctxPath = ctxPath;
        }
    }
}
