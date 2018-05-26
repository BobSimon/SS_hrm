package com.zhiqi.util;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

/**
 * Response工具类
 * @author zhiqi
 *
 */
public class ResponseUtil {

	public static void write(Object o,HttpServletResponse response)throws Exception{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.println(o.toString());
		out.flush();
		out.close();
	}
}
