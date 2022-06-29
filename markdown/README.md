# linux 명령어

- ls : 현재 위치의 폴더/파일 목록 조회 
  - -a : all 옵션 (숨김 파일까지 조회)
  - -l : long 옵션 (용량, 수정 날짜 등 자세한 파일 정보 조회)

- cd : 디렉토리 이동
  - cd ~  : 홈 디렉토리로
  - cd .. : 부모 디렉토리로
  - cd -  : 이전 디렉토리로

- touch : 파일 생성 
  - 띄어쓰기로 구분해 여러 파일을 한꺼번에 생성 가능
  - 숨김 파일을 만들기 위해서 .을 파일명 앞에 붙임

- mkdir : 새 폴더 생성
  - 띄어쓰기로 구분해 여러 파일을 한꺼번에 생성 가능

- mv : 폴더/파일 이동 or 이름 변경
  - 다른 폴더 이동 시, 작성한 폴더가 없다면 이름이 바뀜

- rm : 폴더/파일 삭제 
  - 완전 삭제
  - *(asterisk, wildcard)를 사용해 rm *.txt 라고 입력하면 txt 파일 전체 삭제
  - -r : recursive 옵션. 폴더를 지울 때 사용

- start, open : 폴더/파일 열기


---


# CLI 와 GUI

## CLI

- Command Line Interface
- 터미널을 통해 사용자와 컴퓨터가 상호 작용하는 방식
- GUI에 비해 불가능한 세부적 기능 사용 가능

## GUI

- Graphic User Interface
- 그래픽을 통해 사용자와 컴퓨터가 상호 작용하는 방식
- 컴퓨터 대중화의 주역 중 하나
- CLI에 비해 사용이 쉽지만 단계가 많고, 컴퓨터 성능을 더 많이 소모


---


# Markdown 이란?

- 일반 텍스트 기반의 경량 Markup 언어
- **.md** 확장자
- 개발과 관련된 문서 = 마크다운 형식
- 마크다운의 본질 : 글에게 **역할**을 부여!


---


# Git 이란 ?

- Configuration Management Tool (형상관리도구)
- 분산형 버전 관리 시스템


![Git](http://pismute.github.io/whygitisbetter/images/local-remote.png)

출처: http://pismute.github.io/whygitisbetter/images/local-remote.png


## Working Directory(Working Tree) 

- 사용자의 일반적인 작업이 일어나는 곳

## Staging Area (Index)

- 커밋을 위한 파일 및 폴더가 추가되는 곳

## Repository

- staging area에 있던 파일 및 폴더의 변경사항(커밋)을 저장하는 곳


---


# Github란 ?

## 원격 저장소 (Remote Repository)

- 내 컴퓨터의 로컬 저장소를 다른 사람과 공유 및 협업


---


## Git 기본 명령어

1. **git init** : 해당 폴더를 로컬 저장소로 설정
2. **git status** : 현재 상태 확인
3. **git add** . : 모든 파일 add, Working Directory -> Staging Area (Untracked -> Tracked)
4. **git commit -m ""** : 커밋을 로컬 저장소에 생성, Staging Area -> Commits (commited)
5. **git log** : 커밋 목록 출력

- file 상태 = Tracked, unmodified -> 제일 최신으로 동기화 완료했다는 의미!


## Git remote 명령어

1. **git remote**
   - **add origin [Github repository URL]** : 로컬 저장소와 원격 저장소를 연결
   - **-v**  : 연결된 원격 저장소 목록 조회
   - **rm origin** : 원격 저장소 연결 삭제

2. **git push -u origin master** (이후부터는 git push만 해도 됨) : 로컬 저장소의 commits을 원격 저장소에 업로드

3. **git clone [Github repository URL]** 
   - 원격 저장소(Github)를 로컬에 복제
   - git clone을 통해 생성된 로컬 저장소는 git init과 git remote add 이미 수행  완료

4. **git pull [저장소 이름(origin)][브랜치 이름(master)]** 
   - 원격 저장소의 변경 사항을, 로컬에 받아오기 (동기화)
   - **push 전에 항상 pull**


## 충돌 (Conflict) 

 - 원격 저장소 - 로컬 저장소 서로의 커밋 내역 !=
 - git pull을 통해 동기화를 시키고 새로운 커밋을 쌓아 나가면 된다!
   (**올바른 협업의 순서 = 늘 push 전에 pull**)