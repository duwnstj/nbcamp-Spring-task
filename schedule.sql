create table plan
(
    id        bigint primary key auto_increment, /*일정 고유 번호*/
    todo      varchar(400), /* 할일 */
    name      varchar(100), /* 담당자이름 */
    password  varchar(500),/*비밀번호*/
    create_at timestamp default current_timestamp, /* 만든 날짜 */
    update_at timestamp default current_timestamp on update current_timestamp /* 업데이트 날짜 */
);

