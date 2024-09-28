package com.example.kotlinlib.project.utils;

/**
 * 关于一切：
 *  Json 解析
 *  Json 操作相关的工具类
 * 工具类 都是object
 *  全部都是static函数
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bJ\u0010\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/example/kotlinlib/project/utils/JsonUtil;", "", "()V", "addIndentBlank", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "indent", "", "decodeUnicode", "", "theString", "formatJson", "jsonStr", "kotlinlib_debug"})
public final class JsonUtil {
    @org.jetbrains.annotations.NotNull
    public static final com.example.kotlinlib.project.utils.JsonUtil INSTANCE = null;
    
    private JsonUtil() {
        super();
    }
    
    /**
     * 格式化json字符串
     *
     * @param jsonStr 需要格式化的json串
     * @return 格式化后的json串
     */
    @org.jetbrains.annotations.NotNull
    public final java.lang.String formatJson(@org.jetbrains.annotations.Nullable
    java.lang.String jsonStr) {
        return null;
    }
    
    /**
     * 添加space
     *
     * @param sb
     * @param indent
     */
    private final void addIndentBlank(java.lang.StringBuilder sb, int indent) {
    }
    
    /**
     * http 请求数据返回 json 中中文字符为 unicode 编码转汉字转码
     *
     * @param theString
     * @return 转化后的结果.
     */
    @org.jetbrains.annotations.NotNull
    public final java.lang.String decodeUnicode(@org.jetbrains.annotations.NotNull
    java.lang.String theString) {
        return null;
    }
}