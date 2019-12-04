package kr.or.ddit.vo;

import java.io.File;
import java.util.List;

public class ThumbnailVO {
	private String rnum;
	private String tb_no;
	private String tb_title;
	private String tb_writer;
	private String tb_nickname;
	private String tb_pwd;
	private String tb_mail;
	private String tb_ip;
	private String tb_content;
	private String tb_hit;
	private String tb_reg_date;
	private String tb_status;
	private String save_name;
	
	private List<ThumbnailItemVO> items;
	
	private List<File> files;
	private List<String> filesContentType;
	private List<String> filesFileName;

	
	public String getTb_no() {
		return tb_no;
	}

	public void setTb_no(String tb_no) {
		this.tb_no = tb_no;
	}

	public String getTb_title() {
		return tb_title;
	}

	public void setTb_title(String tb_title) {
		this.tb_title = tb_title;
	}

	public String getTb_writer() {
		return tb_writer;
	}

	public void setTb_writer(String tb_writer) {
		this.tb_writer = tb_writer;
	}

	public String getTb_nickname() {
		return tb_nickname;
	}

	public void setTb_nickname(String tb_nickname) {
		this.tb_nickname = tb_nickname;
	}

	public String getTb_pwd() {
		return tb_pwd;
	}

	public void setTb_pwd(String tb_pwd) {
		this.tb_pwd = tb_pwd;
	}

	public String getTb_mail() {
		return tb_mail;
	}

	public void setTb_mail(String tb_mail) {
		this.tb_mail = tb_mail;
	}

	public String getTb_ip() {
		return tb_ip;
	}

	public void setTb_ip(String tb_ip) {
		this.tb_ip = tb_ip;
	}

	public String getTb_content() {
		return tb_content;
	}

	public void setTb_content(String tb_content) {
		this.tb_content = tb_content;
	}

	public String getTb_hit() {
		return tb_hit;
	}

	public void setTb_hit(String tb_hit) {
		this.tb_hit = tb_hit;
	}

	public String getTb_reg_date() {
		return tb_reg_date;
	}

	public void setTb_reg_date(String tb_reg_date) {
		this.tb_reg_date = tb_reg_date;
	}

	public String getTb_status() {
		return tb_status;
	}

	public void setTb_status(String tb_status) {
		this.tb_status = tb_status;
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

	public String getRnum() {
		return rnum;
	}

	public void setRnum(String rnum) {
		this.rnum = rnum;
	}

	public void setFilesFileName(List<String> filesFileName) {
		this.filesFileName = filesFileName;
	}

	public String getSave_name() {
		return save_name;
	}

	public void setSave_name(String save_name) {
		this.save_name = save_name;
	}

	public List<ThumbnailItemVO> getItems() {
		return items;
	}

	public void setItems(List<ThumbnailItemVO> items) {
		this.items = items;
	}
	
}
