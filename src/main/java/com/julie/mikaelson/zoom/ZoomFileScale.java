package com.julie.mikaelson.zoom;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZoomFileScale {
	
	public static void main(String[] args) {
		ZipFile("C:\\Users\\Public\\Pictures\\Sample Pictures\\1.jpg",
				"C:\\Users\\Public\\Pictures\\Sample Pictures\\1.zip");
	}
	

	/** 压缩单个文件*/
    public static void ZipFile(String filepath ,String zippath) {
    	try {
            File file = new File(filepath);
            File zipFile = new File(zippath);
            InputStream input = new FileInputStream(file);
            ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile));
            zipOut.putNextEntry(new ZipEntry(file.getName()));
            int temp = 0;
            while((temp = input.read()) != -1){
                zipOut.write(temp);
            }
            input.close();
            zipOut.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    /**  解压缩（解压缩单个文件）*/
    public static void ZipContraFile(String zippath ,String outfilepath ,String filename) {
		try {
	        File file = new File(zippath);//压缩文件路径和文件名
	        File outFile = new File(outfilepath);//解压后路径和文件名
	        ZipFile zipFile = new ZipFile(file);
	        ZipEntry entry = zipFile.getEntry(filename);//所解压的文件名
	        InputStream input = zipFile.getInputStream(entry);
	        OutputStream output = new FileOutputStream(outFile);
	        int temp = 0;
	        while((temp = input.read()) != -1){
	            output.write(temp);
	        }
	        input.close();
	        output.close();
	        zipFile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    /**  解压缩（压缩文件中包含多个文件）可代替上面的方法使用。
     * ZipInputStream类
     * 当我们需要解压缩多个文件的时候，ZipEntry就无法使用了，
     * 如果想操作更加复杂的压缩文件，我们就必须使用ZipInputStream类
     * */
    public static void ZipContraMultiFile(String zippath ,String outzippath){
    	try {
            File file = new File(zippath);
            File outFile = null;
            ZipFile zipFile = new ZipFile(file);
            ZipInputStream zipInput = new ZipInputStream(new FileInputStream(file));
            ZipEntry entry = null;
            InputStream input = null;
            OutputStream output = null;
            while((entry = zipInput.getNextEntry()) != null){
                System.out.println("解压缩" + entry.getName() + "文件");
                outFile = new File(outzippath + File.separator + entry.getName());
                if(!outFile.getParentFile().exists()){
                    outFile.getParentFile().mkdir();
                }
                if(!outFile.exists()){
                    outFile.createNewFile();
                }
                input = zipFile.getInputStream(entry);
                output = new FileOutputStream(outFile);
                int temp = 0;
                while((temp = input.read()) != -1){
                    output.write(temp);
                }
                input.close();
                output.close();
            }
            zipInput.close();
            zipFile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    
    /** 一次性压缩多个文件，文件存放至一个文件夹中*/
    public static void ZipMultiFile(String filepath ,String zippath) {
		try {
	        File file = new File(filepath);// 要被压缩的文件夹
	        File zipFile = new File(zippath);
	        InputStream input = null;
	        ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile));
	        if(file.isDirectory()){
	            File[] files = file.listFiles();
	            for(int i = 0; i < files.length; ++i){
	                input = new FileInputStream(files[i]);
	                zipOut.putNextEntry(new ZipEntry(file.getName() + File.separator + files[i].getName()));
	                int temp = 0;
	                while((temp = input.read()) != -1){
	                    zipOut.write(temp);
	                }
	                input.close();
	            }
	        }
	        zipOut.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
