# wedding-guestbook

결혼식 방명록 웹 서비스

## 기술 스택
- Spring Boot
- JPA (Hibernate)
- React
- Docker
- PostgreSQL (DB)

## 주요 기능
- 방명록 작성 및 조회
- 관리자 페이지에서 방명록 관리
- 실시간 반영 및 반응형 UI (SSE 기반 실시간 방명록 업데이트)

## 프로젝트 구조
```
backend/   # Spring Boot + JPA 서버
frontend/  # React 클라이언트
Dockerfile # 전체 서비스 도커라이징
```

## 실행 방법
### 1. Docker로 전체 실행
```bash
docker-compose up --build
```

### 2. 개발 환경에서 개별 실행
#### 백엔드
```bash
cd backend
./gradlew bootRun
```
#### 프론트엔드
```bash
cd frontend
npm install && npm start
```

## 환경 변수
- .env 파일에 DB(PostgreSQL), API 관련 설정 필요

## 라이선스
MIT
