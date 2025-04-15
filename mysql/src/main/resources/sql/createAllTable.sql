-- 회원 정보 테이블
create table tbl_member (
       id 			            bigint auto_increment primary key,
       member_email 		    varchar(200) not null,
       member_password	        varchar(200),
       member_nickname 		    varchar(50),
       member_introduce 		varchar(300) default '',
       member_file_path 		varchar(500) default '',
       member_file_name 		varchar(500) default '',
       member_file_size 		varchar(100) default '',
       member_type 		        tinyint default 0,
       member_suspend 		    tinyint default 0,
       status 		            tinyint default 1,
       created_date 	        datetime default current_timestamp,
       updated_date 	        datetime default current_timestamp
);

-- 알림 설정
create table tbl_notificaton_setting (
       id                                          bigint primary key,
       notificaton_setting_reply                   tinyint default 1,
       notificaton_setting_reply_like              tinyint default 1,
       notificaton_setting_like                    tinyint default 1,
       notificaton_setting_subscribe               tinyint default 1,
       notificaton_setting_community_post          tinyint default 1,
       notificaton_setting_message                 tinyint default 1,
       created_date                                datetime default current_timestamp,
       updated_date                                datetime default current_timestamp,
       constraint fk_notificaton_setting_member foreign key(id)
           references tbl_member(id)
);

-- 채널 정보 테이블
create table tbl_channel (
       id 		                bigint auto_increment primary key,
       channel_title 		    varchar(50) not null,
       channel_introduce 		varchar(300),
       channel_url 		        varchar(50) not null,
       channel_file_path 		varchar(500) default '',
       channel_file_name 		varchar(500) default '',
       channel_file_size 		varchar(100) default '',
       member_id 		        bigint not null,
       status 		            tinyint default 1,
       created_date 	        datetime default current_timestamp,
       updated_date 	        datetime default current_timestamp,
       constraint fk_channel_member foreign key (member_id)
                                 references tbl_member (id)
);

-- ai 응답에 대한 이미지 테이블
create table tbl_ai (
       id 			        bigint auto_increment primary key,
       ai_code              int  not null,
       ai_file_path 		varchar(500) default '',
       ai_file_name 		varchar(500) default '',
       ai_file_size 		varchar(100) default '',
       created_date 	    datetime default current_timestamp,
       updated_date 	    datetime default current_timestamp
);

-- 마음의 일기 테이블
# 전체 공개 / 구독자에게만 공개 / 비공개
create table tbl_diary (
       id 			        bigint auto_increment primary key,
       diary_content 		varchar(4000) not null,
       diary_open       	tinyint default 0,
       member_id 		    bigint not null,
       status 		        tinyint default 1,
       created_date 		datetime default current_timestamp,
       updated_date 	    datetime default current_timestamp,
       constraint fk_diary_member foreign key (member_id)
           references tbl_member (id)
);

-- 개인용 도전 과제  테이블
create table tbl_member_task (
       id 		                    bigint auto_increment primary key,
       mamber_task_content 		    varchar(1000) not null,
       mamber_task_file_path 		varchar(1000) default '',
       mamber_task_file_name 		varchar(1000) default '',
       mamber_task_file_size 		varchar(100) default '',
       status 		                tinyint default 1,
       created_date 	            datetime default current_timestamp,
       updated_date 	            datetime default current_timestamp
);

-- 전 회원용 도전 과제 테이블
create table tbl_common_task (
       id 		                    bigint auto_increment primary key,
       common_task_name             varchar(1000) not null,
       common_task_img              varchar(1000),
       common_task_tell             varchar(50),
       common_task_url              varchar(1000),
       common_task_addr             varchar(1000),
       common_task_lot              decimal(10,6),                 -- 위도
       common_task_lat              decimal(10,6),                 -- 경도
       common_task_service_name 	varchar(100) not null,    -- 열린광장 서비스 명
       common_task_req_page 	    int,                                -- 열린광장 페이지
       status		                tinyint default 1,
       created_date 	            datetime default current_timestamp,
       updated_date 	            datetime default current_timestamp
);

