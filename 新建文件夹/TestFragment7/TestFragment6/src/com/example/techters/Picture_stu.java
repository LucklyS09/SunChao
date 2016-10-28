package com.example.techters;

/*
 * 学生头像 实体类
 * 
 */

public class Picture_stu {
	private String title;
	private int imageId;

	public Picture_stu() {
		super();
	}

	public Picture_stu(String title, int imageId) {
		super();
		this.title = title;
		this.imageId = imageId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}
}

