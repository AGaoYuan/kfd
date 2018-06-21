package cn.cms.test;

import cn.cms.manager.NewsManager;

/**
 * 测试类
 * @author 21600
 *
 */
public class Test {

	public static void main(String[] args) {
		//创建
		NewsManager nm = new NewsManager();
		try {
			//调用对象
			nm.toHtml();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		

	}

}
