package esbInvoke;

import java.io.Serializable;

public class CfgWsClient implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String cfgWsClientCode;
	private String methodName ;	
	private String methodParameter ;	
	private String methodRetrurnType;	
	private String urlAddress ;	
	private String registerTypeMapping ;
	private Long timeoutSeconds ;
	private String state ;
	private String remarks ;
	private String operationStyle ;
	private String operationUse ;
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getCfgWsClientCode() {
		return cfgWsClientCode;
	}
	public String getMethodName() {
		return methodName;
	}
	public String getMethodParameter() {
		return methodParameter;
	}
	public String getMethodRetrurnType() {
		return methodRetrurnType;
	}
	public String getUrlAddress() {
		return urlAddress;
	}
	public String getRegisterTypeMapping() {
		return registerTypeMapping;
	}
	public Long getTimeoutSeconds() {
		return timeoutSeconds;
	}
	public String getState() {
		return state;
	}
	public String getRemarks() {
		return remarks;
	}
	public String getOperationStyle() {
		return operationStyle;
	}
	public String getOperationUse() {
		return operationUse;
	}
	public void setCfgWsClientCode(String cfgWsClientCode) {
		this.cfgWsClientCode = cfgWsClientCode;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public void setMethodParameter(String methodParameter) {
		this.methodParameter = methodParameter;
	}
	public void setMethodRetrurnType(String methodRetrurnType) {
		this.methodRetrurnType = methodRetrurnType;
	}
	public void setUrlAddress(String urlAddress) {
		this.urlAddress = urlAddress;
	}
	public void setRegisterTypeMapping(String registerTypeMapping) {
		this.registerTypeMapping = registerTypeMapping;
	}
	public void setTimeoutSeconds(Long timeoutSeconds) {
		this.timeoutSeconds = timeoutSeconds;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public void setOperationStyle(String operationStyle) {
		this.operationStyle = operationStyle;
	}
	public void setOperationUse(String operationUse) {
		this.operationUse = operationUse;
	}

	
}
