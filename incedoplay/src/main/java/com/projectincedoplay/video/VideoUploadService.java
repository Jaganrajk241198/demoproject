package com.projectincedoplay.video;

import java.util.List;

import com.projectincedoplay.video.VideoUploadEntity.VideoUpload;
import com.projectincedoplay.video.VideoUploadPojo.VideoUploadPojo;


public interface VideoUploadService {

	public String saveVideoUpload(VideoUploadPojo Videouploadpojo);
	
	public List<VideoUpload> getVideoUpload();

	List <VideoUploadPojo> findByVideoname( String video_name);

	
}
