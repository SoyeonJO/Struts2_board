package kr.or.ddit.vo;

import java.io.File;
import java.util.List;

public class NoticeVO {

	private String notice_no;
	private String notice_mem_id;
	private String notice_title;
	private String notice_content;
	private String notice_hit;
	private String notice_reg_date;
	private String notice_status;
	private String notice_mem_name;
	private String notice_group;
	private String notice_seq;


	
	private String rnum;
	private List<NoticeItemVO> items;
	
	private List<File> files;
	private List<String> filesContentType;
	private List<String> filesFileName;

	public String getNotice_no() {
		return notice_no;
	}
	public void setNotice_no(String notice_no) {
		this.notice_no = notice_no;
	}
	public String getNotice_mem_id() {
		return notice_mem_id;
	}
	public void setNotice_mem_id(String notice_mem_id) {
		this.notice_mem_id = notice_mem_id;
	}
	public String getNotice_title() {
		return notice_title;
	}
	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}
	public String getNotice_content() {
		return notice_content;
	}
	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}
	public String getNotice_hit() {
		return notice_hit;
	}
	public void setNotice_hit(String notice_hit) {
		this.notice_hit = notice_hit;
	}
	public String getNotice_reg_date() {
		return notice_reg_date;
	}
	public void setNotice_reg_date(String notice_reg_date) {
		this.notice_reg_date = notice_reg_date;
	}
	public String getNotice_status() {
		return notice_status;
	}
	public void setNotice_status(String notice_status) {
		this.notice_status = notice_status;
	}
	public String getNotice_mem_name() {
		return notice_mem_name;
	}
	public void setNotice_mem_name(String notice_mem_name) {
		this.notice_mem_name = notice_mem_name;
	}
	public String getRnum() {
		return rnum;
	}
	public void setRnum(String rnum) {
		this.rnum = rnum;
	}
	public String getNotice_group() {
		return notice_group;
	}
	public void setNotice_group(String notice_group) {
		this.notice_group = notice_group;
	}
	public String getNotice_seq() {
		return notice_seq;
	}
	public void setNotice_seq(String notice_seq) {
		this.notice_seq = notice_seq;
	}
	public List<NoticeItemVO> getItems() {
		return items;
	}
	public void setItems(List<NoticeItemVO> items) {
		this.items = items;
	}
	public List<File> getFiles() {
		return files;
	}
	public void setFiles(List<File> files) {
		this.files = files;
	}
	public List<String> getFilesContentType() {
		return filesContentType;
	}
	public void setFilesContentType(List<String> filesContentType) {
		this.filesContentType = filesContentType;
	}
	public List<String> getFilesFileName() {
		return filesFileName;
	}
	public void setFilesFileName(List<String> filesFileName) {
		this.filesFileName = filesFileName;
	}

	
	
	
}
