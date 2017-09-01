	/*
	 * Copyright (c) 2012-2014 by Asiainfo-linkage
	 * All rights reserved.
	 */
	package com.crm.cfgdata.base.constant;
	
	
	/**
	 * 常量类
	  */
	public interface SCRMConstants {
		
		 /**
	     *系统常量
	     * @author        [mayc]
	     * @version        1.0
	     */
	    public interface System {
	        String CHANNEL_TYPE = "1"; //渠道类型
	        String REGION_ID = "REGION_ID";
	        String SYS_SUCCESS_VALUE = "0";
	        String SYS_ERROR_VALUE = "1";
	        String COUNTY_CODE = "COUNTY_ID"; //区县ID
	        String ORG_CHANNEL_TYPE = "ORG_CHANNEL_TYPE"; //渠道类型
	        String SEC_ORG_TYPE = "SEC_ORG_TYPE"; //渠道二级类型
	        String THIRD_ORG_TYPE = "THIRD_ORG_TYPE"; //渠道三级类型
	        Integer MODULE_TYPE = 17; //菜单 MODULE_TYPE
	        
	        String STAR_LEVEL = "STAR_LEVEL"; //渠道星级
	        String SPECIALITY = "SPECIALITY"; //渠道是否专营
	        
	    	public static final String CHANNEL_TYPE_FIRSTTYPE = "CHANNEL_TYPE_FIRSTTYPE"; 	//渠道类型,第一大类编码
	    	public static final String CHANNEL_OPPONENT_TYPE = "CHANNEL_OPPONENT_TYPE"; 	//竞争对手渠道类型,第一大类编码
	    	public static final String CHANNEL_TYPE_DEPARTMENT	="1";	//渠道类型：1- 部门
	    	public static final String CHANNEL_TYPE_REGION	="2";	//渠道类型：2- 区域营销中心
	    	public static final String CHANNEL_TYPE_SELFCHNL	="80001";	//渠道类型：3- 自有渠道 
	    	public static final String CHANNEL_TYPE_SOCIETYCHNL	="80002";	//渠道类型：4- 社会渠道	.签约渠道
	    	public static final String CHANNEL_TYPE_DIRECTCHNL	="80003";	//渠道类型：5- 直销渠道
	    	public static final String CHANNEL_TYPE_NOTAUTHORIZEWEB	="80005";	//渠道类型：6- 非授权网点
	    	public static final String CHANNEL_TYPE_WIDEBAND	="80600";	//渠道类型：7- 宽带渠道
	    	public static final String CHANNEL_TYPE_SACHNL	="80610";	//渠道类型：8- 集团客户SA渠道
	    	public static final String CODE_BRACKET_LEFT = "【"; // 显示代码编号和名称用符合
	    	public static final String CODE_BRACKET_RIGHT = "】";
	    }
	
	    /**
	     * ESB常量
	     * @author        [mayc]
	     * @version        1.0
	     */
	    public interface EsbConstant {
	        String BUSI_INFO = "BUSI_INFO";
	        String PUB_INFO = "PUB_INFO";
	        String RESULT_CODE = "RETURN_RESULT"; //报文ESB_KEY_CODE result code
	        String RESULT_MSG = "RETURN_DESC"; // 报文ESB_KEY_CODE  result msg
	        String ERRORINFO = "ERRORINFO";
	        String RetInfo = "RetInfo";
	        String ESB_SUCCESS_CODE = "0";
	        String ESB_ERROR_CODE = "400";
			String ESB_WARING_CODE = "11280001";
	        String ORG_ID_ESB_DEFAULT = "0";
	        int ESB_MAX_PERPAGE_TOTAL = 3000;
	        int ESB_MAX_TOTAL = 15000; //大概要用掉 88m
	        String ESB_SYS_OP_ID = "20057971"; //ESB sysOPId --10010852   SCRM生产工号20057971   准发布可用工号20037686
	        String ESB_SYS_PASSWORD = "8323f15343239abb72885940220a4f3e"; 
//	        String ESB_SYS_PASSWORD = "7c6a180b36896a0a8c02787eeafb0e4c";//准发布
	        //ESB SYS password --7c6a180b36896a0a8c02787eeafb0e4c
	    }
	
	    /**
	     * WEB常量
	     * @author        [mayc]
	     * @version        1.0
	     */
	    public interface WEB_STATUS_CODE {
	        String SUCCESS_CODE_VALUE = "200"; //成功标示，前台交互的标示
	        String SYSTEM_ERROR_CODE_VALUE = "-9999"; //系统错误标示
	        String SYSTEM_ERROR_SHOW_NAME ="-";
	    }
	
	    /**
	     * FTP参数常量
	     * @author        [Mayc]
	     * @version        1.0
	     */
	    public interface FRAME_FTP {
	        String AICCS_COMMON_FTP_CODE = "AICCS_FTP";
	        String FTP_BASE_PATH_KEY = "FTP_BASE_PATH_KEY"; //ftp的base路径key
	        String FTP_FILE_PATH_KEY = "FTP_FILE_PATH_KEY"; //上传文件的路径key
	        String FTP_FILE_STYLE_KEY = "FILE_STYLE"; //上传文件的类型key
	        long FILE_MAX_SIZE = 1024 * 1024L; //文件最大限制
	
	        //公告ftp配置
	        public interface FTP_NOTICE {
	            String AICCS_NOTICE_FTP_PATH = "AICCS_NOTICE_PATH";
	            String COMMON_NOTICE_FILE_STYLE = "*.doc;*.docx;*.pdf;*.xls;*.xlsx;*.txt;*.pptx;*.ppt"; //允许的文件类型
	        }
	    }
	
	    /**
	     * 系统异常级别
	     * @author        xianan
	     *
	     */
	    public interface EXCEPTION_LEVEL {
	        int EXCEPTION_LEVEL_INTERRUPTION = 1; //不可忽略异常
	        int EXCEPTION_LEVEL_CAN_IGNORE = 2; //可忽略异常，会将堆栈信息单独输出日志文件
	    }
	
	    /**
	     * 我的收藏常量
	     * @author       [hujian3]
	     *
	     */
	    public interface MY_FAVORITE {
	        int MAX_NUM = 10; //我的收藏允许添加的最大个数
	    }
	
	    /**
	    * 亲情网
	    * @author     zhengyx5
	    *
	    */
	    public interface FAMILY_NET {
	        String FAMILY_NET_5_PROD_ID = "301000031311"; //亲情网5元产品
	        String FAMILY_NET_6_PROD_ID = "600000044996"; //亲情网6元产品
	        String FAMILY_NET_NEW_PROD_ID = "600000342642"; //亲情网新资费产品
	        String FAMILY_NET_SMS = "600000146985"; //亲情网5元短信畅发
	        String FAMILY_NET_SMS_FREE = "600000146974"; //亲情网免费短信畅发
	        String FAMILY_NET_MAIN_SHORT_NUM = "661"; //亲情网主号
	        String FAMILY_NET_FREE_PROD_200 = "200分钟"; //亲情网本地通话优惠200分钟
	        String FAMILY_NET_FREE_PROD_300 = "300分钟"; //亲情网本地通话优惠300分钟
	        String FAMILY_NET_FREE_PROD_500 = "500分钟"; //亲情网本地通话优惠500分钟
	        long FAMILY_NET_SEC_ENTITY = 50002405; //家庭亲情网拆网立即生效
	        long FAMILY_NET_SEC_PRIV = 331; //家庭亲情网成员退出可选立即生效控制权限
	        String FAMILY_NET_SMS_FEE_0 = "0"; //网龄大于等于24个月短信畅发费用
	        String FAMILY_NET_SMS_FEE_5 = "5"; //网龄小于24个月短信畅发费用
	    }
	
	    /**
	    * 有线宽带预受理常量
	    * @author       [hujian3]
	    *
	    */
	    public interface BROAD_PRE_SALE {
	        long FEATURE_ID_LEVEL_SPECIAL_NOTE = 100211L; //档次特殊提醒FEATURE_ID
	        String OFFER_TYPE_FUSION_BROAD = "OFFER_PLAN_GROUP"; //融合套餐策划类型
	        String OFFER_TYPE_BROAD = "OFFER_PLAN_BROADBAND"; //宽带策划类型
	        long ROLE_ID_FUSION_GSM = 24L; //手机成员角色-融合宽带业务
	        long ROLE_ID_FUSION_FIX = 600000051915L; //固话角色-融合宽带业务
	        long FEATURE_ID_ORDER_FEE = 100204L; //订购费(年费)
	        long FEATURE_ID_MOUNT_FEE = 100221L; //初装费
	        long FEATURE_ID_DEVICE_FEE = 100222L; //设备押金
	        String PARA_TYPE_PAY_WAY = "CCS_BROADBAND_PREPAY_PAY_WAY"; //付费方式
	    }
	    
	    /**
	     * 客户实名登记常量
	     * @author       [xiesb]
	     *
	     */
	    public interface USER_REALNAME_CHECK {
	    	String MARKET_NAME = "客户实名登记";// 业务名称
	    	String REAL_NAME_FLAG_NOREAL = "10"; //非实名
	    	String REAL_NAME_FLAG_REAL = "11"; //实名
	    	String REAL_NAME_FLAG_WAIT_CONFIRM = "12"; //待确认
	        //String PROD_CATALOG_GSM = ""; //GSM用户
	        //String PROD_CATALOG_FIXED = ""; //固话
	        //String PROD_CATALOG_BROADBAND = ""; //宽带
	    }
	    
	    public interface KHRW{
	    	/**
	         * 资源类型(1：用于通过号码模式查询该号码可以参加的营销案档次)
	         */
	       String CFG_BILLID_PATTERN_RES_TYPE_REL_RES_LEVEL ="1";
	        
	        /**
	         * 资源类型(2：号码共性资源，即选择符合该模式的号码后，需要额外订购一个该号码模式对应的策划。
	         * 例如，号码中任意一位带4的号码可以额外赠送20元话费预缴。)
	         */
	        String CFG_BILLID_PATTERN_RES_TYPE_REL_PREPAYID ="2";
	        
	        /**
	    	 * CCS_CFG_LEVE_RES_REL 表 RES_TYPPE 资源类型
	    	 * 	    1.“号码预缴组"营销资源
	    			2.“终端型号”营销资源
	    			3.  "号码模式" 营销资源
	    			4.  "营销案免卡费“营销资源	未定义
	    			6.  "开户营销案带合约机" 
	    			/////////////////////////////////////////////
	    			10. "号码模式" 中送预缴时,预缴遇档次互斥判断
	    	 */
	    	String CCS_CFG_LEVEL_RES_TYPE_PHONENUM ="1";
	    	String CCS_CFG_LEVEL_RES_TYPE_TERMNUM ="2";
	    	String CCS_CFG_LEVEL_RES_TYPE_PHONENUM_PATTERN ="3";	
	        String CCS_CFG_LEVEL_RES_TYPE_FREE_CARD ="4";
	    	String CCS_CFG_LEVEL_RES_TYPE_TERMNSALEUM ="5";
	        String CCS_CFG_LEVEL_RES_TYPE_GSM_TERM_CONTRACT ="6";
	        String CCS_CFG_LEVEL_RES_TYPE_CHG_OFFER ="7";
	        String PARA_TYPE_PRE_OPEN = "CCS_USE_PREOPEN";//是否允许预开户
	        String PARA_CODE_PRE_OPEN = "X";
	        String OPER_TYPE_CREATE = "CREATE";
	        String SEL_FLAG_MUST = "0";//必选
	        String SEL_FLAG_DEFAULT = "1";//默选
	        String SEL_FLAG_CAN = "2";//可选
	        long BUSI_ID_NEW_RBOSS_USER = 500000020001L;
	        String MAIL_TYPE_1 = "1";//短信账单
	        String MAIL_TYPE_2 = "2";//彩信账单
	        String MAIL_TYPE_3 = "3";//Email账单
	        String MAIL_TYPE_4 = "4";//邮寄纸质账单
	        
	    }
	    
	    public interface BUSI_ID {
	    	long NEW_RBOSS_USER = 500000020001L;//开户
	    	long NEW_INC_OFFER = 500000020103L;//订购增值策划
	    }
	    
	    /**
	     * 营销案常量
	     * @author       [hujian3]
	     *
	     */
	    public interface MarketProg{
	    	String OFFER_PROGRAM_TYPE_16 = "16";  //换套餐
	    	/**
	    	 * 档次金额类型 up_item_feature.feature_id 
	    	 */
	    	long FEATURE_ID_HIGHER = 100213L; //就高型
			long FEATURE_ID_ADD = 100212L; //累加型
			long TRADEMARK_GOTONE = 100000000001L;//全球通
			long TRADEMARK_MZONE = 100000000004L;//动感地带
			long TRADEMARK_SHENZHOU= 100000000005L;//神州行
			String EFFECT_ONE_CODE = "11";
			String EFFECT_ONE_NAME = "立即生效";
			String EFFECT_NEXT_CODE = "12";
			String EFFECT_NEXT_NAME = "下周期生效";
			String EXPECT_ONE_CODE = "21";
			String EXPECT_ONE_NAME = "立即失效";
			String EXPECT_NEXT_CODE = "22";
			String EXPECT_NEXT_NAME = "下周期失效";
			String OPER_TYPE_CREATE = "CREATE";
			String OPER_TYPE_LOGOUT = "LOGOUT";
			String OPER_TYPE_NO_PASS = "CREATE_MUTEX_CHK_NO_PASS";
			String BUSI_KHRW = "KHRW";//开户
			String BUSI_CHANGE_OFFER= "GHTC";//换套餐
			String BUSI_OTHER= "OTHER";//普通营销案
			String BUSI_HYGJ= "HYGJ";//合约购机
			String MP_TYPE_15 = "15";//裸机销售-营销案业务类型
			
	    }
	    
	    /**
	     * 模拟月费信息计算常量[ESB_SO_PERSONAL_OFFER_FEECAL_001]
	     * @author       [hujian3]
	     *
	     */
	    public interface FeeCal{
	    	String BUSI_OPER_0 = "0";//业务变更
	    	String BUSI_OPER_1 = "1";//销户
	    	String BUSI_OPER_2 = "2";//开户
	    	String BUSI_OPER_3 = "3";//统一退订-策划
	    	String BUSI_OPER_4 = "4";//统一退订-产品
	    	String BUSI_OPER_9 = "9";//VPMN业务办理
	    	
	    	String OFFER_BUSI_OPER_CREATE = "CREATE";//订购
	    	String OFFER_BUSI_OPER_LOGOUT = "LOGOUT";//退订
	    	String OFFER_BUSI_OPER_UPDATE = "UPDATE";//修改
	    	String OFFER_BUSI_OPER_CHANGE_OFFER = "CHANGE_OFFER";//换套餐
	    	String OFFER_BUSI_OPER_REVISE_OFFER = "REVISE_OFFER";//订正套餐
	    }
	    
	    /**
	     * 账户相关的常量定义
	     * @author       [hujian3]
	     *
	     */
		public interface AccountConstants {
			/** 支付方式:移动充值 */
			public static final int PAY_METHOD_CMCC_CHARGE = 1;
	
			/** 支付方式:信用卡 */
			public static final int PAY_METHOD_CREDIT_CARD = 5;
	
			/** 支付方式:托收 */
			public static final int PAY_METHOD_COLLECTION = 6;
	
			/** 支付方式:一户通 */
			public static final int PAY_METHOD_ONE_PASS = 9;
	
			/** 支付方式:铁通收费 */
			public static final int PAY_METHOD_CRNET_CHARGE = 10;
	
			/** 支付方式:公免 */
			public static final int PAY_METHOD_EXEMPTION = 8;
	
			/** 支付方式:专用卡（预付） */
			public static final int PAY_METHOD_SPECIAL_CARD = 2;
	
			/** 支付方式:储蓄卡 */
			public static final int PAY_METHOD_GELDKARTE = 3;
	
			/** 支付方式:信用卡（日控） */
			public static final int PAY_METHOD_CREDIT_CARD_DAILY = 4;
	
			/** 支付方式:现金 */
			public static final int PAY_METHOD_CASH = 0;
	
			/**
			 * 预付费
			 */
			public static final int PAY_METHOD_PREPAY = 7;
	
			/** 账户状态:预销 */
			public static final int ACCOUNT_STATUS_PRE_CANCEL = 2;
	
			/** 账户状态:注销 */
			public static final int ACCOUNT_STATUS_CANCEL = 3;
	
			/** 账户状态:正常 */
			public static final int ACCOUNT_STATUS_NORMAL = 1;
	
			/** 账户类型:预付费账户 */
			public static final int ACCOUNT_TYPE_PREPAY = 1;
	
			/** 账户类型:后付费帐户 */
			public static final int ACCOUNT_TYPE_POSTPAY = 2;
	
			/** 账户类型:公免帐户 */
			public static final int ACCOUNT_TYPE_EXEMPTION = 3;
	
			/** 账户类型:铁通收费账户 */
			public static final int ACCOUNT_TYPE_CRNET_CHARGE = 4;
	
			/** 免催免停标志:催停 */
			public static final int URGE_STOP_FLAG_URGE_STOP = 00;
	
			/** 免催免停标志:可摧免停 */
			public static final int URGE_STOP_FLAG_URGE_NONSTOP = 01;
	
			/** 免催免停标志:免催可停 */
			public static final int URGE_STOP_FLAG_NONURGE_STOP = 10;
	
			/** 免催免停标志:免催免停 */
			public static final int URGE_STOP_FLAG_NONURGE_NONSTOP = 11;
	
			/** 自有帐户 */
			public static final int SELF_ACCT = 1;
	
			/** 关联帐户 */
			public static final int REAL_ACCT = 2;
	
			/** 是集团预付费 */
			public static final int PRE_PAY = 1;
	
			/** 不是集团预付费 */
			public static final int NOT_PRE_PAY = 0;
	
			/** 是E管家 */
			public static final int E_MANAGER = 1;
	
			/** 不是是E管家 */
			public static final int NOT_E_MANAGER = 0;
	
			/** 按帐户编号 */
			public static final int SEARCH_TYPE_ACCTID = 1;
	
			/** 手机号码 */
			public static final int SEARCH_TYPE_BILLID = 2;
	
			/** 银行帐号 */
			public static final int SEARCH_TYPE_BANKID = 3;
	
			/** 默认帐户 */
			public static final int ACCOUNT_TYPE_DEFAULT = 1;
	
			/** 需要填写帐户编号的支付方式 */
			public static final String NEED_BANK_ACCOUNT = "2,3,4,5,6,9";
	
			/** 新开户的支付方式 */
			public static final String PAY_METHOD_IN_OPEN = "1,5,6,9";
	
			/** 新开户的支付方式 */
			public static final String PAY_METHOD_NEED_BANK = "2,3,4,5,6,9";
	
			public static final String SEQ_CONTRACT_NO = "CM_ACCT_CONTRACT_NO";
		}
		
		 /**
	     * 属性相关的常量定义
	     * @author       [hujian3]
	     *
	     */
		public interface Attr{
			/**实物编码**/
			long ATTR_ID_SWBM = 500000030211L;
			/**订购份数**/
			long ATTR_ID_DGFS = 500000000200L;
		}
		
		/**
		 * 营销案相关属性常量定义
		 * @author momo
		 *
		 */
		public interface MKT_PROGRAM_FEATRUE{
	        long FEATURE_ID_KIND_TYPE = 100145L;//档次类型
	        long MKT_KIND_TYPE = 2;//CFG_MKT_TPL_REL中item_type定义，档次
	        long MKT_PROG_TYPE = 1;//CFG_MKT_TPL_REL中item_type定义，营销案
		}
		
		/**
		 * 增值策划业务变更中常量定义
		 * 
		 * @author niwei
		 */
		public interface BUSI_CHANGE {
			/**
			 * 业务操作ID
			 * 
			 */
			public interface OPER_ID {
				String CREATE = "500000020103";// 订购
				String LOGOUT = "500000020105";// 退订
				String END = "500000020220";// 终止
				String CANCEL = "500000020221";// 反撤
				String UPDATE = "500000020101";// 变更
				String CANCEL_NEXT_CYCLE = "500000020107";//取消下周期
				String BASE_MODIFY = "500000020102";//套餐订正
			}
	
			long BUSI_ID = 500000020103L;// 业务变更业务ID
	
			public String[] I18N_LONG_DISTANCE_ROMAING_OFFER_ID = { "500300130435", // 国际及港澳台漫游数据流量日套餐
					"600000121968", // 国际及港澳台漫游数据流量包18元日套餐
					"500190114003",// 国际及港澳台长途
					"500190117785", // 30天国际及港澳台漫游
					"500190117786", // 60天国际及港澳台漫游
					"600000447512", // 180天国际及港澳台漫游
					"500190117007"// 国际及港澳台漫游
			};
	
			String STANDARD_FEE_OFFER_ID = "500153001021";// 移动数据流量标准资费策划ID
			String STANDARD_FEE_PRODUCT_ID = "105053001021";// 移动数据流量标准资费产品ID
			
			String STANDARD_MSG_FEE_OFFER_ID = "500120001015";// 短消息策划ID
			String STANDARD_MSG_FEE_PRODUCT_ID = "105020001015";// 短消息产品ID
	
			/**
			 * 属性配置时的操作类型
			 * 
			 */
			public interface ATTR_CONFIG_OPER_TYPE {
				String NEW = "1";// 新增
				String MODIFY = "2";// 修改
				String DELETE = "3";// 删除
				String UNCHANGED = "4";// 不变
			}
	
			public String ATTR_ID_FAMILY_LINE_520 = "500000030271";// 属性ID：520亲情号码
			public String ATTR_ID_FAMILY_LINE_521 = "500000030272";// 属性ID：521亲情号码
			public String PROD_ID_FAMILY_LINE_400 = "301000123836"; // 产品ID：亲情快线400产品

			public String[] OFFER_ID_FAMILY_LINE = { "500000100028", "500000100030", "500000100031", "500000100032",
					"500000100033", "500000100034", "500000100035", "500000100036", "500000100037", "500000100038",
					"500000100039", "500000100040" };// 移动亲情快线，校园亲情快线策划ID
	
			public String OFFER_ID_HAPPY_LINE = "600000004501";// 幸福快线策划ID
			
			public String UP_SHIFT_FLAG_CURRENT = "1";// 立即升档
			public String UP_SHIFT_FLAG_NEXT = "2";// 次月生效
		}
		
		//搜索营销案方式
		public interface SEARCH_MKT_PROGRAM_TYPE{
			int CHNL_TYPE = 1;
			int ORG_ID = 2;
		}
	
		//设备类型查询
		public interface SERVICE_DEAL {
			public static final String SECCUSS_CODE = "200" ;     //成功
			public static final String ERROR_CODE = "-1";       //失败
		}
		
		
		/**
		 * 押金管理常量
		 * @author [wangshan]
		 *
		*/
		public interface INDEP_FEE_MANAGE 
		{
		    //押金查询GSMtype 
			String OP_TYPE_GSM="1";
			//押金查询固网type 
			String OP_TYPE_FIX="2";
			
			//固网押金管理补收及收费busiType,补收的busiType
			String BUSI_TYPE_CHARGE="C";
		}
		
		/**
		 * 群组套餐变更常量
		 */
		public interface GROUP_BUSINESS_CHANGE
		{
			//群组家长角色
			public static final long GROUP_MEMBER_MAIN_ROLE_ID=22L;
			//群组手机角色
			public static final long GROUP_MEMBER_PHONE_ROLE_ID=24L;
			//群组固话角色
			public static final long GROUP_MEMBER_TELEPHONE_ROLE_ID = 600000051915L; 
			//群组宽带角色
			public static final long GROUP_MEMBER_BROADBAND_ROLE_ID = 500000010111L; 
			
			//群组家长用户
			public static final String GROUP_MEMBER_MAIN_USER = "1"; 
			//群组成员用户
			public static final String GROUP_MEMBER_MEM_USER = "0"; 
			
			//群组家长本周期
			public static final String GROUP_MAIN_DATE_NOW = "1"; 
			//群组家长下周期
			public static final String GROUP_MAIN_DATE_NEXT = "0"; 
			
			//群组套餐价格计划
			public static final String GROUP_PRICE_TYPE = "GROUP"; 
			
			//宽带套餐价格计划
			public static final String BROAD_PRICE_TYPE = "BROAD";
			
			//变更账户显示的支付方式
			public static final String PAY_METHOD_IN_OPEN = "1,6,9";
						
		}
		/**
		 * 规则常量
		 */
		public interface RULE_PARAMS {
			public static final String USER_INFOS = "USER_INFOS"; 
		}
		//规则校验提前拼装好的用户列表
		
		/**
		 * 对于用户一证五户的校验的开关 0 标识开，1标识关
		 */
		public interface ONE_MANY_USER_SWITCH {
			public static final String CHECK_USER_SWITCH_OPEN = "0";
			public static final String CHECK_USER_SWITCH_CLOSE = "1";
		}
		/**
		 * 用户标签的配置
		 */
		public interface USER_TAG_ID {
			public static final String ONE_MANY_USER_TAG_ID = "10000001";
			public static final String ONE_MANY_USER_TAG_LIMIT = "1";
			public static final String ONE_MANY_USER_TAG_NO_LIMIT = "2";
		}
		
		/**
		 * 流程状态  1 审批中 2 审批通过 3 审批驳回 4 审批通过，待营业员确认 5 营业员确认成功，流转到账务员 6 营业员确认失败 7 退出成功 8 退回失败
		 * 操作类型  1新增 2 修改 3 删除 4 营业入账
		 * 资金流向  1 收款  2 使用  3 退款
		 * @author WANGTF2
		 *
		 */
		public interface TEMP_DEPOSIT_ORDER {
			public static final String WF_STATE_4 = "4";
			public static final String WF_STATE_5 = "5";
			public static final String OPER_TYPE_1 = "1";
			public static final String OPER_TYPE_2 = "2";
			public static final String OPER_TYPE_3 = "3";
			public static final String OPER_TYPE_4 = "4";
			
			public static final String FUNDS_FLOWS_1 = "1";
			public static final String FUNDS_FLOWS_2 = "2";
			public static final String FUNDS_FLOWS_3 = "3";
		}
		
		public interface FILE_UPLOAD {
			/**
			 * 内容平台中的文档类别ID，使用{base_url}/api/catalog查询 
			 */
			public static final String E_INV_CATALOGID = "2179";//内容平台中的文档类别ID，使用{base_url}/api/catalog查询 
			
			/**
			 * 如商机录入、客户资料变更等。这里传入的为编码，需在内容管理平台预先设置,参考 业务类型编码
			 */
			public static final String E_INV_BUSITYPE = "electronic_invoice";//如商机录入、客户资料变更等。这里传入的为编码，需在内容管理平台预先设置,参考 业务类型编码
			
			/**
			 * 如工单号，集团编号，客户编号等
			 */
			public static final String E_INV_BUSIVALUE = "0";//如工单号，集团编号，客户编号等
		}
	}
