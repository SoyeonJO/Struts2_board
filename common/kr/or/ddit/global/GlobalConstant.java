package kr.or.ddit.global;

public interface GlobalConstant {
	// "D:\\temp\\images" 폴더에 저장된 파일을 
	// http://192.168.207.141/files/a.png 접근 가능
	// 서버(웹서버, 웹 어플리케이션 서버)
	//  *http 프로토콜을 활용해 클라이언트의 접근 환경 구성
	//  * 구성 (이클립스 내 server view에서 설정)
	//         Document Folder   : D:\\temp\\images
	//         Context Root|Path : /files
	
	public String FILE_PATH = "D:\\temp\\images";
}
