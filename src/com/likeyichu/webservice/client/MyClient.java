package com.likeyichu.webservice.client;

import org.springframework.web.client.RestTemplate;

import com.likeyichu.webservice.resource.Student;
/**RestTemplate使用方法示例
 * @see org.springframework.web.client.RestTemplate
 */
public class MyClient {

	public static void main(String[] args) {
		RestTemplate client=new RestTemplate();
		//get方法
		String url="http://localhost:8080/WebService/student";
		Student student=client.getForObject(url, Student.class);
		System.out.println(student.getName());
		
		//post方法
		
	}

}
//xiaoMing
