package cn.cms.manager;

import java.util.List;

import cn.cms.dao.INewsDAO;
import cn.cms.dao.impl.NewsDAOImpl;
import cn.cms.entity.News;
import cn.cms.service.INewsService;
import cn.cms.service.impl.NewsServiceimpl;
import cn.cms.util.FileIO;

/**
 * 管理书籍类
 * @author 21600
 *
 */
public class NewsManager {
	
	/**
	 * 转换文件中的标签内容，并写入到硬盘上的html文件
	 * @throws Exception 异常
	 */
	public void toHtml() throws Exception{
		//创建读取对象
		FileIO fi = new FileIO();
		//指定路径
		String rf = fi.readFile("D:/上课使用/Java/S2230/workspace/cms/news.template");
		//创建Service层的实现类对象
		INewsService ind = new NewsServiceimpl();
		//调用读取数据库中News表中数据的方法
		List<News> fa = ind.findAll();
		//循环去替换文件中的内容
		for (int i = 0; i < fa.size(); i++) {
			News news = fa.get(i);
			String ss = new String();
			ss = rf;
			ss = ss.replace("{title}", news.getTitle());
			ss = ss.replace("{author}", news.getAuthor());
			ss = ss.replace("{createTime}", news.getCreateTime().toString());
			ss = ss.replace("{content}", news.getContent());
			//保存连接
			String filePath = "E:/news+"+i+".html";
			
			//写入硬盘
			fi.writeFile(filePath, ss);
		}
		
		
		
		
	}
	
}