-- 개인 할당 과제 및 선정 테이블
create table tbl_member_challenge (
       id 		                         bigint auto_increment primary key,
       member_challenge_ok           	 tinyint default 0,
       member_challenge_complete      	 tinyint default 0,
       member_id 	                     bigint not null,
       task_id 		                     bigint not null,
       status 		                     tinyint default 1,
       created_date 	                 datetime default current_timestamp,
       updated_date 	                 datetime default current_timestamp,
       constraint fk_member_challenge_member foreign key (member_id)
           references tbl_member (id) ,
       constraint fk_member_challenge_task foreign key (task_id)
           references tbl_member_task (id)
);

-- 선정 과제 (전 회원용) 테이블
create table tbl_common_challenge (
       id 			                    bigint  auto_increment primary key,
       common_challenge_complete 		tinyint default 0,
       member_id 		                bigint not null,
       task_id 		                    bigint not null,
       status 		                    tinyint default 1,
       created_date 		            datetime default current_timestamp,
       updated_date 		            datetime default current_timestamp,
       constraint fk_common_challenge_member foreign key (member_id)
           references tbl_member (id) ,
       constraint fk_common_challenge_task foreign key (task_id)
           references tbl_common_task (id)
);

-- 포스트, 커뮤니티 게시글 슈퍼키
create table tbl_post (
       id 			        bigint auto_increment primary key,
       post_title 		    varchar(1000) not null,
       post_sub_title 		varchar(1000),
       post_content 		varchar(4000) not null,
       status 		        tinyint default 1,
       created_date 		datetime default current_timestamp,
       updated_date 	    datetime default current_timestamp
);

-- 포스크 게시글
#포스트 / 응원글
create table tbl_post_post (
       id 			        bigint primary key,
       post_type 		    tinyint default 1,
       member_id            bigint not null,
       channel_id 		    bigint not null,
       status 		        tinyint default 1,
       created_date 		datetime default current_timestamp,
       updated_date 	    datetime default current_timestamp,
       constraint fk_post_post_post foreign key (id)
           references tbl_post (id),
       constraint fk_post_member foreign key (member_id)
           references tbl_member (id),
       constraint fk_post_channel foreign key (channel_id)
           references tbl_channel (id)
);

-- 게시글 대표이미지
create table tbl_post_mainimg(
       id 		                    bigint  primary key,
       post_mainimg_file_path 		varchar(500) default '',
       post_mainimg_file_name 		varchar(500) default '',
       post_mainimg_file_size 		varchar(500) default '',
       created_date 	            datetime default current_timestamp,
       updated_date 	            datetime default current_timestamp,
       constraint fk_post_mainimg_post foreign key(id)
           references tbl_post(id)
);

-- 게시물 파일 테이블
create table tbl_post_file (
       id 		            bigint auto_increment primary key,
       pose_file_path 		varchar(500) default '',
       pose_file_name 		varchar(500) default '',
       pose_file_size 		varchar(500) default '',
       post_id 		        bigint not null,
       status 		        tinyint default 1,
       created_date 	    datetime default current_timestamp,
       updated_date 	    datetime default current_timestamp,
       constraint fk_post_file_post foreign key (post_id)
           references tbl_post (id)
);

-- 좋아요 테이블 슈퍼키
create table tbl_like
(
    id           bigint auto_increment primary key,
    status 		    tinyint default 1,
    created_date datetime default current_timestamp,
    updated_date datetime default current_timestamp
);

-- 게시물 좋아요 테이블
create table tbl_post_like (
       id 		        bigint primary key,
       member_id 	    bigint not null,
       post_id 	 	    bigint not null,
       status 		    tinyint default 1,
       constraint fk_post_like_like foreign key (id)
           references tbl_like (id) ,
       constraint fk_post_like_member foreign key (member_id)
           references tbl_member (id) ,
       constraint fk_post_like_post foreign key (post_id)
           references tbl_post (id)
);

