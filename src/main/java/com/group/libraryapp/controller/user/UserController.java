package com.group.libraryapp.controller.user;

import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import com.group.libraryapp.service.user.UserServiceV1;
import com.group.libraryapp.service.user.UserServiceV2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/* <도서 관리 애플리케이션> 요구사항

* 사용자
    - 도서관의 사용자를 등록할 수 있다. (이름 필수, 나이 선택)
    - 도서관 사용자의 목록을 볼 수 있다.
    - 도서관 사용자 이름을 업데이트 할 수 있다.
    - 도서관 사용자를 삭제할 수 있다.

* 책
    - 도서관에 책을 등록할 수 있다.
    - 사용자가 책을 빌릴 수 있다.
        - 다른 사람이 그 책을 진작 빌렸다면 빌릴 수 없다.
    - 사용자가 책을 반납할 수 있다.

 */

/* saveUser API specification

- HTTP Method : POST
- HTTP Path : /user
- HTTP Body (JSON) : { "name" : String (null X), "age" : Integer }
- API 결과 반환 : X (상태 코드 '200 OK'면 충분하다.)
 */

/* getUsers API specification

- HTTP Method : GET
- HTTP Path : /user
- HTTP Query : X
- API 결과 반환 : JSON [{ "id" : Long, "name" : String (null X), "age" : Integer }, . . .]
    - Controller에서 그냥 객체를 반환하면, JSON으로 응답이 가게 된다. 이 때, 객체에는 getter가 있어야 한다.

 */

/* updateUser API specification

- HTTP Method : PUT
- HTTP Path : /user
- HTTP Body : JSON { "id" : Long, "name" : String // 변경되어야 하는 이름이 들어온다 }
- API 결과 반환 : X (HTTP 상태 200 OK이면 충분하다)

 */

/* deleteUser API specification

- HTTP Method : DELETE
- HTTP Path : /user
- HTTP Query : 문자열 name (샥제되어야 하는 사용자 이름)
- API 결과 반환 : X (HTTP 상태 200 OK이면 충분하다)

 */

@RestController
public class UserController {

    private final UserServiceV2 userService;

    public UserController(UserServiceV2 userService) {

        this.userService = userService;
    }

    @PostMapping("/user")
    public void saveUser(@RequestBody UserCreateRequest request) {

        userService.saveUser(request);
    }

    @GetMapping("/user")
    public List<UserResponse> getUsers() {

        return userService.getUsers();
    }

    @PutMapping("/user")
    public void updateUser(@RequestBody UserUpdateRequest request) {

        userService.updateUser(request);
    }

    @DeleteMapping("/user")
    public void deleteUser(@RequestParam String name) {


    }
}
