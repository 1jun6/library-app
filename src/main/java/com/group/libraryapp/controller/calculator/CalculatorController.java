package com.group.libraryapp.controller.calculator;

import com.group.libraryapp.dto.calculator.request.CalculatorAddRequest;
import com.group.libraryapp.dto.calculator.request.CalculatorMultiplyRequest;
import org.springframework.web.bind.annotation.*;

/* addTwoNumbers API Specification

- HTTP Method : GET
- HTTP Path : /add
- Query 사용 (key & value) : int number1, int number2 & 정수값
- API 결과 반환 : int Query로 들어온 두 숫자의 합

 */

/* multiplyTwoNumbers API Specification

- HTTP Method : POST
- HTTP Path : /multiply
- Body 사용 : { "number1" : 정수, "number2" : 정수 }
- 결과 반환 : 곱셈 결과, 숫자 타압


 */

@RestController
// 주어진 클래스를 Controller(API의 시작 지점)로 등록한다.

public class CalculatorController {

    @GetMapping("/add")
    // 아래에 주어진 함수를 HTTP Method가 GET이고 HTTP Path가 /add인 API로 지정한다.

    /*
    public int addTwoNumbers(@RequestParam int number1, @RequestParam int number2) {

        // @RequestParam : 주어지는 Query를 함수 파라미터에 집어넣는다.
        return (number1 + number2);
    }

     */

    // Query가 많아지더라도 Parameter 개수를 줄인 방식의 addTwoNumbers API
    public int addTwoNumbers(CalculatorAddRequest request) {

        return (request.getNumber1() + request.getNumber2());
    }

    @PostMapping("/multiply")
    // 아래에 주어진 함수를 HTTP Method가 POST이고 HTTP Path가 /multiply인 API로 지정한다.
    public int multiplyTwoNumbers(@RequestBody CalculatorMultiplyRequest request) {

        // @RequestBody : HTTP Body로 들어오는 JSON을 함수 파라미터로 바꿔준다. POST API는 BODY를 통해 데이터가 들어오므로 반드시 사용해주자.
        return (request.getNumber1() * request.getNumber2());
    }

    // ** POST API는 어떤 값을 저장한다는 의미의 API이므로 이와 같이 곱셈 기능을 하는 경우는 POST API로 작성하면 안된다. 연습삼아 한 번 해본 것.
}
