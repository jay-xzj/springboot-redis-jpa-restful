package com.crm.login.impl;

import com.alibaba.fastjson.JSON;
import com.asiainfo.portal.framework.busiclient.DefaultPopedomImpl;
import com.asiainfo.portal.framework.busiclient.IPopedom;
import com.asiainfo.portal.framework.busiclient.LogUtil;
import com.asiainfo.portal.framework.busiclient.UserInfo;
import com.crm.comm.Result;
import com.crm.comm.ResultMsg;
import com.crm.comm.exception.ServiceException;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by SS on 2017/3/20.
 */
public class PopedomImpl extends DefaultPopedomImpl implements IPopedom {

    private final static String PORTAL_POPEDOMIMPL_SESSION = "PORTAL_POPEDOMIMPL_SESSION";
    public static String errPage = "";
   

    /**
     * 判断是否登陆
     *
     * @param request  HttpServletRequest
     * @param response HttpServletResponse
     * @return boolean
     */
    public boolean isLogin(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        if (session == null || session.getAttribute(PORTAL_POPEDOMIMPL_SESSION) == null) {
            return false;
        }

        return true;
    }

    /**
     * 外围系统本地实现
     *
     * @param request  HttpServletRequest
     * @param response HttpServletResponse
     * @return boolean
     * @paramoperInfoOperInfo
     */
    public boolean doSelfSession(HttpServletRequest request, HttpServletResponse response, UserInfo userInfo) {
        request.getSession().setAttribute(PORTAL_POPEDOMIMPL_SESSION, userInfo);
        request.getSession().setAttribute("user4aname", userInfo.getUserResAcct());
        return true;
    }
    
    @Override
    public void redirectPortalHome(HttpServletRequest request, HttpServletResponse response, String strPortalServerName){
    		   LogUtil.printLog((short)0, "redirect:" + strPortalServerName);
            //response.sendRedirect(strPortalServerName);
    		    response.setCharacterEncoding("UTF-8");
    	        response.setHeader("Content-type", "application/json;charset=UTF-8");
			Result result = new Result();
			result.setCode(250);
			result.setMessage("4A Authentication Failed");
			//throw new ServiceException("校验失败");			
			try {
				response.getWriter().write(JSON.toJSONString(result));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
			   			
      }

}