-- 게시물 스크랩 테이블
create table tbl_post_scrap (
       id               bigint 		auto_increment primary key,
       member_id 	    bigint not null,
       post_id 		    bigint not null,
       status 		    tinyint default 1,
       created_date 	datetime default current_timestamp,
       updated_date 	datetime default current_timestamp,
       constraint fk_post_scrap_member foreign key (member_id)
           references tbl_member (id) ,
       constraint fk_post_scrap_post foreign key (post_id)
           references tbl_post (id)
);

-- 댓글 테이블 슈퍼키
create table tbl_reply (
       id 		            bigint auto_increment primary key,
       reply_content 		varchar(2000),
       reply_file_path 		varchar(500) default '',
       reply_file_name 		varchar(500) default '',
       reply_file_size 		varchar(100) default '',
       status               tinyint default 1,
       created_date 	    datetime default current_timestamp,
       updated_date 	    datetime default current_timestamp
);

-- post 댓글 테이블
create table tbl_post_reply (
       id 		                    bigint primary key,
       member_id 	                bigint not null,
       post_id 		                bigint not null,
       status 		                tinyint default 1,
       constraint fk_post_reply_reply foreign key (id)
           references tbl_reply (id) ,
       constraint fk_post_reply_member foreign key (member_id)
           references tbl_member (id) ,
       constraint fk_post_reply_post foreign key (post_id)
           references tbl_post (id)
);

-- post 댓글 좋아요 테이블
create table tbl_post_reply_like (
        id 		                bigint primary key,
        member_id 	            bigint not null,
        reply_id 	            bigint not null,
        status 		            tinyint default 1,
        constraint fk_post_reply_like foreign key (id)
            references tbl_like (id) ,
        constraint fk_post_reply_like_member foreign key (member_id)
            references tbl_member (id) ,
        constraint fk_post_reply_like_reply foreign key (reply_id)
            references tbl_post_reply (id)
);

-- 신고 테이블 슈퍼키
create table tbl_report (
       id 		            bigint auto_increment primary key,
       status               tinyint default 1,
       created_date 	    datetime default current_timestamp,
       updated_date 	    datetime default current_timestamp
);

-- post 신고 테이블
create table tbl_post_report (
       id 		            bigint primary key ,
       member_id 	        bigint not null,
       post_id 		        bigint not null,
       status 		        tinyint default 1,
       constraint fk_post_report_report foreign key (id)
           references tbl_report (id) ,
       constraint fk_post_report_member foreign key (member_id)
           references tbl_member (id) ,
       constraint fk_post_report_post foreign key (post_id)
           references tbl_post (id)
);

-- community 글 테이블
create table tbl_community_post (
       id 		                bigint primary key,
       member_id	            bigint not null,
       channel_id 	            bigint not null,
       status 		            tinyint default 1,
       created_date 	        datetime default current_timestamp,
       updated_date 	        datetime default current_timestamp,
       constraint fk_community_post_post foreign key (id)
           references tbl_post (id) ,
       constraint fk_community_member foreign key (member_id)
           references tbl_member (id) ,
       constraint fk_community_channel foreign key (channel_id)
           references tbl_channel (id)
);

-- community 파일 테이블
create table tbl_community_file (
       id 		                bigint auto_increment primary key,
       community_file_path 	    varchar(500) default '',
       community_file_name 	    varchar(500) default '',
       community_file_size 	    varchar(100) default '',
       community_id 	        bigint not null,
       status 		            tinyint default 1,
       created_date 	        datetime default current_timestamp,
       updated_date 	        datetime default current_timestamp,
       constraint fk_community_file_community foreign key (community_id)
           references tbl_community_post (id)
);

-- community 좋아요 테이블
create table tbl_community_like (
       id 		            bigint primary key,
       member_id 	        bigint not null,
       community_id 	    bigint not null,
       status 		        tinyint default 1,
       constraint fk_community_like_like foreign key (id)
           references tbl_like (id) ,
       constraint fk_community_like_member foreign key (member_id)
           references tbl_member (id) ,
       constraint fk_community_like_community foreign key (community_id)
           references tbl_community_post (id)
);

