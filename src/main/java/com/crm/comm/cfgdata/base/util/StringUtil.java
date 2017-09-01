package com.crm.comm.cfgdata.base.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * <p>FileName: StringUtil.java</p>
 * <p/>
 * <p>Title: 字符串处理工具类</p>
 * <p/>
 * <p>Description: 用于对字符串进行替换和转换等操作</p>
 * <p/>
 *
 * @version 1.00
 */
public class StringUtil extends org.apache.commons.lang.StringUtils {
	private static final Log log = LogFactory.getLog(StringUtil.class);
    private static final char LT_ENCODE[] = "&lt;".toCharArray();
    private static final char GT_ENCODE[] = "&gt;".toCharArray();
    private static final char BR_TAG[] = "<BR>".toCharArray();

    /**
     * 字符串替换
     *
     * @param strSrc String		源字符串
     * @param strOld String		被替换的字符串
     * @param strNew String		欲替换的字符串
     * @return String
     */
    public static final String replace(
            String strSrc,
            String strOld,
            String strNew) {

        String szReturn = "";
        String szTemp = null;
        int iIndex = -1;
        boolean bFirst = true;

        if (strSrc == null) {
            return null;
        }
        while ((iIndex = strSrc.indexOf(strOld)) != -1) {
            szTemp = strSrc.substring(0, iIndex);
            if (bFirst) {
                szReturn = "";
                bFirst = false;
            }
            szReturn += szTemp + strNew;
            strSrc = strSrc.substring(iIndex + strOld.length());
        }
        szReturn += strSrc;
        return szReturn;
    }
    /**
     * 
    * @Function: 
    * @Description: java端加密，对应js方法解密unescape(str)
    *
    * @param:参数描述
    * @return：返回结果描述
    * @throws：异常描述
    *
    * @version: v1.0.0
    * @author: Tong
    * @date: Dec 8, 2011 6:40:04 PM 
    *
    * Modification History:
    * Date         Author          Version            Description
    *---------------------------------------------------------*
    * Dec 8, 2011     Tong           v1.0.0               修改原因
     */
    public static String escape(String src) {
		int i;
		char j;
		StringBuffer tmp = new StringBuffer();
		tmp.ensureCapacity(src.length() * 6);
		for (i = 0; i < src.length(); i++) {
			j = src.charAt(i);
			if (Character.isDigit(j) || Character.isLowerCase(j)
					|| Character.isUpperCase(j))
				tmp.append(j);
			else if (j < 256) {
				tmp.append("%");
				if (j < 16)
					tmp.append("0");
				tmp.append(Integer.toString(j, 16));
			} else {
				tmp.append("%u");
				tmp.append(Integer.toString(j, 16));
			}
		}
		return tmp.toString();
	}	
    
    /**
     * 把字符中的html特殊符号"<",">"换成对应的转义符
     *
     * @param s String	字符串
     * @return String
     */
    public static final String escapeHTMLTags(String s) {
        if (s == null)
            return null;
        int i = 0;
        int j = 0;
        char ac[] = s.toCharArray();
        int k = ac.length;
        StringBuffer stringbuffer = new StringBuffer((int) ((double) k * 1.3D));
        for (; i < k; i++) {
            char c = ac[i];
            if (c > '>')
                continue;
            if (c == '<') {
                if (i > j)
                    stringbuffer.append(ac, j, i - j);
                j = i + 1;
                stringbuffer.append(LT_ENCODE);
                continue;
            }
            if (c != '>')
                continue;
            if (i > j)
                stringbuffer.append(ac, j, i - j);
            j = i + 1;
            stringbuffer.append(GT_ENCODE);
        }

        if (j == 0)
            return s;
        if (i > j)
            stringbuffer.append(ac, j, i - j);
        return stringbuffer.toString();
    }

