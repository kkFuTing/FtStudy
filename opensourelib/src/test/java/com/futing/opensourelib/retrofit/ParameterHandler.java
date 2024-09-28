package com.futing.opensourelib.retrofit;

/**
 * 处理请求的参数
 */

public abstract class ParameterHandler {

    abstract void apply(ServiceMethod method,String value);

    static class Query extends ParameterHandler{
       private String name;

        public Query(String name) {
            this.name = name;
        }

        @Override
        void apply(ServiceMethod method, String value) {
            method.addQueryParameter(name,value);
        }
    }

    static class Filed extends ParameterHandler{
        private String name;

        public Filed(String name) {
            this.name = name;
        }
        @Override
        void apply(ServiceMethod method, String value) {
            method.addFormFiledParameter(name,value);
        }
    }
}