-- community 댓글 테이블
create table tbl_community_reply (
       id 		                        bigint primary key ,
       member_id 	                    bigint not null,
       community_id	                    bigint not null,
       status 		                    tinyint default 1,
       constraint fk_community_reply_reply foreign key (id)
           references tbl_reply (id) ,
       constraint fk_community_reply_member foreign key (member_id)
           references tbl_member (id) ,
       constraint fk_community_reply_community foreign key (community_id)
           references tbl_community_post (id)
);

-- community 댓글 좋아요 테이블
create table tbl_community_reply_like (
       id 			    bigint primary key,
       member_id 		bigint not null,
       reply_id 		bigint not null,
       status 		    tinyint default 1,
       constraint fk_community_reply_like_like foreign key (id)
           references tbl_like (id) ,
       constraint fk_community_reply_like_member foreign key (member_id)
           references tbl_member (id) ,
       constraint fk_community_reply_like_reply foreign key (reply_id)
           references tbl_community_reply (id)
);

-- community 신고 테이블
create table tbl_community_report (
       id 			    bigint primary key ,
       member_id 		bigint not null,
       community_id 	bigint not null,
       status 		    tinyint default 1,
       constraint fk_community_report_report foreign key (id)
           references tbl_report (id) ,
       constraint fk_community_report_member foreign key (member_id)
           references tbl_member (id) ,
       constraint fk_community_report_community foreign key (community_id)
           references tbl_community_post (id)
);

-- 메시지 테이블 슈퍼키
create table tbl_message (
       id 		            bigint auto_increment primary key,
       message_content 		varchar(1000),
       status 		        tinyint default 1,
       created_date 	    datetime default current_timestamp,
       updated_date 	    datetime default current_timestamp
);

-- 받은 메시지 테이블
create table tbl_receive_message (
       id 		    bigint ,
       member_id 	bigint not null,
       sender_id 	bigint not null,
       status 		tinyint default 1,
       constraint fk_receive_message_message foreign key (id)
           references tbl_message (id) ,
       constraint fk_receive_message_member foreign key (member_id)
           references tbl_member (id) ,
       constraint fk_receive_message_sender foreign key (sender_id)
           references tbl_member (id)
);

-- 보낸 메시지 테이블
create table tbl_send_message (
       id 		    bigint ,
       member_id 	bigint not null,
       receiver_id 	bigint not null,
       status 		tinyint default 1,
       constraint fk_send_message_message foreign key (id)
           references tbl_message (id) ,
       constraint fk_send_message_member foreign key (member_id)
           references tbl_member (id) ,
       constraint fk_send_message_receiver foreign key (receiver_id)
           references tbl_member (id)
);

-- 공지사항 테이블
create table tbl_notice (
       id 			        bigint auto_increment primary key,
       notice_title 		varchar(4000) not null,
       notice_content 		varchar(4000) not null,
       member_id 		    bigint not null,
       status 		        tinyint default 1,
       created_date         datetime default current_timestamp,
       updated_date         datetime default current_timestamp,
       constraint fk_notice_member foreign key (member_id)
           references tbl_member (id)
);

-- 자주묻는질문 테이블
create table tbl_faq (
       id                   bigint auto_increment primary key,
       faq_title            varchar(1000) not null,
       faq_content          varchar(4000) not null,
       member_id            bigint not null,
       status               tinyint default 1,
       created_date         datetime default current_timestamp,
       updated_date         datetime default current_timestamp,
       constraint fk_faq_member foreign key (member_id)
           references tbl_member (id)
);

-- 구독 테이블
create table tbl_subscribe (
       id                   bigint auto_increment primary key,
       channel_id           bigint not null,
       member_id            bigint not null,
       status               tinyint default 1,
       created_date         datetime default current_timestamp,
       updated_date         datetime default current_timestamp,
       constraint fk_subscribe_member_target foreign key(channel_id)
           references tbl_channel(id),
       constraint fk_subscribe_member_subscriber foreign key(member_id)
           references tbl_member(id)
);
