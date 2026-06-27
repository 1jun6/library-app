package com.group.libraryapp.dto.user.request;

public class UserCreateRequest {

    private String name;    // 유저 생성 시 필수 사항
    private Integer age;    // 유저 생성 시 선택 사항이므로 null값이 들어갈 수 있는 Integer 타입을 선택하였다.

    // @RequestBody 어노테이션을 받는 POST API의 DTO 클래스는 생성자를 생략해도 무방하다.


    public String getName() {

        return name;
    }

    public Integer getAge() {

        return age;
    }
}
