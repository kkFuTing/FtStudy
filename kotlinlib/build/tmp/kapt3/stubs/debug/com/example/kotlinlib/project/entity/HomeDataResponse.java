package com.example.kotlinlib.project.entity;

/**
 * 首页的数据实体Bean
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0004\u0018\u0019\u001a\u001bB\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Lcom/example/kotlinlib/project/entity/HomeDataResponse;", "", "()V", "data", "Lcom/example/kotlinlib/project/entity/HomeDataResponse$DataBean;", "getData", "()Lcom/example/kotlinlib/project/entity/HomeDataResponse$DataBean;", "setData", "(Lcom/example/kotlinlib/project/entity/HomeDataResponse$DataBean;)V", "errcode", "", "getErrcode", "()I", "setErrcode", "(I)V", "errdialog", "getErrdialog", "setErrdialog", "errmsg", "", "getErrmsg", "()Ljava/lang/String;", "setErrmsg", "(Ljava/lang/String;)V", "AdListBean", "CompanyListBean", "DataBean", "NewsListBean", "kotlinlib_debug"})
public final class HomeDataResponse {
    public com.example.kotlinlib.project.entity.HomeDataResponse.DataBean data;
    
    /**
     * data : {"ad_list":[{"image":"http://resource.ffu365.com/upload/images/default/2016-06-04/57529302a2f602.54526763.jpg","link":"http://m.ffu365.com/static/bas/1.html"}],"company_list":[{"image":"http://resource.ffu365.com/upload/images/default/2016-06-02/574fd1fb4b91d8.93153953.jpg","link":"http://app.ffu365.com/pages/company.html"}],"news_list":[{"title":"天天防腐APP产品定位及功能介绍","create_time":"2016-05-01","link":"http://m.ffu365.com/static/News/news.html?id=10"},{"title":"全球腐蚀调研项目结果公布","create_time":"2016-03-23","link":"http://m.ffu365.com/static/News/news.html?id=11"},{"title":"天天防腐APP上线啦！！！","create_time":"2015-09-05","link":"http://m.ffu365.com/static/News/news.html?id=12"},{"title":"天天防腐APP开始内测","create_time":"2015-05-08","link":"http://m.ffu365.com/static/News/news.html?id=13"},{"title":"天天防腐团队组建","create_time":"2014-07-20","link":"http://m.ffu365.com/static/News/news.html?id=14"}]}
     * errcode : 1
     * errmsg : 操作成功
     * errdialog : 0
     */
    private int errcode = 0;
    public java.lang.String errmsg;
    private int errdialog = 0;
    
    public HomeDataResponse() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.kotlinlib.project.entity.HomeDataResponse.DataBean getData() {
        return null;
    }
    
    public final void setData(@org.jetbrains.annotations.NotNull
    com.example.kotlinlib.project.entity.HomeDataResponse.DataBean p0) {
    }
    
    /**
     * data : {"ad_list":[{"image":"http://resource.ffu365.com/upload/images/default/2016-06-04/57529302a2f602.54526763.jpg","link":"http://m.ffu365.com/static/bas/1.html"}],"company_list":[{"image":"http://resource.ffu365.com/upload/images/default/2016-06-02/574fd1fb4b91d8.93153953.jpg","link":"http://app.ffu365.com/pages/company.html"}],"news_list":[{"title":"天天防腐APP产品定位及功能介绍","create_time":"2016-05-01","link":"http://m.ffu365.com/static/News/news.html?id=10"},{"title":"全球腐蚀调研项目结果公布","create_time":"2016-03-23","link":"http://m.ffu365.com/static/News/news.html?id=11"},{"title":"天天防腐APP上线啦！！！","create_time":"2015-09-05","link":"http://m.ffu365.com/static/News/news.html?id=12"},{"title":"天天防腐APP开始内测","create_time":"2015-05-08","link":"http://m.ffu365.com/static/News/news.html?id=13"},{"title":"天天防腐团队组建","create_time":"2014-07-20","link":"http://m.ffu365.com/static/News/news.html?id=14"}]}
     * errcode : 1
     * errmsg : 操作成功
     * errdialog : 0
     */
    public final int getErrcode() {
        return 0;
    }
    
    /**
     * data : {"ad_list":[{"image":"http://resource.ffu365.com/upload/images/default/2016-06-04/57529302a2f602.54526763.jpg","link":"http://m.ffu365.com/static/bas/1.html"}],"company_list":[{"image":"http://resource.ffu365.com/upload/images/default/2016-06-02/574fd1fb4b91d8.93153953.jpg","link":"http://app.ffu365.com/pages/company.html"}],"news_list":[{"title":"天天防腐APP产品定位及功能介绍","create_time":"2016-05-01","link":"http://m.ffu365.com/static/News/news.html?id=10"},{"title":"全球腐蚀调研项目结果公布","create_time":"2016-03-23","link":"http://m.ffu365.com/static/News/news.html?id=11"},{"title":"天天防腐APP上线啦！！！","create_time":"2015-09-05","link":"http://m.ffu365.com/static/News/news.html?id=12"},{"title":"天天防腐APP开始内测","create_time":"2015-05-08","link":"http://m.ffu365.com/static/News/news.html?id=13"},{"title":"天天防腐团队组建","create_time":"2014-07-20","link":"http://m.ffu365.com/static/News/news.html?id=14"}]}
     * errcode : 1
     * errmsg : 操作成功
     * errdialog : 0
     */
    public final void setErrcode(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getErrmsg() {
        return null;
    }
    
    public final void setErrmsg(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    public final int getErrdialog() {
        return 0;
    }
    
    public final void setErrdialog(int p0) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/example/kotlinlib/project/entity/HomeDataResponse$AdListBean;", "", "image", "", "link", "(Ljava/lang/String;Ljava/lang/String;)V", "getImage", "()Ljava/lang/String;", "getLink", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "kotlinlib_debug"})
    public static final class AdListBean {
        @org.jetbrains.annotations.NotNull
        private final java.lang.String image = null;
        @org.jetbrains.annotations.NotNull
        private final java.lang.String link = null;
        
        public AdListBean(@org.jetbrains.annotations.NotNull
        java.lang.String image, @org.jetbrains.annotations.NotNull
        java.lang.String link) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getImage() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getLink() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.example.kotlinlib.project.entity.HomeDataResponse.AdListBean copy(@org.jetbrains.annotations.NotNull
        java.lang.String image, @org.jetbrains.annotations.NotNull
        java.lang.String link) {
            return null;
        }
        
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/example/kotlinlib/project/entity/HomeDataResponse$CompanyListBean;", "", "image", "", "link", "(Ljava/lang/String;Ljava/lang/String;)V", "getImage", "()Ljava/lang/String;", "getLink", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "kotlinlib_debug"})
    public static final class CompanyListBean {
        @org.jetbrains.annotations.NotNull
        private final java.lang.String image = null;
        @org.jetbrains.annotations.NotNull
        private final java.lang.String link = null;
        
        public CompanyListBean(@org.jetbrains.annotations.NotNull
        java.lang.String image, @org.jetbrains.annotations.NotNull
        java.lang.String link) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getImage() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getLink() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.example.kotlinlib.project.entity.HomeDataResponse.CompanyListBean copy(@org.jetbrains.annotations.NotNull
        java.lang.String image, @org.jetbrains.annotations.NotNull
        java.lang.String link) {
            return null;
        }
        
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u00a2\u0006\u0002\u0010\tJ\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H\u00c6\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0003H\u00c6\u0003J9\u0010\u0011\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003H\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0016H\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0018H\u00d6\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b\u00a8\u0006\u0019"}, d2 = {"Lcom/example/kotlinlib/project/entity/HomeDataResponse$DataBean;", "", "ad_list", "", "Lcom/example/kotlinlib/project/entity/HomeDataResponse$AdListBean;", "company_list", "Lcom/example/kotlinlib/project/entity/HomeDataResponse$CompanyListBean;", "news_list", "Lcom/example/kotlinlib/project/entity/HomeDataResponse$NewsListBean;", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getAd_list", "()Ljava/util/List;", "getCompany_list", "getNews_list", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "kotlinlib_debug"})
    public static final class DataBean {
        
        /**
         * image : http://resource.ffu365.com/upload/images/default/2016-06-04/57529302a2f602.54526763.jpg
         * link : http://m.ffu365.com/static/bas/1.html
         */
        @org.jetbrains.annotations.NotNull
        private final java.util.List<com.example.kotlinlib.project.entity.HomeDataResponse.AdListBean> ad_list = null;
        
        /**
         * image : http://resource.ffu365.com/upload/images/default/2016-06-02/574fd1fb4b91d8.93153953.jpg
         * link : http://app.ffu365.com/pages/company.html
         */
        @org.jetbrains.annotations.NotNull
        private final java.util.List<com.example.kotlinlib.project.entity.HomeDataResponse.CompanyListBean> company_list = null;
        
        /**
         * title : APP产品定位及功能介绍
         * create_time : 2016-05-01
         * link : http://m.ffu365.com/static/News/news.html?id=10
         */
        @org.jetbrains.annotations.NotNull
        private final java.util.List<com.example.kotlinlib.project.entity.HomeDataResponse.NewsListBean> news_list = null;
        
        public DataBean(@org.jetbrains.annotations.NotNull
        java.util.List<com.example.kotlinlib.project.entity.HomeDataResponse.AdListBean> ad_list, @org.jetbrains.annotations.NotNull
        java.util.List<com.example.kotlinlib.project.entity.HomeDataResponse.CompanyListBean> company_list, @org.jetbrains.annotations.NotNull
        java.util.List<com.example.kotlinlib.project.entity.HomeDataResponse.NewsListBean> news_list) {
            super();
        }
        
        /**
         * image : http://resource.ffu365.com/upload/images/default/2016-06-04/57529302a2f602.54526763.jpg
         * link : http://m.ffu365.com/static/bas/1.html
         */
        @org.jetbrains.annotations.NotNull
        public final java.util.List<com.example.kotlinlib.project.entity.HomeDataResponse.AdListBean> getAd_list() {
            return null;
        }
        
        /**
         * image : http://resource.ffu365.com/upload/images/default/2016-06-02/574fd1fb4b91d8.93153953.jpg
         * link : http://app.ffu365.com/pages/company.html
         */
        @org.jetbrains.annotations.NotNull
        public final java.util.List<com.example.kotlinlib.project.entity.HomeDataResponse.CompanyListBean> getCompany_list() {
            return null;
        }
        
        /**
         * title : APP产品定位及功能介绍
         * create_time : 2016-05-01
         * link : http://m.ffu365.com/static/News/news.html?id=10
         */
        @org.jetbrains.annotations.NotNull
        public final java.util.List<com.example.kotlinlib.project.entity.HomeDataResponse.NewsListBean> getNews_list() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.List<com.example.kotlinlib.project.entity.HomeDataResponse.AdListBean> component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.List<com.example.kotlinlib.project.entity.HomeDataResponse.CompanyListBean> component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.List<com.example.kotlinlib.project.entity.HomeDataResponse.NewsListBean> component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.example.kotlinlib.project.entity.HomeDataResponse.DataBean copy(@org.jetbrains.annotations.NotNull
        java.util.List<com.example.kotlinlib.project.entity.HomeDataResponse.AdListBean> ad_list, @org.jetbrains.annotations.NotNull
        java.util.List<com.example.kotlinlib.project.entity.HomeDataResponse.CompanyListBean> company_list, @org.jetbrains.annotations.NotNull
        java.util.List<com.example.kotlinlib.project.entity.HomeDataResponse.NewsListBean> news_list) {
            return null;
        }
        
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b\u00a8\u0006\u0015"}, d2 = {"Lcom/example/kotlinlib/project/entity/HomeDataResponse$NewsListBean;", "", "title", "", "create_time", "link", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCreate_time", "()Ljava/lang/String;", "getLink", "getTitle", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "kotlinlib_debug"})
    public static final class NewsListBean {
        @org.jetbrains.annotations.NotNull
        private final java.lang.String title = null;
        @org.jetbrains.annotations.NotNull
        private final java.lang.String create_time = null;
        @org.jetbrains.annotations.NotNull
        private final java.lang.String link = null;
        
        public NewsListBean(@org.jetbrains.annotations.NotNull
        java.lang.String title, @org.jetbrains.annotations.NotNull
        java.lang.String create_time, @org.jetbrains.annotations.NotNull
        java.lang.String link) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getTitle() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getCreate_time() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getLink() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.example.kotlinlib.project.entity.HomeDataResponse.NewsListBean copy(@org.jetbrains.annotations.NotNull
        java.lang.String title, @org.jetbrains.annotations.NotNull
        java.lang.String create_time, @org.jetbrains.annotations.NotNull
        java.lang.String link) {
            return null;
        }
        
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
            return null;
        }
    }
}