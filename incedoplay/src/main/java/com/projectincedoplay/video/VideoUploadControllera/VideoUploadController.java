package com.projectincedoplay.video.VideoUploadControllera;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projectincedoplay.video.VideoUploadService;
import com.projectincedoplay.video.VideoUploadEntity.VideoUpload;
import com.projectincedoplay.video.VideoUploadPojo.VideoUploadPojo;

@RestController
public class VideoUploadController {

	@Autowired
	private VideoUploadService videoUploadService;
	
	@PostMapping("/videoUpload")
	public String videoUpload(@RequestBody VideoUploadPojo videoUploadPojo ) {
		return videoUploadService.saveVideoUpload(videoUploadPojo);
	}
	
	@GetMapping("/videoUploaddetails")
	public List<VideoUpload> videoUploaddetails() {
		return videoUploadService.getVideoUpload();
	}

	@GetMapping("/videoUploaddetails/{video_name}")
	List <VideoUploadPojo> findByvideoname(@PathVariable String video_name) {
		return videoUploadService.findByVideoname(video_name);
	}
	
	
}
