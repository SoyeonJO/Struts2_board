package kr.or.ddit.utiles;

import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

// FileUploadRequestWrapper is a HttpServletRequestWrapper
// HttpServletRequestWrapper is a HttpServletRequest
// FileUploadRequestWrapper is a HttpServletRequest
// 파일 업로드 시 폼필드와 파일의 활용을 용이하도록 코드 구성
public class FileUploadRequestWrapper extends HttpServletRequestWrapper {
	// 파일 업로드 요청(multipart 요청)
	// <form method=POST enctype=multipart/form-data/> 파일 업로드 필수 설정
	// 파일 업로드 요청시 form필드 저장
	private Map<String, String[]> queryStringMap;
	// 파일 업로드 요청시 파일 저장
	private Map<String, FileItem[]> fileItemMap;
	
	private boolean multipartFlag = false;
	
	// new FileUploadRequestWrapper(request) O -> request 생성자가 반드시 필요
	// new FileUploadRequestWrapper() X
	public FileUploadRequestWrapper(HttpServletRequest request) {
		this(request, -1, -1);
	}
	
	// new FileUploadRequestWrapper(request, 1024*1024*100, 1024*1024*100);
	public FileUploadRequestWrapper(HttpServletRequest request, int threshold, int sizeMax) {
		super(request);
		
		parsing(request, threshold, sizeMax);
	}

	private void parsing(HttpServletRequest request, int threshold, int sizeMax) {
		this.multipartFlag = ServletFileUpload.isMultipartContent(request);
		
		if(this.multipartFlag) {  // 파일 업로드 일때
			this.queryStringMap = new HashMap<String, String[]>();
			this.fileItemMap = new HashMap<String, FileItem[]>();
			
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(threshold);
			
			ServletFileUpload fileUpload = new ServletFileUpload(factory);
			fileUpload.setSizeMax(sizeMax);
			
			try {
				List<FileItem> items = fileUpload.parseRequest(request);
				
				for(FileItem item : items) {
					if(item.getSize() > 0) {
						// mem_id, mem_pass, mem_name, files*2
						String fieldName = item.getFieldName();
						
						if(item.isFormField()) {
							// mem_id, mem_pass, mem_name
							String value = item.getString("UTF-8");
							
							// queryStringMap 내 기존 해당 fieldName으로 저장된 값이 존재 또는 존재하지 않을때 처리 분기
							String[] values = this.queryStringMap.get(fieldName);  
							if( values == null ) {
								values = new String[]{ value };
							}else {
								String[] temp = new String[values.length + 1];
								
								// 배열 카피 : 1. 스왈로우 카피 : 원본 배열의 각 인덱스에서 레퍼런스하는 요소값의 주소가 복사
								//                                MemberVO[] 원본 : [0] - MemberVO 저장(주소1)   => 스왈로우 카피  =>  MemberVO[] 복사 대상 배열 - [0] MemberVO(동일주소1 레퍼런스)
								//                                                  [1] - MemberVO 저장(주소2)                                                     [1] MemberVO(동일주소2 레퍼런스)
								//             2.    딥 카피    : 원본 배열의 각 인덱스에서 레퍼런스하는 요소값의 주소와 
								//                                복사 대상 배열의 인덱스가 레퍼런스하는 요소값 주소와 상이 
								//                                MemberVO[] 원본 : [0] - MemberVO 저장(주소1)   => 딥 카피  =>  MemberVO[] 복사 대상 배열 - [0] MemberVO(주소3)
								//                                                  [1] - MemberVO 저장(주소2)                                               [1] MemberVO(주소4)
								// arraycopy(원본배열, 원본배열의 복사시작index, 복사대상배열, 복사대상 배열의 복사시작index, 원본 배열에서 복사될 전체 index);
								System.arraycopy(values, 0, temp, 0, values.length);
								
								temp[temp.length -1] = value;
								
								values = temp;
							}
							this.queryStringMap.put(fieldName, values);
						}else {  // 업로드된 파일
							// files * 2
							FileItem[] values = this.fileItemMap.get(fieldName);
							if(values == null) { //values에 저장된 값 없을 때
								values = new FileItem[] { item };  // values가 null이 아니게 만든다.
							}else {
								FileItem[] temp = new FileItem[values.length + 1];
								System.arraycopy(values, 0, temp, 0, values.length);
								
								temp[temp.length -1] = item;
								
								values = temp;
							}
							this.fileItemMap.put(fieldName, values);
						}
					}
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public String getParameter(String name) {
		if(this.multipartFlag) {
			String[] values = this.queryStringMap.get(name);
			if(values == null) {
				return null;
			}else {
				return values[0];
			}
		}else {
			return super.getParameter(name);
		}
	}

	@Override
	public Map<String, String[]> getParameterMap() {
		if(this.multipartFlag) {
			return this.queryStringMap;
		}else {
			return super.getParameterMap();
		}
	}

	@Override
	public Enumeration<String> getParameterNames() {
		if(this.multipartFlag) {
			return new Enumeration<String>() {
				Iterator<String> keys = queryStringMap.keySet().iterator();
				
				@Override
				public boolean hasMoreElements() {
					return keys.hasNext();  // boolean 타입으로 반환
				}

				@Override
				public String nextElement() {
					return keys.next();
				}
			};
		}else {
			return super.getParameterNames();
		}
	}

	@Override
	public String[] getParameterValues(String name) {
		if(this.multipartFlag) {
			return this.queryStringMap.get(name);
		}else {
			return super.getParameterValues(name);
		}
	}
	
	public FileItem getFileItem(String name) {
		if(this.multipartFlag) {
			FileItem[] items = this.fileItemMap.get(name);
			if(items == null) {
				return null;
			}else {
				return items[0];
			}
		}else {
			return null;
		}
	}
	
	public Map<String, FileItem[]> getFileItemMap() {
		if(this.multipartFlag) {
			return this.fileItemMap;
		}else {
			return null;
		}
	}
	
	public FileItem[] getFileItemValues(String name) {
		if(this.multipartFlag) {
			return this.fileItemMap.get(name);
		}else{ 
			return null; // 파일 업로드 요청이 아닐때
		}
	}
}