    /**
     * 把字符串的"\n","\r\n"换成hmtl标签
     *
     * @param s String
     * @return String
     */
    public static String convertNewlines(String s) {
        char ac[] = s.toCharArray();
        int i = 0;
        int j = ac.length;
        StringBuffer stringbuffer = new StringBuffer(j);
        for (int k = 0; k < j; k++) {
            if (ac[k] == '\n') {
                stringbuffer.append(ac, i, k - i).append(BR_TAG);
                i = k + 1;
                continue;
            } else if (ac[k] == '\r' && k < j - 1 && ac[k + 1] == '\n') {
                stringbuffer.append(ac, i, k - i).append(BR_TAG);
                i = ++k + 1;
            }
        }

        stringbuffer.append(ac, i, j - i);
        return stringbuffer.toString();
    }

    /**
     * 作些相应的转化成sql字符串
     *
     * @param s  String		要转换的字符串
     * @param s1 String		like的主体
     * @return String
     */
    public static String getTranslateStr(String s, String s1) {
        String s2 = "";
        if (s.indexOf(" ") > 0) {
            boolean flag = true;
            String as[] = s.split(" ");
            for (int i = 0; i < as.length; i++) {
                if (as[i].equals("AND") || as[i].equals("&")) {
                    s2 = s2 + " and ";
                    flag = true;
                    continue;
                }
                if (as[i].equals("OR") || as[i].equals("|")) {
                    s2 = s2 + " or ";
                    flag = true;
                    continue;
                }
                if (as[i].equals("NOT") || as[i].equals("!") || as[i].equals("！")) {
                    s2 = s2 + " not ";
                    flag = true;
                    continue;
                }
                if (as[i].equals("(") || as[i].equals("（") || as[i].equals("（")) {
                    s2 = s2 + " ( ";
                    flag = true;
                    continue;
                }
                if (as[i].equals(")") || as[i].equals("）") || as[i].equals("）")) {
                    s2 = s2 + " ) ";
                    flag = true;
                    continue;
                }
                if ("".equals(as[i]))
                    continue;
                if (!flag)
                    s2 = s2 + " and ";
                if (as[i].indexOf("%") > 0)
                    s2 = s2 + " " + s1 + " like '" + as[i].replaceAll("'", "''") + "' ";
                else
                    s2 = s2 + " " + s1 + " like '%" + as[i].replaceAll("'", "''") + "%' ";
                flag = false;
            }

            return s2;
        }
        if (s.indexOf("%") > 0)
            s2 = s2 + " " + s1 + " like '" + s.replaceAll("'", "''") + "' ";
        else
            s2 = s2 + " " + s1 + " like '%" + s.replaceAll("'", "''") + "%' ";
        return s2;
    }

    /**
     * 对字符串进行html过滤
     *
     * @param s String
     * @return String
     */
    public static String toHtmlInput(String s) {
        if (s == null) {
            return null;
        } else {
            String s1 = new String(s);
            s1 = replace(s1, "&", "&amp;");
            s1 = replace(s1, "<", "&lt;");
            s1 = replace(s1, ">", "&gt;");
            s1 = replace(s1, "\"", "&quot;");
            s1 = replace(s1, "'", "''");
            return s1;
        }
    }

    /**
     * 把字符串转换成html字符串
     *
     * @param s String
     * @return String
     */
    public static String toHtml(String s) {
        if (s == null) {
            return null;
        } else {
            String s1 = new String(s);
            s1 = toHtmlInput(s1);
            s1 = replace(s1, "\r\n", "\n");
            s1 = replace(s1, "\n", "<br>\n");
            s1 = replace(s1, "\t", "    ");
            s1 = replace(s1, "  ", " &nbsp;");
            return s1;
        }
    }

    /**
     * 将string 转换为int
     *
     * @param str 要转换的字符串
     * @return int
     */
    public static int StringToInt(String str) {
        if (str == null) {
            return 0;
        }
        return (Integer.valueOf(str.trim())).intValue();
    }

    /**
     * 返回要截取的字符串中的分量数
     *
     * @param sz_theChar   String	要截取的字符串
     * @param sz_Separator String	分隔符
     * @return int
     *         eg:
     *         若sz_theChar="1,2,3,4";sz_Separator=",";那么就返回4
     */
    public static int getCharTolNum(String sz_theChar, String sz_Separator) {
        return sz_theChar.split(sz_Separator).length;
    }

