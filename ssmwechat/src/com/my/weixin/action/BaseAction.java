package com.my.weixin.action;

import java.io.PrintWriter;
import java.math.BigDecimal;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;


public abstract class BaseAction{
	
	private int id;
	
	public ServletContext getServletContext() {
		return ServletActionContext.getServletContext();
	}

	public String getRealyPath(String path) {
		return getServletContext().getRealPath(path);
	}
	
	public HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}
	
	public HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}
	
	public HttpSession getSession() {
		return getRequest().getSession();
	}
	/**
	 * requset.getParameter
	 * @param name 键
	 * @return String 值
	 */
	public String getParam(String name){
		return getRequest().getParameter(name);
	}
	/**
	 * requset.getAttribute
	 * @param name 键
	 * @return Object
	 */
	public Object getAttr(String name){
		return getRequest().getAttribute(name);
	}
	/**
	 * request.setAttribute
	 * @param name 键
	 * @param o 值
	 */
	public void setAttr(String name,Object o){
		getRequest().setAttribute(name, o);
	}
	/**
	 * getFirstResult
	 * 设置开始的是第一条数据
	 * @return 第一条
	 */
	public Integer getFirstResult(){
		return (getPageNumber()-1)*getMaxResult() + 1;
	}
	/**
	 * getMaxResult
	 * 设置页面的条数
	 * @return 条数
	 */
	public Integer getMaxResult(){
		String max=getParam(MAXRESULT);
		return max==null?10:Integer.parseInt(max);
	}
	/**
	 * 获取当前第几页
	 * @return 第几页
	 */
	public Integer getPageNumber(){
		return getParam(PAGENUMBER)==null?1:Integer.parseInt(getParam(PAGENUMBER));
	}
	
	public void setCount(Integer count){
		setAttr(COUNT, count);
	}
	
	public Integer getCount(){
		Integer count=Integer.parseInt(getAttr(COUNT).toString());
		return count==null?0:count;
	}
	/**
	 * 获取当前分页总页数
	 * @return 当前查询的总页数
	 */
	public Integer getMax(){
		Integer max = 0;
		BigDecimal result = new BigDecimal(0);
		BigDecimal divisor = new BigDecimal(getCount());//除数，总条数
		BigDecimal dividend = new BigDecimal(getMaxResult());//被除数，每页条数
		
		//每页数不等于null 并且不为0
		if (!dividend.equals(new BigDecimal(0))) {
			result = divisor.divide(dividend,2,BigDecimal.ROUND_HALF_EVEN);//如果出现无限小数，会抛异常,规定精确度
		}
		try {
			max = (int)Math.ceil(Double.parseDouble(result.toString()));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return max;
	}
		
	protected void outJSONData(Object obj){
        PrintWriter out = null;
        try{
             getResponse().setContentType("text/javascript;charset=UTF-8");
             out = getResponse().getWriter();
             out.print(obj);
        }catch (Exception e) {
             e.printStackTrace();   
        }finally{
                if(out != null){
                   out.flush();
                   out.close();
                }
        }
	}
	
	protected void outStringData(String result){
		PrintWriter out = null;
		try {
			getResponse().setContentType("text/html; charset=utf-8");   
			getResponse().setHeader("Cache-Control", "no-cache");   
	        out = getResponse().getWriter();   
	        out.write(result);
			out.flush();   
		} catch (Exception e) {
			
		}finally{
			if(out != null){
				out.close();
			}
		}
	}
	
	protected void outJSONDataString(String str){
        PrintWriter out = null;
        try{
             getResponse().setContentType("text/json;charset=UTF-8");
             out = getResponse().getWriter();
             out.print(str);
        }catch (Exception e) {
             e.printStackTrace();   
        }finally{
                if(out != null){
                   out.flush();
                   out.close();
                }
        }
	}

	/**
	 * 对getParam方法
	 * 如果是空转换
	 * */
	public String getParamNotNnll(String name){
		return this.getParam(name)==null?"":this.getParam(name);
	}
	/**
	 * 当前页
	 */
	protected static final String PAGENUMBER="pageNumber";
	/**
	 * 每页条数
	 */
	protected static final String MAXRESULT="maxResult";
	/**
	 * 总条数
	 */
	protected static final String COUNT="count";
	/**
	 * 总页数
	 */
	protected static final String MAX="max";
	
	
	public static final String SUCCESS="success";
	public static final String INPUT="input";
	public static final String ERROR="error";
	public static final String LOGIN="login";
	public static final String NONE="none";

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
