package com.projectincedoplay.video.VideouploadRepositorya;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectincedoplay.video.VideoUploadEntity.VideoUpload;

@Repository
public interface VideoUploadRepository extends JpaRepository<VideoUpload, Integer>{

	
	List <VideoUpload> findByVideoname( String video_name);
	
	
	
	}


