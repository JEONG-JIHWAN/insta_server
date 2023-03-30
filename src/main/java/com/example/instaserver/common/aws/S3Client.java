package com.example.instaserver.common.aws;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import java.io.IOException;
import java.io.InputStream;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Component
@RequiredArgsConstructor
public class S3Client {

    @Value("${cloud.aws.s3.bucket}")
    private String bucketName;
    private final AmazonS3 amazonS3;

    public String uploadImage(MultipartFile multipartFile) throws IOException {
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentType(multipartFile.getContentType());
        System.out.println(multipartFile.getContentType());
        System.out.println(multipartFile.getOriginalFilename());
        String imageUrl = upload(bucketName, multipartFile.getOriginalFilename(), multipartFile.getInputStream(), metadata);
        return imageUrl;
    }

    public S3Object get(String key) {
        GetObjectRequest request = new GetObjectRequest(bucketName, key);
        return amazonS3.getObject(request);
    }

    public String upload(String bucketName, String key, InputStream in, ObjectMetadata objectMetadata) {
        PutObjectRequest request = new PutObjectRequest(bucketName, key, in, objectMetadata);
        amazonS3.putObject(request.withCannedAcl(CannedAccessControlList.PublicRead));
        return amazonS3.getUrl(bucketName, key).toString();
    }


}
