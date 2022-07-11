# 네트워킹

<br>

- [네트워크 기초](#네트워크-기초)



<br>

<br>

---

## 네트워크 기초

### 네트워크 (network)

- 네트워크 : 여러 대의 컴퓨터를 통신 회선으로 연결한 것
- 홈 네트워크 : 집에 각 방마다 컴퓨터를 통신 회선으로 연결한 것
- 지역 네트워크 : 회사, 건물, 특정 영역에 존재하는 컴퓨터를 통신 회선으로 연결한 것

- 인터넷 : 지역 네트워크를 통신 회선으로 연결한 것

<br>

<br>

---

### 서버와 클라이언트

- 서버(server) : 서비스를 제공하는 프로그램 (response)

- 클라이언트(client) : 서비스를 받는 프로그램 (request)

- 프로토콜 (protocol) : 서버와 클라이언트 컴퓨터 통신 규칙 = 약속 언어

<br>

서버와 클라이언트가 서로 통신 가능하려면 프로토콜이 같아야 한다.

즉, 서버에도 클라이언트에도 같은 종류의 프로토콜이 설치되어 있어야 한다.

<br>

<br>

---

### IP 주소와 포트

#### IP 주소 (Internet Protocol address) 

- 컴퓨터 네트워크에서 장치들이 서로를 인식하고 통신을 하기 위해서 사용하는 특수한 번호이다.

##### IPv4의 주소체계

- 총 12자리이며 네 부분으로 나뉜다.
- 각 부분은 0~255까지 3자리의 수로 표현된다.
- 중복될 수 없다
- 현재 인터넷 사용자의 증가로 인해 주소공간의 고갈에 대한 우려가 높아지고 있다. (IPv6 방식으로 개선중)

<br>

#### port 번호 

- 컴퓨터 내에서 작동하는 여러개 서비스를 식별하기 위해 사용하는 숫자 

##### 포트번호의 범위

- 포트번호는 0~65535번 (2^16)번까지 사용할 수 있다.

  - 잘 알려진 포트 (well-known port) 

    - 0~1023번

    - unix/linux에서 root 권한으로만 port를 열 수 있는 예약 영역

  - 등록된 포트 (registered port) 

    - 1024~49251번
    - 주로 서버 소켓으로 사용하는 영역

  - 동적 포트 (dynamic port) 

    -  49152~65535번

  <br>

#### DNS (Domain Name System)

- HTTP와 같이 응용 계층 시스템에서 도메인 이름과 IP 주소 이름 확인을 제공 
- 사람이 읽을 수 있는 도메인 이름(ex) www.amazon.com)을 머신이 읽을 수 있는 IP주소(ex) 192.0.2.44)로 변환

<br>

<br>

----

## InetAddress로 IP주소 얻기

현재 내 컴퓨터인 로컬호스트의 IP 주소를 출력하고 싶다면 아래와 같이 작성한다.

```java
InetAddress ip = InetAddress.getLocalHost();
		System.out.println("내컴퓨터의ip="+ip.getHostAddress());//ip 주소값
```



만약 DNS에 등록된 모든 IP 주소를 얻고 싶다면 getAllByName()  메소드를 호출하면 된다.

```java
InetAddress[] ip2 = InetAddress.getAllByName("www.multicampus.co.kr");
		for(InetAddress inet : ip2) {
			System.out.println("다음 ip="+inet.getHostAddress());
		}
```

