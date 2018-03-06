package com.taskplz.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.MetadataException;
import com.drew.metadata.exif.ExifIFD0Directory;

public class UploadFileUtils {
	private static final Logger logger = LoggerFactory.getLogger(UploadFileUtils.class);
	
	public static String uploadFile(String uploadPath, 
							        String originalName, 
							        byte[] fileData)throws Exception{

		UUID uid = UUID.randomUUID();
		
		String savedName = uid.toString() +"_"+originalName;
		
		String savedPath = calcPath(uploadPath);
		
		File target = new File(uploadPath +savedPath,savedName);
		
		FileCopyUtils.copy(fileData, target);
		
		String formatName = originalName.substring(originalName.lastIndexOf(".")+1);
		
		String uploadedFileName = null;
		
		if(MediaUtils.getMediaType(formatName) != null){
		uploadedFileName = makeThumbnail(uploadPath, savedPath, savedName);
		}else{
		uploadedFileName = makeIcon(uploadPath, savedPath, savedName);
		}
		return uploadedFileName;
		
	}
	
	private static  String makeIcon(String uploadPath, 
		String path, 
		String fileName)throws Exception{
		
		String iconName = uploadPath + path + File.separator+ fileName;
		
		return iconName.substring(
		uploadPath.length()).replace(File.separatorChar, '/');
	}
	
	private static String calcPath(String uploadPath){
		Calendar cal = Calendar.getInstance();
		
		String yearPath = File.separator+cal.get(Calendar.YEAR);
		
		String monthPath = yearPath + File.separator + new DecimalFormat("00").format(cal.get((Calendar.MONTH)+1));
		
		String datePath = monthPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.DATE));
		
		makeDir(uploadPath, yearPath, monthPath, datePath);
		
		logger.info(datePath);
		
		return datePath;
	}
	
	private static void makeDir(String uploadPath, String... paths){
		if(new File(paths[paths.length-1]).exists()){
			return;
		}
		
		for(String path : paths){
			File dirPath=new File(uploadPath + path);
			if(!dirPath.exists()){
				dirPath.mkdir();
			}
		}
	}
	
	private static  String makeThumbnail(
            String uploadPath, 
            String path, 
            String fileName)throws Exception{
          
  BufferedImage sourceImg = 
      ImageIO.read(new File(uploadPath + path, fileName));
  
  BufferedImage destImg = 
      Scalr.resize(sourceImg, 
          Scalr.Method.AUTOMATIC, 
          Scalr.Mode.FIT_TO_WIDTH,350);
  
  String thumbnailName = 
      uploadPath + path + File.separator +"s_"+ fileName;
  
  File newFile = new File(thumbnailName);
  String formatName = 
      fileName.substring(fileName.lastIndexOf(".")+1);
  
  
  ImageIO.write(destImg, formatName.toUpperCase(), newFile);
  return thumbnailName.substring(
      uploadPath.length()).replace(File.separatorChar, '/');
} 

	public static int getOrientation(File in)
			throws IOException, MetadataException, ImageProcessingException{
		int orientation = 1;
		try {
			Metadata md = ImageMetadataReader.readMetadata(in);
			Directory directory = md.getFirstDirectoryOfType(ExifIFD0Directory.class);
			
			try {
				if(directory != null){
					orientation = directory.getInt(ExifIFD0Directory.TAG_ORIENTATION);
				}
			} catch (MetadataException me) {
				me.printStackTrace();
				return orientation;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orientation;
	}
	
}
