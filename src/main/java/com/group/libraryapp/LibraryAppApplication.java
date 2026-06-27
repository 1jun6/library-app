package com.group.libraryapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// 스프링을 실행시키기 위해 필요한 설정들을 자동으로 해주는 어노테이션
public class LibraryAppApplication {

  public static void main(String[] args) {

    SpringApplication.run(LibraryAppApplication.class, args);
    // 스프링 어플리케이션을 실행시키는 코드. 즉, 제작한 서버를 실행시키는 코드이다.

    /* 서버(Server)

    : '특정 기능'을 '제공(serve)'하는 프로그램 및 해당 프로그램을 실행시키는 컴퓨터
    - 특정 기능을 제공받기 위해서는 서버 컴퓨터에게 요청을 해야하는데, 인터넷(Internet)을 통해 요청을 보낼 수 있다.
     */
  }

}
