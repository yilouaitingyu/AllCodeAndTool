package cn.huchao.test;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.junit.Test;

import cn.huchao.utils.MyMethods;

/**
 * @author huchao
 *	@description
 *删除指定文件夹下的指定格式的文件
 */
public class DeleteFileTest {
	@Test
	public void function1() {
		File file =new File("D:\\就业班最后课程\\删除文件");
		List<File> findFileList = MyMethods.findFileList(file);
		int count =0;
		for (File file2 : findFileList) {
			if ("itheima".equals(FilenameUtils.getExtension(file2.getName()))) {
				count++;
				file2.delete();
				System.out.println(count+"--||--"+file2.getName());
			}
		}
		
	}
}