    /**
     * 返回要截取的字符串中的分量数
     *
     * @param sz_theChar   String	要截取的字符串
     * @param sz_Separator String	分隔符
     * @return String[]
     *         eg:
     *         若sz_theChar="1,2,3,4";sz_Separator=",";那么就返回String[]={"1","2","3","4"}
     */
    public static String[] getSepStr(String sz_theChar, String sz_Separator) {
        return sz_theChar.split(sz_Separator);
    }

    /**
     * 返回要截取的字符串中的分量
     *
     * @param sz_theChar   String	要截取的字符串
     * @param sz_Separator String	分隔符
     * @param i_CharNum    String	要取得的字符串位置
     * @return String
     *         eg:
     *         若sz_theChar="1,3,2,4";sz_Separator=",";i_CharNum=2;那么就返回"3"
     */
    public static String getSeparatorChar(String sz_theChar, String sz_Separator, int i_CharNum) {
        String[] str = sz_theChar.split(sz_Separator);
        return str[i_CharNum - 1];
    }

    /**
     * 将月份的格式由数字转换成英文简拼
     *
     * @param i_theMonth int		数字格式的月份
     * @return String
     */
    public static String convertMonthToChar(int i_theMonth) {
        String sz_theChar = "";
        String charMonth[] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        switch (i_theMonth) {
            case 1:
                sz_theChar = charMonth[0];
                break;
            case 2:
                sz_theChar = charMonth[1];
                break;
            case 3:
                sz_theChar = charMonth[2];
                break;
            case 4:
                sz_theChar = charMonth[3];
                break;
            case 5:
                sz_theChar = charMonth[4];
                break;
            case 6:
                sz_theChar = charMonth[5];
                break;
            case 7:
                sz_theChar = charMonth[6];
                break;
            case 8:
                sz_theChar = charMonth[7];
                break;
            case 9:
                sz_theChar = charMonth[8];
                break;
            case 10:
                sz_theChar = charMonth[9];
                break;
            case 11:
                sz_theChar = charMonth[10];
                break;
            case 12:
                sz_theChar = charMonth[11];
                break;
            default:
                break;
        }
        return sz_theChar;
    }

    /**
     * 转换字符串中间的分隔符(主要用于sql子语句in(xx,xx))
     *
     * @param szAllString  String    需要转换的字符串       <p>
     * @param iFlag        int       1 用引号 0 不用引号    <P>
     * @param szCharFirst  String    被替换的字符           <p>
     * @param szCharSecond String    替换为的字符           <P>
     * @return String                     替换以后的字符串       <P>
     */
    public static String getRecombineStr(String szAllString, int iFlag, String szCharFirst, String szCharSecond) {
        String szReformString = "";
        // String szTempString = "" ;
        int iIndexOf = 0;
        // iFlag==1 varchar , iFlag==0 number
        // szCharFirst 初始分隔符
        // szCharSecond 重组后的分隔符
        if (szAllString == null || (szAllString != null && (szAllString.trim()).equals(""))) {
            return "";
        }
        /*if (iFlag=='')
        {
            iFlag = 1;
        }*/
        if (szCharFirst == null || (szCharFirst != null && (szCharFirst.trim()).equals(""))) {
            szCharFirst = ";";
        }
        if (szCharSecond == null || (szCharSecond != null && (szCharSecond.trim()).equals(""))) {
            szCharSecond = ",";
        }
        if (szAllString != null && szAllString.startsWith(";")) {
            szAllString = szAllString.substring(1);
        }
        iIndexOf = szAllString.indexOf(szCharFirst);
        if (iIndexOf == -1) {
            szReformString = szAllString;
            if (iFlag == 1) {
                szReformString = "'" + szReformString + "'";
            }
            return szReformString;
        }
        if (szAllString.endsWith(";") == false) {
            szAllString = szAllString + ";";
        }
        for (int i = 0; ; i++) {
            iIndexOf = szAllString.indexOf(szCharFirst);
            if (iIndexOf == -1) {
                break;
            }
            if (iFlag == 1) {
                szReformString = szReformString + "'" + szAllString.substring(0, iIndexOf) + "'" + "" + szCharSecond + "";
            } else {
                szReformString = szReformString + szAllString.substring(0, iIndexOf) + "" + szCharSecond + "";
            }

            szAllString = szAllString.substring((iIndexOf + 1), szAllString.length());
        }
        if (szReformString != null && szReformString.startsWith(szCharSecond)) {
            szReformString = szReformString.substring(1);
        }
        if (szReformString != null && szReformString.endsWith(szCharSecond)) {
            szReformString = szReformString.substring(0, szReformString.length() - 1);
        }
        //bug("szReformString="+szReformString) ;
        return szReformString;
    }

