# 로그인 토이 프로젝트
* 설계, 개발 연습용 Java SE Toy Project


## 핵심 기능 

* 로그인 기능
* 회원가입 기능
* 비밀번호 찾기로 새로운 비밀번호로 변경 기능
* 로그인 하면 가입된 회원 정보들을 조회하는 기능
 * Thread로 다른 유저가 가입 시 바로 유저목록이 갱신

## UI 설계

* 로그인 화면

![01](https://github.com/younggeun0/younggeun0.github.io/blob/master/_posts/img/toyProjects/simpleLogin/01.png?raw=true)

* 회원가입 화면

![02](https://github.com/younggeun0/younggeun0.github.io/blob/master/_posts/img/toyProjects/simpleLogin/02.png?raw=true) 

* 주소 검색

![03](https://github.com/younggeun0/younggeun0.github.io/blob/master/_posts/img/toyProjects/simpleLogin/03.png?raw=true)

* 로그인 후 볼 수 있는 유저 목록

![04](https://github.com/younggeun0/younggeun0.github.io/blob/master/_posts/img/toyProjects/simpleLogin/04.png?raw=true)

* 비밀번호 찾기 후 변경

![05](https://github.com/younggeun0/younggeun0.github.io/blob/master/_posts/img/toyProjects/simpleLogin/05.png?raw=true)

![06](https://github.com/younggeun0/younggeun0.github.io/blob/master/_posts/img/toyProjects/simpleLogin/06.png?raw=true)

## DB 설계

* 회원가입 시 아이디, 비밀번호, 연락처, 이메일, 주소, 주민등록번호. 검증용 질문답 입력 후 회원가입 수행
  * 중복된 아이디인지 검증
  * 비밀번호 입력된 두 값이 같은지 검증
  * 이메일 @과 .가 입력되었는지 검증
  * 주소는 DB때 사용했던 지번정보를 저장한 Zipcode 테이블 사용
  * 주민등록번호는 DB때 배운 SSN검증 알고리즘 사용
  * 질문은 1 또는 2로 저장

```sql
-- user 데이터를 저장할 simple_login 테이블
CREATE TABLE simple_login(
    id VARCHAR2(15) CONSTRAINT pk_simple_login PRIMARY KEY,
    password VARCHAR2(10) NOT NULL,
    tel CHAR(13) NOT NULL,
    email VARCHAR2(30) NOT NULL,
    ssn CHAR(14) CONSTRAINT uk_simple_login UNIQUE,
    question CHAR(1) NOT NULL,
    answer VARCHAR2(30) NOT NULL
);
```

## Class Diagram

![07](https://github.com/younggeun0/younggeun0.github.io/blob/master/_posts/img/toyProjects/simpleLogin/07.jpg?raw=true)

## 구현 화면

![08](https://github.com/younggeun0/younggeun0.github.io/blob/master/_posts/img/toyProjects/simpleLogin/08.jpg?raw=true)

![09](https://github.com/younggeun0/younggeun0.github.io/blob/master/_posts/img/toyProjects/simpleLogin/09.jpg?raw=true)

![10](https://github.com/younggeun0/younggeun0.github.io/blob/master/_posts/img/toyProjects/simpleLogin/10.jpg?raw=true)

![11](https://github.com/younggeun0/younggeun0.github.io/blob/master/_posts/img/toyProjects/simpleLogin/11.jpg?raw=true)

![12](https://github.com/younggeun0/younggeun0.github.io/blob/master/_posts/img/toyProjects/simpleLogin/12.jpg?raw=true)

![13](https://github.com/younggeun0/younggeun0.github.io/blob/master/_posts/img/toyProjects/simpleLogin/13.jpg?raw=true)

![14](https://github.com/younggeun0/younggeun0.github.io/blob/master/_posts/img/toyProjects/simpleLogin/14.jpg?raw=true)

![15](https://github.com/younggeun0/younggeun0.github.io/blob/master/_posts/img/toyProjects/simpleLogin/15.jpg?raw=true)

