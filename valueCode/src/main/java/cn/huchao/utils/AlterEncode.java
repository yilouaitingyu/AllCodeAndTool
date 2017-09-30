package cn.huchao.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @author huchao
 * @date 2017年2月24日
 * @version 1.0 改变一个文件夹内的所有文本文件的编码
 */
public class AlterEncode {
	/**
	 * 改变编码,输入一个文件，将文件内的文本文档吧编码转换
	 * 
	 * @param fromDirectory
	 * @param toDirectory
	 * @param fromEncode
	 * @param toEncode
	 * @throws Exception
	 */
	public void alterEncode(File fromDirectory, File toDirectory, String fromEncode, String toEncode) throws Exception {
		List<File> fileList = new ArrayList<File>();
		String str =toDirectory.getAbsolutePath();
		MyMethods.findFileList(fromDirectory, fileList);
		for (File file : fileList) {
			// 不能使用filereader，因为没有指定编码集的构造方法，导致读取中文时有可能会出现乱码
			// BufferedReader reader =new BufferedReader(new );
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), fromEncode));
			// BufferedWriter writer = new BufferedWriter(new
			// FileWriter(toDirectory + "/" + file.getName()));
			String fileNotPath =getNotSameStr(file.getAbsolutePath(), fromDirectory.getAbsolutePath());
			String filePath =str+"/"+fileNotPath;
			System.out.println(filePath);
			File file1 = new File(filePath);
			File parent = file1.getParentFile();
			if (!parent.exists()) {
				parent.mkdirs();
			}
			FileOutputStream fos =new FileOutputStream(file1);
			BufferedWriter writer = new BufferedWriter(
					new OutputStreamWriter(fos, toEncode));
			String line = null;
			while ((line = reader.readLine()) != null) {
				// String str = new String(line.getBytes(fromEncode), toEncode);
				writer.write(line);
				writer.newLine();
			}
			reader.close();
			writer.close();
		}
		System.out.println("转换完成");

	}

	@Test
	public void test1() throws Exception {

		/*alterEncode(new File("C:/Users/胡超/Desktop/utils"), new File("C:/Users/胡超/Desktop/新建文件夹"), "GBK",
				"UTF-8");*/
		//要求，被转换的文件夹必须与转换后放置的文件在同一目录下
		File file =new File("C:/Users/Administrator/Desktop/gbk");
		File file2 =new File("C:/Users/Administrator/Desktop/utf-8");
		/*String path = file.getAbsolutePath();
		String path2 = file2.getAbsolutePath();
		String sameStr = getNotSameStr(path, path2);
		System.err.println(sameStr);*/
		alterEncode(file, file2, "GBK", "UTF-8");
		
	}
	//*第一个str2与第二个str1不一样的地方，返回的是第一个（注意不是第二个）
	public String getNotSameStr(String str1,String str2){
		String str="";
		if (str1.length()<=str2.length()) {
			str = str2.substring(str1.length()+1);
		}else{
			str = str1.substring(str2.length()+1);
		}
		return str;
	}
}