    /**
     * 适用varchar,date(实体中对应类型是String)
     *
     * @param htSource Hashtable	数据结果集
     * @param szValue  String 键值名称
     * @return String
     * @throws Exception
     */
    public static String getHashtableValue(Hashtable htSource, String szValue)
            throws Exception {
        if (htSource == null)
            return "";
        String szGetVal = (String) htSource.get(szValue);
        if (szGetVal == null)
            szGetVal = "";
        else
            szGetVal = szGetVal.trim();
        //new
        return szGetVal;
    }

    /**
     * 适用long,int,float,double
     *
     * @param htSource Hashtable	数据结果集
     * @param szValue  String 键值名称
     * @return String
     * @throws Exception
     */
    public static String getNotStrHashtableValue(Hashtable htSource, String szValue)
            throws Exception {
        if (htSource == null)
            return "0";
        String szGetVal = (String) htSource.get(szValue);
        if (szGetVal == null)
            szGetVal = "0";
        else
            szGetVal = szGetVal.trim();
        return szGetVal;
    }

    /**
     * 截取一定长度的字符串
     *
     * @param str String 源字符串
     * @param len int	 长度
     * @return String
     */
    public static String getSubString(String str, int len) {
        int i = str.length();
        if (i <= len) {
            return str;
        } else {
            return str.substring(0, len) + "...";
        }
    }

    /**
     * 截取一定长度的字符串
     *
     * @param str String 源字符串
     * @param len int	 长度
     * @return String
     */
    public static String getSubLenString(String str, int len) {
        int i = str.length();
        if (i <= len) {
            return str;
        } else {
            return str.substring(0, len) + "<br>" + getSubLenString(str.substring(len), len);
        }
    }

    /**
     * 替换ORACLE SQL中所用到String型参数中的单引号和'&'符号
     *
     * @param strSrc String		源字符串
     * @return String
     */
    public static final String formatOraSql(String strSrc) {
        if (strSrc == null) {
            return null;
        }
        if ("".equals(strSrc)) {
            return strSrc;
        }
        strSrc = replace(strSrc, "'", "''");
        //strSrc=replace(strSrc,"&","'||'&'||'");
        return strSrc;
    }

