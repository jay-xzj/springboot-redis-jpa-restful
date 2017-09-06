/*
 * Copyright (c) 2012-2014 by Asiainfo Linkage
 * All rights reserved.
 * $Id: OutputQryUsedFreeResDO.java 312765 2015-12-09 10:01:23Z shantj $
 */
package com.crm.flowdetail.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;



/**
 * @User: mayc
 * @Date: 2014年7月4日
 * @Time: 上午10:36:16
 * @version $Revision: 312765 $ $Date: 2015-12-09 18:01:23 +0800 (周三, 09 十二月 2015) $
 */
@SuppressWarnings("serial")
public class OutputQryUsedFreeResDO  {
    private String freeResMonth;
    private List<FreeResInfoDO> freeResInfos = new ArrayList<FreeResInfoDO>();

    public String getFreeResMonth() {
        return freeResMonth;
    }

    public void setFreeResMonth(String freeResMonth) {
        this.freeResMonth = freeResMonth;
    }

    public List<FreeResInfoDO> getFreeResInfos() {
        return freeResInfos;
    }

    public void setFreeResInfos(List<FreeResInfoDO> freeResInfos) {
        this.freeResInfos = freeResInfos;
    }

    public static class FreeResInfoDO implements Serializable {
        private String ACC_CODE;
        private String ACC_NAME;
        private String ACC_TYPE;
        private String FREE_TOTAL;
        private String REAL_USE;
        private String ACC_UNIT;
        private String TOTAL_DAYS;
        private String USE_DAYS;
        private String PROD_ID;
        private String PROD_NAME;
        private String UP_LIMIT;
        private String EFF_TIME;
        private String EXP_TIME;
        private String HISTORY_USED;
        private String ROLLOVER_FLAG;
        private String FREE_RES_MONTH;
        private String OFFER_NAME;
        private String DONE_DATE;

        public String getOFFER_NAME() {
			return OFFER_NAME;
		}

		public void setOFFER_NAME(String offerName) {
            if (offerName == null) {
            	offerName = "";
            }

            this.OFFER_NAME = offerName;
		}
		  public String getDONE_DATE() {
				return DONE_DATE;
			}

			public void setDONE_DATE(String doneDate) {
	            if (doneDate == null) {
	            	doneDate = "";
	            }

	            this.DONE_DATE = doneDate;
			}
        public String getHISTORY_USED() {
			return HISTORY_USED;
		}

		public void setHISTORY_USED(String historyUsed) {
            if (historyUsed == null) {
            	historyUsed = "";
            }

            this.HISTORY_USED = historyUsed;
		}

		public String getROLLOVER_FLAG() {
			return ROLLOVER_FLAG;
		}

		public void setROLLOVER_FLAG(String rolloverFlag) {
            if (rolloverFlag == null) {
            	rolloverFlag = "";
            }

            this.ROLLOVER_FLAG = rolloverFlag;
		}

		public String getACC_CODE() {
            return ACC_CODE;
        }

        public void setACC_CODE(String accCode) {
            if (accCode == null) {
                accCode = "";
            }

            this.ACC_CODE = accCode;
        }

        public void setACC_CODE(String accCode, String defaultVal) {
            if (accCode == null) {
                accCode = defaultVal;
            }

            this.ACC_CODE = accCode;
        }

        public String getACC_NAME() {
            return ACC_NAME;
        }

        public void setACC_NAME(String accName) {
            if (accName == null) {
                accName = "";
            }

            this.ACC_NAME = accName;
        }

        public void setACC_NAME(String accName, String defaultVal) {
            if (accName == null) {
                accName = defaultVal;
            }

            this.ACC_NAME = accName;
        }

        public String getACC_TYPE() {
            return ACC_TYPE;
        }

        public void setACC_TYPE(String accType) {
            if (accType == null) {
                accType = "";
            }

            this.ACC_TYPE = accType;
        }

        public void setACC_TYPE(String accType, String defaultVal) {
            if (accType == null) {
                accType = defaultVal;
            }

            this.ACC_TYPE = accType;
        }

        public String getFREE_TOTAL() {
            return FREE_TOTAL;
        }

        public void setFREE_TOTAL(String freeTotal) {
            if (freeTotal == null) {
                freeTotal = "";
            }

            this.FREE_TOTAL = freeTotal;
        }

