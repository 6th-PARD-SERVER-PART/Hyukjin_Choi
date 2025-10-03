# Member API 명세서

## Base URL
```
/wk2/homework/member
```

---

## 1. 회원 생성
새로운 회원을 생성합니다.

### Request
- **Method**: `POST`
- **URL**: `/wk2/homework/member`
- **Content-Type**: `application/json`

### Request Body
```json
{
  "id": 1,
  "name": "홍길동",
  "email": "hong@example.com",
  "password": "password123"
}
```

| Field | Type | Required | Description |
|-------|------|----------|-------------|
| id | Long | Yes | 학생 ID |
| name | String | Yes | 회원 이름 |
| email | String | Yes | 회원 이메일 |
| password | String | Yes | 회원 비밀번호 |

### Response
- **Status**: `200 OK`
- **Body**: `"저장완료!!"`

---

## 2. 회원 전체 조회
모든 회원 정보를 조회합니다.

### Request
- **Method**: `GET`
- **URL**: `/wk2/homework/member`

### Response
- **Status**: `200 OK`
- **Content-Type**: `application/json`

### Response Body
```json
[
  {
    "id": 1,
    "name": "홍길동",
    "email": "hong@example.com",
    "password": "password123"
  },
  {
    "id": 2,
    "name": "김철수",
    "email": "kim@example.com",
    "password": "password456"
  }
]
```

---

## 3. 회원 상세 조회
특정 회원의 전체 정보를 조회합니다.

### Request
- **Method**: `GET`
- **URL**: `/wk2/homework/member/{studentId}`

### Path Parameters
| Parameter | Type | Required | Description |
|-----------|------|----------|-------------|
| studentId | Long | Yes | 조회할 학생 ID |

### Response
- **Status**: `200 OK`
- **Content-Type**: `application/json`

### Response Body
```json
{
  "id": 1,
  "name": "홍길동",
  "email": "hong@example.com",
  "password": "password123"
}
```

---

## 4. 회원 이메일 조회
특정 회원의 이메일 정보를 조회합니다.

### Request
- **Method**: `GET`
- **URL**: `/wk2/homework/member/{studentId}/nameAndAge`

### Path Parameters
| Parameter | Type | Required | Description |
|-----------|------|----------|-------------|
| studentId | Long | Yes | 조회할 학생 ID |

### Response
- **Status**: `200 OK`
- **Content-Type**: `application/json`

### Response Body
```json
{
  "email": "hong@example.com"
}
```

---

## 5. 회원 정보 수정
특정 회원의 이름을 수정합니다.

### Request
- **Method**: `PATCH`
- **URL**: `/wk2/homework/member/{studentId}`
- **Content-Type**: `application/json`

### Path Parameters
| Parameter | Type | Required | Description |
|-----------|------|----------|-------------|
| studentId | Long | Yes | 수정할 학생 ID |

### Request Body
```json
{
  "name": "홍길동2"
}
```

| Field | Type | Required | Description |
|-------|------|----------|-------------|
| name | String | Yes | 수정할 회원 이름 |

### Response
- **Status**: `200 OK`
- **Body**: `"수정완료~"`

---

## 6. 회원 삭제
특정 회원을 삭제합니다.

### Request
- **Method**: `DELETE`
- **URL**: `/wk2/homework/member/{studentId}`

### Path Parameters
| Parameter | Type | Required | Description |
|-----------|------|----------|-------------|
| studentId | Long | Yes | 삭제할 학생 ID |

### Response
- **Status**: `200 OK`
- **Body**: `"삭제완료~"`

---

## Error Response
API 요청 실패 시 반환되는 에러 형식입니다.

```json
{
  "error": "Error message"
}
```

---

## Notes
- 모든 요청은 적절한 Content-Type 헤더를 포함해야 합니다.
- studentId는 Long 타입의 숫자여야 합니다.
- 회원 정보는 메모리(HashMap)에 저장되므로 서버 재시작 시 데이터가 초기화됩니다.