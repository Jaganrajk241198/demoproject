package com.projectincedoplay.video.VideoUploadEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "uploaded_Videos")
public class VideoUpload {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "video_id")
	private int videoid;

	@Column(name = "video_name")
	private String videoname;

	@Column(name = "video_file")
	private String videofile;

	@Column(name = "user_id")
	private int userId;

	@Column(name = "user_emailid")
	private String userEmailId;
	public String getUserEmailId() {
		return userEmailId;
	}

	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}

	public VideoUpload() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getVideoid() {
		return videoid;
	}

	public void setVideoid(int videoid) {
		this.videoid = videoid;
	}

	public String getVideoname() {
		return videoname;
	}

	public void setVideoname(String videoname) {
		this.videoname = videoname;
	}

	public String getVideofile() {
		return videofile;
	}

	public void setVideofile(String videofile) {
		this.videofile = videofile;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public VideoUpload(int videoid, String videoname, String videofile, int userId) {
		super();
		this.videoid = videoid;
		this.videoname = videoname;
		this.videofile = videofile;
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "VideoUpload [videoid=" + videoid + ", videoname=" + videoname + ", videofile=" + videofile + ", userId="
				+ userId + "]";
	}

	

}
