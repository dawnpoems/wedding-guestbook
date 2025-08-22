-- 이벤트(결혼식) 테이블
CREATE TABLE event (
                       id          UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                       title       VARCHAR(100) NOT NULL,         -- 이벤트 이름 (예: "김철수 ❤️ 이영희 결혼식")
                       event_date  DATE NOT NULL,                 -- 결혼식 날짜
                       created_at  TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW()
);

-- 방명록 엔트리 테이블
CREATE TABLE guestbook_entry (
                                 id          UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                                 event_id    UUID NOT NULL REFERENCES event(id) ON DELETE CASCADE,
                                 nickname    VARCHAR(40) NOT NULL,          -- 작성자 닉네임
                                 message     TEXT NOT NULL,                 -- 방명록 메시지
                                 emoji       VARCHAR(8),                    -- 이모지 (예: 🎉, 💕)
                                 is_visible  BOOLEAN NOT NULL DEFAULT TRUE, -- 표시 여부 (관리자가 숨길 수 있음)
                                 created_at  TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW()
);

-- 조회 성능을 위한 인덱스 (최근 작성 순으로 불러오기 위함)
CREATE INDEX idx_guestbook_event_created
    ON guestbook_entry (event_id, created_at DESC, id DESC);
