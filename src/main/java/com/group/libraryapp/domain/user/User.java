package com.group.libraryapp.domain.user;

import com.group.libraryapp.domain.user.loanhistory.UserLoanHistory;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null; // Long <--> bigint

    @Column(nullable = false, length = 20, name = "name")   // name varchar(20)
    private String name;

    // @Column 어노테이션을 생략 가능하다!
    private Integer age;

    @OneToMany(mappedBy = "user")   // 연관관계의 주인 설 (얘가 설정되어야 진정한 데이터가 저장된다)
    private List<UserLoanHistory> userLoanHisotries = new ArrayList<>();

    protected User() { }

    public User (String name, Integer age) {

        if (name == null || name.isBlank()) {

            throw new IllegalArgumentException(String.format("잘못된 name(%s)이 들어왔습니다.", name));
        }

        this.name = name;
        this.age = age;
    }

    public Long getId() {

        return id;
    }

    public String getName() {

        return name;
    }

    public Integer getAge() {

        return age;
    }

    public void updateName(String name) {

        this.name = name;
    }

    public void loanBook(String bookName) {

        this.userLoanHisotries.add(new UserLoanHistory(this, bookName));
    }

    public void returnBook(String bookName) {

        UserLoanHistory targetHistory = this.userLoanHisotries.stream()
                                        .filter(history -> history.getBookName().equals(bookName))
                                        .findFirst().orElseThrow(IllegalAccessError::new);

        targetHistory.doReturn();
    }
}
