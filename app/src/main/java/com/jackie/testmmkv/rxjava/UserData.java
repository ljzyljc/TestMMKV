package com.jackie.testmmkv.rxjava;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Jackie on 2018/8/28.
 */
public class UserData extends BaseData {


    /**
     * succ : true
     * statusCode : 200
     * msg : null
     * data : [{"id":10607,"channelId":0,"title":"车的好管家，您的好帮手","author":"","pubDept":"0","imgUrl":"http://gaapi.jl.gov.cn:80/econsole/upload/news/e0a8cbfac9ff2f0a54640f3002d6b161.jpg","summary":"","content":"","pubTime":null,"createTime":1535444692036,"orginalUrl":"","imgNews":1,"topNews":0,"pubStr":""},{"id":10567,"channelId":0,"title":"吉林公安互联网公众号开通啦！","author":"","pubDept":"0","imgUrl":"http://gaapi.jl.gov.cn:80/econsole/upload/news/7b43cb09e57c3e7ad1a6b2aa9b467f47.jpg","summary":"","content":"","pubTime":null,"createTime":1535444692036,"orginalUrl":"","imgNews":1,"topNews":0,"pubStr":""},{"id":10527,"channelId":0,"title":"感谢你，含辛茹苦的警嫂 \u2014\u2014胡家福同志致全省警嫂的一封信","author":"","pubDept":"0","imgUrl":"http://gaapi.jl.gov.cn:80/econsole/upload/news/246c1202a9466b8cce696cb113b3f064.jpg","summary":"","content":"","pubTime":null,"createTime":1535444692036,"orginalUrl":"","imgNews":1,"topNews":0,"pubStr":""}]
     * time : 1535444692037
     * desc : null
     * hasNext : false
     */

    private boolean succ;
    private int statusCode;
    @SerializedName("msg")
    private Object msgX;
    private long time;
    private Object desc;
    private boolean hasNext;
    private List<DataBean> data;

    public boolean isSucc() {
        return succ;
    }

    public void setSucc(boolean succ) {
        this.succ = succ;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public Object getMsgX() {
        return msgX;
    }

    public void setMsgX(Object msgX) {
        this.msgX = msgX;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public Object getDesc() {
        return desc;
    }

    public void setDesc(Object desc) {
        this.desc = desc;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 10607
         * channelId : 0
         * title : 车的好管家，您的好帮手
         * author :
         * pubDept : 0
         * imgUrl : http://gaapi.jl.gov.cn:80/econsole/upload/news/e0a8cbfac9ff2f0a54640f3002d6b161.jpg
         * summary :
         * content :
         * pubTime : null
         * createTime : 1535444692036
         * orginalUrl :
         * imgNews : 1
         * topNews : 0
         * pubStr :
         */

        private int id;
        private int channelId;
        private String title;
        private String author;
        private String pubDept;
        private String imgUrl;
        private String summary;
        private String content;
        private Object pubTime;
        private long createTime;
        private String orginalUrl;
        private int imgNews;
        private int topNews;
        private String pubStr;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getChannelId() {
            return channelId;
        }

        public void setChannelId(int channelId) {
            this.channelId = channelId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getPubDept() {
            return pubDept;
        }

        public void setPubDept(String pubDept) {
            this.pubDept = pubDept;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public Object getPubTime() {
            return pubTime;
        }

        public void setPubTime(Object pubTime) {
            this.pubTime = pubTime;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public String getOrginalUrl() {
            return orginalUrl;
        }

        public void setOrginalUrl(String orginalUrl) {
            this.orginalUrl = orginalUrl;
        }

        public int getImgNews() {
            return imgNews;
        }

        public void setImgNews(int imgNews) {
            this.imgNews = imgNews;
        }

        public int getTopNews() {
            return topNews;
        }

        public void setTopNews(int topNews) {
            this.topNews = topNews;
        }

        public String getPubStr() {
            return pubStr;
        }

        public void setPubStr(String pubStr) {
            this.pubStr = pubStr;
        }
    }
}
