package cn.huchao.test;

import java.io.File;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import cn.huchao.utils.MyMethods;

/**
 * @author huchao
 *	@2017年8月25日
 *	@description
 *	
 */
public class Pra1 {
	/**
	 * @description
	 *	清除文件里的所有以.lastUpdated结尾的文件
	 *@2017年8月25日
	 *@author huchao
	 */
	@Test
	public void function1() {
		File file  =new File("D:\\ChinaMobile\\repository");
		List<File> findFileList = MyMethods.findFileList(file);
		for (File file2 : findFileList) {
			//String absolutePath = file2.getAbsolutePath();
			String name = file2.getName();
			if (name.endsWith(".lastUpdated")) {
				//boolean delete = file2.delete();
				System.out.println(name);
				//System.out.println(delete);
			}
		}
	}
	public static void main(String[] args) {
	/*	int i =56/200;
		System.out.println(i);*/
		System.out.println("你好世界");
	}
}

