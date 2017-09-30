package cn.huchao.utils;

import java.io.File;
import java.util.List;

import org.junit.Test;

/**
 * @author huchao
 *	@description
 *
 */
public class DeleteFile {
	@Test
	public void function1() {
		File file =new File("D:\\MavenRepository");
		List<File> list = MyMethods.findFileList(file);
		for (File file2 : list) {
			if (file2.getName().endsWith(".lastUpdated")) {
				file2.delete();
			}
		}
	}
}
