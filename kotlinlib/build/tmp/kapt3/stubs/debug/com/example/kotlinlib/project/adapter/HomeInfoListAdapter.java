package com.example.kotlinlib.project.adapter;

/**
 * 同学们这是 “首页” 列表的适配器
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0015B\u001d\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007B\u0007\b\u0002\u00a2\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\nH\u0016J&\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\r\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/example/kotlinlib/project/adapter/HomeInfoListAdapter;", "Landroid/widget/BaseAdapter;", "context", "Landroid/content/Context;", "mNews", "", "Lcom/example/kotlinlib/project/entity/HomeDataResponse$NewsListBean;", "(Landroid/content/Context;Ljava/util/List;)V", "()V", "getCount", "", "getItem", "", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "ViewHolder", "kotlinlib_debug"})
public final class HomeInfoListAdapter extends android.widget.BaseAdapter {
    private java.util.List<com.example.kotlinlib.project.entity.HomeDataResponse.NewsListBean> mNews;
    private android.content.Context context;
    
    private HomeInfoListAdapter() {
        super();
    }
    
    public HomeInfoListAdapter(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.util.List<com.example.kotlinlib.project.entity.HomeDataResponse.NewsListBean> mNews) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public android.view.View getView(int position, @org.jetbrains.annotations.Nullable
    android.view.View convertView, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup parent) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public java.lang.Object getItem(int position) {
        return null;
    }
    
    @java.lang.Override
    public long getItemId(int position) {
        return 0L;
    }
    
    @java.lang.Override
    public int getCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/example/kotlinlib/project/adapter/HomeInfoListAdapter$ViewHolder;", "", "()V", "newDate", "Landroid/widget/TextView;", "getNewDate", "()Landroid/widget/TextView;", "setNewDate", "(Landroid/widget/TextView;)V", "newsText", "getNewsText", "setNewsText", "kotlinlib_debug"})
    public static final class ViewHolder {
        public static android.widget.TextView newsText;
        public static android.widget.TextView newDate;
        @org.jetbrains.annotations.NotNull
        public static final com.example.kotlinlib.project.adapter.HomeInfoListAdapter.ViewHolder INSTANCE = null;
        
        private ViewHolder() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getNewsText() {
            return null;
        }
        
        public final void setNewsText(@org.jetbrains.annotations.NotNull
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getNewDate() {
            return null;
        }
        
        public final void setNewDate(@org.jetbrains.annotations.NotNull
        android.widget.TextView p0) {
        }
    }
}