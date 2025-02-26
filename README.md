# 2022 Java Spring Cafe

2022년도 마스터즈 멤버스 백엔드 스프링 카페 프로젝트

<br/>

## 스프링 카페 5단계 - 게시글 권한부여

<br/>

## 기능 요구사항
- [X] 로그인하지 않은 사용자는 게시글의 목록만 볼 수 있다.
- [X] 로그인한 사용자만 게시글의 세부내용을 볼 수 있다.
- [X] 로그인한 사용자만 게시글을 작성할 수 있다.
- [X] 로그인한 사용자는 자신의 글을 수정 및 삭제할 수 있다.

### 게시글 작성하기
- [X] 글작성 화면에서 글쓴이 입력 필드를 삭제한다.
- [X] 로그인하지 않은 사용자가 글쓰기 페이지에 접근할 경우 로그인 페이지로 이동한다.

### 게시글 수정하기
- [X] 수정하기 폼 과 수정하기 기능은 로그인 사용자와 글쓴이의 사용자 아이디가 같은 경우에만 가능하다.
- [X] 상황에 따라 "다른 사람의 글을 수정할 수 없다."와 같은 에러 메시지를 출력하는 페이지로 이동하도록 구현한다.

### 게시글 삭제하기
- [X] 삭제하기는 로그인 사용자와 글쓴이의 사용자 아이디가 같은 경우에만 가능하다.
- [X] 상황에 따라 "다른 사람의 글을 수정할 수 없다."와 같은 에러 메시지를 출력하는 페이지로 이동하도록 구현한다.

<br/>

<br/>

## 프로그래밍 요구사항
- [X] 스프링 부트, 웹 MVC로 구현한다.
- [X] API로 구현하지 않고, 템플릿 기반으로 구현한다.
- [X] HttpSession을 활용해서 구현한다.

## 게시글 작성하기
- [X] Article의 글쓴이 값은 User의 name 값을 가지는 것으로 구현한다.

## 게시글 수정하기
- [X] @PutMapping을 사용해 매핑한다.
- [X] html에서 form submit을 할 때 <input type="hidden" name="_method" value="PUT" />과 같이 PUT method를 값으로 전송한다.

## 게시글 삭제하기
- [X] @DeleteMapping을 사용해 매핑하고 구현한다.
- [X] html에서 form submit을 할 때 <input type="hidden" name="_method" value="DELETE" />와 같이 PUT method를 값으로 전송한다.

<br/>

## 이벤트 흐름도
> ![image](https://user-images.githubusercontent.com/82401504/158037575-7b20e55f-adb7-4b23-b8e0-fdcb53bb0fdf.png)

<br/>

## 프로젝트 디렉토리 구조
```
.
|-- main
|   |-- java
|   |   `-- com
|   |       `-- kakao
|   |           `-- cafe
|   |               |-- config
|   |               |-- controller
|   |               |-- domain
|   |               |-- dto
|   |               |-- exception
|   |               |-- repository
|   |               `-- service
|   `-- resources
|       |-- static
|       |   |-- css
|       |   |-- fonts
|       |   |-- images
|       |   `-- js
|       `-- templates
|           |-- error
|           |-- partial
|           |-- qna
|           `-- user
`-- test
    `-- java
        `-- com
            `-- kakao
                `-- cafe
                    |-- controller
                    |-- domain
                    |-- repository
                    `-- service
```