package com.crm.comm;

/**
 * 响应码枚举，参考HTTP状态码的语义
 */
public enum ResultCode {
    SUCCESS(200),//成功
    FAIL(400),//失败
    UNAUTHORIZED(250),//未认证（签名错误）
    NOT_FOUND(404),//接口不存在
    INTERNAL_SERVER_ERROR(500),//服务器内部错误
	DATA_NOT_FOUND(301);//查询无数据
	
    

    public int code;

    ResultCode(int code) {
        this.code = code;
    }
}
