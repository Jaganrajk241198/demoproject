package com.projectincedoplay.video;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectincedoplay.reglog.UserEntitya.User;
import com.projectincedoplay.reglog.UserRepository.UserRepository;
import com.projectincedoplay.video.VideoUploadEntity.VideoUpload;
import com.projectincedoplay.video.VideoUploadPojo.VideoUploadPojo;
import com.projectincedoplay.video.VideouploadRepositorya.VideoUploadRepository;


@Service
public class VideoUploadServiceImpl implements VideoUploadService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private VideoUploadRepository videoUploadRepository;

	@Override
	public String saveVideoUpload(VideoUploadPojo Videouploadpojo) {

		Optional<User> email = userRepository.findByEmailId(Videouploadpojo.getEmailId());
		if (email.isPresent()) {
			VideoUpload videoupload = new VideoUpload();
			videoupload.setUserId(email.get().getUserid());
			videoupload.setVideoname(Videouploadpojo.getVideoname());
			videoupload.setVideofile(Videouploadpojo.getVideofile());
			videoupload.setUserEmailId(Videouploadpojo.getEmailId());
			videoUploadRepository.save(videoupload);
			return "Sucessfully Uploaded";
		} else {
			return "Invalid user";
		}

	}

	@Override
	public List<VideoUpload> getVideoUpload() {
		List<VideoUpload> getData = videoUploadRepository.findAll();
		return getData;

	}

	@Override
	public List<VideoUploadPojo> findByVideoname( String video_name) {
		
		List <VideoUpload> video = videoUploadRepository.findByVideoname(video_name);
		
		List <VideoUploadPojo> videoPojo = new ArrayList<VideoUploadPojo>();
		for(VideoUpload v : video) {
			VideoUploadPojo obj = new VideoUploadPojo();
			obj.setVideofile(v.getVideofile());
			obj.setVideoname(v.getVideoname());
			obj.setUserId(v.getUserId());
			obj.setEmailId(v.getUserEmailId());
			videoPojo.add(obj);
		}
		return videoPojo;
		
		
	}
 
}
