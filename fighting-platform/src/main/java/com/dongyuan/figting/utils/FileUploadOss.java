package com.dongyuan.figting.utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.ObjectListing;
import com.aliyun.oss.model.ObjectMetadata;

public class FileUploadOss {
	
	private static String accessKey = "etvNKXqD9vxV2wDZ"; 
	private static String accessKeySecret = "7sg32TWuwVU3cqSpbCd63DCkRrnXML";
	private static String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";
	
	private static String dayFormat = "yyyyMMdd";
	
	private static OSSClient client = null;
	
	static{
		client = new OSSClient(endpoint,accessKey, accessKeySecret);
	}
	
	public static String uploadFile(String bucketName, MultipartFile file) throws IOException{
		String myFileName = file.getOriginalFilename();
		String fileName = generateOssKey(myFileName);
		
		Date date = new Date();
		String prefix  = new SimpleDateFormat(dayFormat).format(date);
		
		//按天创建文件夹
		createPrefixFilePath(bucketName, prefix);
		
		String key = StringCommUtils.connectArray(new String[] {prefix, fileName}, "/");
		InputStream content = file.getInputStream();

	    // 创建上传Object的Metadata
	    ObjectMetadata meta = new ObjectMetadata();
	    // 必须设置ContentLength
	    meta.setContentLength(file.getSize());

	    // 上传Object.    ETag值???
	    client.putObject(bucketName, key, content, meta);
	    return StringCommUtils.connectArray(new String[] {endpoint, bucketName, key}, "/");
	}
	
	public static ObjectListing listObjects(String bucketName) {
	    ObjectListing listing = client.listObjects(bucketName);
	    return listing;
	}
	
	public static OSSObject getObject(String bucketName, String key){
		OSSObject obj = null;
		try {
			obj = client.getObject(bucketName, key);
		} catch (Exception e) {
		}
		return obj;
	}
	
	public static void deleteObject(String bucketName, String key) {
	    client.deleteObject(bucketName, key);
	}
	
	private static String generateOssKey(String fileName){
		String randStr = StringCommUtils.getRandomStr(10, null);
		String ossKey = randStr + String.valueOf(System.currentTimeMillis());
		String extension = "";
		if(fileName != null){
			int index = fileName.lastIndexOf(".");
			if (index != -1) {
				extension = fileName.substring(index);
			}
		}
		ossKey = ossKey + extension;
		return ossKey;
	}
	
	public static void createPrefixFilePath(String bucketName, String prefixPath) throws IOException{
		String key = prefixPath + "/"; 
		OSSObject obj = getObject(bucketName, key);
		if(obj == null){
			/*这里的size为0,注意OSS本身没有文件夹的概念,这里创建的文件夹本质上是一个size为0的Object,dataStream仍然可以有数据	 */
			byte[] buffer = new byte[0];
			ByteArrayInputStream in = new ByteArrayInputStream(buffer);  
			ObjectMetadata objectMeta = new ObjectMetadata(); 
			objectMeta.setContentLength(0);
			try {
				client.putObject(bucketName, key, in, objectMeta);
			} finally {
				in.close();
			}
		}
	}
	
	public static void main(String[] args) {
//		System.out.println(FileUploadOss.getObject("midea-wx", "20150819/"));
//		FileUploadOss.deleteObject("midea-wx", "006.jpg");
//		try {
//			String result = FileUploadOss.uploadFile("midea-wx", "d:\\mydata\\桌面\\工单原型\\photo\\006.jpg");
//			System.out.println(result);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		System.out.println(FastJSONHelper.serialize(FileUploadOss.listObjects("midea-wx")));
	}
	
}
