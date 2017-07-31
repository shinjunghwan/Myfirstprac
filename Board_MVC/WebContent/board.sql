-- board.sql

create table board(
	no number not null, -- 글번호
	id varchar2(50) not null, -- 아이디
	pwd varchar2(20) not null, -- 비밀번호
	title varchar2(100) not null,  -- 제목
	content varchar2(4000) not null,  -- 내용
	regdate date not null,  -- 작성일
	hit number not null, -- 조회수
	parent number not null, -- 부모 글 번호
	sort number not null,  -- 답글 정렬 번호
	tab number not null, -- 들여 쓰기
	constraint pk_board primary key(no) -- 글번호를 기본키로 설정
);