package com.crm.comm;

/**
 * 响应消息枚举，参考HTTP状态码的语义
 */
public enum ResultMsg {
    
	SOS00000001("手机号码不能为空"),
	SOS00000002("查询时间不能为空")
	;

    public String msg;

    ResultMsg(String msg) {
        this.msg = msg;
    }
    
    public String getValue() {
        return msg;
    }
}
