package cn.huchao.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyMethodsTest {
	/**
	 * 统计一个字符串的各个字母出现的次数
	 * 
	 * @param str
	 * @return
	 */
	public static Map<Character, Integer> characterNumber(String str) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		Character c;
		for (int i = 0; i < str.length(); i++) {
			c = str.charAt(i);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		return map;
	}

	/**
	 * 找到传入文件里的所有文件集合
	 * 
	 * @param file文件
	 * @return list集合
	 */
	public static void findFileList(File file, List<File> fileList) {
		if (file.isFile()) {
			fileList.add(file);
		} else if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (File file2 : files) {
				// 循环遍历，递归调用
				findFileList(file2, fileList);
			}
		}
	}

	/**
	 * 复制指定文件内的指定格式的文件到指定位置
	 * 
	 * @param str
	 *            指定格式
	 * @param fromFile
	 *            原文件
	 * @param toDirectory
	 *            目标文件夹
	 * @throws IOException
	 */
	public static void copyPattern2Directory(String str, File fromFile,
			File toDirectory) throws IOException {
		List<File> fileList = new ArrayList<File>();
		findFileList(fromFile, fileList);
		for (File file2 : fileList) {
			String str1 = "." + str;
			if (file2.getName().endsWith(str1)) {
				InputStream fis = new FileInputStream(file2);
				OutputStream fos = new FileOutputStream(toDirectory + "\\"
						+ file2.getName());
				int len = 0;
				byte[] b = new byte[1024 * 5];
				while ((len = fis.read(b)) != -1) {
					fos.write(b, 0, len);
				}
				fis.close();
				fos.close();
			}
		}
		System.out.println("copy指定格式完成");
	}

	/**
	 * 加密一个文件（非文件夹文件 秘钥是9）
	 * 
	 * @param fromFile
	 * @param toDirectory
	 * @throws IOException
	 */
	public static void encryptFile(File fromFile, File toDirectory) throws IOException {
		if (fromFile.isFile()) {
			FileInputStream fis = new FileInputStream(fromFile);
			FileOutputStream fos = new FileOutputStream(toDirectory + "\\加密文件_"
					+ fromFile.getName());
			int x = 0;
			while ((x = fis.read()) != -1) {
				x = x ^ 9;
				fos.write(x);
			}
			fis.close();
			fos.close();
		} else {
			System.out.println("错误：加密文件为文件夹,不可加密");
		}
		System.out.println("加密完成");
	}
	/**
	 * 对由这个工具加密的文件直接解密(加密的文件不做修改，文件名不修改)
	 * @param fromFile
	 * @param toDirectory
	 * @throws IOException
	 */
	public static void inverseEncrypt(File fromFile, File toDirectory) throws IOException{
		if (fromFile.isFile()) {
			FileInputStream fis = new FileInputStream(fromFile);
			FileOutputStream fos = new FileOutputStream(toDirectory + "\\解密文件_"
					+ fromFile.getName().substring(5));
			int x = 0;
			while ((x = fis.read()) != -1) {
				x = x ^ 9;
				fos.write(x);
			}
			fis.close();
			fos.close();
		} else {
			System.out.println("错误：解密文件为文件夹,不可加密");
		}
		System.out.println("解密完成");
	}
	/**
	 * 未写：文件转码，将gbk编码的文件转换成utf-8格式的文件
	 */
	
	

}
