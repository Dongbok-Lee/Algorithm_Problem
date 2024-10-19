-- 코드를 입력하세요
SELECT MEMBER_ID,	MEMBER_NAME,	GENDER,	date_format(DATE_OF_BIRTH, '%Y-%m-%d') as DATE_OF_BIRTH
from MEMBER_PROFILE where month(DATE_OF_BIRTH) = 3 and TLNO is not NULL and gender = 'W'
order by member_id