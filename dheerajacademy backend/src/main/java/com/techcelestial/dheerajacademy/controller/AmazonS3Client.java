package com.techcelestial.dheerajacademy.controller;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

/**
 * Created by pramod on 4/11/2018.
 */
@Service
class AmazonClient {
    private AmazonS3 s3client;

    @Value("${cloud.aws.credentials.endpointurl}")
    private String endpointUrl;

    @Value("${cloud.aws.credentials.bucketName}")
    private String bucketName;

    @Value("${cloud.aws.credentials.accessKey}")
    private String accessKey;

    public AmazonS3 getS3client() {
        return s3client;
    }

    public void setS3client(AmazonS3 s3client) {
        this.s3client = s3client;
    }

    public String getEndpointUrl() {
        return endpointUrl;
    }

    public void setEndpointUrl(String endpointUrl) {
        this.endpointUrl = endpointUrl;
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    @Value("${cloud.aws.credentials.secretKey}")
    private String secretKey;



    @PostConstruct
    private void initializeAmazon() {
        AWSCredentials credentials = new BasicAWSCredentials(this.accessKey, this.secretKey);
        this.s3client = new AmazonS3Client(credentials);
    }

    private File convertMultiPartToFile(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }
    private String generateFileName(MultipartFile multiPart) {
        return new Date().getTime() + "-" + multiPart.getOriginalFilename().replace(" ", "_");
    }
    private void uploadLogoTos3bucket(String fileName, File file) {
        s3client.putObject(new PutObjectRequest(bucketName+"/logo", fileName, file)
                .withCannedAcl(CannedAccessControlList.PublicRead));
    }

    public String uploadLogo(MultipartFile multipartFile) {
        String fileUrl = "";
        try {
            File file = convertMultiPartToFile(multipartFile);
            String fileName = generateFileName(multipartFile);
            fileUrl = getEndpointUrl() + "/" + bucketName + "/logo/" + fileName;
            uploadLogoTos3bucket(fileName, file);
            file.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileUrl;
    }

	public String uploadprofile(MultipartFile multipartFile) {
	    String fileUrl = "";
        try {
            File file = convertMultiPartToFile(multipartFile);
            String fileName = generateFileName(multipartFile);
            fileUrl = getEndpointUrl() + "/" + bucketName + "/studentprofilepic/" + fileName;
            uploadProfileTos3bucket(fileName, file);
            file.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileUrl;
	}

	private void uploadProfileTos3bucket(String fileName, File file) {
		 s3client.putObject(new PutObjectRequest(bucketName+"/studentprofilepic", fileName, file)
	                .withCannedAcl(CannedAccessControlList.PublicRead));
		
	}

	public String uploadimgaepdf(MultipartFile multipartFile) {
		 String fileUrl = "";
	        try {
	            File file = convertMultiPartToFile(multipartFile);
	            String fileName = generateFileName(multipartFile);
	            fileUrl = getEndpointUrl() + "/" + bucketName + "/homework/" + fileName;
	            uploadimgaepdfTos3bucket(fileName, file);
	            file.delete();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return fileUrl;
	}

	private void uploadimgaepdfTos3bucket(String fileName, File file) {
		 s3client.putObject(new PutObjectRequest(bucketName+"/homework", fileName, file)
	                .withCannedAcl(CannedAccessControlList.PublicRead));
	}

	public String uploadNotes(MultipartFile multipartFile) {
		String fileUrl = "";
        try {
            File file = convertMultiPartToFile(multipartFile);
            String fileName = generateFileName(multipartFile);
            fileUrl = getEndpointUrl() + "/" + bucketName + "/notes/" + fileName;
            uploadNotesTos3bucket(fileName, file);
            file.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileUrl;
	}

	private void uploadNotesTos3bucket(String fileName, File file) {
		s3client.putObject(new PutObjectRequest(bucketName+"/notes", fileName, file)
                .withCannedAcl(CannedAccessControlList.PublicRead));
	}

	public String uploadProfileForAndroid(MultipartFile multipartFile) {
		String fileUrl = "";
        try {
            File file = convertMultiPartToFile(multipartFile);
            String fileName = generateFileName(multipartFile);
            fileUrl = getEndpointUrl() + "/" + bucketName + "/studentprofilepic/" + fileName;
            uploadProfileForAndroidTos3bucket(fileName, file);
            file.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileUrl;
	}

	private void uploadProfileForAndroidTos3bucket(String fileName, File file) {
		s3client.putObject(new PutObjectRequest(bucketName+"/studentprofilepic", fileName, file)
                .withCannedAcl(CannedAccessControlList.PublicRead));
		
	}

	public String uploadVideo(MultipartFile multipartFile) {
		
		String fileUrl = "";
        try {
            File file = convertMultiPartToFile(multipartFile);
            String fileName = generateFileName(multipartFile);
            fileUrl = getEndpointUrl() + "/" + bucketName + "/video/" + fileName;
            uploadVideoTos3bucket(fileName, file);
            file.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileUrl;
	}

	private void uploadVideoTos3bucket(String fileName, File file) {
		s3client.putObject(new PutObjectRequest(bucketName+"/video", fileName, file)
                .withCannedAcl(CannedAccessControlList.PublicRead));
		
	}

	
}
