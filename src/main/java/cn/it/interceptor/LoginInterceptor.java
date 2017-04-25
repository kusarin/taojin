package cn.it.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 登陆拦截器.
 * 
 * @author wz
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
	private static final String[] IGNORE_URI = { "login.do", "/Itemlist.do",
			"/lookItem.do", "/lookshopItem.do", "/ItemType1.do",
			"/ItemType2.do", "/searchItem.do","/findResourceFile.do" ,
			"RF","anage","/updatepassword.do","SR","/findItem.do","/findShop.do"
			,"/findUser.do","/deleteComment.do","/lookComment.do","addUser.do"};
	private static final String[] M_URL = {"/findResourceFile.do" ,
		"RF","anage","/updatepassword.do","SR","/findItem.do","/findShop.do"
		,"/findUser.do","/deleteComment.do","/lookComment.do"};
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		boolean flag = false;
		boolean flagM = false;
		String url = request.getRequestURL().toString();
		System.out.println(">>>: " + url);
		for (String s : IGNORE_URI) {
			if (url.contains(s)) {
				flag = true;
				break;
			}
		}
		for (String s :M_URL){
			if (url.contains(s)) {
				flagM = true;
				break;
			}
		}
		if (!flag) {
			Object mySession = request.getSession().getAttribute("user");
			System.out.println(">>>: " + mySession);
			if (mySession != null) {
				flag = true;
			} else {
				response.sendRedirect("/Taojin/login.jsp");
			}
			return flag;
		}
		if (flagM){
			Object mySession = request.getSession().getAttribute("manager");
			if (mySession != null) {
				flagM = true;
			} else {
				response.sendRedirect("/Taojin/mlogin.jsp");
			}
			return flagM;
		}
		return flag;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}
}