    /**
     * 判断字符串是否在源字符串已经存在
     *
     * @param source 源字符串
     * @param curStr 要判断的字符串
     * @param sep    分隔符
     * @return boolean
     */
    public static boolean isInStr(String source, String curStr, String sep) {
        if (isNull(source)) {
            return false;
        } else {
            String[] str = source.split(sep);
            for (int i = 0; i < str.length; i++) {
                if (curStr.equals(str[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断字符串是否为空或""
     *
     * @param str
     * @return boolean
     */
    public static boolean isNull(String str) {
        if (str == null || str.trim().equals("") || str.toLowerCase().equals("null")) {
            return true;
        } else {
            return false;
        }
    }


    /*
             * 转换大小写
             */
    private String ConvertSumTotal(String sz_Number, int i_Type) {
        String sz_RtnSumTol = "";
        String sz_Temp = "";
        String charSum[] = null;

        if (sz_Number.equals("")) return sz_RtnSumTol;
        if (i_Type == 0) {
            charSum = new String[]{"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖", "拾"};
        } else if (i_Type == 1) {
            charSum = new String[]{"○", "一", "二", "三", "四", "五", "六", "七", "八", "九", "十"};
        } else {
            charSum = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ""};
        }
        for (int i = 0; i < sz_Number.length(); i++) {
            sz_Temp = sz_Number.substring(i, i + 1);
            if (!sz_Temp.equals(".")) {
                sz_RtnSumTol = sz_RtnSumTol + charSum[Integer.parseInt(sz_Temp)];
            } else {
                sz_RtnSumTol = sz_RtnSumTol + ".";
            }
        }
        return sz_RtnSumTol;
    }

    /**
     * 空字符串处理
     */
    public static String NullToBlank(String s) {
        if ((s == null) || "".equals(s) || "null".equals(s)) {
            return "";
        } else {
            return s;
        }
    }

    /**
     * 空字符串处理,如果为空返回0
     */
    public static String isZero(String s) {
        if ((s == null) || "".equals(s) || "null".equals(s)) {
            return "0";
        } else {
            return s;
        }
    }

    public static String NullBlankToNbsp(String s) {
        if (s == null) {
            return "&nbsp;";
        } else if (s.trim().equals("")) {
            return "&nbsp;";
        } else {
            return s;
        }
    }

    public static String trimNull(float num) {

        if (num == 0.0) {

            return "";
        }
        return String.valueOf(num);
    }

    public static float trimTo(String num) {

        if (num.trim().equals("")) {

            return 0;
        }
        return new Float(num).floatValue();
    }

    public static String NullToBlanPercent(String s) {
        if (s == null) {
            return "";
        } else {
            return s + "%";
        }
    }

    /**
     * 符号分隔字符串
     *
     * @param str  字符串数组
     * @param sign 分隔符号
     *             例:str[] = {"张三","李四","王二"}	sign=@
     * @return 张三@李四@王二
     */
    public static String signCompartStr(String[] str, String sign) {
        String signStr = "";
        if (str.length > 0) {
            for (int i = 0; i < str.length; i++) {

                if (!(str[i].trim()).equals("")) {

                    signStr = signStr + str[i] + sign;
                }
            }

            if (signStr.length() > sign.length()) {

                signStr = signStr.substring(0, (signStr.length() - sign.length()));
            }

        }
        return signStr;
    }

    public static void main(String[] args) {
/*
			 String ss="<div style='font-size:9pt;font-family:宋体,Verdana,Arial;Color:#000000;'><P>\n" +
                     "<IMG src=\"http://10.96.20.250:8888/business/com.asiainfo.boss.ngcs.base.ftp.out.ActionDcmntFtp?action=doDown&amp;TYPE=IMG&amp;DOCUMENT_ID=1000000253\"></P> <P>\n" +
                     "<IMG height=18 src=\"http://10.96.20.250:8888/theme/classicalblue/images/ngcs/startmenu/icons2/pic_411.png\" width=18>\n" +
                     "<A href=\"http://10.96.20.250:8888/business/com.asiainfo.boss.ngcs.base.ftp.out.ActionDcmntFtp?action=doDown&amp;TYPE=OTHER&amp;DOCUMENT_ID=1000000254\">3问题沟通及实现情况汇总表11.13.xls</A></P> <P>\n" +
                     "<IMG height=18 src=\"http://10.96.20.250:8888/theme/classicalblue/images/ngcs/startmenu/icons2/pic_427.png\" width=18>\n" +
                     "<A href=\"http://10.96.20.250:8888/business/com.asiainfo.boss.ngcs.base.ftp.out.ActionDcmntFtp?action=doDown&amp;TYPE=OTHER&amp;DOCUMENT_ID=1000000255\">地市编码.txt</A></P></div>";
			 String sign = "com.asiainfo.boss.ngcs.base.ftp.out.ActionDcmntFtp?action=doDown";
             Integer[] ret = indexsOf(ss,sign);
             for(int i=0;i<ret.length;i++){
			    System.out.println(ss.substring(ret[i].intValue(),ret[i].intValue()+107));
             }
*/
        try {
            String[] ss = StringUtil.filterParentCode("000,000104,000108 ,000104001,000107002,000107005,000107008,000107011,000108001,000104002 ,000107001 ,000107003 ,000107004 ,000107006 ,000107007 ,000107009 ,000107010 ,000107012 ,000104000001,000104000004,000104000007,000104000010,000104000014,000104000019,000104000022,000104000041,000104001003,000104001007,000104001010,000104001013,000104001016,000104001019,000104002001,000104002005,000104002007,000104002009,000104002011,000104002015,000104000003 ,000104000005 ,000104000006 ,000104000008 ,000104000009 ,000104000012 ,000104000013 ,000104000015 ,000104000018 ,000104000020 ,000104000021 ,000104000023 ,000104000024 ,000104000042 ,000104000043 ,000104001001 ,000104001002 ,000104001005 ,000104001006 ,000104001008 ,000104001009 ,000104001011 ,000104001012 ,000104001014 ,000104001015 ,000104001017 ,000104001018 ,000104001050 ,000104002002 ,000104002003 ,000104002006 ,000104002008 ,000104002010 ,000104002012 ,000104002013 ,000104002014 ,000104002003001,000104002006002,000104002006005,000104002007003,000104002007006,000104002007009,000104002008002,000104002009003,000104002010001,000104002010004,000104002011003,000104002012001,000104002012004,000104002013002,000104002013005,000104002014001,000104002014004,000104002014007,000104002014010,000104002014013,000104002014016,000104002014019,000104002015003,000104002015006,000104002015009,000104002015012,000104002003002 ,000104002003003 ,000104002006001 ,000104002006003 ,000104002006004 ,000104002006006 ,000104002006007 ,000104002007001 ,000104002007002 ,000104002007004 ,000104002007005 ,000104002007007 ,000104002007008 ,000104002008001 ,000104002008003 ,000104002008004 ,000104002009001 ,000104002009002 ,000104002009004 ,000104002010002 ,000104002010003 ,000104002010005 ,000104002010006 ,000104002011001 ,000104002011002 ,000104002011004 ,000104002012002 ,000104002012003 ,000104002013001 ,000104002013003 ,000104002013004 ,000104002013006 ,000104002014002 ,000104002014003 ,000104002014005 ,000104002014006 ,000104002014008 ,000104002014009 ,000104002014011 ,000104002014012 ,000104002014014 ,000104002014015 ,000104002014017 ,000104002014018 ,000104002014020 ,000104002014021 ,000104002015001 ,000104002015002 ,000104002015004 ,000104002015005 ,000104002015007 ,000104002015008 ,000104002015010 ,000104002015011");
            for (String s : ss) {
                System.out.println(s);
            }
        } catch (Exception e) {
            log.error(e);
        }
    }


    /**
     * 在字符左边填充或截断的字符串，使其达到固定的长度
     *
     * @param srcStr
     * @param num
     * @param ch
     * @return
     */
    public static String lpad(String srcStr, int num, char ch) {
        String destStr = srcStr;
        if (srcStr.length() > num) {
            destStr = srcStr.substring(srcStr.length() - num);
        } else if (srcStr.length() < num) {
            StringBuffer strBuf = new StringBuffer(16);
            for (int i = 0; i < num - srcStr.length(); i++) {
                strBuf.append(ch);
            }
            destStr = strBuf.toString() + srcStr;
        }
        return destStr;
    }


    /**
     * Code shared by String and StringBuffer to do searches. The
     * source is the character array being searched, and the target
     * is the string being searched for.
     */
    public static Integer[] indexsOf(String s_source, String s_target) {

        char[] source = s_source.toCharArray();
        int sourceOffset = 0;
        int sourceCount = source.length;
        int fromIndex = 0;
        char[] target = s_target.toCharArray();
        int targetCount = target.length;
        int targetOffset = 0;


        ArrayList ret = new ArrayList();
        if (fromIndex >= sourceCount) {
            return null;
        }
        if (fromIndex < 0) {
            fromIndex = 0;
        }
        if (targetCount == 0) {
            return null;
        }

        char first = target[targetOffset];
        int max = sourceOffset + (sourceCount - targetCount);

        for (int i = sourceOffset + fromIndex; i <= max; i++) {
            /* Look for first character. */
            if (source[i] != first) {
                while (++i <= max && source[i] != first) ;
            }

            /* Found first character, now look at the rest of v2 */
            if (i <= max) {
                int j = i + 1;
                int end = j + targetCount - 1;
                for (int k = targetOffset + 1; j < end && source[j] ==
                        target[k]; j++, k++)
                    ;

                if (j == end) {
                    /* Found whole string. */
                    ret.add(new Integer(i - sourceOffset));
                }
            }
        }
        if (ret.size() > 0) {
            return (Integer[]) ret.toArray(new Integer[0]);
        } else {
            return null;
        }
    }


    public static boolean isInStringArrayExist(String[] slist, String sk) throws Exception {
        if (null != slist && null != sk) {
            for (int i = 0; i < slist.length; i++) {
                if (slist[i].trim().equals(sk.trim())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isNotInStringArray(String[] s, String value) {
        for (int i = 0; i < s.length; i++) {
            if (value.equalsIgnoreCase(s[i])) return false;
        }
        return true;
    }

    /**
     * 将"1,3,45,123..."格式的字符串转换为long数组,中间出现的非法字符将被忽略
     * 如果传入str为null或者""，将返回长度为0的long数组
     *
     * @param str
     * @param splitstr
     * @return
     */
    public static long[] split2longArray(String str, String splitstr) {
        if (isEmpty(str)) {
            return new long[0];
        }
        String[] items = split(str, splitstr);
        List l = new ArrayList();
        for (int i = 0; i < items.length; i++) {
            if (isNotEmpty(str)) {
                l.add(items[i]);
            }
        }
        long[] result = new long[l.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = Long.parseLong((String) l.get(i));
        }
        return result;
    }

    public static String replaceSpecialStr(String srcStr) {
        String replacedStr = srcStr;
        replacedStr = replaceChars(replacedStr, "<", " ");
        replacedStr = replaceChars(replacedStr, ">", " ");
        replacedStr = replaceChars(replacedStr, "&", " ");
        replacedStr = replaceChars(replacedStr, "'", " ");
        replacedStr = replaceChars(replacedStr, "'\"", " ");
        replacedStr = replaceChars(replacedStr, "'\\", " ");
        replacedStr = replaceChars(replacedStr, "'\n", " ");
        return replacedStr;
    }


   /* public static String filterExpireAttrValue(String attrValue) throws Exception {
        if (attrValue == null)
            return null;
        Timestamp sysdate = DateTimeUtil.getDefaultSysDate();
        String[] itemLines = StringUtil.splitByWholeSeparator(attrValue, ";");
        StringBuffer attrSB = new StringBuffer();
        for (int i = 0; i < itemLines.length; i++) {
            String[] items = StringUtil.splitByWholeSeparator(itemLines[i], "|");
            if (items.length >= 4) {
                String replaceStr = itemLines[i];
                DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                Timestamp endDate = new Timestamp(format.parse(items[2]).getTime());
                if (endDate.getTime() >= sysdate.getTime()) {
                    attrSB.append(itemLines[i]).append(";");
                }
            } else {
                if (!"".equals(itemLines[i]))
                    attrSB.append(itemLines[i]).append(";");
            }
        }
        String filteredStr = attrSB.toString();
        if (!"".equals(filteredStr) && filteredStr.endsWith(";"))
            filteredStr = filteredStr.substring(0, filteredStr.length() - 1);
        return filteredStr;
    }*/


    public static String iso2gbk(String str) {
        if (isBlank(str)) {
            return str;
        }
        try {
            String reStr = new String(str.trim().getBytes("ISO-8859-1"), "GB2312");
            return reStr.replaceAll("@~", "\\\n");
        } catch (Exception e) {
        	 log.error(e);
        }
        return str;
    }

    public static String[] getSplitByDou(String s) {
        s = s.trim().replaceAll("，", ",");
        String[] res = s.split(",");
        if (null != res) {
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i].trim();
            }
        }
        return res;
    }

    /**
     * 转换@~
     *
     * @param
     * @return
     * @throws Exception
     * @throws RemoteException
     * @author zhanggr
     */
    public static String transferText(String text) throws Exception, RemoteException {
        if (text != null) {

            return text.replaceAll("@~", "\r\n");
        }
        return text;
    }

    public static String[] filterParentCode(String orgs) {
        String[] temp = orgs.split(",");
        return temp;

/*
        if(null != temp && temp.length>0){
            ArrayList<String> sortList = new ArrayList();
            for(String s:temp){
                if(sortList.size()==0){
                    sortList.add(s);
                    continue;
                }
                int i=0;
                for(i=0;i<sortList.size();i++){
                    if(s.length()<sortList.get(i).length()){
                        sortList.add(i,s);
                        break;
                    }
                }
                if(i==sortList.size()){
                    sortList.add(s);
                }
            }
            ArrayList<String> tempList = new ArrayList();
            boolean isin= false;
            for(String org:sortList){
                isin = false;
                for(String adds:tempList){
                    if(org.indexOf(adds)==0){
                        isin = true;
                        break;
                    }
                }
                if(!isin)
                    tempList.add(org);
            }
            return (String[])tempList.toArray(new String[0]);
        }

        return null;
*/
    }

    public static final byte[] compress(String str) {
        if (str == null)
            return null;

        byte[] compressed;
        ByteArrayOutputStream out = null;
        ZipOutputStream zout = null;

        try {
            out = new ByteArrayOutputStream();
            zout = new ZipOutputStream(out);
            zout.putNextEntry(new ZipEntry("0"));
            zout.write(str.getBytes());
            zout.closeEntry();
            compressed = out.toByteArray();
        } catch (IOException e) {
        	 log.error(e);
            compressed = null;
        } finally {
            if (zout != null) {
                try {
                    zout.close();
                } catch (IOException e) {
                	 log.error(e);
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                	 log.error(e);
                }
            }
        }
        return compressed;
    }


    public static final String decompress(byte[] compressed) {
        if (compressed == null)
            return null;

        ByteArrayOutputStream out = null;
        ByteArrayInputStream in = null;
        ZipInputStream zin = null;
        String decompressed;
        try {
            out = new ByteArrayOutputStream();
            in = new ByteArrayInputStream(compressed);
            zin = new ZipInputStream(in);
            ZipEntry entry = zin.getNextEntry();
            byte[] buffer = new byte[1024];
            int offset = -1;
            while ((offset = zin.read(buffer)) != -1) {
                out.write(buffer, 0, offset);
            }
            decompressed = out.toString();
        } catch (IOException e) {
        	 log.error(e);
            decompressed = null;
        } finally {
            if (zin != null) {
                try {
                    zin.close();
                } catch (IOException e) {
                	 log.error(e);
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                	 log.error(e);
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                	 log.error(e);
                }
            }
        }

        return decompressed;
    }

    public static String add(String str1,String str2){
    	return str1+str2;
    }

    public static String getUUID(){
        String uuid = UUID.randomUUID().toString();
        //去除"-"符号
        return uuid.replaceAll("-", "");
    }
    
    /**
	 * <p>判断一组字符串中是否有 null 或者空值</p>
	 *
	 * @param arg0
	 * @param arg1
	 * @param strs2  一组字符串
	 *
	 * @return 若一组字符串中的任何一个是 null 或者空值时返回 true，否则返回 false
	 *
	 */
	public static boolean isBlank(String arg0, String arg1, String... args) {
		if (isBlank(arg0) || isBlank(arg1)) {
			return true;
		}
		if (args == null) {
			return true;
		}
		for (int i = 0; i < args.length; i++) {
			if (isBlank(args[i])) {
				return true;
			}
		}
		return false;
	}

	/**
	 * <p>判断数值对象是否为空</p>
	 */
	public static boolean isBlank(Number number) {
		return (number == null);
	}

	/**
	 * <p>判断集合是否为 null 或者是空值</p>
	 */
	public static boolean isBlank(Collection<?> collection) {
		return (collection == null || collection.size() == 0);
	}

	/**
	 * <p>判断 Map 是否为 null 或者是空值</p>
	 */
	public static boolean isBlank(Map<?, ?> map) {
		return (map == null || map.size() == 0);
	}

	/**
	 * <p>判断对象数组是否为 null 或者是空</p>
	 */
	public static boolean isBlank(Object[] objs) {
		return (objs == null || objs.length == 0);
	}
	
	public static String objToStr(Object obj) {
		String ret = "";
		if (obj == null) {
			return "";
		}
		ret = String.valueOf(obj);
		if (ret == null || ret.trim().length() == 0 || "null".equals(ret)) {
			ret = "";
		}
		return ret;
	}
}

