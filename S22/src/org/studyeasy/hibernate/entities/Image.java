package org.studyeasy.hibernate.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="images")
@Table(name="images")
public class Image {
	@Id
	@Column(name="id")
	int id;
	@Column(name="file_name")
	String fileName;
	public Image(String fileName) {
		super();
		this.fileName = fileName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	

}