        public void setFREE_TOTAL(String freeTotal, String defaultVal) {
            if (freeTotal == null) {
                freeTotal = defaultVal;
            }

            this.FREE_TOTAL = freeTotal;
        }

        public String getREAL_USE() {
            return REAL_USE;
        }

        public void setREAL_USE(String realUse) {
            if (realUse == null) {
                realUse = "";
            }

            this.REAL_USE = realUse;
        }

        public void setREAL_USE(String realUse, String defaultVal) {
            if (realUse == null) {
                realUse = defaultVal;
            }

            this.REAL_USE = realUse;
        }

        public String getACC_UNIT() {
            return ACC_UNIT;
        }

        public void setACC_UNIT(String accUnit) {
            if (accUnit == null) {
                accUnit = "";
            }

            this.ACC_UNIT = accUnit;
        }

        public void setACC_UNIT(String accUnit, String defaultVal) {
            if (accUnit == null) {
                accUnit = defaultVal;
            }

            this.ACC_UNIT = accUnit;
        }

        public String getTOTAL_DAYS() {
            return TOTAL_DAYS;
        }

        public void setTOTAL_DAYS(String totalDays) {
            if (totalDays == null) {
                totalDays = "";
            }

            this.TOTAL_DAYS = totalDays;
        }

        public void setTOTAL_DAYS(String totalDays, String defaultVal) {
            if (totalDays == null) {
                totalDays = defaultVal;
            }

            this.TOTAL_DAYS = totalDays;
        }

        public String getUSE_DAYS() {
            return USE_DAYS;
        }

        public void setUSE_DAYS(String useDays) {
            if (useDays == null) {
                useDays = "";
            }

            this.USE_DAYS = useDays;
        }

        public void setUSE_DAYS(String useDays, String defaultVal) {
            if (useDays == null) {
                useDays = defaultVal;
            }

            this.USE_DAYS = useDays;
        }

        public String getPROD_ID() {
            return PROD_ID;
        }

        public void setPROD_ID(String prodId) {
            if (prodId == null) {
                prodId = "";
            }

            this.PROD_ID = prodId;
        }

        public void setPROD_ID(String prodId, String defaultVal) {
            if (prodId == null) {
                prodId = defaultVal;
            }

            this.PROD_ID = prodId;
        }

        public String getPROD_NAME() {
            return PROD_NAME;
        }

        public void setPROD_NAME(String prodName) {
            if (prodName == null) {
                prodName = "";
            }

            this.PROD_NAME = prodName;
        }

        public void setPROD_NAME(String prodName, String defaultVal) {
            if (prodName == null) {
                prodName = defaultVal;
            }

            this.PROD_NAME = prodName;
        }

        public String getUP_LIMIT() {
            return UP_LIMIT;
        }

        public void setUP_LIMIT(String upLimit) {
            if (upLimit == null) {
                upLimit = "";
            }

            this.UP_LIMIT = upLimit;
        }

        public void setUP_LIMIT(String upLimit, String defaultVal) {
            if (upLimit == null) {
                upLimit = defaultVal;
            }

            this.UP_LIMIT = upLimit;
        }

        public String getEFF_TIME() {
            return EFF_TIME;
        }

        public void setEFF_TIME(String effTime) {
            if (effTime == null) {
                effTime = "";
            }

            this.EFF_TIME = effTime;
        }

        public void setEFF_TIME(String effTime, String defaultVal) {
            if (effTime == null) {
                effTime = defaultVal;
            }

            this.EFF_TIME = effTime;
        }

        public String getEXP_TIME() {
            return EXP_TIME;
        }

        public void setEXP_TIME(String expTime) {
            if (expTime == null) {
                expTime = "";
            }

            this.EXP_TIME = expTime;
        }

        public void setEXP_TIME(String expTime, String defaultVal) {
            if (expTime == null) {
                expTime = defaultVal;
            }

            this.EXP_TIME = expTime;
        }
        public String getFREE_RES_MONTH() {
     			return FREE_RES_MONTH;
     		}

     		public void setFREE_RES_MONTH(String freeResMonth) {
                 if (freeResMonth == null) {
                	 freeResMonth = "";
                 }

                 this.FREE_RES_MONTH = freeResMonth;
     		}

        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this);
        }
    }
}
