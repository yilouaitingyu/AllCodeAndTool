package cn.huchao.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 复制mp3文件到一个文件夹内
 * @author 胡超
 *
 */
public class CopyTest {
	public static void main(String[] args) throws IOException  {
		File file1=new File("F:\\我的音乐\\Download");
		File file2=new File("F:\\我的音乐\\new_mp3");
		File[] files = file1.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				File[] files2 = file.listFiles();
				for (File file3 : files2) {
					if (file3.isFile()&&file3.getName().endsWith(".mp3")) {
						FileInputStream fis =new FileInputStream(file3);
						FileOutputStream fos =new FileOutputStream(new File(file2.getAbsolutePath(),file3.getName()));
						byte[] b=new byte[1024];
						int len=0;
						while ((len=fis.read(b))!=-1) {
							fos.write(b, 0, len);
						}
						fis.close();
						fos.close();
					}
				}
			}
		}
	}
}
