/*
 * Copyright (c) 2012-2014 by Asiainfo Linkage
 * All rights reserved.
 * $Id: CustomerConst.java 112 2015-02-10 11:13:29Z wanglf $
 */
package com.crm.cfgdata.base.constant;

import static com.asiainfo.utils.StringPool.FORWARD_SLASH;
import static com.asiainfo.utils.StringPool.GREATER_THAN;
import static com.asiainfo.utils.StringPool.LESS_THAN;

/**
 * @User: mayc
 * @Date: 2014年5月20日
 * @Time: 下午3:52:40
 * @version $Revision: 112 $ $Date: 2015-02-10 19:13:29 +0800 (周二, 10 二月 2015) $
 */
public interface CustomerConst {
    public interface CustConst {
        String IS_LOCAL_USER = "0"; //浙江省号码
        String IS_NOT_LOCAL_USER = "1"; //外省市号码
        String IS_OUT_NET = "11100015"; //外省号码查询错误码
        public static enum PROD_CATALOG {GSM("1"), ADSL("2"),BROADTV("3"), TEL("4");public String CATALOG;  //1=GSM 2=宽带  4=固话

            PROD_CATALOG(String catalog) {
                this.CATALOG = catalog;
            }
        }
        //免费资源
        String RTA_ALL_SUM_FREE_CODE = "RTA_ALL_SUM_FREE_CODE";
        //客户类型: 0=本省异地用户,1=本地GSM用户,2=本地宽带用户,3本地宽带电视用户,4=本地固话用户,5=无用户,6=外省用户
        public static enum LoginCustType {LOCAL_DIST("0"),LOCAL_GSM("1"),LOCAL_ADSL("2"),LOCAL_BROADTV("3"),LOCAL_TEL("4"),NO_USER("5"),OTHERE_PROV("6");public String TYPE;
        	LoginCustType(String type) {
                this.TYPE = type;
            }
        }
        String BELONG_COMPANY_MOBILE ="1";
        String BELONG_COMPANY_UNICOM ="2";
        String BELONG_COMPANY_TELECOM ="3";
        //保底科目编号
        String[] RATE_VALUE_PROJECT = new String []{"1509032","46000150"};
        //0就高型保底 1累加型保底 2独立型
        String GUARANT_TYPE_0 = "0";
        String GUARANT_TYPE_1 = "1";
        String GUARANT_TYPE_2 = "2";
        
      //保底角色
        String BD_ROLE_1 = "1";//个人
        String BD_ROLE_2 = "2";//家长
        String BD_ROLE_3 = "3";//成员
        
        String REAL_NAME_FLAG10="10"; //10 非实名
        String REAL_NAME_FLAG11="11"; //11:实名
        String REAL_NAME_FLAG12="12"; //12:待确认
        
        String STATE_IN_USE = "1"; //用户正常状态
    }

    public interface CustBillingConst {
        String QRY_RECORD_MULTIBILL_KEY = "关键信息区";
        String QRY_RECORD_MULTIBILL_KEY_START = LESS_THAN + QRY_RECORD_MULTIBILL_KEY + GREATER_THAN;
        String QRY_RECORD_MULTIBILL_KEY_END = LESS_THAN + FORWARD_SLASH + QRY_RECORD_MULTIBILL_KEY + GREATER_THAN;
        String QRY_RECORD_MULTIBILL_SECOND = "一级项";
        String QRY_RECORD_MULTIBILL_MONEY = "金额";
        String SECOND_ITEM_LIST="二级项集合";
        String SECOND_ITEM="二级项";
    }

    /****热门业务字段定义*****/
    public interface CustHotBusiess {
        String HOT_BUSI_FAMILY = "0";
        String HOT_BUSI_UNIFYPAY = "1";
        String HOT_BUSI_FUSEWIDEPAY = "2";
        String HOT_BUSI_VIRTUALNET = "3";
        String HOT_BUSI_BROADTV = "4";
        String CUST_HOT_BUSI_MAPPING = "AISCRM_CUST_HOT_BUSI_MAPPING";
        
        String HOT_RECHARGE_TYPE ="10"; //充值
        String HOT_BUSINESS_TYPE ="11"; //业务受理
        String HOT_MONEY_TYPE ="12"; //资金记录
    }

    public interface FLOW_UNIT {
        long KB = 1;
        long MB = 1024 * KB;
        long GB = 1024 * MB;
        long TB = 1024 * GB;
        public static enum UNIT {G, M, K;
        }
    }

    public interface OTHER_USER {
        String ONSTATUS = "正常";
        String NOSTATUS = "暂无法查询";
        String OFFSTATUS = "停机";
        String QRY_CERT_TYPE = "0";
		// 1.当值为1的时候，只传证件类型、证件号码查询所有用户
		// 2.当值为2的时候，传证件类型、证件号码以及归属地市查询当前地市的用户
		// 3.当值为3的时候，传账户编号以及归属地市查询用户
		String QRY_TYPE_1 = "1";
		String QRY_TYPE_2 = "2";
		String QRY_TYPE_3 = "3";
    }
    
    public interface BillCustomize{
    	String CM_CUSTOMIZE_MAIL_TYPE ="CM_CUSTOMIZE_MAIL_TYPE"; //个性化账单
    	String CUSTOMIZE_FLAG  = "CUSTOMIZE_FLAG";
    	String APPENDIX_PAGE_FLAG = "0";
    	String OPER_TYPE_CUSTOMIZE ="2";  //定制
    	String OPER_TYPE_CANCEL ="3";   //取消
    	String OPER_TYPE_ADD ="1";   //增加
    	String SEND_MAIL_SUFFIX ="@139.com";
    	
    	String CUSTOMIZE_FLAG0="0";  //0未定制
    	String CUSTOMIZE_FLAG1="1";  //1 已定制
    }
}
